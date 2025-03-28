package com.example.monir_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Location_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location3);

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Location_3.this, Location_4.class);
                startActivity(intent);
            }
        });

//        ImageView imageView4 = findViewById(R.id.imageView4);
//        imageView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomePage.this, Location_1.class); // Replace with your target activity
//                startActivity(intent);
            }
}

//package com.example.monir_try;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.maps.MapView;
//
//import org.osmdroid.config.Configuration;
//import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
//import org.osmdroid.util.GeoPoint;
//import org.osmdroid.views.MapView;
//import org.osmdroid.views.overlay.Marker;
//
//public class Location_3 extends AppCompatActivity {
//    private MapView map;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // Set OSM user agent to avoid issues
//        Configuration.getInstance().setUserAgentValue(getApplicationContext().getPackageName());
//
//        setContentView(R.layout.activity_location3);
//
//        // Initialize MapView
//        map = findViewById(R.id.map);
//        map.setTileSource(TileSourceFactory.MAPNIK);
//        map.setBuiltInZoomControls(true);
//        map.setMultiTouchControls(true);
//
//        // Set initial map location (Example: Custom Location)
//        GeoPoint startPoint = new GeoPoint(22.5726, 88.3639); // Example: Kolkata, India
//        map.getController().setZoom(15.0);
//        map.getController().setCenter(startPoint);
//
//        // Add marker at location
//        Marker startMarker = new Marker(map);
//        startMarker.setPosition(startPoint);
//        startMarker.setTitle("Current Location");
//        map.getOverlays().add(startMarker);
//
//        // Set Button Click to Move to Location_4
//        Button button = findViewById(R.id.button3);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Location_3.this, Location_4.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (map != null) map.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (map != null) map.onPause();
//    }
//}
