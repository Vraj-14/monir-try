//package com.example.monir_try;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//
//public class cart extends AppCompatActivity {
//
//    private FirebaseFirestore db;
//    private TextView textViewPrice; // TextView to display price
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cart);
//
//        // Initialize Firestore
//        db = FirebaseFirestore.getInstance();
//
//        // Find Views
//        textViewPrice = findViewById(R.id.textView61); // TextView to display price
//
//        // Retrieve price from Firestore
//        retrievePriceFromFirestore();
//
//        // Existing Code (UNCHANGED)
//        ImageView imageView4 = findViewById(R.id.imageView4);
//        imageView4.setOnClickListener(v -> {
//            Intent intent = new Intent(cart.this, Location_1.class);
//            startActivity(intent);
//        });
//
//        ImageView imageview20 = findViewById(R.id.imageView20);
//        imageview20.setOnClickListener(view -> {
//            Log.d("HomePage", "Navigating to user_profile...");
//            Intent intent = new Intent(cart.this, com.example.monir_try.user_profile.class);
//            startActivity(intent);
//            Log.d("HomePage", "Intent to user_profile started!");
//        });
//
//        Button button7 = findViewById(R.id.button7);
//        button7.setOnClickListener(v -> {
//            Intent intent = new Intent(cart.this, payment.class);
//            startActivity(intent);
//        });
//    }
//
//    // ✅ Retrieve Price from Firestore
//    private void retrievePriceFromFirestore() {
//        DocumentReference docRef = db.collection("TiffinProviders").document("Provider1");
//
//        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (documentSnapshot.exists()) {
//                    Long price = documentSnapshot.getLong("price"); // Get price as Number
//                    if (price != null) {
//                        textViewPrice.setText("Rs. " + price); // Set text in TextView
//                    } else {
//                        textViewPrice.setText("Rs. 0"); // If price is missing
//                    }
//                } else {
//                    textViewPrice.setText("Rs. 0"); // If document doesn't exist
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(Exception e) {
//                Toast.makeText(cart.this, "Failed to load price", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

package com.example.monir_try;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;




public class cart extends AppCompatActivity {
    EditText editTextNumber2;
    private FirebaseFirestore db;
    private TextView textViewPrice; // TextView to display price

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        try {
            db = FirebaseFirestore.getInstance();

            textViewPrice = findViewById(R.id.textView61);

            if (textViewPrice == null) {
                Log.e("cart", "textView61 not found in layout.");
                Toast.makeText(this, "UI Error: Price TextView not found", Toast.LENGTH_SHORT).show();
                return;
            }

            retrievePriceFromFirestore();

            ImageView imageView4 = findViewById(R.id.imageView4);
            if (imageView4 != null) {
                imageView4.setOnClickListener(v -> startActivity(new Intent(cart.this, Location_1.class)));
            }

            ImageView imageView20 = findViewById(R.id.imageView20);
            if (imageView20 != null) {
                imageView20.setOnClickListener(view -> {
                    Log.d("CartPage", "Navigating to user_profile...");
                    startActivity(new Intent(cart.this, user_profile.class));
                });
            }

            Button button7 = findViewById(R.id.button7);
            if (button7 != null) {
                button7.setOnClickListener(v -> {
                    Log.d("CartPage", "Navigating to payment screen...");
                    startActivity(new Intent(cart.this, payment.class));
                });
            }

        } catch (Exception e) {
            Log.e("cart", "Exception in onCreate: ", e);
            Toast.makeText(this, "Error initializing cart screen", Toast.LENGTH_LONG).show();
        }

        Button button10 = findViewById(R.id.button10);
        if (button10 != null) {
            button10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Step 1: Get provider email from Firestore
                    DocumentReference docRef = db.collection("providers").document("TtjxQAnyoPA5Uncu03Up"); //rF8P56IJxgIm6iqUWJJB
                    docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String email = documentSnapshot.getString("email");
                                if (email != null && !email.isEmpty()) {
                                    // Save to Firebase
                                    EditText editTextNumber2 = findViewById(R.id.editTextNumber2);
                                    String orderStr = editTextNumber2.getText().toString();
                                    if (!orderStr.isEmpty()) {
                                        try {
                                            int totalOrders = Integer.parseInt(orderStr);
                                            FirebaseFirestore.getInstance()
                                                    .collection("ProvidersName")
                                                    .document("Radhe Krishna Kitchen")
                                                    .update("Total Orders", totalOrders)
                                                    .addOnSuccessListener(aVoid -> Log.d("FirebaseUpdate", "Total Orders updated successfully"))
                                                    .addOnFailureListener(e -> Log.e("FirebaseUpdate", "Error updating Total Orders", e));

                                            // Step 2: Launch email intent
                                            Intent intent = new Intent(Intent.ACTION_SEND);
                                            intent.setType("message/rfc822");
                                            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                                            intent.putExtra(Intent.EXTRA_SUBJECT, "Order Confirmation");
                                            intent.putExtra(Intent.EXTRA_TEXT, "Please Confirm the order of " + totalOrders + " tiffins");

                                            try {
                                                startActivity(Intent.createChooser(intent, "Send Confirmation Email"));
                                            } catch (android.content.ActivityNotFoundException ex) {
                                                Toast.makeText(cart.this, "No email client installed.", Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (NumberFormatException e) {
                                            Toast.makeText(cart.this, "Invalid order number format.", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(cart.this, "Please enter a valid order number.", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(cart.this, "Email not found in document.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(cart.this, "Provider document does not exist.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@androidx.annotation.NonNull Exception e) {
                            Toast.makeText(cart.this, "Failed to fetch email: " + e.getMessage(), Toast.LENGTH_LONG).show();
                            Log.e("EmailFetch", "Error fetching provider email", e);
                        }
                    });
                }
            });
        }
    }

    private void retrievePriceFromFirestore() {
        DocumentReference docRef = db.collection("TiffinProviders").document("Provider1");

        docRef.get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                Object priceObj = documentSnapshot.get("price");

                if (priceObj instanceof Number) {
                    long price = ((Number) priceObj).longValue();
                    textViewPrice.setText("Rs. " + price);
                } else {
                    Log.w("cart", "Price field is missing or not a number.");
                    textViewPrice.setText("Rs. 0");
                }

            } else {
                Log.w("cart", "Document does not exist.");
                textViewPrice.setText("Rs. 0");
            }
        }).addOnFailureListener(e -> {
            Log.e("cart", "Error retrieving price", e);
            Toast.makeText(cart.this, "Failed to load price", Toast.LENGTH_SHORT).show();
        });
    }



}
