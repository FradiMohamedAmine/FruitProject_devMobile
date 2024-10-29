package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BillActivity extends AppCompatActivity {

    private TextView totalPriceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        totalPriceText = findViewById(R.id.totalPriceText);

        // Get the total price as a float from the Intent
        float totalPrice = getIntent().getFloatExtra("totalPrice", 0.0f);

        // Display the total price with 2 decimal precision
        totalPriceText.setText(String.format("Total Price: $%.2f", totalPrice));
    }
}
