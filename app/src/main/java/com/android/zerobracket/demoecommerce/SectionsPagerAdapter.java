package com.android.zerobracket.demoecommerce;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new TopProductsFragment();
            case 1:
                return new TopProductsFragment();
            case 2:
                return new TopProductsFragment();

                default:
                    return null;
        }
    }
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Top Products";
            case 1:
                return "Most Viewed";
            case 2:
                return "Most Liked";

                default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
