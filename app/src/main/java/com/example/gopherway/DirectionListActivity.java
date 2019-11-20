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

        DirectionAdapter adapter = new DirectionAdapter(this, directionList);

        recyclerView.setAdapter(adapter);
    }
}
