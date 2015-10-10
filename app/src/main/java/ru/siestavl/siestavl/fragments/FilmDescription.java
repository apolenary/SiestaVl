package ru.siestavl.siestavl.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.TabFragment;

/**
 * Created by dmitry on 9/29/15.
 */
public class FilmDescription extends Fragment implements TabFragment{


    static PageFragmentListener firstPageListener;

    public FilmDescription() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_film, container, false);
        return rootView;
    }

    public static FilmDescription newInstance(PageFragmentListener listener) {
        firstPageListener = listener;
        return new FilmDescription();
    }

    public void backPressed() {
        firstPageListener.onSwitchToNextFragment(5);
    }
}
