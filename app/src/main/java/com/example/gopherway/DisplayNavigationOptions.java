package com.example.gopherway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayNavigationOptions extends AppCompatActivity {

    Button backButton;
    Button infoButton;
    Button nextButton;
    ImageView directionImage;
    ImageView routeImage;
    TextView directions;
    int routeOption =0;
    int stepNumber = 0;
    String[][] directionTextArr = UniversityLocations.getDirectionArr();
    int[][] directionImageArr = UniversityLocations.getImageArr();
    int[][] routeImageArr = UniversityLocations.getRouteImageArr();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_navigation_options);

        Intent intent=getIntent();

        //Load id's for buildings that were entered on main screen
        int currentLocation = (int)(intent.getIntExtra("CurrentLocation",0));
        int destination = (int)(intent.getIntExtra("Destination",0));

        //Decide which route option to begin displaying
        if(currentLocation == 1 && destination ==2){routeOption=1;}
        else if(currentLocation == 3 && destination ==4){routeOption=2;}
        else if(currentLocation == 5 && destination ==6){routeOption=3;}

        //TextView for Direction Information -- Display first Step
        directions = (TextView)findViewById(R.id.textView2);
        directions.setText(directionTextArr[routeOption][stepNumber]);

        //Image view for direction arrows
        directionImage = (ImageView)findViewById(R.id.imageView4);
        //TODO: Load in images properly
        directionImage.setImageResource(directionImageArr[routeOption][stepNumber]);

        //Image view for route images
        routeImage = (ImageView)findViewById(R.id.imageView3);
        //TODO: Load in images properly
        routeImage.setImageResource(routeImageArr[routeOption][stepNumber]);

        //Bottom Page Button Navigation
        backButton = (Button) findViewById(R.id.button2);
        infoButton = (Button) findViewById(R.id.button3);
        nextButton = (Button) findViewById(R.id.button4);
    }

    public void backButtonClick(View view){
        stepNumber--;
        //Update directional text
        directions.setText(directionTextArr[routeOption][stepNumber]);
        //Update directional image
        directionImage.setImageResource(directionImageArr[routeOption][stepNumber]);
        //Update route image
        routeImage.setImageResource(routeImageArr[routeOption][stepNumber]);}

    public void moreInfoClick(){}

    public void nextButtonClick(View view){
        stepNumber++;
        //Update directional text
        directions.setText(directionTextArr[routeOption][stepNumber]);
        //Update directional image
        directionImage.setImageResource(directionImageArr[routeOption][stepNumber]);
        //Update route image
        routeImage.setImageResource(routeImageArr[routeOption][stepNumber]);
    }
}
