package com.example.monir_try;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class provider_weekly_plan extends AppCompatActivity {

    private RecyclerView roti_RecyclerView;
    private pr_itemAdapter roti_ItemAdapter;
    private List<pr_itemModel> roti_itemList;

    private FirebaseFirestore db;
    private EditText editTextPrice, editTextPrimarySabji, editTextSecondarySabji, editTextDal,editTextRice, editTextExtra1, editTextExtra2, editTextExtra3;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_weekly_plan);

        db = FirebaseFirestore.getInstance(); // Initialize Firestore

        // RecyclerView setup (UNCHANGED)
        roti_RecyclerView = findViewById(R.id.provider_roti);
        roti_RecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        roti_itemList = new ArrayList<>();
        roti_itemList.add(new pr_itemModel("Chapati"));
        roti_itemList.add(new pr_itemModel("Naan"));
        roti_itemList.add(new pr_itemModel("Butter Tandoori Roti"));

        roti_ItemAdapter = new pr_itemAdapter(this, roti_itemList, item -> {});
        roti_RecyclerView.setAdapter(roti_ItemAdapter);
        roti_ItemAdapter.notifyDataSetChanged();

        // ✅ Finding all EditTexts
        editTextPrice = findViewById(R.id.editTextNumberSigned);
        editTextPrimarySabji = findViewById(R.id.editText91);
        editTextSecondarySabji = findViewById(R.id.editText93);
        editTextDal = findViewById(R.id.editText97);
        editTextRice=findViewById(R.id.editTextText5);
        editTextExtra1 = findViewById(R.id.editText99);
        editTextExtra2 = findViewById(R.id.editText100);
        editTextExtra3 = findViewById(R.id.editText101);

        buttonConfirm = findViewById(R.id.button5);

        // ✅ Save data when Confirm button is clicked
        buttonConfirm.setOnClickListener(view -> saveDataToFirestore());
    }

    // ✅ New Method: Save Price & Other Data to Firestore
    private void saveDataToFirestore() {
        try {
            String price = editTextPrice.getText().toString().trim();
            String primarySabji = editTextPrimarySabji.getText().toString().trim();
            String secondarySabji = editTextSecondarySabji.getText().toString().trim();
            String dal = editTextDal.getText().toString().trim();
            String rice = editTextRice.getText().toString().trim();
            String extra1 = editTextExtra1.getText().toString().trim();
            String extra2 = editTextExtra2.getText().toString().trim();
            String extra3 = editTextExtra3.getText().toString().trim();

            Map<String, Object> menuData = new HashMap<>();
            menuData.put("Primary Sabji", primarySabji);
            menuData.put("Secondary Sabji", secondarySabji);
            menuData.put("Dal", dal);
            menuData.put("Rice", rice);
            menuData.put("Extra1", extra1);
            menuData.put("Extra2", extra2);
            menuData.put("Extra3", extra3);

            // Convert price safely to integer (or store as a string if needed)
            try {
                menuData.put("price", Integer.parseInt(price));
            } catch (NumberFormatException e) {
                menuData.put("price", price); // Store as string if invalid number
            }

            db.collection("TiffinProviders")
                    .document("Provider1")
                    .update(menuData)
                    .addOnSuccessListener(aVoid -> Toast.makeText(this, "Menu Updated Successfully", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(this, "Failed to update menu", Toast.LENGTH_SHORT).show());

        } catch (Exception e) {
            Toast.makeText(this, "An error occurred: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
