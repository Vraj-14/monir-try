package com.example.monir_try;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Location_4 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LocationAdapter adapter;
    private List<LocationItem> locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location4);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of LocationItem objects
        locationList = new ArrayList<>();
        locationList.add(new LocationItem(R.drawable.distance,"100 meter", "Gitanjali Society","Tarsali"));
        locationList.add(new LocationItem(R.drawable.distance,"1.5 Km", "Indraprasth Society","Makarpura"));
        locationList.add(new LocationItem(R.drawable.distance,"2.5 Km", "Anand Baug Society","Karelibaug"));
        locationList.add(new LocationItem(R.drawable.distance,"3 Km", "Vrundavan Society","Makarpura"));

        // Create and set the adapter
        adapter = new LocationAdapter(this, locationList);
        recyclerView.setAdapter(adapter);


    }
}