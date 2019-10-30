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

public class SavedLocationsFragment extends Fragment {

    private SavedLocationsViewModel savedLocationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        savedLocationsViewModel =
                ViewModelProviders.of(this).get(SavedLocationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_saved_locations, container, false);
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