package com.android.zerobracket.demoecommerce;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomLayoutFragment extends Fragment {

    private ViewPager viewPager;
    private SectionsPagerAdapter2 sectionsPagerAdapter;
    private TabLayout tabLayout;

    public BottomLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        viewPager= getActivity().findViewById(R.id.second_tab_pager);//creates pages or
        sectionsPagerAdapter= new SectionsPagerAdapter2(getActivity().getSupportFragmentManager());//creates sections for the element to view viewpager
        viewPager.setAdapter(sectionsPagerAdapter);//show content on each fragments
        tabLayout= getActivity().findViewById(R.id.second_tab_layout);
        tabLayout.setupWithViewPager(viewPager);//Initiating viewpager to tablayout
        super.onActivityCreated(savedInstanceState);
    }
}
