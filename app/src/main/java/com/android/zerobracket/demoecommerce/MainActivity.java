package com.android.zerobracket.demoecommerce;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    SlideShowFragment slideShowFragment;
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
    TopLayoutFragment topLayoutFragment;
    BottomLayoutFragment bottomLayoutFragment;

    private TextView countTv;
    MenuItem cartIconMenuItem;
    private int mCount = 0;
    private ArrayList<String> productList;
    ViewPager viewPager;
    SectionsPagerAdapter sectionsPagerAdapter;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout= findViewById(R.id.nobar);

        sectionsPagerAdapter= new SectionsPagerAdapter(getSupportFragmentManager());//creates sections for the element to view viewpager
        tabLayout.setTabsFromPagerAdapter(sectionsPagerAdapter);
        slideShowFragment=new SlideShowFragment();
        topLayoutFragment=new TopLayoutFragment();
        bottomLayoutFragment=new BottomLayoutFragment();
        setFragment(slideShowFragment,topLayoutFragment,bottomLayoutFragment);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        expandableList = findViewById(R.id.navigationmenu);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);
        expandableList.setAdapter(mMenuAdapter);
        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                //Log.d("DEBUG", "submenu item clicked");
                Toast.makeText(MainActivity.this, "Submenu item clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                //Log.d("DEBUG", "heading clicked");
                Toast.makeText(MainActivity.this, "Group clicked", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void setupDrawerContent(NavigationView navigationView) {
        //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        ExpandedMenuModel item1 = new ExpandedMenuModel();
        item1.setIconName("HOME");
        item1.setIconImg(R.drawable.ic_home);
        // Adding data header
        listDataHeader.add(item1);

        ExpandedMenuModel item2 = new ExpandedMenuModel();
        item2.setIconName("CATEGORIES");
        item2.setIconImg(R.drawable.category);
        listDataHeader.add(item2);

        ExpandedMenuModel item3 = new ExpandedMenuModel();
        item3.setIconName("SHOP");
        item3.setIconImg(R.drawable.ic_shopping_cart);
        listDataHeader.add(item3);

        ExpandedMenuModel item4 = new ExpandedMenuModel();
        item4.setIconName("MY ACCOUNT");
        item4.setIconImg(R.drawable.ic_account_circle);
        listDataHeader.add(item4);

        ExpandedMenuModel item5 = new ExpandedMenuModel();
        item5.setIconName("MY ORDERS");
        item5.setIconImg(R.drawable.ic_assignment);
        listDataHeader.add(item5);

        ExpandedMenuModel item6 = new ExpandedMenuModel();
        item6.setIconName("MY ADDRESSES");
        item6.setIconImg(R.drawable.ic_place_black_24dp);
        listDataHeader.add(item6);

        ExpandedMenuModel item7 = new ExpandedMenuModel();
        item7.setIconName("MY FAVORITES");
        item7.setIconImg(R.drawable.ic_favorite_black_24dp);
        listDataHeader.add(item7);

        ExpandedMenuModel item8 = new ExpandedMenuModel();
        item8.setIconName("CONTACT US");
        item8.setIconImg(R.drawable.message_bulleted);
        listDataHeader.add(item8);

        ExpandedMenuModel item9 = new ExpandedMenuModel();
        item9.setIconName("ABOUT");
        item9.setIconImg(R.drawable.about);
        listDataHeader.add(item9);

        ExpandedMenuModel item19 = new ExpandedMenuModel();
        item19.setIconName("SHARE APP");
        item19.setIconImg(R.drawable.ic_share_black_24dp);
        listDataHeader.add(item19);

        ExpandedMenuModel item10 = new ExpandedMenuModel();
        item10.setIconName("RATE APP");
        item10.setIconImg(R.drawable.ic_stars_black_24dp);
        listDataHeader.add(item10);

        ExpandedMenuModel item11 = new ExpandedMenuModel();
        item11.setIconName("SETTINGS");
        item11.setIconImg(R.drawable.ic_settings_black_24dp);
        listDataHeader.add(item11);

        ExpandedMenuModel item12 = new ExpandedMenuModel();
        item12.setIconName("LOGIN");
        item12.setIconImg(R.drawable.ic_login);
        listDataHeader.add(item12);

        // Adding child data
        List<String> heading1 = new ArrayList<String>();
        heading1.add("HOME 1");
        heading1.add("HOME 2");
        heading1.add("HOME 3");
        heading1.add("HOME 4");
        heading1.add("HOME 5");

        List<String> heading2 = new ArrayList<String>();
        heading2.add("CATEGORY 1");
        heading2.add("CATEGORY 2");
        heading2.add("CATEGORY 3");
        heading2.add("CATEGORY 4");
        heading2.add("CATEGORY 5");
        heading2.add("CATEGORY 6");

        List<String> heading3 = new ArrayList<String>();
        heading3.add("NEWEST ");
        heading3.add("TOP DISHES ");
        heading3.add("SUPER DEALS");
        heading3.add("MOST LIKED");
        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        cartIconMenuItem = menu.findItem(R.id.cart_count_menu_item);
        MenuItem search = menu.findItem(R.id.search);
        search.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                return true;
            }
        });

        View actionView = cartIconMenuItem.getActionView();
        View cartImageButtonwMenuItem;
        if (actionView != null) {
            countTv = actionView.findViewById(R.id.count_tv);
            cartImageButtonwMenuItem = actionView.findViewById(R.id.cart_ic_image);
            cartImageButtonwMenuItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                    startActivity(intent);*/
                }
            });
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(Fragment fragment1,Fragment fragment2,Fragment fragment3) {
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.slide_show_frame,fragment1);
        fragmentTransaction.replace(R.id.first_tab_frame,fragment2);
        fragmentTransaction.replace(R.id.second_tab_frame,fragment3);
        fragmentTransaction.commit();
        //Toast.makeText(getApplicationContext(),fragment.toString(),Toast.LENGTH_SHORT).show();
    }
}
