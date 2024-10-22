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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText editTextName, editTextEmail, editTextPassword;
    private Button buttonSignUp;
    private TextView textViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize FirebaseAuth instance
        auth = FirebaseAuth.getInstance();

        // Get references to UI elements
        editTextName = findViewById(R.id.editTextText1);  // Name field
        editTextEmail = findViewById(R.id.editTextText2);  // Email field
        editTextPassword = findViewById(R.id.editTextText3);  // Password field
        buttonSignUp = findViewById(R.id.buttonlg);
        textViewLogin = findViewById(R.id.textView8);

        // Set onClickListener for the sign-up button
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get input values from fields
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Validate input fields
                if (name.isEmpty()) {
                    editTextName.setError("Name cannot be empty");
                } else if (email.isEmpty()) {
                    editTextEmail.setError("Email cannot be empty");
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextEmail.setError("Enter a valid email");
                } else if (password.isEmpty()) {
                    editTextPassword.setError("Password cannot be empty");
                } else {
                    // Proceed with Firebase sign-up
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign-up successful
                                Toast.makeText(SignUp.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUp.this, MainActivity.class);
                                startActivity(intent);
                                finish();
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
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the login activity
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });
    }
}
