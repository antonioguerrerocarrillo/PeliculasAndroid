package com.cescristorey.appmovie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cescristorey.appmovie.ModeloPelicula.MovieListed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.moviesViewHolder> {

    public final Context context;
    private ArrayList<MovieListed> list;
    private MovieAdapter.OnItemClickListener listener;

    //Defino un interface con el OnItemClickListener
    public interface OnItemClickListener {
        void onItemClick(MovieListed movie);
    }

    public MovieAdapter(Context context) {
        this.list = new ArrayList<MovieListed>();
        this.context = context;
        setListener();
    }

    private void setListener () {
        this.listener = new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(MovieListed movie) {

                Intent intent = new Intent(context, Pelicula_Actividad.class);
                int id = (int) movie.getId();
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        };
    }

    @Override
    public moviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tvshow_item, parent, false);
        moviesViewHolder tvh = new moviesViewHolder(itemView);
        return tvh;
    }

    @Override
    public void onBindViewHolder(moviesViewHolder holder, int position) {

        final MovieListed movie = list.get(position);
        holder.bindMovie(movie, listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class moviesViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        RatingBar ratingBar;
        ImageView image;

        public moviesViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
            image = (ImageView) itemView.findViewById(R.id.imageView2);

        }

        public void bindMovie(final MovieListed movie, final MovieAdapter.OnItemClickListener listener) {
            tvName.setText(movie.getTitle());
            float puntuacion = (movie.getVote_average()) /2;
            ratingBar.setNumStars(5);
            ratingBar.setRating(puntuacion);
            Picasso.get().load("http://image.tmdb.org/t/p/w500" + movie.getPoster_path()).into(image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(movie);
                }
            });
        }
    }


    public void swap(List<MovieListed> newListMovies) {
        list.clear();
        list.addAll(newListMovies);
        notifyDataSetChanged();
    }
}