package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.TabFragment;

/**
 * Created by dmitry on 9/29/15.
 */
public class CuisineDetail extends RootFragment {


    static private int btnId;

    public CuisineDetail() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cuisine_detail, container, false);
        return rootView;
    }

//    private void enterNextFragment(int buttonId) {
//        CuisineDetail cuisineDetail = new CuisineDetail();
//        Bundle bundle = new Bundle();
//        bundle.putInt("btnId", buttonId);
//        cuisineDetail.setArguments(bundle);
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//
//        // Store the Fragment in stack
//        transaction.addToBackStack(null);
//        transaction.replace(R.id.fragment_mainLayout, cuisineDetail).commit();
//    }

}
