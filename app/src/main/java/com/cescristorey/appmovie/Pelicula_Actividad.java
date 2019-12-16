package com.cescristorey.appmovie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cescristorey.appmovie.ModeloPelicula.CreditsFeed;
import com.cescristorey.appmovie.ModeloPelicula.MovieDetail;
import com.cescristorey.appmovie.retrofit.MovieService;
import com.cescristorey.appmovie.retrofit.RetrofitInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.hanks.library.bang.SmallBangView;

public class Pelicula_Actividad extends AppCompatActivity {
    ImageView image;
    TextView estudio, genero, releasedate;
    TextView titulo,descripcion, texto_estudio,texto_genero, texto_releasedate;
    RatingBar ratingBar;
    RecyclerView recyclerView;
    CastAdapter castAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        int id =  intent.getIntExtra("id", 0);
        loadSearch(id);




    }
    public void loadPelicula(MovieDetail movie){
        final String id_db = String.valueOf((int)movie.getId());
        final String titulo_db = movie.getTitle();
        final String imagen_db = movie.getPoster_path();
        image = findViewById(R.id.image_pelicula);
        titulo = findViewById(R.id.titulo_pelicula);
        ratingBar = findViewById(R.id.ratingBar);
        descripcion = findViewById(R.id.descripcion);
        Picasso.get().load("http://image.tmdb.org/t/p/w500" + movie.getPoster_path()).resize(412, 320).into(image);
        titulo.setText(movie.getTitle());
        float puntuacion = (movie.getVote_average()) /2;
        ratingBar.setNumStars(5);
        ratingBar.setRating(puntuacion);
        descripcion.setText(movie.getOverview());

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_actores);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        castAdapter = new CastAdapter(this);
        recyclerView.setAdapter(castAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        int id_cast = (int) movie.getId();
        loadCast(id_cast);


        estudio = findViewById(R.id.estudio);
        genero = findViewById(R.id.genero);
        releasedate = findViewById(R.id.releasedate);
        texto_estudio = findViewById(R.id.texto_estudio);
        texto_genero = findViewById(R.id.texto_genero);
        texto_releasedate = findViewById(R.id.texto_releasedate);

        ArrayList<Object> generos;
        ArrayList<Object> productores;
        productores = movie.getProduction_companies();
        generos = movie.getGenres();
        int start = 0;
        String cadena1="";
        String cadena2="";
        Object aux;

        for(int i=0; i < productores.size() ;i++){
            aux = productores.get(i);
            if(i!=productores.size()-1) {
                cadena2 = aux.toString();
                start = cadena2.indexOf("name=")+5;
                cadena1 += cadena2.substring(start, cadena2.indexOf(",",start)) + " , ";

            }
            else{
                cadena2 = aux.toString();
                start = cadena2.indexOf("name=") + 5;
                cadena1 += cadena2.substring(start, cadena2.indexOf(",",start));
            }
        }
        texto_estudio.setText(cadena1);
        cadena2="";
        cadena1 = "";


        for(int i=0; i < generos.size() ;i++){
            aux = generos.get(i);
            if(i!=generos.size()-1) {
                cadena2 = aux.toString();
                start = cadena2.indexOf("n")+5;
                cadena1 += cadena2.substring(start, cadena2.length()-1) + " , ";
            }
            else{
                cadena2 = aux.toString();
                start = cadena2.indexOf("n") + 5;
                cadena1 += cadena2.substring(start, cadena2.length()-1);
            }
        }
        texto_genero.setText(cadena1);
        texto_releasedate.setText(movie.getRelease_date());

        final SmallBangView like_heart = findViewById(R.id.like_heart);

        FavoritosSQLiteHelper favoritosSQLiteHelper = new FavoritosSQLiteHelper(getApplicationContext(), "DBFavoritos", null, 1);
        SQLiteDatabase db = favoritosSQLiteHelper.getReadableDatabase();


        Cursor c = db.rawQuery("SELECT * FROM Favoritos WHERE codigo='"+id_db+"' AND es_pelicula='1'",null);
        if (c.moveToFirst()) {
            like_heart.setSelected(true);
        }
        db.close();
        like_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like_heart.isSelected()) {
                    like_heart.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                        }
                    });
                    like_heart.setSelected(false);

                    FavoritosSQLiteHelper usdbh =
                            new FavoritosSQLiteHelper(getApplicationContext(), "DBFavoritos", null, 1);
                    SQLiteDatabase db = usdbh.getWritableDatabase();
                    db.execSQL("DELETE FROM Favoritos WHERE codigo='"+id_db+"' AND es_pelicula= '1'");
                    db.close();

                } else {
                    like_heart.setSelected(true);
                    like_heart.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                        }
                    });
                    FavoritosSQLiteHelper usdbh =
                            new FavoritosSQLiteHelper(getApplicationContext(), "DBFavoritos", null, 1);
                    SQLiteDatabase db = usdbh.getWritableDatabase();
                    if(db != null) {
                        db.execSQL("INSERT INTO Favoritos (codigo, nombre, foto, es_pelicula) VALUES ('" + id_db + "', '" + titulo_db + "', '" + imagen_db + "', '1')");
                        db.close();
                    }
                }
            }
        });




    }

    public void loadSearch(int id) {
        /* Crea la instanncia de retrofit */
        MovieService getMovie = RetrofitInstance.getRetrofitInstance().create(MovieService.class);
        /* Se definen los parámetros de la llamada a la función getTopRated */
        Call<MovieDetail> call = getMovie.getMovie(id, RetrofitInstance.getApiKey(), "es");
        /* Se hace una llamada asíncrona a la API */
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                switch (response.code()) {
                    /* En caso de respuesta correcta */
                    case 200:
                        Log.i("Entra", "hello");
                        /* En el objeto data de la clase MovieFeed se almacena el JSON convertido a objetos*/
                        MovieDetail data = response.body();
                        loadPelicula(data);
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Error cargando películas", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void loadCast (int id) {
        /* Crea la instanncia de retrofit */
        MovieService getCast = RetrofitInstance.getRetrofitInstance().create(MovieService.class);
        /* Se definen los parámetros de la llamada a la función getTopRated */
        Call<CreditsFeed> call = getCast.getCast(id,RetrofitInstance.getApiKey(), "es");
        /* Se hace una llamada asíncrona a la API */
        call.enqueue(new Callback<CreditsFeed>() {
            @Override
            public void onResponse(Call<CreditsFeed> call, Response<CreditsFeed> response) {
                switch (response.code()) {
                    /* En caso de respuesta correcta */
                    case 200:
                        /* En el objeto data de la clase MovieFeed se almacena el JSON convertido a objetos*/
                        CreditsFeed data = response.body();
                        /* Se actualizan los datos contenidos en el adaptador */
                        castAdapter.swap(data.getCast());
                        /* Se notifica un cambio de datos para que se refresque la vista */
                        castAdapter.notifyDataSetChanged();
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<CreditsFeed> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Error cargando películas", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
