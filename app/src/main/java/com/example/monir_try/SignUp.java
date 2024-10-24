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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    private EditText editTextText1, editTextText2, editTextText3;
    private Button buttonlg;
    private TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize FirebaseAuth and Firestore
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        // Get references to UI elements
        editTextText1 = findViewById(R.id.editTextText1); // user name
        editTextText2 = findViewById(R.id.editTextText2); // email
        editTextText3 = findViewById(R.id.editTextText3); // password
        buttonlg = findViewById(R.id.buttonlg); // sign up button
        textView8 = findViewById(R.id.textView8); // login text

        // Set onClickListener for the sign-up button
        buttonlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get input values from fields
                String userEmail = editTextText2.getText().toString().trim();
                String userPassword = editTextText3.getText().toString().trim();
                String userName = editTextText1.getText().toString().trim();

                // Check if fields are empty
                if (userEmail.isEmpty()) {
                    editTextText2.setError("Email cannot be empty");
                } else if (userPassword.isEmpty()) {
                    editTextText3.setError("Password cannot be empty");
                } else if (userName.isEmpty()) {
                    editTextText1.setError("Name cannot be empty");
                } else {
                    // Proceed with Firebase sign-up
                    auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Store user details in Firestore with a unique document ID (user ID)
                                String userId = auth.getCurrentUser().getUid(); // Get unique user ID

                                Map<String, Object> userMap = new HashMap<>();
                                userMap.put("name", userName); // Store the value of userName
                                userMap.put("email", userEmail); // Store the value of userEmail

                                firestore.collection("users").document(userId).set(userMap)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(SignUp.this, MainActivity.class));
                                                    finish();
                                                } else {
                                                    Toast.makeText(SignUp.this, "Failed to store user data.", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(SignUp.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });

                            } else {
                                // Sign-up failed
                                Toast.makeText(SignUp.this, "Sign Up Failed. " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        // Set onClickListener for the login link text
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the login activity
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });
    }
}
