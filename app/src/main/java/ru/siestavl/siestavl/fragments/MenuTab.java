package ru.siestavl.siestavl.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import ru.siestavl.siestavl.R;

/**
 * Created by dmitry on 9/26/15.
 */
public class MenuTab extends RootFragment {

//    static PageFragmentListener firstPageListener;
//    View.OnClickListener onClickListener;

    public MenuTab() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                if (firstPageListener != null)
////                    firstPageListener.onSwitchToNextFragment((int) v.getTag());
//                int btnId = (int) v.getTag();
//                switch (btnId) {
//                    case 1:
//
//                }
//            }
//        };
        View rootView = inflater.inflate(R.layout.fragment_menu_tab, container, false);

        ImageButton btnFoodkourt = (ImageButton)rootView.findViewById(R.id.ibtnFoodkourt);
  //      btnFoodkourt.setTag(1);
        btnFoodkourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment(1);
            }
        });

        ImageButton btnBar = (ImageButton)rootView.findViewById(R.id.ibtnBar);
//        btnBar.setTag(2);
        btnBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment(2);
            }
        });

        return rootView;
    }

    private void enterNextFragment(int buttonId) {
        MenuGroupsList menuGroupsList = new MenuGroupsList();
        Bundle bundle = new Bundle();
        bundle.putInt("btnId", buttonId);
        menuGroupsList.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, menuGroupsList).commit();
    }
//    public static MenuTab newInstance(PageFragmentListener listener) {
//        firstPageListener = listener;
//        return new MenuTab();
//    }
}
