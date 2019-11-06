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
        String[] McNamaraToMoosTower = {};//TODO: Fill in path directions
        String[] RapsonToFord = {};//TODO: Fill in path directions
        String[] CoffmanToDiehl = {};//TODO: Fill in path directions
        String[][] result = {error, McNamaraToMoosTower, RapsonToFord, CoffmanToDiehl};
        return result;
    }
}