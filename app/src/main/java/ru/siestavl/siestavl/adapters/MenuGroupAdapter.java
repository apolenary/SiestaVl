package ru.siestavl.siestavl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ru.siestavl.siestavl.R;

/**
 * Created by dmitry on 10/13/15.
 */
public class MenuGroupAdapter extends BaseAdapter {

    private final Context context;
    String [] groupList;
    int [] images = {R.drawable.ic_soup1,R.drawable.ic_roll, R.drawable.ic_zaverton1};

    public MenuGroupAdapter(Context context) {
        this.context = context;
        groupList = context.getResources().getStringArray(R.array.cusine_list);
    }

    @Override
    public int getCount() {
        return groupList.length;
    }

    @Override
    public Object getItem(int position) {
        return groupList[position];
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
            row = inflater.inflate(R.layout.menu_group_row, parent, false);
        } else {
            row = convertView;
        }
        TextView textView = (TextView) row.findViewById(R.id.rowText);
        textView.setText(groupList[position]);

        switch(position) {
            case 0:
                textView.setBackgroundResource(images[position]);
                break;
            case 1:
                textView.setBackgroundResource(images[position]);
                break;
            case 2:
                textView.setBackgroundResource(images[position]);
                break;
            default:
                textView.setBackgroundResource(images[0]);
        }

        return row;
    }
}
