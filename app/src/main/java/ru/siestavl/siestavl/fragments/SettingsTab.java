package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.adapters.OrderAdapter;
import ru.siestavl.siestavl.entity.Order;

/**
 * Created by dmitry on 10/11/15.
 */
public class SettingsTab extends RootFragment{

    Order order;
    TextView tempText;
    ListView list;
    ArrayList<String> temp;

    public SettingsTab(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting_tab, container, false);
        order = Order.getInstance();
        tempText = (TextView)rootView.findViewById(R.id.settings_temp_text);
        Button btn = (Button)rootView.findViewById(R.id.settings_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Количество заказов " + order.getCountOfDishes() , Toast.LENGTH_SHORT).show();
            }
        });
        list = (ListView) rootView.findViewById(R.id.settings_listView);
        converter();
        OrderAdapter adapter = new OrderAdapter(getContext(), temp);

        list.setAdapter(adapter);


        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stockArr);

        return rootView;
    }

    private void converter() {
        temp = order.getArray();
    }
}
