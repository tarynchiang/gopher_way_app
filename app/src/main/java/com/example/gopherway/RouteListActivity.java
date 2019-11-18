package com.example.gopherway;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RouteListActivity extends AppCompatActivity {

    //a list to store all the products
    List<Route> routeList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_saved_locations);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.routeCard);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the routelist
        routeList = new ArrayList<>();


        //adding some items to our list
        routeList.add(
                new Route(
                        1,
                        "McNamara",
                        "Moos"));

        routeList.add(
                new Route(
                        1,
                        "Rapson",
                        "Coffman"));

        //creating recyclerview adapter
        RouteAdapter adapter = new RouteAdapter(this, routeList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}