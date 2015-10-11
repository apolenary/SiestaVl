package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;

/**
 * Created by dmitry on 10/9/15.
 */
public class BarList extends Fragment {
    static PageFragmentListener firstPageListener;
    private ListView list;
    public BarList() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_groups_list, container, false);
        return view;
    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        firstPageListener.onSwitchToNextFragment();
    }*/

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.bar_list, android.R.layout.simple_list_item_1);
        list = (ListView) view.findViewById(R.id.cusine_list);
        list.setAdapter(adapter);
    }

    public static MenuGroupsList newInstance(PageFragmentListener listener) {
        firstPageListener = listener;
        return new MenuGroupsList();

    }


    public void backPressed() {
        //firstPageListener.onSwitchToNextFragment();
    }

}
