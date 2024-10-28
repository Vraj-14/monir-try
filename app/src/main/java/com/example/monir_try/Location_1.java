package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Location_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location1);

        TextView textView = findViewById(R.id.textView21);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the Overview activity
                Intent intent = new Intent(Location_1.this, Location_2.class);
                startActivity(intent);
            }


        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the Location_2 activity
                Intent intent = new Intent(Location_1.this, Location_2.class);
                startActivity(intent);
            }

            ;


            // Closing parenthesis added here
        });

    }
}
