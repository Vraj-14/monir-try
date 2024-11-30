package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ImageDecoderKt;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class plan_selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_plan_selection);

        ImageView imageView4 = findViewById(R.id.imageView4); // Cart Button
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plan_selection.this, cart.class);
                imageView4.setOnClickListener(v -> startActivity(intent));
            }
        });

        ImageView imageView22 = findViewById(R.id.imageView22); // Profile Button
        imageView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plan_selection.this, user_profile.class);
                startActivity(intent);
            }
        });


        Button button6 = findViewById(R.id.button6); // Continue Button
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plan_selection.this, timings.class);
                startActivity(intent);
            }
        });
    }
}