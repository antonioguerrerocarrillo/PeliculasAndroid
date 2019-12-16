package com.cescristorey.appmovie.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cescristorey.appmovie.ModeloPelicula.TVShowFeed;
import com.cescristorey.appmovie.R;
import com.cescristorey.appmovie.retrofit.MovieService;
import com.cescristorey.appmovie.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesFragment extends Fragment {


        RecyclerView recyclerView,recyclerView2;

        public View onCreateView(@NonNull LayoutInflater inflater,
                ViewGroup container, Bundle savedInstanceState) {


            View vista = inflater.inflate(R.layout.fragment_peliculas, container, false);

            //RECYCLER 1 SERIES

            recyclerView = (RecyclerView) vista.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            loadSearch();

            //RECYCLER 2 SERIES

            recyclerView2 = (RecyclerView) vista.findViewById(R.id.recycler_view2);
            recyclerView2.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView2.setHasFixedSize(true);
            recyclerView2.addItemDecoration(new DividerItemDecoration(recyclerView2.getContext(), DividerItemDecoration.VERTICAL));
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
            loadSearch2();



            return vista;
        }
        public void loadSearch () {
            /* Crea la instanncia de retrofit */
            MovieService getSerie = RetrofitInstance.getRetrofitInstance().create(MovieService.class);
            /* Se definen los parámetros de la llamada a la función getTopRated */
            Call<TVShowFeed> call = getSerie.getTopRatedTvShow(RetrofitInstance.getApiKey(), "es");
            /* Se hace una llamada asíncrona a la API */
            call.enqueue(new Callback<TVShowFeed>() {
                @Override
                public void onResponse(Call<TVShowFeed> call, Response<TVShowFeed> response) {
                    switch (response.code()) {
                        /* En caso de respuesta correcta */
                        case 200:
                            /* En el objeto data de la clase MovieFeed se almacena el JSON convertido a objetos*/
                            TVShowFeed data = response.body();
                            break;
                        case 401:
                            break;
                        default:
                            break;
                    }
                }

                @Override
                public void onFailure(Call<TVShowFeed> call, Throwable t) {
                    //Toast.makeText(MainActivity.this, "Error cargando películas", Toast.LENGTH_SHORT).show();
                }
            });
        }
    public void loadSearch2 () {
        /* Crea la instanncia de retrofit */
        MovieService getSerie = RetrofitInstance.getRetrofitInstance().create(MovieService.class);
        /* Se definen los parámetros de la llamada a la función getTopRated */
        Call<TVShowFeed> call = getSerie.getTvShowLatest(RetrofitInstance.getApiKey(), "es");
        /* Se hace una llamada asíncrona a la API */
        call.enqueue(new Callback<TVShowFeed>() {
            @Override
            public void onResponse(Call<TVShowFeed> call, Response<TVShowFeed> response) {
                switch (response.code()) {
                    /* En caso de respuesta correcta */
                    case 200:
                        /* En el objeto data de la clase MovieFeed se almacena el JSON convertido a objetos*/
                        TVShowFeed data = response.body();

                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<TVShowFeed> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Error cargando películas", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
