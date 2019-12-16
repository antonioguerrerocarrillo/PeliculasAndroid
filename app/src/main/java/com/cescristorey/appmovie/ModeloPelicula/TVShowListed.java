package com.cescristorey.appmovie.ModeloPelicula;

import java.util.ArrayList;

public class TVShowListed {
    private String original_name;
    ArrayList < Object > genre_ids = new ArrayList < Object > ();
    private String name;
    private float popularity;
    ArrayList < Object > origin_country = new ArrayList< Object >();
    private float vote_count;
    private String first_air_date;
    private String backdrop_path;
    private String original_language;
    private float id;
    private float vote_average;
    private String overview;
    private String poster_path;


    // Getter Methods

    public String getOriginal_name() {
        return original_name;
    }

    public String getName() {
        return name;
    }

    public float getPopularity() {
        return popularity;
    }

    public float getVote_count() {
        return vote_count;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public float getId() {
        return id;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    // Setter Methods

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
