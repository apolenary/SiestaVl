package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.entity.Basket;

/**
 * Created by dmitry on 10/11/15.
 */
public class SettingsTab extends RootFragment{

    Basket order;
    TextView tempText;

    public SettingsTab(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting_tab, container, false);
        order = Basket.getInstance();
        tempText = (TextView)rootView.findViewById(R.id.settings_temp_text);
        Button btn = (Button)rootView.findViewById(R.id.settings_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Количество заказов " + order.getCountOfDishes() , Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
