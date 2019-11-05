package com.example.gopherway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayNavigationOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_navigation_options);

        Intent intent=getIntent();
        int currentLocation = (int)(intent.getIntExtra("CurrentLocation",0));
        int destination = (int)(intent.getIntExtra("Destination",0));

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText(Integer.toString(currentLocation));
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setText(Integer.toString(destination));
    }
}
