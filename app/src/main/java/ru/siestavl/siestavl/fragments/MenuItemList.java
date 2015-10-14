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

import java.util.ArrayList;

import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.adapters.DishListAdapter;
import ru.siestavl.siestavl.entity.Dish;

/**
 * Created by dmitry on 10/9/15.
 */
public class MenuItemList extends RootFragment {

    private ListView list;
    private ArrayList<Dish> dishesListst;
    static private int btnId;
    public MenuItemList() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_item_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //ArrayAdapter adapter;
       // btnId = getArguments().getInt("btnId");
//        if (btnId == 1)
          //  adapter = ArrayAdapter.createFromResource(getActivity(), R.array.items_list, android.R.layout.simple_list_item_1);
//        else
//            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.bar_list, android.R.layout.simple_list_item_1);

        dishesListst = getDishesList();
        DishListAdapter adapter = new DishListAdapter(getContext(), dishesListst);
        list = (ListView) view.findViewById(R.id.group_items_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterNextFragment(position);
            }
        });
    }

    private void enterNextFragment(int position) {
        CuisineDetail cuisineDetail = new CuisineDetail();
        Bundle bundle = new Bundle();
        //bundle.putInt("btnId", buttonId);
        bundle.putSerializable("dish_key", dishesListst.get(position));
        cuisineDetail.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, cuisineDetail).commit();
    }

    private ArrayList<Dish> getDishesList() {
        ArrayList<Dish> list = new ArrayList<>();
        Dish dish;

        dish = new Dish();
        dish.setName("Soup 1");
        dish.setShortDescription("This is delicious dish");
        dish.setDescription("This is full description for Soup 1. Here should be more lines");
        dish.setPrice(100);
        dish.setDishIndex(1);
        list.add(dish);

        dish = new Dish();
        dish.setName("Soup 2");
        dish.setShortDescription("This is one more delicious dish");
        dish.setDescription("This is full description for Soup 2. Here should be more lines");
        dish.setPrice(120);
        dish.setDishIndex(2);
        list.add(dish);

        dish = new Dish();
        dish.setName("Soup 3");
        dish.setShortDescription("This is one more delicious dish");
        dish.setDescription("This is full description for Soup 3. Here should be more lines");
        dish.setPrice(80);
        dish.setDishIndex(3);
        list.add(dish);

        return list;
    }
}
