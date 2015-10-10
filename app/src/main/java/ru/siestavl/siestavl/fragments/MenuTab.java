package ru.siestavl.siestavl.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.R;

/**
 * Created by dmitry on 9/26/15.
 */
public class MenuTab extends Fragment {

    static PageFragmentListener firstPageListener;
    View.OnClickListener onClickListener;

    public MenuTab() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstPageListener != null)
                    firstPageListener.onSwitchToNextFragment((int) v.getTag());
            }
        };
        View rootView = inflater.inflate(R.layout.fragment_menu_tab, container, false);
        ImageButton btnFoodkourt = (ImageButton)rootView.findViewById(R.id.ibtnFoodkourt);
        btnFoodkourt.setTag(1);
        btnFoodkourt.setOnClickListener(onClickListener);

        ImageButton btnBar = (ImageButton)rootView.findViewById(R.id.ibtnBar);
        btnBar.setTag(2);
        btnBar.setOnClickListener(onClickListener);

        return rootView;
    }

    public static MenuTab newInstance(PageFragmentListener listener) {
        firstPageListener = listener;
        return new MenuTab();
    }
}
