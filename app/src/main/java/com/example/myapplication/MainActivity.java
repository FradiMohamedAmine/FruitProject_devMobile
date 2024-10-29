package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Fruit;
import utils.FruitAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.myListView);

        // Liste de fruits avec noms et images
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Abricot",10, R.drawable.abricot));
        fruits.add(new Fruit("Banane",15, R.drawable.banane));
        fruits.add(new Fruit("Orange",30, R.drawable.orange));
        fruits.add(new Fruit("Pêche",5, R.drawable.peche));
        fruits.add(new Fruit("Poire",25, R.drawable.poire));
        fruits.add(new Fruit("Pomme",11, R.drawable.pomme));
        fruits.add(new Fruit("Raisin",40, R.drawable.raisin));

        // Créer l'adaptateur et l'associer à la ListView
        FruitAdapter adapter = new FruitAdapter(this, fruits);
        listView.setAdapter(adapter);
    }
}