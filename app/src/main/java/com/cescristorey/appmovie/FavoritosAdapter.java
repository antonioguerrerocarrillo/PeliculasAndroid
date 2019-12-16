package com.cescristorey.appmovie;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cescristorey.appmovie.ModeloPelicula.MovieListed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.moviesViewHolder> {

    public final Context context; //Almacena el contexto donde se ejecutará
    private Cursor list; //Almacenará las películas a mostrar
    private OnItemClickListener listener; //Listener para cuando se haga click



    //Defino un interface con el OnItemClickListener
    public interface OnItemClickListener {
        void onItemClick(MovieListed movie);
    }

    public FavoritosAdapter(Context context, Cursor cursor) {
        this.list = cursor;
        this.context = context;
        setListener();
    }

    private void setListener () {
        this.listener = new OnItemClickListener() {
            @Override
            public void onItemClick(MovieListed movie) {
                //Toast.makeText(context,  movie.getTitle(), Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public moviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_favoritos_item, parent, false);
        moviesViewHolder tvh = new moviesViewHolder(itemView);
        return tvh;
    }

    @Override
    public void onBindViewHolder(moviesViewHolder holder, int position) {
        String name;
        String photo;
        name = list.getString(1);
        photo= list.getString(2);
        holder.bindMovie(name, photo, listener);
        list.moveToNext();

    }

    @Override
    public int getItemCount() {
        return list.getCount();
    }


    public class moviesViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView imageView;


        public moviesViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            imageView=(ImageView) itemView.findViewById(R.id.imageView2);

        }

        public void bindMovie(String nombre, String foto, final OnItemClickListener listener) {
            tvName.setText(nombre);
            Picasso.get().load("https://image.tmdb.org/t/p/w500"+foto).into(imageView);

        }
    }

    public void swap(Cursor cursor) {
        list.equals(cursor);
        notifyDataSetChanged();
    }
}