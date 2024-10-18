package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ServiceLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_login);

        Button loginButton = findViewById(R.id.buttonlg);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // Create an Intent to navigate to the ServiceLogin activity
                Intent intent = new Intent(ServiceLogin.this, location.class);
                startActivity(intent);
            }
        });
    }
}