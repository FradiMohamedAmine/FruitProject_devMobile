package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import utils.Fruit;

public class PurchaseActivity extends AppCompatActivity {

    private TextView fruitName;
    private EditText kilos;
    private Button addToCartButton, buyButton;
    private Fruit fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        // Find views by ID
        fruitName = findViewById(R.id.fruitName);
        kilos = findViewById(R.id.kilos);
        addToCartButton = findViewById(R.id.addToCartButton);
        buyButton = findViewById(R.id.buyButton);

        // Get the Fruit object from the Intent
        Intent intent = getIntent();
        fruit = (Fruit) intent.getSerializableExtra("fruit");

        // Set fruit name to TextView
        if (fruit != null) {
            fruitName.setText(fruit.getName());
        } else {
            Toast.makeText(this, "Fruit data not found", Toast.LENGTH_SHORT).show();
            finish(); // Exit if no data is available
        }

        // Add to cart button action (go back to MainActivity)
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Closes current activity and returns to the previous one
            }
        });

        // Buy button action (go to BillActivity with total price)
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int kilosInt = Integer.parseInt(kilos.getText().toString());
                    float pricePerKilo = fruit.getPrice();
                    float totalPrice = kilosInt * pricePerKilo;

                    // Send total price to BillActivity
                    Intent billIntent = new Intent(PurchaseActivity.this, BillActivity.class);
                    billIntent.putExtra("totalPrice", totalPrice);
                    startActivity(billIntent);
                } catch (NumberFormatException e) {
                    Toast.makeText(PurchaseActivity.this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
