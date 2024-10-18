package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the "Service Login" TextView
        TextView serviceLoginTextView = findViewById(R.id.textView4);

        // Set an OnClickListener on the TextView
        serviceLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the ServiceLogin activity
                Intent intent = new Intent(MainActivity.this, ServiceLogin.class);
                startActivity(intent);
            }
        });

        Button loginButton = findViewById(R.id.buttonlg);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // Create an Intent to navigate to the ServiceLogin activity
                Intent intent = new Intent(MainActivity.this, location.class);
                startActivity(intent);
            }
        });


    }
}
