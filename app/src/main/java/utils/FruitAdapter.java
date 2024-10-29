package utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import utils.Fruit;
import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private final Context context;
    private final List<Fruit> fruits;

    public FruitAdapter(Context context, List<Fruit> fruits) {
        super(context, R.layout.item_view, fruits);
        this.context = context;
        this.fruits = fruits;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_view, parent, false);
        }

        // Obtenir les éléments visuels
        ImageView fruitImage = convertView.findViewById(R.id.fruitImage);
        TextView fruitName = convertView.findViewById(R.id.fruitName);

        // Mettre à jour les données
        Fruit currentFruit = fruits.get(position);
        fruitName.setText(currentFruit.getName());
        fruitImage.setImageResource(currentFruit.getImage());

        return convertView;
    }
}
