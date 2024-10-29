package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BillActivity extends AppCompatActivity {

    private TextView billTotalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        billTotalText = findViewById(R.id.billTotalText);

        Intent intent = getIntent();
        float totalPrice = intent.getFloatExtra("totalPrice", 0.0f);

        billTotalText.setText(String.format("Total Purchase: $%.2f", totalPrice));
    }
}
