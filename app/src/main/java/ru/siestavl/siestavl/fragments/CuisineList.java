package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.TabFragment;

/**
 * Created by dmitry on 10/9/15.
 */
public class CuisineList extends Fragment implements TabFragment{

    static PageFragmentListener firstPageListener;
    private ListView list;
    static private int btnId;
    public CuisineList() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuisine_list, container, false);
        return view;
    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        firstPageListener.onSwitchToNextFragment();
    }*/

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter adapter;
        if (btnId == 1)
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.cusine_list, android.R.layout.simple_list_item_1);
        else
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.bar_list, android.R.layout.simple_list_item_1);
        list = (ListView) view.findViewById(R.id.cusine_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                firstPageListener.onSwitchToNextFragment(btnId);
            }
        });
    }

    public static CuisineList newInstance(PageFragmentListener listener, int buttonId) {
        firstPageListener = listener;
        btnId = buttonId;
        return new CuisineList();

    }


    public void backPressed() {
        firstPageListener.onSwitchToNextFragment(4);
    }
}
