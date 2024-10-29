package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import utils.Fruit;
import utils.FruitAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myListView);

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Fraise", 5.500f, R.drawable.fraise));
        fruits.add(new Fruit("Banane", 3.700f, R.drawable.banane));
        fruits.add(new Fruit("Pomme", 5.300f, R.drawable.pomme));
        fruits.add(new Fruit("Dattes", 8.900f, R.drawable.dattes));
        fruits.add(new Fruit("Poire", 6.200f, R.drawable.poire));

        FruitAdapter adapter = new FruitAdapter(this, fruits);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit selectedFruit = fruits.get(position);

                Intent intent = new Intent(MainActivity.this, PurchaseActivity.class);
                intent.putExtra("fruit", selectedFruit);
                intent.putExtra("price", selectedFruit.getPrice());
                startActivity(intent);
            }
        });
    }
}
