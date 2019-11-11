package com.example.gopherway;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        return map;
    }

    public static int findBuilding(String building) {
        return buildingList.get(building);
    }

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
        return result;
    }
}