package com.example.monir_try;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_page);

        ImageView imageView = findViewById(R.id.imageView11);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the Overview activity
                Intent intent = new Intent(HomePage.this, Overview.class);

                // Starting the Overview activity
                startActivity(intent);
            }
        });

        ImageView imageView4 = findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the LocationActivity (replace with your actual target)
                Intent intent = new Intent(HomePage.this, Location_1.class); // Change to your desired target activity
                startActivity(intent);
            }
        });
    }
}
