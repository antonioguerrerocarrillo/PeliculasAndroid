
package com.cescristorey.appmovie.ModeloPelicula;

import java.util.ArrayList;

public class TVShowDetail {
    private String backdrop_path;
    ArrayList < Object > created_by = new ArrayList < Object > ();
    ArrayList < Object > episode_run_time = new ArrayList< Object >();
    private String first_air_date;
    ArrayList < Object > genres = new ArrayList < Object > ();
    private String homepage;
    private float id;
    private boolean in_production;
    ArrayList < Object > languages = new ArrayList < Object > ();
    private String last_air_date;
    Object Last_episode_to_airObject;
    private String name;
    private Object next_episode_to_air = null;
    ArrayList < Object > networks = new ArrayList < Object > ();
    private float number_of_episodes;
    private float number_of_seasons;
    ArrayList < Object > origin_country = new ArrayList < Object > ();
    private String original_language;
    private String original_name;
    private String overview;
    private float popularity;
    private String poster_path;
    ArrayList < Object > production_companies = new ArrayList < Object > ();
    ArrayList < Object > seasons = new ArrayList < Object > ();
    private String status;
    private String type;
    private float vote_average;
    private float vote_count;


    // Getter Methods

    public ArrayList<Object> getProduction_companies() { return production_companies;}

    public ArrayList<Object> getGenres() {
        return genres;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public String getHomepage() {
        return homepage;
    }

    public float getId() {
        return id;
    }

    public boolean getIn_production() {
        return in_production;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public String getName() {
        return name;
    }

    public Object getNext_episode_to_air() {
        return next_episode_to_air;
    }

    public float getNumber_of_episodes() {
        return number_of_episodes;
    }

    public float getNumber_of_seasons() {
        return number_of_seasons;
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

    public float getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public float getVote_average() {
        return vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    // Setter Methods

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setIn_production(boolean in_production) {
        this.in_production = in_production;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNext_episode_to_air(Object next_episode_to_air) {
        this.next_episode_to_air = next_episode_to_air;
    }

    public void setNumber_of_episodes(float number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public void setNumber_of_seasons(float number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
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

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }
}
