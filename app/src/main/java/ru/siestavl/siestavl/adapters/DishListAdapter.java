package ru.siestavl.siestavl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.entity.Dish;

/**
 * Created by dmitry on 10/13/15.
 */
public class DishListAdapter extends BaseAdapter {

    private final Context context;
    ArrayList<Dish> dishesList;
    int [] images = {R.drawable.ic_soup1,R.drawable.ic_soup2,
            R.drawable.ic_soup3, R.drawable.ic_soup4, R.drawable.ic_soup5};

    public DishListAdapter(Context context, ArrayList<Dish> dishesList) {
        this.context = context;
        //dishesList = context.getResources().getStringArray(R.array.cusine_list);
        this.dishesList = dishesList;
    }

    @Override
    public int getCount() {
        return dishesList.size();
    }

    @Override
    public Object getItem(int position) {
        return dishesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.dish_list_row, parent, false);
        } else {
            row = convertView;
        }

        Dish dish = dishesList.get(position);
        ImageView image = (ImageView) row.findViewById(R.id.dishList_image);
        TextView textView_name = (TextView) row.findViewById(R.id.dishList_name);
        TextView textView_price = (TextView) row.findViewById(R.id.dishList_price);
        TextView textView_description = (TextView) row.findViewById(R.id.dishList_description);


        image.setImageResource(images[position]);
        textView_name.setText(dish.getName());
        textView_price.setText(String.format("%d",dish.getPrice()));
        textView_description.setText(dish.getDescription());


        return row;
    }
}
