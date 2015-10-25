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
import ru.siestavl.siestavl.entity.Order;

/**
 * Created by dmitry on 10/25/15.
 */
public class OrderAdapter extends BaseAdapter {

    private Order orderMap;
    private Context context;
    private ArrayList<String> array;

    public OrderAdapter(Context context, ArrayList<String> array) {
        this.context = context;
        this.array = array;
    }

    @Override
    public int getCount() {
        //return orderMap.getCountOfDishes();
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
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
            row = inflater.inflate(R.layout.order_row, parent, false);
        } else {
            row = convertView;
        }
        TextView dishText = (TextView) row.findViewById(R.id.order_dish);
        TextView countText = (TextView) row.findViewById(R.id.order_count);

        dishText.setText("TEXT - ");
        countText.setText(array.get(position));

        return row;
    }
}
