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
                AllProductsFragment allProductsFragment= new AllProductsFragment();
                return allProductsFragment;
            case 1:
                allProductsFragment= new AllProductsFragment();
                return allProductsFragment;
            case 2:
                allProductsFragment= new AllProductsFragment();
                return allProductsFragment;

            case 3:
                allProductsFragment= new AllProductsFragment();
                return allProductsFragment;
            case 4:
                allProductsFragment= new AllProductsFragment();
                return allProductsFragment;
            case 5:
                allProductsFragment= new AllProductsFragment();
                return allProductsFragment;
            case 6:
                allProductsFragment= new AllProductsFragment();
                return allProductsFragment;

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