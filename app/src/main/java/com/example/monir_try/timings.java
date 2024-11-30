package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class timings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timings);

        ImageView imageView4 = findViewById(R.id.imageView4); // Cart Button
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(timings.this, cart.class);
                startActivity(intent); // Fixed duplicate setOnClickListener
            }
        });

        ImageView imageView22 = findViewById(R.id.imageView22); // Profile Button
        imageView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(timings.this, user_profile.class);
                startActivity(intent);
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(timings.this, cart.class);
                startActivity(intent);
            }
        });
    }
}
