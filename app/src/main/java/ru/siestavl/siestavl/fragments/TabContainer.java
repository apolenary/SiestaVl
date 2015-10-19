package ru.siestavl.siestavl.fragments;


//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.siestavl.siestavl.OnBackPressListener;
import ru.siestavl.siestavl.R;
import ru.siestavl.siestavl.adapters.ViewPagerAdapter;
import ru.siestavl.siestavl.adapters.ViewPagerAdapterOld;
import ru.siestavl.siestavl.view.SlidingTabLayout;

/**
 * Created by dmitry on 9/26/15.
 */
public class TabContainer extends Fragment {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapterOld mViewPagerAdapterOld;
    private ViewPagerAdapter adapter;
    //private SamplePagerAdapter mViewPagerAdapterOld;
    CharSequence Titles[]={"Меню","Программа"};
    int Numboftabs =2;

    public TabContainer() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_container, container, false);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
//        rootView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                if (keyCode == KeyEvent.KEYCODE_BACK) {
//                    if (event.getAction() != KeyEvent.ACTION_DOWN)
//                        return true;
//                    //Toast.makeText(getContext(), "Message", Toast.LENGTH_SHORT).show();
//                    //getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                    if (mViewPager.getCurrentItem() == 0) {
//                        if (mViewPagerAdapterOld.getItem(0) instanceof MenuGroupsList ||
//                                mViewPagerAdapterOld.getItem(0) instanceof CuisineDetail) {
//                            ((TabFragment) mViewPagerAdapterOld.getItem(0)).backPressed();
//                            return true;
//                        } else if (mViewPagerAdapterOld.getItem(0) instanceof MenuTab) {
//                            return false;
//                        }
//                    }
//                    return true;
//                }
//                return false;
//            }
//        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        // Creating The ViewPagerAdapterOld and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        //mViewPagerAdapterOld =  new ViewPagerAdapterOld(getFragmentManager(), Titles, Numboftabs);
        //mViewPagerAdapterOld =  new SamplePagerAdapter();

        adapter = new ViewPagerAdapter(getResources(), getChildFragmentManager());
        //mViewPager.setAdapter(adapter);

        // Assigning ViewPager View and setting the adapter
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        //mSlidingTabLayout.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }

            @Override
            public int getDividerColor(int position) {
                return position;
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        mSlidingTabLayout.setViewPager(mViewPager);
    }


    public boolean onBackPressed() {
        // currently visible tab Fragment
        OnBackPressListener currentFragment = (OnBackPressListener) adapter.getRegisteredFragment(mViewPager.getCurrentItem());

        if (currentFragment != null) {
            // lets see if the currentFragment or any of its childFragment can handle onBackPressed
            return currentFragment.onBackPressed();
        }

        // this Fragment couldn't handle the onBackPressed call
        return false;
    }
    // Adapter
//    class SamplePagerAdapter extends PagerAdapter {
//
//        /**
//         * Return the number of pages to display
//         */
//        @Override
//        public int getCount() {
//            return 2;
//        }
//
//        /**
//         * Return true if the value returned from is the same object as the View
//         * added to the ViewPager.
//         */
//        @Override
//        public boolean isViewFromObject(View view, Object o) {
//            return o == view;
//        }
//
//        /**
//         * Return the title of the item at position. This is important as what
//         * this method returns is what is displayed in the SlidingTabLayout.
//         */
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return Titles[position];
//        }
//
//        /**
//         * Instantiate the View which should be displayed at position. Here we
//         * inflate a layout from the apps resources and then change the text
//         * view to signify the position.
//         */
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            View view = null;
//            if(position == 0) {
//                view = getActivity().getLayoutInflater().inflate(R.layout.fragment_menu_tab,
//                        container, false);
//            } else {
//                view = getActivity().getLayoutInflater().inflate(R.layout.fragment_films_tab,
//                        container, false);
//            }
//
//
//            // Inflate a new layout from our resources
//            //View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item,
//            //        container, false);
//            // Add the newly created View to the ViewPager
//            container.addView(view);
//
//            // Retrieve a TextView from the inflated View, and update it's text
//            //TextView title = (TextView) view.findViewById(R.id.item_title);
//            //title.setText(String.valueOf(position + 1));
//
//            // Return the View
//            return view;
//        }
//
//        /**
//         * Destroy the item from the ViewPager. In our case this is simply
//         * removing the View.
//         */
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//        }
//    }

}
