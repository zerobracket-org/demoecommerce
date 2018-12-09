package com.android.zerobracket.demoecommerce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class ItemDetailsViewActivity extends AppCompatActivity {

    private TextView countTv;
    MenuItem cartIconMenuItem;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdetailsview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Product Description");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
