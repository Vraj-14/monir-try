package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        ImageView imageView32 = findViewById(R.id.imageView32);
        imageView32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this, MainActivity.class); //
                startActivity(intent);
            }
        });


        imageView32.setAlpha(0f);

        imageView32.animate()
                .alpha(1f)
                .setDuration(2000)
                .start();


        TextView textView68 = findViewById(R.id.textView68); // Home
        TranslateAnimation slideInFromLeft = new TranslateAnimation(
                -1000f, 0f, 0f, 0f // From left (-1000f on X-axis)
        );
        slideInFromLeft.setDuration(3000); // 3 seconds
        slideInFromLeft.setFillAfter(true); // Keep position after animation ends
        textView68.setAnimation(slideInFromLeft);

// TextView for "Harvest"
        TextView textView81 = findViewById(R.id.textView81); // Harvest
        TranslateAnimation slideInFromRight = new TranslateAnimation(
                1000f, 0f, 0f, 0f // From right (1000f on X-axis)
        );
        slideInFromRight.setDuration(3000); // 3 seconds
        slideInFromRight.setFillAfter(true); // Keep position after animation ends
        textView81.setAnimation(slideInFromRight);



    }
}