package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.siestavl.siestavl.R;

/**
 * Created by dmitry on 10/11/15.
 */
public class SettingsTab extends RootFragment{

    public SettingsTab(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting_tab, container, false);
        return rootView;
    }
}
