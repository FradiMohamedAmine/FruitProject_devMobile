package utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import java.text.DecimalFormat;
import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private final Context context;
    private final List<Fruit> fruits;
    private final DecimalFormat priceFormat = new DecimalFormat("#.00");

    public FruitAdapter(Context context, List<Fruit> fruits) {
        super(context, R.layout.item_view, fruits);
        this.context = context;
        this.fruits = fruits;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_view, parent, false);
            holder = new ViewHolder();
            holder.fruitImage = convertView.findViewById(R.id.fruitImage);
            holder.fruitName = convertView.findViewById(R.id.fruitName);
            holder.fruitPrice = convertView.findViewById(R.id.fruitPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Populate the data
        Fruit currentFruit = fruits.get(position);
        holder.fruitName.setText(currentFruit.getName());
        holder.fruitImage.setImageResource(currentFruit.getImage());
        holder.fruitPrice.setText(priceFormat.format(currentFruit.getPrice()));

        return convertView;
    }

    // ViewHolder class to cache view references
    private static class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitPrice;
    }
}
