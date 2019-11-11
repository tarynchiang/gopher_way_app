package com.example.gopherway;

import java.util.HashMap;
import java.util.Map;

public class UniversityLocations {

    UniversityLocations() {
    }

    public static Map<String, Integer> buildingList = createMap();

    private static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("McNamara", 1);
        map.put("Moos Tower", 2);
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
                "Take a right and follow hallway to Moos Tower."};//TODO: Fill in path directions
        String[] RapsonToFord = {};//TODO: Fill in path directions
        String[] CoffmanToDiehl = {};//TODO: Fill in path directions
        String[][] result = {error, McNamaraToMoosTower, RapsonToFord, CoffmanToDiehl};
        String[] M_M_Directions = {};//TODO: Fill in path directions
        String[] K_W_Directions = {};//TODO: Fill in path directions
        String[] C_D_Directions = {};//TODO: Fill in path directions
        String[][] result = {error, M_M_Directions, K_W_Directions, C_D_Directions};
        return result;
    }

    //Returns array of integers which correspond with what directional image to display for each step for each route
    // 0 = forward
    // 1 = left
    // 2 = right
    // 3 = stairs
    // 4 = elevator
    public static int[][] getImageArr() {
        int[] error = {-1};
        int[] M_M_Images = {};  //TODO: Fill in path image keys
        int[] K_W_Images = {};  //TODO: Fill in path image keys
        int[] C_D_Images = {};  //TODO: Fill in path image keys
        int[][] result = {error, M_M_Images, K_W_Images, C_D_Images};
        return result;
    }

    public static int[][] getRouteImageArr(){
        //TODO: fill this out
        int[][] result = {};
        return result;
    }
}