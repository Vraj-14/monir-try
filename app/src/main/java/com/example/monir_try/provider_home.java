package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

// for Radhe Krishna Kitchen
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

        ImageView imageView2 = findViewById(R.id.imageView2); //profile
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(provider_home.this, provider_dashboard.class);
                startActivity(intent);
            }
        });

        ImageView imageView4 = findViewById(R.id.imageView4); // Back Button
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(provider_home.this, provider_options.class);
                startActivity(intent);
            }
        });

        TextView textView82 = findViewById(R.id.textView82);// Proceed for Menu Setting
        textView82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(provider_home.this, Provider_MainMenu.class);
                startActivity(intent);
            }
        });

        // ----------- Firestore Code Starts Here -----------
        TextView textView11 = findViewById(R.id.textView11);
        TextView textView80 = findViewById(R.id.textView80); // Target TextView

        FirebaseFirestore db = FirebaseFirestore.getInstance(); // Initialize Firestore

        // Reference to the document in Firestore
        DocumentReference docRef = db.collection("ProvidersName").document("Radhe Krishna Kitchen");

        // Fetch and set the data
        docRef.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                String name = documentSnapshot.getString("Name");

                Long totalOrdersLong = documentSnapshot.getLong("Total Orders");
                int totalOrders = totalOrdersLong != null ? totalOrdersLong.intValue() : 0;

                textView11.setText(name);
                textView80.setText(String.valueOf(totalOrders));
            } else {
                textView11.setText("No data found");
                textView80.setText("0");
            }
        }).addOnFailureListener(e -> {
            textView11.setText("Failed to load");
            textView80.setText("0");
        });




        // ----------- Firestore Code Ends Here -----------

    }
}
