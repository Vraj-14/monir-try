package com.example.monir_try;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    private RecyclerView horizontalRecyclerView;
    private HorizontalAdapter adapter;
    private List<ItemModel> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page); // Make sure this is your layout file

        // Initialize the ImageView and set the click listener
        ImageView imageView4 = findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Location_1.class); // Replace with your target activity
                startActivity(intent);
            }
        });

        // Initialize RecyclerView and set layout manager
        horizontalRecyclerView = findViewById(R.id.horizontalRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontalRecyclerView.setLayoutManager(layoutManager);

        // Create a list of ItemModel objects
        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.pizza, "Pizza"));
        itemList.add(new ItemModel(R.drawable.gujarati_thali, "Gujarati"));
        itemList.add(new ItemModel(R.drawable.punjabi, "Punjabi"));
        itemList.add(new ItemModel(R.drawable.chinese, "Chinese"));

        // Initialize the adapter and set it on the RecyclerView
        adapter = new HorizontalAdapter(itemList, new HorizontalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemModel item) {
                Intent intent;
                switch (item.getItemName()) {
                    case "Pizza":
                        intent = new Intent(HomePage.this, Pizza.class);
                        startActivity(intent);
                        break;

                    case "Punjabi" :
                        intent = new Intent(HomePage.this, Pizza.class);

                }
            }
        });

        // Set the adapter for RecyclerView
        horizontalRecyclerView.setAdapter(adapter);
        Log.d("HomePage", "Adapter is attached to RecyclerView"); // Debugging log
    }
}
