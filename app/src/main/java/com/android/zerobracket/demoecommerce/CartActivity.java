package com.android.zerobracket.demoecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class CartActivity extends AppCompatActivity {

    private TextView countTv;
    private int mCount = 0;
    RecyclerView recyclerView;
    ArrayList<String> foodList;
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("My Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CartAdapter(this);
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
}
