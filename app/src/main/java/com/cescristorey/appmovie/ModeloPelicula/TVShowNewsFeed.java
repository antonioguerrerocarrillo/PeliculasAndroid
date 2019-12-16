package com.cescristorey.appmovie.ModeloPelicula;

import java.util.ArrayList;

public class TVShowNewsFeed {
    private float page;
    ArrayList < TVShowNewsListed > results = new ArrayList< TVShowNewsListed >();
    private float total_pages;
    private float total_results;


    // Getter Methods

    public float getPage() {
        return page;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    public float getTotal_results() {
        return total_results;
    }

    public ArrayList<TVShowNewsListed> getResults() {
        return results;
    }
    // Setter Methods

    public void setPage(float page) {
        this.page = page;
    }

    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_results(float total_results) {
        this.total_results = total_results;
    }
}
