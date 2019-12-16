package com.cescristorey.appmovie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cescristorey.appmovie.ModeloPelicula.CreditsListed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class CastAdapter extends RecyclerView.Adapter<CastAdapter.moviesViewHolder> {

    public final Context context;
    private ArrayList<CreditsListed> list;
    //Listener para cuando se haga click
    private CastAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(CreditsListed movie);
    }


    public CastAdapter(Context context) {
        this.list = new ArrayList<CreditsListed>();
        this.context = context;
        setListener();
    }

    private void setListener () {
        this.listener = new CastAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CreditsListed movie) {

            }

        };
    }

    @Override
    public moviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cast_item, parent, false);
        moviesViewHolder tvh = new moviesViewHolder(itemView);
        return tvh;
    }
    @Override
    public void onBindViewHolder(moviesViewHolder holder, int position) {

        final CreditsListed movie = list.get(position);
        holder.bindMovie(movie, listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class moviesViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView image;

        public moviesViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.cast_name);
            image = (ImageView) itemView.findViewById(R.id.cast_image);

        }

        public void bindMovie(final CreditsListed movie, final OnItemClickListener listener) {
            tvName.setText(movie.getName());
            Picasso.get().load("http://image.tmdb.org/t/p/w500" + movie.getProfile_path()).into(image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                }
            });
        }
    }

    public void swap(List<CreditsListed> newListMovies) {
        list.clear();
        list.addAll(newListMovies);
        notifyDataSetChanged();
    }
}