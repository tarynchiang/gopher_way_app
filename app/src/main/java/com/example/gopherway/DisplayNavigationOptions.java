package com.example.gopherway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayNavigationOptions extends AppCompatActivity {

    ImageButton backButton;
    ImageButton infoButton;
    ImageButton nextButton;
    ImageView directionImage;
    ImageView routeImage;
    TextView directions;
    int routeOption = 0;
    int stepNumber = 0;
    boolean displayMap = true;
    String[][] directionTextArr = UniversityLocations.getDirectionArr();
    int[][] directionImageArr = UniversityLocations.getImageArr();
    int[][] routeImageArr = UniversityLocations.getRouteImageArr();
    int[][] routeMapArr = UniversityLocations.getMapImageArr();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_navigation_options);

        Intent intent = getIntent();

        //Load id's for buildings that were entered on main screen
        int currentLocation = (int)(intent.getIntExtra("CurrentLocation",0));
        int destination = (int)(intent.getIntExtra("Destination",0));

        //Decide which route option to begin displaying
        if(currentLocation == 1 && destination == 2){routeOption=1;}
        else if(currentLocation == 3 && destination ==4){routeOption=2;}
        else if(currentLocation == 5 && destination ==6){routeOption=3;}
        else{routeOption=1;}

        //TextView for Direction Information -- Display first Step
        directions = (TextView)findViewById(R.id.textView2);
        directions.setText(directionTextArr[routeOption][stepNumber]);

        //Image view for direction arrows
        directionImage = (ImageView)findViewById(R.id.imageView4);
        directionImage.setImageResource(directionImageArr[routeOption][stepNumber]);

        //Image view for route images
        //routeImage = (ImageView)findViewById(R.id.imageView3);
        //routeImage.setImageResource(routeImageArr[routeOption][stepNumber]);

        //Image view for route map images
        routeImage = (ImageView)findViewById(R.id.imageView3);
        routeImage.setImageResource(routeMapArr[routeOption][stepNumber]);

        //Bottom Page Button Navigation
        backButton = (ImageButton) findViewById(R.id.imageButton2);
        infoButton = (ImageButton) findViewById(R.id.imageButton3);
        nextButton = (ImageButton) findViewById(R.id.imageButton);
    }

    public void backButtonClick(View view) {

        if (stepNumber != 0) {
            stepNumber--;
        }
        //Update directional text
        directions.setText(directionTextArr[routeOption][stepNumber]);
        //Update directional image
        directionImage.setImageResource(directionImageArr[routeOption][stepNumber]);
        //Update route image
        if (displayMap) {
            routeImage.setImageResource(routeMapArr[routeOption][stepNumber]);
        } else {
            routeImage.setImageResource(routeImageArr[routeOption][stepNumber]);
        }
    }

    public void moreInfoClick(View view){
        displayMap = !displayMap;
        if (displayMap) {
            routeImage.setImageResource(routeMapArr[routeOption][stepNumber]);
            infoButton.setImageResource(R.drawable.image);
        } else {
            routeImage.setImageResource(routeImageArr[routeOption][stepNumber]);
            infoButton.setImageResource(R.drawable.map);
        }
    }

    public void nextButtonClick(View view){
        if(stepNumber != directionTextArr[routeOption].length-1) {
            stepNumber++;
        }
        //Update directional text
        directions.setText(directionTextArr[routeOption][stepNumber]);
        //Update directional image
        directionImage.setImageResource(directionImageArr[routeOption][stepNumber]);
        //Update route image
        if(displayMap) {
            routeImage.setImageResource(routeMapArr[routeOption][stepNumber]);
        }
        else{
            routeImage.setImageResource(routeImageArr[routeOption][stepNumber]);
        }
    }
}
