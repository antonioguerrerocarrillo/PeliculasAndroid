package com.cescristorey.appmovie.ModeloPelicula;

import java.util.ArrayList;

public class CreditsFeed {
    private float id;
    ArrayList< CreditsListed > cast = new ArrayList < CreditsListed > ();
    ArrayList < Object > crew = new ArrayList < Object > ();


    // Getter Methods

    public float getId() {
        return id;
    }

    public ArrayList<CreditsListed> getCast() {
        return cast;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }
}
