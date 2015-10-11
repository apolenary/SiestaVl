package ru.siestavl.siestavl.adapters;

/**
 * Created by dmitry on 9/28/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ru.siestavl.siestavl.PageFragmentListener;
import ru.siestavl.siestavl.fragments.CuisineDetail;
import ru.siestavl.siestavl.fragments.MenuGroupsList;
import ru.siestavl.siestavl.fragments.FilmsTab;
import ru.siestavl.siestavl.fragments.MenuTab;

public class ViewPagerAdapterOld extends FragmentStatePagerAdapter {

    private final class PageListener implements
            PageFragmentListener {
        public void onSwitchToNextFragment(int btnId) {
            mFragmentManager.beginTransaction().remove(mFragmentAtPos0)
                    .commit();
            if (mFragmentAtPos0 instanceof MenuTab ||
                    mFragmentAtPos0 instanceof CuisineDetail){
                //mFragmentAtPos0 = MenuGroupsList.newInstance(listener, btnId);
            }else{ // Instance of NextFragment
                if (mFragmentAtPos0 instanceof MenuGroupsList && btnId != 4) {
                    mFragmentAtPos0 = CuisineDetail.newInstance(listener, btnId);
                } else {
                  //  mFragmentAtPos0 = MenuTab.newInstance(listener);
                }
            }
            notifyDataSetChanged();
        }
    }

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapterOld is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapterOld is created
    private Fragment mFragmentAtPos0;
    private Fragment mFragmentAtPos1;
    private final FragmentManager mFragmentManager;
    PageListener listener = new PageListener();

    // Build a Constructor and assign the passed Values to appropriate values in the class
//    public ViewPagerAdapterOld(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
    public ViewPagerAdapterOld(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);
        mFragmentManager = fm;
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            if (mFragmentAtPos0 == null) {
                //mFragmentAtPos0 = MenuTab.newInstance(listener);
            }
            return mFragmentAtPos0;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            return new FilmsTab();
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }

    @Override
    public int getItemPosition(Object object) {
        if (object instanceof MenuTab && mFragmentAtPos0 instanceof MenuGroupsList) {
            return POSITION_NONE;
        } else if (object instanceof MenuGroupsList && mFragmentAtPos0 instanceof CuisineDetail) {
            return POSITION_NONE;
        } else if (object instanceof CuisineDetail && mFragmentAtPos0 instanceof MenuGroupsList) {
            return POSITION_NONE;
        } else if (object instanceof MenuGroupsList && mFragmentAtPos0 instanceof MenuTab) {
            return POSITION_NONE;
        }
        return POSITION_UNCHANGED;
    }
}