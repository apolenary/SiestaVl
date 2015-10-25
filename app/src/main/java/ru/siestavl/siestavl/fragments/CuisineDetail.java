package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.entity.Order;
import ru.siestavl.siestavl.entity.Dish;

/**
 * Created by dmitry on 9/29/15.
 */
public class CuisineDetail extends RootFragment implements NumberDialog.NumberPickerListener {


    static private int btnId;
    private Dish dish;
    Button button;
    NumberDialog dialog;
    Order order;

    public CuisineDetail() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cuisine_detail, container, false);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        dish = (Dish)getArguments().getSerializable("dish_key");

        ImageView image = (ImageView)rootView.findViewById(R.id.cuisine_detail_image);
        TextView name = (TextView)rootView.findViewById(R.id.cuisine_detail_name);
        TextView price = (TextView)rootView.findViewById(R.id.cuisine_detail_price);
        TextView description = (TextView)rootView.findViewById(R.id.cuisine_detail_description);
        Button button = (Button)rootView.findViewById(R.id.cuisine_detail_button);

        dialog = new NumberDialog();
        dialog.setTargetFragment(this, 0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = Order.getInstance();
                /*order.setDish(dish);
                Toast.makeText(getContext(), "Order Lenth is " + order.getCountOfDishes() , Toast.LENGTH_SHORT);*/

                dialog.show(getFragmentManager(), "Количество");
            }
        });
        image.setImageResource(R.drawable.ic_soup5);
        name.setText(dish.getName());
        price.setText("Цена: " + dish.getPrice() + " руб");
        description.setText(dish.getDescription());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        order = Order.getInstance();

    }

    @Override
    public void updateResult(int inputInt) {
        order.setDish(dish, inputInt);
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
