package ru.siestavl.siestavl.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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
public class FilmsTab extends Fragment {

    ListView list;
    private PageFragmentListener pageFragmentListener;

    public FilmsTab() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_films_tab, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter adapter;
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.films_list, android.R.layout.simple_list_item_1);
        list = (ListView) view.findViewById(R.id.films_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //firstPageListener.onSwitchToNextFragment(btnId);
            }
        });
    }
}
