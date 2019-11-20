package com.example.gopherway.ui.savedlocations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.gopherway.R;
import com.example.gopherway.Route;
import com.example.gopherway.RouteAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

public class SavedLocationsFragment extends Fragment {

    private SavedLocationsViewModel savedLocationsViewModel;
    private static List<Route> routeList;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        savedLocationsViewModel =
                ViewModelProviders.of(this).get(SavedLocationsViewModel.class);

//        routeList = new ArrayList<>();
//        routeList.add(
//                new Route(
//                        1,
//                        "McNamara",
//                        "Moos"));
//
//        routeList.add(
//                new Route(
//                        1,
//                        "Rapson",
//                        "Coffman"));

        this.loadRoutes();

        View root = inflater.inflate(R.layout.fragment_saved_locations, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.routeCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RouteAdapter adapter = new RouteAdapter(getActivity(), routeList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


        final TextView textView = root.findViewById(R.id.text_saved_locations);
        savedLocationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }


    public void loadRoutes(){
        FileInputStream fis = null;
        routeList = new ArrayList<>();
        try{
            fis = getActivity().openFileInput("savedRoutes");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                routeList.add(new Route(1,text,text));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}