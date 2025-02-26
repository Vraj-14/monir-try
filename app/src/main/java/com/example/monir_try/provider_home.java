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
import java.util.Collections;
import java.util.List;

public class provider_home extends AppCompatActivity {

    private RecyclerView provider_RecyclerView;
    private provider_ItemAdapter providerItemAdapter;
    private List<provider_ItemModel> provider_itemList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_provider_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        provider_RecyclerView = findViewById(R.id.provider_RecyclerView);
        provider_RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data for providerItemList
        provider_itemList = new ArrayList<>();
        provider_itemList.add(new provider_ItemModel(R.drawable.image_10,"Total Order",23));
        provider_itemList.add(new provider_ItemModel(R.drawable.container_4,"Active Subscription",17));
        provider_itemList.add(new provider_ItemModel(R.drawable.container_6,"Revenue Summary",15750));

        provider_RecyclerView.setAdapter(providerItemAdapter);
    }
}