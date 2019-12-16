package com.cescristorey.appmovie.ui.peliculas;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cescristorey.appmovie.MainActivity;
import com.cescristorey.appmovie.ModeloPelicula.MovieFeed;
import com.cescristorey.appmovie.MovieAdapter;
import com.cescristorey.appmovie.R;
import com.cescristorey.appmovie.retrofit.MovieService;
import com.cescristorey.appmovie.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculasFragment extends Fragment {

    RecyclerView recyclerView,recyclerView2;
    MovieAdapter movieAdapter,movieAdapter2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View vista = inflater.inflate(R.layout.fragment_peliculas, container, false);

        /* Enlaza el RecyclerView definido en el layout con el objeto recyclerView */
        recyclerView = (RecyclerView) vista.findViewById(R.id.recycler_view);
        /* Establece que recyclerView tendrá un layout lineal, en concreto vertical*/
        recyclerView.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.HORIZONTAL, false));
        /*  Indica que cada uno de los items va a tener un tamaño fijo*/
        recyclerView.setHasFixedSize(true);
        /* Establece la  decoración por defecto de cada uno de lo items: una línea de división*/
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        /* Instancia un objeto de la clase MovieAdapter */
        movieAdapter = new MovieAdapter(vista.getContext());
        /* Establece el adaptador asociado a recyclerView */
        recyclerView.setAdapter(movieAdapter);
        /* Pone la animación por defecto de recyclerView */
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadSearch();

        /* Enlaza el RecyclerView definido en el layout con el objeto recyclerView */
        recyclerView2 = (RecyclerView) vista.findViewById(R.id.recycler_view2);
        /* Establece que recyclerView tendrá un layout lineal, en concreto vertical*/
        recyclerView2.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.HORIZONTAL, false));
        /*  Indica que cada uno de los items va a tener un tamaño fijo*/
        recyclerView2.setHasFixedSize(true);
        /* Establece la  decoración por defecto de cada uno de lo items: una línea de división*/
        recyclerView2.addItemDecoration(new DividerItemDecoration(recyclerView2.getContext(), DividerItemDecoration.VERTICAL));
        /* Instancia un objeto de la clase MovieAdapter */
        movieAdapter2 = new MovieAdapter(vista.getContext());
        /* Establece el adaptador asociado a recyclerView */
        recyclerView2.setAdapter(movieAdapter2);
        /* Pone la animación por defecto de recyclerView */
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        loadSearch2();


        return vista;
    }
    public void loadSearch () {
        /* Crea la instanncia de retrofit */
        MovieService getMovie = RetrofitInstance.getRetrofitInstance().create(MovieService.class);
        /* Se definen los parámetros de la llamada a la función getTopRated */
        Call<MovieFeed> call = getMovie.getTopRated(RetrofitInstance.getApiKey(), "es");
        /* Se hace una llamada asíncrona a la API */
        call.enqueue(new Callback<MovieFeed>() {
            @Override
            public void onResponse(Call<MovieFeed> call, Response<MovieFeed> response) {
                switch (response.code()) {
                    /* En caso de respuesta correcta */
                    case 200:
                        /* En el objeto data de la clase MovieFeed se almacena el JSON convertido a objetos*/
                        MovieFeed data = response.body();
                        /* Se actualizan los datos contenidos en el adaptador */
                        movieAdapter.swap(data.getResults());
                        /* Se notifica un cambio de datos para que se refresque la vista */
                        movieAdapter.notifyDataSetChanged();
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<MovieFeed> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Error cargando películas", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void loadSearch2 () {
        /* Crea la instanncia de retrofit */
        MovieService getMovie = RetrofitInstance.getRetrofitInstance().create(MovieService.class);
        /* Se definen los parámetros de la llamada a la función getTopRated */
        Call<MovieFeed> call = getMovie.getMovieLatest(RetrofitInstance.getApiKey(), "es");
        /* Se hace una llamada asíncrona a la API */
        call.enqueue(new Callback<MovieFeed>() {
            @Override
            public void onResponse(Call<MovieFeed> call, Response<MovieFeed> response) {
                switch (response.code()) {
                    /* En caso de respuesta correcta */
                    case 200:
                        Log.i("Entra","hello");
                        /* En el objeto data de la clase MovieFeed se almacena el JSON convertido a objetos*/
                        MovieFeed data = response.body();
                        /* Se actualizan los datos contenidos en el adaptador */
                        movieAdapter2.swap(data.getResults());
                        /* Se notifica un cambio de datos para que se refresque la vista */
                        movieAdapter2.notifyDataSetChanged();
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<MovieFeed> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Error cargando películas", Toast.LENGTH_SHORT).show();
            }
        });
    }
}