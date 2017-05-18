package com.example.andrew.bikerapplication;


/**
 * Created by Andrew on 5/13/2017.
 */

public class Route {

    private String routeName, startLat, startLong, endLat, endLong, frequency;

    public Route() {
    }

    public Route(String routeName, String startLat, String startLong, String endLat, String endLong, String frequency) {
        this.routeName = routeName;
        this.startLat = startLat;
        this.startLong = startLong;
        this.endLat = endLat;
        this.endLong = endLong;
        this.frequency = frequency;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getStartLat() {
        return startLat;
    }

    public void setStartLat(String startLat) {
        this.startLat = startLat;
    }

    public String getStartLong() {
        return startLong;
    }

    public void setStartLong(String startLong) {
        this.startLong = startLong;
    }

    public String getEndLat() {
        return endLat;
    }

    public void setEndLat(String endLat) {
        this.endLat = endLat;
    }

    public String getEndLong() {
        return endLong;
    }

    public void setEndLong(String endLong) {
        this.endLong = endLong;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
