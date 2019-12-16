package com.cescristorey.appmovie.ModeloPelicula;

import java.util.ArrayList;

public class TVShowNewsListed {
    private String backdrop_path;
    private String first_air_date;
    ArrayList < Object > genre_ids = new ArrayList< Object >();
    private float id;
    private String name;
    ArrayList < Object > origin_country = new ArrayList < Object > ();
    private String original_language;
    private String original_name;
    private String overview;
    private String poster_path;
    private float vote_average;
    private float vote_count;
    private float popularity;


    // Getter Methods

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    public float getPopularity() {
        return popularity;
    }

    // Setter Methods

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
}
