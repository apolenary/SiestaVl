package ru.siestavl.siestavl.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.TabFragment;
import ru.siestavl.siestavl.entity.Film;

/**
 * Created by dmitry on 9/29/15.
 */
public class FilmDescription extends RootFragment{


    private Film film;
    int [] images = {R.drawable.ic_film1,R.drawable.ic_film2,
            R.drawable.ic_film3, R.drawable.ic_film4};
    public FilmDescription() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_film, container, false);

        film = (Film)getArguments().getSerializable("film_key");
        ImageView image = (ImageView)rootView.findViewById(R.id.film_image);
        TextView name = (TextView)rootView.findViewById(R.id.film_name);
        TextView description = (TextView)rootView.findViewById(R.id.film_description);
        TextView country = (TextView)rootView.findViewById(R.id.film_country);

        image.setImageResource(images[film.getIndex()]);
        name.setText(film.getName());
        description.setText(film.getDescription());
        country.setText(film.getCountry());


        return rootView;
    }


}
