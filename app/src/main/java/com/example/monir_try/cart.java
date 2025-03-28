package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class cart extends AppCompatActivity {

    private FirebaseFirestore db;
    private TextView textViewPrice; // TextView to display price

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        // Find Views
        textViewPrice = findViewById(R.id.textView61); // TextView to display price

        // Retrieve price from Firestore
        retrievePriceFromFirestore();

        // Existing Code (UNCHANGED)
        ImageView imageView4 = findViewById(R.id.imageView4);
        imageView4.setOnClickListener(v -> {
            Intent intent = new Intent(cart.this, Location_1.class);
            startActivity(intent);
        });

        ImageView imageview20 = findViewById(R.id.imageView20);
        imageview20.setOnClickListener(view -> {
            Log.d("HomePage", "Navigating to user_profile...");
            Intent intent = new Intent(cart.this, com.example.monir_try.user_profile.class);
            startActivity(intent);
            Log.d("HomePage", "Intent to user_profile started!");
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(v -> {
            Intent intent = new Intent(cart.this, payment.class);
            startActivity(intent);
        });
    }

    // ✅ Retrieve Price from Firestore
    private void retrievePriceFromFirestore() {
        DocumentReference docRef = db.collection("TiffinProviders").document("Provider1");

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    Long price = documentSnapshot.getLong("price"); // Get price as Number
                    if (price != null) {
                        textViewPrice.setText("Rs. " + price); // Set text in TextView
                    } else {
                        textViewPrice.setText("Rs. 0"); // If price is missing
                    }
                } else {
                    textViewPrice.setText("Rs. 0"); // If document doesn't exist
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(cart.this, "Failed to load price", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
