package com.example.gopherway.ui.travelhistory;

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

public class TravelHistoryFragment extends Fragment {

    private TravelHistoryViewModel travelHistoryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        travelHistoryViewModel =
                ViewModelProviders.of(this).get(TravelHistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_travel_history, container, false);
        final TextView textView = root.findViewById(R.id.text_travel_history);
        travelHistoryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}