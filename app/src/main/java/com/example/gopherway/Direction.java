package com.example.gopherway;

public class Direction{
    private String description;
    private int dirImg;
    private int mapImg;
    private int realImg;

    public Direction(String description, int direction_icon, int help_photo, int map_image){
        this.description = description;
        this.dirImg = direction_icon;
        this.mapImg = map_image;
        this.realImg = help_photo;
    }

    public String getDescription(){ return description;}
    public int getDirImg(){ return dirImg; }
    public int getmapImg(){ return mapImg; }
    public int getrealImg(){ return realImg; }
}