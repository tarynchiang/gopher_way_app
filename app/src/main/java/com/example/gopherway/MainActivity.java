package com.example.gopherway;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
/*
        Spinner select_start = (Spinner) findViewById(R.id.spinner_start);
        Spinner select_destination = (Spinner) findViewById(R.id.spinner_destination);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.buildings));

        //myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_start.setAdapter(myAdapter);
        select_destination.setAdapter(myAdapter);
*/
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_saved_locations, R.id.nav_travel_history,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /**Called when the user taps the Search button */
    public void search(View view){
        /*
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String currentLocation = editText.getText().toString();
        String destination = editText2.getText().toString();
        UniversityLocations test = new UniversityLocations();
        int x = UniversityLocations.findBuilding(currentLocation);
        int y = UniversityLocations.findBuilding(destination);
        //Intent intent = new Intent(this, DisplayNavigationOptions.class);
        */

        //Changed Input to selection from list rather than reading in a string
        Spinner select_start = (Spinner) findViewById(R.id.spinner_start);
        Spinner select_destination = (Spinner) findViewById(R.id.spinner_destination);
        //String currentLocation = select_start.getText().toString();
        //String destination = select_destination.getText().toString();
        int startID = select_start.getSelectedItemPosition();
        int destinationID = select_destination.getSelectedItemPosition();
        //short circuiting to this screen for now
        Intent intent = new Intent(this, DisplayNavigationOptions.class);
        intent.putExtra("CurrentLocation", startID);
        intent.putExtra("Destination", destinationID);
        startActivity(intent);
    }
}
