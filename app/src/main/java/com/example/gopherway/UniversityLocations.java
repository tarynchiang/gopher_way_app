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
    public static Direction[][] getDirectionArr() {
        String[] error = {"Error: Path not found"};
        //14 steps
        Direction[] McNamaraToMoosTower = {
                new Direction(
                        "Start at Fireplace in Macnamara.",
                        R.drawable.ahead,
                        R.drawable.mm1,
                        R.drawable.m1),
                new Direction("Take the stairs to the right of the fireplace down.",
                        R.drawable.downstairs,
                        R.drawable.mm2,
                        R.drawable.m2),
                new Direction("Follow the tunnel until the elevator.",
                        R.drawable.ahead,
                        R.drawable.mm3,
                        R.drawable.m3),
                new Direction("Take the elevator up to the skyway (level 2).",
                        R.drawable.elevator_up,
                        R.drawable.mm4,
                        R.drawable.m4),
                new Direction("Take a right and enter graduate hotel.",
                        R.drawable.right,
                        R.drawable.mm5,
                        R.drawable.m4),
                new Direction("Take a right.",
                        R.drawable.right,
                        R.drawable.mm6,
                        R.drawable.m4),
                new Direction("Follow right wall until brown double doors.",
                        R.drawable.ahead,
                        R.drawable.mm7,
                        R.drawable.m5),
                new Direction("Follow skyway to the parking garage, go through the first set of doors.",
                        R.drawable.ahead,
                        R.drawable.mm8,
                        R.drawable.m6),
                new Direction("Go through the doors to the left.",
                        R.drawable.left,
                        R.drawable.mm9,
                        R.drawable.m6),
                new Direction("Follow the hallway past the first door.",
                        R.drawable.ahead,
                        R.drawable.mm10,
                        R.drawable.m6),
                new Direction("Go through the tan double doors",
                        R.drawable.doubledoor,
                        R.drawable.mm11,
                        R.drawable.m7),
                new Direction("Follow hallway to the end and go through the doors.",
                        R.drawable.ahead,
                        R.drawable.mm11,
                        R.drawable.m8),
                new Direction("Take elevator down to the basement (level B).",
                        R.drawable.elevator_down,
                        R.drawable.mm12,
                        R.drawable.m8),
                new Direction("Take a right and follow hallway to Moos Tower.",
                        R.drawable.right,
                        R.drawable.mm13,
                        R.drawable.m9
                )
        };
        Direction[] KolthoffToWilliamson = {
                new Direction("take elevator up to the 4th floor.",
                        R.drawable.elevator_up,
                        R.drawable.kw1,
                        R.drawable.k1),
                new Direction("turn right and head down hall 50m.",
                        R.drawable.right,
                        R.drawable.kw2,
                        R.drawable.k1),
                new Direction("turn the first left and head down hallway for another 50m.",
                        R.drawable.left,
                        R.drawable.kw3,
                        R.drawable.k2),
                new Direction("enter Smith Hall, walk 10m and turn right.",
                        R.drawable.right,
                        R.drawable.kw4,
                        R.drawable.k2),
                new Direction("walk to the end of the hall and turn left.",
                        R.drawable.left,
                        R.drawable.kw5,
                        R.drawable.k3),
                new Direction("walk 50 meters forward, towards the elevator",
                        R.drawable.ahead,
                        R.drawable.kw6,
                        R.drawable.k3),
                new Direction("take elevator down to level B",
                        R.drawable.elevator_down,
                        R.drawable.kw7,
                        R.drawable.k3),
                new Direction("exit elevator, turn left and walk through the doors",
                        R.drawable.doubledoor,
                        R.drawable.kw8,
                        R.drawable.k3),
                new Direction("at end of corridor, turn left then immediately the first right",
                        R.drawable.left,
                        R.drawable.kw9,
                        R.drawable.k4),
                new Direction("walk to the end of hallway (80m), turn right, then left",
                        R.drawable.ahead,
                        R.drawable.kw10,
                        R.drawable.k4),
                new Direction("walk straight 100m",
                        R.drawable.ahead,
                        R.drawable.kw11,
                        R.drawable.k4),
                new Direction("Enter Johnson Hall. At end of hall, turn right",
                        R.drawable.right,
                        R.drawable.kw12,
                        R.drawable.k5),
                new Direction("Enter door labeled Northrop Garage and head up the stairs",
                        R.drawable.upstairs,
                        R.drawable.kw13,
                        R.drawable.k5),
                new Direction("Open second door and enter Northrop Garage",
                        R.drawable.door,
                        R.drawable.kw14,
                        R.drawable.k5),
                new Direction("Walk across garage (200m) towards Morrill Hall",
                        R.drawable.ahead,
                        R.drawable.kw15,
                        R.drawable.k6),
                new Direction("Turn left and walk another 100m straight (down slope)",
                        R.drawable.left,
                        R.drawable.kw16,
                        R.drawable.k7),
                new Direction("Enter door towards Williamson Hall and follow tunnel path",
                        R.drawable.door,
                        R.drawable.kw17,
                        R.drawable.k7),
                new Direction("At the end of the tunnel, turn left",
                        R.drawable.left,
                        R.drawable.kw18,
                        R.drawable.k7),
                new Direction("At tunnel split, choose path on the left",
                        R.drawable.left,
                        R.drawable.kw19,
                        R.drawable.k7),
                new Direction("Head down the final hall and enter Williamson Hall",
                        R.drawable.ahead,
                        R.drawable.kw20,
                        R.drawable.k7)
        };
        Direction[] CoffmanToDiehl = {
                new Direction("Take elevator down to the second floor.",
                        R.drawable.elevator_down,
                        R.drawable.ll1,
                        R.drawable.l1),
                new Direction("Go straight to access the P_W Bulidings.",
                        R.drawable.ahead,
                        R.drawable.ll2,
                        R.drawable.l1),
                new Direction("Turn left at the sign to Mayo building.",
                        R.drawable.left,
                        R.drawable.ll3,
                        R.drawable.l2),
                new Direction("walk across the tunnel, turn left.",
                        R.drawable.left,
                        R.drawable.ll4,
                        R.drawable.l3),
                new Direction("walk across the Mayo building.",
                        R.drawable.ahead,
                        R.drawable.ll5,
                        R.drawable.l3),
                new Direction("Take the elevator down to the lower floor.",
                        R.drawable.elevator_down,
                        R.drawable.ll6,
                        R.drawable.l3),
                new Direction("walk across the tunnel, enter Coffman Hall.",
                        R.drawable.ahead,
                        R.drawable.ll7,
                        R.drawable.l4)
        };//TODO: Fill in path directions
        Direction[][] result = {McNamaraToMoosTower, KolthoffToWilliamson, CoffmanToDiehl};
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
        int[] C_D_Images = {
                R.drawable.elevator_down,
                R.drawable.ahead,
                R.drawable.left,
                R.drawable.left,
            R.drawable.ahead,
         R.drawable.elevator_down,
            R.drawable.ahead
        };  
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
        int[] C_D_Images = {
               R.drawable.l1,
                R.drawable.l1,
                R.drawable.l2,
                R.drawable.l3,
                R.drawable.l3,
                R.drawable.l3,
                R.drawable.l4
        
        };  
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
