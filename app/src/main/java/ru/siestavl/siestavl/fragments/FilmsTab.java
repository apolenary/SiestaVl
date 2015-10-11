package ru.siestavl.siestavl.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;

/**
 * Created by dmitry on 9/26/15.
 */
public class FilmsTab extends RootFragment {

    ListView list;

    public FilmsTab() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_films_tab, container, false);

        ArrayAdapter adapter;
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.films_list, android.R.layout.simple_list_item_1);
        list = (ListView) rootView.findViewById(R.id.films_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterNextFragment();
            }
        });
        return rootView;
    }

    private void enterNextFragment() {
        FilmDescription filmDescription = new FilmDescription();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, filmDescription).commit();
    }
}