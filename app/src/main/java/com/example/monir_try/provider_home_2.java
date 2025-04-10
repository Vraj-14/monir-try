package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class provider_home_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_provider_home2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ImageView imageView34 = findViewById(R.id.imageView34); // Back Button
        imageView34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(provider_home_2.this, provider_options.class);
                startActivity(intent);
            }
        });

        TextView textView102 = findViewById(R.id.textView102);// Proceed for Menu Setting
        textView102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(provider_home_2.this, provider_main_menu_2.class);
                startActivity(intent);
            }
        });

        // ----------- Firestore Code Starts Here -----------
        TextView textView97 = findViewById(R.id.textView97);
        TextView textView100 = findViewById(R.id.textView100); // Target TextView

        FirebaseFirestore db = FirebaseFirestore.getInstance(); // Initialize Firestore

        // Reference to the document in Firestore
        DocumentReference docRef = db.collection("ProvidersName").document("Mahi Krupa Kitchen");

        // Fetch and set the data
        docRef.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                String name = documentSnapshot.getString("Name");
                String totalOrders = documentSnapshot.getString("Total Orders");
                textView97.setText(name);
                textView100.setText(totalOrders);
            } else {
                textView97.setText("No data found");
                textView100.setText("0");
            }
        }).addOnFailureListener(e -> {
            textView97.setText("Failed to load");
            textView100.setText("0");
        });
        // ----------- Firestore Code Ends Here -----------


    }
}