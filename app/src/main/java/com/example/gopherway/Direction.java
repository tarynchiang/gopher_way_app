package com.example.gopherway;

public class Direction {
    private int id;
    private String title;
    private String shortdesc;
    private double distance;
    private int image;

    public Direction(int id, String title, String shortdesc, double distance, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.distance = distance;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getDistance() {
        return distance;
    }

    public int getImage() {
        return image;
    }
}
