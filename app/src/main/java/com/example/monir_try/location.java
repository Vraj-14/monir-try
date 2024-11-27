package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location); // Ensure this refers to activity_location.xml

        // Step 1: Find the "City" Spinner and set it up
        Spinner citySpinner = findViewById(R.id.spinnerCity); // Spinner for cities
        ArrayAdapter<CharSequence> cityAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.city_list, // City array from strings.xml
                android.R.layout.simple_spinner_item
        );
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);

        // Step 2: Find the "Area" Spinner and set it up
        Spinner areaSpinner = findViewById(R.id.spinner); // Spinner for areas
        ArrayAdapter<CharSequence> areaAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.area_list, // Area array from strings.xml
                android.R.layout.simple_spinner_item
        );
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(areaAdapter);







        Button backButton = findViewById(R.id.buttonback);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // Create an Intent to navigate to the ServiceLogin activity
                Intent intent = new Intent(location.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button continueButton = findViewById(R.id.buttoncontinue);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to go to Home page (next page)
                Intent intent = new Intent(location.this, HomePage.class);
                startActivity(intent);
            }
        });

    }
}
