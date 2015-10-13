package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.adapters.MenuGroupAdapter;

/**
 * Created by dmitry on 10/9/15.
 */
public class MenuGroupsList extends RootFragment {

    private ListView list;
    static private int btnId;
    public MenuGroupsList() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_groups_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ArrayAdapter adapter;
//        btnId = getArguments().getInt("btnId");
//        if (btnId == 1)
//            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.cusine_list, android.R.layout.simple_list_item_1);
//        else
//            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.bar_list, android.R.layout.simple_list_item_1);
        list = (ListView) view.findViewById(R.id.cusine_list);

//        list.setAdapter(adapter);
        MenuGroupAdapter menuAdapter = new MenuGroupAdapter(getContext());
        list.setAdapter(menuAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterNextFragment(position);
            }
        });
    }

    private void enterNextFragment(int buttonId) {
        MenuItemList menuItemList = new MenuItemList();
        Bundle bundle = new Bundle();
        bundle.putInt("btnId", buttonId);
        menuItemList.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, menuItemList).commit();
    }
}
