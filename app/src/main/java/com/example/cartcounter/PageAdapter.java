package com.example.cartcounter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numOfTabs = numOfTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new LeftFragment();
            case 1:
                return new LeftCenterFragment();
            case 2:
                return new RightCenterFragment();
            case 3:
                return new RightFragment();
            default:
                return new LeftFragment();
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
