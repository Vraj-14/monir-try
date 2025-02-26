package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseFirestore db;
    private TextView textView42, textView48; // Added textView48 for Dinner
    private ListenerRegistration listenerRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView42 = findViewById(R.id.textView42); // Lunch
        textView48 = findViewById(R.id.textView48); // Dinner
        db = FirebaseFirestore.getInstance();

        // Fetch food items from Firestore
        fetchFoodItems();

        ImageView imageView4 = findViewById(R.id.imageView4);
        imageView4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, HomePage.class);
            startActivity(intent);
        });

        ImageView imageview20 = findViewById(R.id.imageView20);
        imageview20.setOnClickListener(view -> {
            Log.d("HomePage", "Navigating to user_profile...");
            Intent intent = new Intent(MainActivity2.this, com.example.monir_try.user_profile.class);
            startActivity(intent);
            Log.d("HomePage", "Intent to user_profile started!");
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, cart.class);
            startActivity(intent);
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, cart.class);
            startActivity(intent);
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, plan_selection.class);
            startActivity(intent);
        });
    }

    // ------------ UPDATED FUNCTION TO FETCH BOTH LUNCH & DINNER DATA ---------------

    private void fetchFoodItems() {
        DocumentReference docRef = db.collection("Menu").document("Today");

        listenerRegistration = docRef.addSnapshotListener((documentSnapshot, e) -> {
            if (e != null) {
                Log.e("Firestore", "Error fetching data", e);
                return;
            }

            if (documentSnapshot != null && documentSnapshot.exists()) {
                String lunchMenu = documentSnapshot.getString("Lunch");
                String dinnerMenu = documentSnapshot.getString("Dinner");

                textView42.setText(lunchMenu != null ? lunchMenu : "No lunch menu available");
                textView48.setText(dinnerMenu != null ? dinnerMenu : "No dinner menu available");
            } else {
                textView42.setText("No lunch menu available");
                textView48.setText("No dinner menu available");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (listenerRegistration != null) {
            listenerRegistration.remove();
        }
    }
}
