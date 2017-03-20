package com.example.jonghyun.datemaker_v2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    ArrayList<Place> restaurant, activity;

    public PageAdapter(FragmentManager fm, int NumOfTabs, ArrayList<Place> restaurant, ArrayList<Place> activity) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.restaurant = restaurant;
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ResultFragment tab1 = ResultFragment.newInstance(1, restaurant, activity);
                return tab1;
            case 1:
                ResultFragment tab2 = ResultFragment.newInstance(2, restaurant, activity);
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
