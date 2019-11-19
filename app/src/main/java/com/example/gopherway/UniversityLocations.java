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
        map.put("Diehl", 3);
        map.put("Coffman", 4);
        map.put("Kolthoff", 5);
        map.put("Williamson", 6);
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
        String[] KolthoffToWilliamson = { "take elevator up to the 4th floor.",
                "turn right and head down hall 50m.",
                "turn the first left and head down hallway for another 50m.",
                "enter Smith Hall, walk 10m and turn right.",
                "walk to the end of the hall and turn left.",
                "walk 50 meters forward, towards the elevator",
                "take elevator down to level B",
                "exit elevator, turn left and walk towards the doors at the end of the corridor. Continue through doors and enter Walter Library",
                "at end of corridor, turn left then immediately the first right",
                "walk to the end of hallway (80m), turn right, and then left following hallway",
                "walk straight 100m",
                "Enter Johnson Hall. At end of hall, turn right",
                "Enter door labeled Northrop Garage and head up the stairs",
                "At the top of the stairs, open second door and enter Northrop Garage",
                "Walk across garage (200m) towards Morrill Hall",
                "Turn left and walk another 100m straight (down parking garage slope)",
                "Enter door towards Williamson Hall and follow tunnel path",
                "At the end of the tunnel, turn left, following signs to Williamson Hall",
                "At tunnel split, choose path on the left",
                "Head down the final hall and enter Williamson Hall"};
        String[] CoffmanToDiehl = {};//TODO: Fill in path directions
        String[][] result = {error, McNamaraToMoosTower, KolthoffToWilliamson, CoffmanToDiehl};
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
        int[] K_W_Images = { R.drawable.elevator_up,
                R.drawable.right,
                R.drawable.left,
                R.drawable.right,
                R.drawable.left,
                R.drawable.ahead,
                R.drawable.elevator_down,
                R.drawable.doubledoor,
                R.drawable.left,
                R.drawable.ahead,
                R.drawable.ahead,
                R.drawable.right,
                R.drawable.upstairs,
                R.drawable.door,
                R.drawable.ahead,
                R.drawable.left,
                R.drawable.door,
                R.drawable.left,
                R.drawable.left,
                R.drawable.ahead, };
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
        int[] K_W_Images = new int[]{ R.drawable.kw1,
                R.drawable.kw2,
                R.drawable.kw3,
                R.drawable.kw4,
                R.drawable.kw5,
                R.drawable.kw6,
                R.drawable.kw7,
                R.drawable.kw8,
                R.drawable.kw9,
                R.drawable.kw10,
                R.drawable.kw11,
                R.drawable.kw12,
                R.drawable.kw13,
                R.drawable.kw14,
                R.drawable.kw15,
                R.drawable.kw16,
                R.drawable.kw17,
                R.drawable.kw18,
                R.drawable.kw19,
                R.drawable.kw20 };
        int[] C_D_Images = {};  //TODO: Fill in path image keys
        int[][] result = {error, M_M_Images, K_W_Images, C_D_Images};
        return result;
    }

    //Returns array of drawables for each image of the map to be loaded per step of each route
    public static int[][] getMapImageArr(){
        int[] error = {-1};
        int[] M_M_Images = {R.drawable.m1,R.drawable.m2,R.drawable.m3,R.drawable.m4,R.drawable.m4,R.drawable.m4,R.drawable.m5,R.drawable.m6,R.drawable.m6,R.drawable.m6,R.drawable.m7,R.drawable.m8,R.drawable.m8,R.drawable.m9};
        int[] K_W_Images = {R.drawable.k1,R.drawable.k2,R.drawable.k3,R.drawable.k4,R.drawable.k5,R.drawable.k6,R.drawable.k7};
        int[] C_D_Images = {R.drawable.l1,R.drawable.l2,R.drawable.l3,R.drawable.l4};
        int[][] result = {error, M_M_Images, K_W_Images, C_D_Images};
        return result;
    }
}