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
import ru.siestavl.siestavl.entity.Film;

/**
 * Created by dmitry on 10/13/15.
 */
public class FilmsListAdapter extends BaseAdapter {

    private final Context context;
    ArrayList<Film> filmsList;
    int [] images = {R.drawable.ic_film1,R.drawable.ic_film2,
            R.drawable.ic_film3, R.drawable.ic_film4};

    public FilmsListAdapter(Context context, ArrayList<Film> filmsList) {
        this.context = context;
        //dishesList = context.getResources().getStringArray(R.array.cusine_list);
        this.filmsList = filmsList;
    }

    @Override
    public int getCount() {
        return filmsList.size();
    }

    @Override
    public Object getItem(int position) {
        return filmsList.get(position);
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
            row = inflater.inflate(R.layout.films_list_row, parent, false);
        } else {
            row = convertView;
        }

        Film film = filmsList.get(position);
        ImageView image = (ImageView) row.findViewById(R.id.filmsList_image);
        TextView textView_name = (TextView) row.findViewById(R.id.filmsList_name);
        TextView textView_description = (TextView) row.findViewById(R.id.filmsList_description);


        if(position < 5) {
            image.setImageResource(images[position]);
        } else {
            image.setImageResource(images[1]);
        }


        textView_name.setText(film.getName());
        textView_description.setText("Короткое описание фильма!!!");

        return row;
    }
}
