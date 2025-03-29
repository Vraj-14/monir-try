package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseFirestore db;
    private TextView textView42, textView48; // Lunch & Dinner TextViews
    private ListenerRegistration listenerRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize Firestore and UI Elements
        db = FirebaseFirestore.getInstance();
        textView42 = findViewById(R.id.textView42); // Lunch
        textView48 = findViewById(R.id.textView48); // Dinner

        // Fetch food items from Firestore in real-time
        fetchFoodItems();

        // Button Click Listeners (UNCHANGED)
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

    // ✅ UPDATED: Fetch Both Lunch & Dinner Data in Real-Time


//    private void fetchFoodItems() {
//        // ✅ Get the current day (Monday, Tuesday, etc.)
//        String today = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(Calendar.getInstance().getTime());
//
//        // ✅ Use today's day name as the Firestore document
//        DocumentReference docRef = db.collection("Menu").document(today);
//
//        listenerRegistration = docRef.addSnapshotListener((documentSnapshot, e) -> {
//            if (e != null) {
//                Log.e("Firestore", "Error fetching data", e);
//                Toast.makeText(MainActivity2.this, "Failed to load menu", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            if (documentSnapshot != null && documentSnapshot.exists()) {
//                String lunchMenu = documentSnapshot.getString("Lunch");
//                String dinnerMenu = documentSnapshot.getString("Dinner");
//
//                textView42.setText(lunchMenu != null ? lunchMenu : "Lunch menu not available");
//                textView48.setText(dinnerMenu != null ? dinnerMenu : "Dinner menu not available");
//
//                Log.d("Firestore", "Menu Updated: Lunch = " + lunchMenu + ", Dinner = " + dinnerMenu);
//            } else {
//                textView42.setText("Lunch menu not available");
//                textView48.setText("Dinner menu not available");
//                Log.w("Firestore", "Document does not exist for " + today);
//            }
//        });
//    }

    private void fetchFoodItems() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("TiffinProviders").document("Provider1");

        docRef.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                // Retrieve values from Firestore
                String primarySabji = documentSnapshot.getString("Primary Sabji");
                String secondarySabji = documentSnapshot.getString("Secondary Sabji");
                String dal = documentSnapshot.getString("Dal");
                String extra1 = documentSnapshot.getString("Extra1");
                String extra2 = documentSnapshot.getString("Extra2");
                String extra3 = documentSnapshot.getString("Extra3");

                // Handle null values to avoid "null" in TextView
                if (primarySabji == null) primarySabji = "";
                if (secondarySabji == null) secondarySabji = "";
                if (dal == null) dal = "";
                if (extra1 == null) extra1 = "";
                if (extra2 == null) extra2 = "";
                if (extra3 == null) extra3 = "";

                // Format data into a single string
                String displayText =
                        "Dal: " + dal + "\n" +
                                "Primary Sabji: " + primarySabji + "\n" +
                                "Secondary Sabji: " + secondarySabji + "\n" +
                                "Extra1: " + extra1 + "\n" +
                                "Extra2: " + extra2 + "\n" +
                                "Extra3: " + extra3;

                // Set the formatted text to textView42
                TextView textView42 = findViewById(R.id.textView42);
                textView42.setText(displayText);

                TextView textView48 = findViewById(R.id.textView48);
                textView48.setText(displayText);
            } else {
                Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> {
            Toast.makeText(this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (listenerRegistration != null) {
            listenerRegistration.remove(); // ✅ Stop Firestore listener when activity is destroyed
        }
    }
}
