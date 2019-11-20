package com.example.gopherway.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.gopherway.DisplayNavigationOptions;
import com.example.gopherway.R;
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
import android.widget.Toast;

public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private HomeViewModel homeViewModel;
    Button mButton;
    EditText mEdit;
    EditText mEdit2;
    Spinner select_start;
    Spinner select_destination;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        select_start = (Spinner) root.findViewById(R.id.spinner_start);
        select_destination = (Spinner) root.findViewById(R.id.spinner_destination);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.buildings, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        select_start.setAdapter(adapter);
        select_start.setOnItemSelectedListener(this);

        select_destination.setAdapter(adapter);
        select_destination.setOnItemSelectedListener(this);

        mButton = (Button) root.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int startID = select_start.getSelectedItemPosition();
                int destinationID = select_destination.getSelectedItemPosition();
                Intent intent = new Intent(getActivity(), DisplayNavigationOptions.class);
                intent.putExtra("CurrentLocation", startID);
                intent.putExtra("Destination", destinationID);
                startActivity(intent);
            }
        });


        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //mButton = (Button)findViewById(R.id.button);
        //mEdit = (EditText)findViewById(R.id.editText);
        //mEdit2 = (EditText)findViewById(R.id.editText2);
        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(), adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
/*
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        select_start = (Spinner) getView().findViewById(R.id.spinner_start);
        select_destination = (Spinner) getView().findViewById(R.id.spinner_destination);
        mButton = (Button) getView().findViewById(R.id.button);
    }
/*
    public void search(){
        int startID = select_start.getSelectedItemPosition();
        int destinationID = select_destination.getSelectedItemPosition();
        Intent intent = new Intent(getActivity(), DisplayNavigationOptions.class);
        intent.putExtra("CurrentLocation", startID);
        intent.putExtra("Destination", destinationID);
        startActivity(intent);
    }

 */
}