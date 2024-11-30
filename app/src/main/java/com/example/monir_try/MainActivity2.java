package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main2);

        ImageView imageView4 = findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, HomePage.class); //
                startActivity(intent);
            }
        });

        ImageView imageview20 = findViewById(R.id.imageView20);
        imageview20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("HomePage", "Navigating to user_profile...");
                Intent intent = new Intent(MainActivity2.this, com.example.monir_try.user_profile.class);
                startActivity(intent);
                Log.d("HomePage", "Intent to user_profile started!");
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, cart.class); //
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, cart.class); //
                startActivity(intent);
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, plan_selection.class); //
                startActivity(intent);
            }
        });



    }
}