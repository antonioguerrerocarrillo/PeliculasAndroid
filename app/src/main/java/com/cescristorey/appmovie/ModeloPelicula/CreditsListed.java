package com.cescristorey.appmovie.ModeloPelicula;

public class CreditsListed {
    private float cast_id;
    private String character;
    private String credit_id;
    private float gender;
    private float id;
    private String name;
    private float order;
    private String profile_path;


    // Getter Methods

    public float getCast_id() {
        return cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public float getGender() {
        return gender;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getOrder() {
        return order;
    }

    public String getProfile_path() {
        return profile_path;
    }

    // Setter Methods

    public void setCast_id(float cast_id) {
        this.cast_id = cast_id;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public void setGender(float gender) {
        this.gender = gender;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(float order) {
        this.order = order;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
