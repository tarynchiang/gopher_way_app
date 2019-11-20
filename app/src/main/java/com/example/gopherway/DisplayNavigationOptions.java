package com.example.gopherway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    Direction[][] directionArr = UniversityLocations.getDirectionArr();
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
        if(currentLocation == 20 && destination == 23){routeOption=0;}
        else if(currentLocation == 16 && destination == 36){routeOption=1;}
        else if(currentLocation == 7 && destination ==6){routeOption=2;}
        else{routeOption=0;}

        //TextView for Direction Information -- Display first Step
        directions = (TextView)findViewById(R.id.textView2);
        directions.setText(directionArr[routeOption][stepNumber].getDescription());

        //Image view for direction arrows
        directionImage = (ImageView)findViewById(R.id.imageView4);
        directionImage.setImageResource(directionArr[routeOption][stepNumber].getDirImg());

        //Image view for route images
        //routeImage = (ImageView)findViewById(R.id.imageView3);
        //routeImage.setImageResource(routeImageArr[routeOption][stepNumber]);

        //Image view for route map images
        routeImage = (ImageView)findViewById(R.id.imageView3);
        routeImage.setImageResource(directionArr[routeOption][stepNumber].getmapImg());

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
        directions.setText(directionArr[routeOption][stepNumber].getDescription());
        //Update directional image
        directionImage.setImageResource(directionArr[routeOption][stepNumber].getDirImg());
        //Update route image
        if (displayMap) {
            routeImage.setImageResource(directionArr[routeOption][stepNumber].getmapImg());
        } else {
            routeImage.setImageResource(directionArr[routeOption][stepNumber].getrealImg());
        }
    }

    public void moreInfoClick(View view){
        displayMap = !displayMap;
        if (displayMap) {
            routeImage.setImageResource(directionArr[routeOption][stepNumber].getmapImg());
            infoButton.setImageResource(R.drawable.image);
        } else {
            routeImage.setImageResource(directionArr[routeOption][stepNumber].getrealImg());
            infoButton.setImageResource(R.drawable.map);
        }
    }

    public void nextButtonClick(View view){
        if(stepNumber != directionArr[routeOption].length-1) {
            stepNumber++;
        }
        //Update directional text
        directions.setText(directionArr[routeOption][stepNumber].getDescription());
        //Update directional image
        directionImage.setImageResource(directionArr[routeOption][stepNumber].getDirImg());
        //Update route image
        if(displayMap) {
            routeImage.setImageResource(directionArr[routeOption][stepNumber].getmapImg());
        }
        else{
            routeImage.setImageResource(directionArr[routeOption][stepNumber].getrealImg());
        }
    }
}
