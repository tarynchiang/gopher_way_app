package com.example.gopherway;

public class Route {
    private int id;
    private String start;
    private String end;

    public Route(int id, String start, String end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}