package com.example.gopherway;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DirectionListActivity extends AppCompatActivity {
    List<Direction> directionList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        directionList = new ArrayList<>();


        //Example directions, will be generated after path is calculated
        directionList.add(
                new Direction(
                        1,
                        "Take right",
                        "At end of hall",
                        20,
                        R.drawable.right));

        directionList.add(
                new Direction(
                        1,
                        "Walk straight",
                        "Until doorway",
                        60,
                        R.drawable.ahead));

        directionList.add(
                new Direction(
                        1,
                        "Go Up stairs on left",
                        "",
                        0,
                        R.drawable.upstairs));

        DirectionAdapter adapter = new DirectionAdapter(this, directionList);

        recyclerView.setAdapter(adapter);
    }
}
