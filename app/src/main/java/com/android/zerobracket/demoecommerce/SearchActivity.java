package com.android.zerobracket.demoecommerce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private TextView countTv;
    MenuItem cartIconMenuItem;
    private int mCount = 0;
    RecyclerView recyclerView;
    ArrayList<String> foodList;
    SearchView searchView;
    SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Search");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

        foodList = new ArrayList<>(5);
        foodList.add("Snacks & Small Plates");
        foodList.add("Soups");
        foodList.add("Side Salads");
        foodList.add("Steak");
        foodList.add("Seafood");
        foodList.add("Chicken");

        recyclerView = findViewById(R.id.recylerViewSearch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new SearchAdapter(foodList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem cartIconMenuItem = menu.findItem(R.id.cart_count_menu_item);
        View actionView = cartIconMenuItem.getActionView();
        View cartImageButtonwMenuItem;
        if (actionView != null) {
            countTv = actionView.findViewById(R.id.count_tv);
            cartImageButtonwMenuItem = actionView.findViewById(R.id.cart_ic_image);
            cartImageButtonwMenuItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String temp = newText.toLowerCase();
        ArrayList<String> tempFoodList = new ArrayList<>(3);

        for (String value : foodList) {
            if(value.toLowerCase().contains(temp)){
                tempFoodList.add(value);
            }
        }
        Log.d("App", "onQueryTextChange: foodlistSize: "+tempFoodList.size());
        adapter.updateList(tempFoodList);

        return true;
    }
}
