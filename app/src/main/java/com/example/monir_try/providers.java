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

public class providers extends AppCompatActivity {

    private RecyclerView kpRecyclerView;
    private kp_ItemAdapter kpAdapter;
    private List<kp_ItemModel> kpItemList;

    private RecyclerView acRecyclerView;
    private ac_ItemAdapter acAdapter;
    private List<ac_ItemModel> acItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_providers);

        // Initialize RecyclerView for kitchen Partner
        kpRecyclerView = findViewById(R.id.kp_RecyclerView);
        kpRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        kpItemList = new ArrayList<>();

        //Add items to the list
        kpItemList.add(new kp_ItemModel(R.drawable.radhe_krishna));
        kpItemList.add(new kp_ItemModel(R.drawable.radhe_krishna));
        kpItemList.add(new kp_ItemModel(R.drawable.radhe_krishna));

        kpAdapter = new kp_ItemAdapter(this, kpItemList);
        kpRecyclerView.setAdapter(kpAdapter);


        // Initialize Recyclerviews for ALa Carta
        acRecyclerView = findViewById(R.id.ac_RecyclerView);
        acRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        acItemList = new ArrayList<>();

        //Add items to the list
        acItemList.add(new ac_ItemModel(R.drawable.achari_aloo, "Achari Aloo", "₹100", 0));
        acItemList.add(new ac_ItemModel(R.drawable.butter_milk, "Butter Milk", "₹50", 0));

        acAdapter = new ac_ItemAdapter(acItemList);
        acRecyclerView.setAdapter(acAdapter);


    }
}