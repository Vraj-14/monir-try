package com.example.monir_try;

import android.os.Bundle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Overview extends AppCompatActivity {
    private RecyclerView kpRecyclerView;
    private kp_ItemAdapter kpAdapter;
    private List<kp_ItemModel> kpItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        kpRecyclerView = findViewById(R.id.kp_RecyclerView);
        kpRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        kpItemList = new ArrayList<>();

        //Add items to the list
        kpItemList.add(new kp_ItemModel(R.drawable.radhe_krishna));
        kpItemList.add(new kp_ItemModel(R.drawable.radhe_krishna));
        kpItemList.add(new kp_ItemModel(R.drawable.radhe_krishna));

        kpAdapter = new kp_ItemAdapter(this, kpItemList);
        kpRecyclerView.setAdapter(kpAdapter);


    }

}