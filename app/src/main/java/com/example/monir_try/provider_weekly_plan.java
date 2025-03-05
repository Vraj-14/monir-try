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

public class provider_weekly_plan extends AppCompatActivity {

    private RecyclerView roti_RecyclerView;
    private pr_itemAdapter roti_ItemAdapter;
    private List<pr_itemModel> roti_itemList; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_provider_weekly_plan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        roti_RecyclerView = findViewById(R.id.provider_roti);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        roti_RecyclerView.setLayoutManager(layoutManager);


        roti_itemList = new ArrayList<>();
        roti_itemList.add(new pr_itemModel("Chapati")); //
        roti_itemList.add((new pr_itemModel("Naan")));
        roti_itemList.add(new pr_itemModel("Tandoori Roti"));

        // ✅ Use the correct adapter
        roti_ItemAdapter = new pr_itemAdapter(this, roti_itemList, item -> {
            // Handle item click (if needed)
        });
        roti_RecyclerView.setAdapter(roti_ItemAdapter);
        roti_ItemAdapter.notifyDataSetChanged(); //  Force RecyclerView to refresh

    }
}
