package ru.siestavl.siestavl.fragments;

import android.support.v4.app.Fragment;

import ru.siestavl.siestavl.BackPressImpl;
import ru.siestavl.siestavl.OnBackPressListener;

/**
 * Created by dmitry on 10/11/15.
 */
public class RootFragment extends Fragment implements OnBackPressListener{
    @Override
    public boolean onBackPressed() {
        return new BackPressImpl(this).onBackPressed();
    }
}
