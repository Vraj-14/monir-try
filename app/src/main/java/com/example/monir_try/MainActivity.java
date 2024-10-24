package com.example.monir_try;

import static com.example.monir_try.R.id.textView7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText editTextText2,editTextText3;
    private Button buttonlg;
    private TextView textView7,textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        editTextText2= findViewById(R.id.editTextText2);
        editTextText3= findViewById(R.id.editTextText3);
        buttonlg = findViewById(R.id.buttonlg);
        textView8 = findViewById(R.id.textView8); //sign up
        textView7 = findViewById(R.id.textView7); //forgot password

        buttonlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextText2.getText().toString();
                String password = editTextText3.getText().toString();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if(!password.isEmpty()) {
                        auth.signInWithEmailAndPassword(email,password)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(MainActivity.this, location.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this,"Login Failed.",Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        editTextText3.setError("Password can not be empty.");
                    }
                } else if(email.isEmpty()) {
                    editTextText2.setError("Email can not be empty.");
                } else {
                    editTextText2.setError("Please enter valid email.");
                }
            }
        });

        // Forgot Password Functionality
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextText2.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    auth.sendPasswordResetEmail(email)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(MainActivity.this, "Reset password link sent to your email.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this, "Error! Reset link not sent: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    editTextText2.setError("Please enter your registered email.");
                }
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });
    }
}