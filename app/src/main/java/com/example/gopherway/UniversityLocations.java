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
        String[] M_M_Directions = {};//TODO: Fill in path directions
        String[] K_W_Directions = {};//TODO: Fill in path directions
        String[] C_D_Directions = {};//TODO: Fill in path directions
        String[][] result = {error, M_M_Directions, K_W_Directions, C_D_Directions};
        return result;
    }

    //Returns array of integers which correspond with what directional image to display for each step for each route
    public static int[][] getImageArr() {
        int[] error = {-1};
        int[] M_M_Images = {};
        int[] K_W_Images = {};
        int[] C_D_Images = {};
        int[][] result = {error, M_M_Images, K_W_Images, C_D_Images};
        return result;
    }
}