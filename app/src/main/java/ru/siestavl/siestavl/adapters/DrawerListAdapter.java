package ru.siestavl.siestavl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ru.siestavl.siestavl.R;

/**
 * Created by dmitry on 9/28/15.
 */
public class DrawerListAdapter extends BaseAdapter {
    Context context;
    String [] tabList;
    int [] images = {R.drawable.ic_menu_home,R.drawable.ic_menu_user,
            R.drawable.ic_menu_services, R.drawable.ic_menu_info};

    public DrawerListAdapter(Context context) {
        this.context = context;
        tabList = context.getResources().getStringArray(R.array.navigation_drawer);
    }

    @Override
    public int getCount() {
        return tabList.length;
    }

    @Override
    public Object getItem(int position) {
        return tabList[position];
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
            row = inflater.inflate(R.layout.drawer_custom_row, parent, false);
        } else {
            row = convertView;
        }
        TextView textView = (TextView) row.findViewById(R.id.rowText);
        ImageView imageView = (ImageView) row.findViewById(R.id.rowImage);

        textView.setText(tabList[position]);
        imageView.setImageResource(images[position]);

        return row;
    }
}
