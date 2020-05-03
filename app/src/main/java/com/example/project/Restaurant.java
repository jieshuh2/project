package com.example.project;

import com.google.android.gms.maps.model.LatLng;

public class Restaurant {
    private String name;
    private int score = 0;
    private LatLng location;
    Restaurant(String setName, double setLatitude, double setLongitude) {
        name = setName;
        location = new LatLng(setLatitude, setLongitude);
    }
    public void increase() {
        score++;
    }
    public void decrease() {
        score--;
    }
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
    public LatLng getLocation() {
        return location;
    }
}
