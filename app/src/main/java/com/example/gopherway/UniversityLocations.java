package com.example.gopherway;

import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Map;

public class UniversityLocations {

    UniversityLocations() {
    }

    public static Map<String, Integer> buildingList = createMap();

    private static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("McNamara", 1);
        map.put("Moose Tower", 2);
        map.put("Rapson", 3);
        map.put("Ford Hall", 4);
        map.put("Coffman", 5);
        map.put("Diehl", 6);
        return map;
    }

    public static int findBuilding(String building) {
        return buildingList.get(building);
    }

    //Returns array of Strings describing each step for each route
    public static String[][] getDirectionArr() {
        String[] error = {"Error: Path not found"};
        //14 steps
        String[] McNamaraToMoosTower = {"Start at Fireplace in Macnamara.",
                "Take the stairs to the right of the fireplace down.",
                "Follow the tunnel until the elevator.",
                "Take the elevator up to the skyway (level 2).",
                "Take a right and enter graduate hotel.",
                "Take a right.",
                "Follow right wall until brown double doors.",
                "Follow skyway to the parking garage, go through the first set of doors.",
                "Go through the doors to the left.",
                "Follow the hallway past the first door.",
                "Go through the tan double doors",
                "Follow hallway to the end and go through the doors.",
                "Take elevator down to the basement (level B).",
                "Take a right and follow hallway to Moos Tower."};
        String[] RapsonToFord = {};//TODO: Fill in path directions
        String[] CoffmanToDiehl = {};//TODO: Fill in path directions
        String[][] result = {error, McNamaraToMoosTower, RapsonToFord, CoffmanToDiehl};
        return result;
    }

    //Returns array of drawables for each directional image to be loaded per step of each route (left, right, etc)
    public static int[][] getImageArr() {
        int[] error = {-1};
        int[] M_M_Images = {R.drawable.ahead,
                R.drawable.downstairs,
                R.drawable.ahead,
                R.drawable.elevator_up,
                R.drawable.right,
                R.drawable.right,
                R.drawable.ahead,
                R.drawable.ahead,
                R.drawable.left,
                R.drawable.ahead,
                R.drawable.doubledoor,
                R.drawable.ahead,
                R.drawable.elevator_down,
                R.drawable.right};
        int[] K_W_Images = {};  //TODO: Fill in path image keys
        int[] C_D_Images = {};  //TODO: Fill in path image keys
        int[][] result = {error, M_M_Images, K_W_Images, C_D_Images};
        return result;
    }

    //Returns array of drawables for each real life image to be loaded per step of each route
    public static int[][] getRouteImageArr(){
        int[] error = {-1};
        int[] M_M_Images = new int[]{R.drawable.mm1,
                R.drawable.mm2,
                R.drawable.mm3,
                R.drawable.mm4,
                R.drawable.mm5,
                R.drawable.mm6,
                R.drawable.mm7,
                R.drawable.mm8,
                R.drawable.mm9,
                R.drawable.mm10,
                R.drawable.mm11,
                R.drawable.mm12,
                R.drawable.mm13,
                R.drawable.mm14};
        int[] K_W_Images = {};  //TODO: Fill in path image keys
        int[] C_D_Images = {};  //TODO: Fill in path image keys
        int[][] result = {error, M_M_Images, K_W_Images, C_D_Images};
        return result;
    }

    //Returns array of drawables for each image of the map to be loaded per step of each route
    public static int[][] getMapImageArr(){
        int[] error = {-1};
        int[] M_M_Images = {};  //TODO: Fill in path image keys
        int[] K_W_Images = {};  //TODO: Fill in path image keys
        int[] C_D_Images = {};  //TODO: Fill in path image keys
        int[][] result = {error, M_M_Images, K_W_Images, C_D_Images};
        return result;
    }
}