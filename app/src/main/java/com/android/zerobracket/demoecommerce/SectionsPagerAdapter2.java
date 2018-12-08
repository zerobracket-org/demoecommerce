package com.android.zerobracket.demoecommerce;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.zerobracket.demoecommerce.MostLikedFragment;
import com.android.zerobracket.demoecommerce.MostViewedFragment;
import com.android.zerobracket.demoecommerce.TopProductsFragment;


class SectionsPagerAdapter2 extends FragmentPagerAdapter {
    public SectionsPagerAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                TopProductsFragment topProductsFragment= new TopProductsFragment();
                return topProductsFragment;
            case 1:
                MostViewedFragment mostViewedFragment= new MostViewedFragment();
                return mostViewedFragment;
            case 2:
                MostLikedFragment mostLikedFragment= new MostLikedFragment();
                return mostLikedFragment;

            case 3:
                topProductsFragment= new TopProductsFragment();
                return topProductsFragment;
            case 4:
                mostViewedFragment= new MostViewedFragment();
                return mostViewedFragment;
            case 5:
                mostLikedFragment= new MostLikedFragment();
                return mostLikedFragment;
            case 6:
                topProductsFragment= new TopProductsFragment();
                return topProductsFragment;

            default:
                return null;
        }
    }
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "All";

            case 1:
                return "Electronics";

            case 2:
                return "Health & Beauty";

            case 3:
                return "Babies and Toys";

            case 4:
                return "Groceries";

            case 5:
                return "Frozen Foods";

            case 6:
                return "others";

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 7;
    }
}