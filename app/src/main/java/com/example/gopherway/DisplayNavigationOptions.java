package com.example.gopherway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DisplayNavigationOptions extends AppCompatActivity {

    Button backButton;
    Button infoButton;
    Button nextButton;
    TextView directions;
    int routeOption=0;
    String[][] directionArr = UniversityLocations.getDirectionArr();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_navigation_options);

        Intent intent=getIntent();
        int currentLocation = (int)(intent.getIntExtra("CurrentLocation",0));
        int destination = (int)(intent.getIntExtra("Destination",0));

        //Decide which route option to begin displaying
        if(currentLocation == 1 && destination ==2){routeOption=1;}
        else if(currentLocation == 3 && destination ==4){routeOption=2;}
        else if(currentLocation == 5 && destination ==6){routeOption=3;}

        //TextView for Direction Information -- Display first Step
        directions = (TextView)findViewById(R.id.textView2);
        directions.setText(directionArr[routeOption][0]);

        //Bottom Page Button Navigation
        backButton = (Button) findViewById(R.id.button2);
        infoButton = (Button) findViewById(R.id.button3);
        nextButton = (Button) findViewById(R.id.button4);
    }

    public void backButtonClick(){}

    public void moreInfoClick(){}

    public void nextButtonClick(){}
}
