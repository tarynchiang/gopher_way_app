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

public class SavedLocationsFragment extends Fragment {

    private SavedLocationsViewModel savedLocationsViewModel;
    private static List<Route> routeList;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        savedLocationsViewModel =
                ViewModelProviders.of(this).get(SavedLocationsViewModel.class);

        routeList = new ArrayList<>();
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


}