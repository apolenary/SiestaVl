package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.TabFragment;

/**
 * Created by dmitry on 9/29/15.
 */
public class CuisineDetail extends Fragment implements TabFragment{


    static PageFragmentListener firstPageListener;
    static private int btnId;

    public CuisineDetail() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cuisine_detail, container, false);
        return rootView;
    }

    public static CuisineDetail newInstance(PageFragmentListener listener, int buttonId) {
        firstPageListener = listener;
        btnId = buttonId;
        return new CuisineDetail();
    }

    public void backPressed() {
        firstPageListener.onSwitchToNextFragment(btnId);
    }
}
