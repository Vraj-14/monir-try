package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ServiceLogin extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_login);

        db = FirebaseFirestore.getInstance();

        EditText emailEditText = findViewById(R.id.editTextText2);
        EditText passwordEditText = findViewById(R.id.editTextText3);


        Button checkButton = findViewById(R.id.buttonlg);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = emailEditText.getText().toString().trim();
                String enteredPassword = passwordEditText.getText().toString().trim();

                if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                    Toast.makeText(ServiceLogin.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                } else {
                    authenticateUser(enteredEmail, enteredPassword);
                }
            }
        });

        TextView textView8 = findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceLogin.this, SignUp.class); //
                startActivity(intent);
            }
        });

        TextView textView3 = findViewById(R.id.textView3); //User Login Text
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceLogin.this, MainActivity.class); //
                startActivity(intent);
            }
        });

    }

    private void authenticateUser(String email, String password) {
        db.collection("providers")
                .whereEqualTo("email", email)
                .whereEqualTo("password", password)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (!querySnapshot.isEmpty()) {
                            // Login successful
                            Toast.makeText(ServiceLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ServiceLogin.this, provider_options.class); // to provider_option screen
                            startActivity(intent);
                            finish(); // Close login activity
                        } else {
                            // No matching document found
                            Toast.makeText(ServiceLogin.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ServiceLogin.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });





    }
}
