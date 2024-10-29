package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import utils.Fruit;

public class PurchaseActivity extends AppCompatActivity {

    private TextView fruitName, cartTotalText;
    private EditText kilos;
    private Button addToCartButton, buyButton;
    private Fruit fruit;
    private static float totalSum = 0.0f;  // Static total sum of all purchases

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        fruitName = findViewById(R.id.fruitName);
        kilos = findViewById(R.id.kilos);
        cartTotalText = findViewById(R.id.cartTotalText);  // TextView to display cart total
        addToCartButton = findViewById(R.id.addToCartButton);
        buyButton = findViewById(R.id.buyButton);

        Intent intent = getIntent();
        fruit = (Fruit) intent.getSerializableExtra("fruit");

        if (fruit != null) {
            fruitName.setText(fruit.getName());
        } else {
            Toast.makeText(this, "Fruit data not found", Toast.LENGTH_SHORT).show();
            finish();  // Exit if no data is available
        }

        updateCartTotalDisplay();

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCurrentProductToCart();
                Intent intent = new Intent(PurchaseActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(PurchaseActivity.this, "Added to cart! Returning to main page.", Toast.LENGTH_SHORT).show();
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCurrentProductToCart();
                Intent billIntent = new Intent(PurchaseActivity.this, BillActivity.class);
                billIntent.putExtra("totalPrice", totalSum);
                startActivity(billIntent);
                resetTotalSum();
                updateCartTotalDisplay();  // Reset display to 0 after purchase
            }
        });
    }

    private void addCurrentProductToCart() {
        try {
            int kilosInt = Integer.parseInt(kilos.getText().toString());
            float pricePerKilo = fruit.getPrice();
            float purchaseTotal = kilosInt * pricePerKilo;
            totalSum += purchaseTotal;
            updateCartTotalDisplay();  // Update display after adding product
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateCartTotalDisplay() {
        cartTotalText.setText("Cart Total: $" + String.format("%.2f", totalSum));
    }

    public static void resetTotalSum() {
        totalSum = 0.0f;
    }

    public static float getTotalSum() {
        return totalSum;
    }
}
