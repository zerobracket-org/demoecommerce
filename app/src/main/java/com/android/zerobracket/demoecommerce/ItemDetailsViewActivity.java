package com.android.zerobracket.demoecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
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
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdetailsview);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
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
            countTv.setText(String.valueOf(MainActivity.mCount));
            cartImageButtonwMenuItem = actionView.findViewById(R.id.cart_ic_image);
            cartImageButtonwMenuItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                    startActivity(intent);
                }
            });
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void btnAddToCartClicked(View view) {

        MainActivity.mCount += 1;
        countTv.setText(String.valueOf(MainActivity.mCount));
        MainActivity.countTv.setText(String.valueOf(MainActivity.mCount));

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Item is add", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.mCount > 0){
                    MainActivity.mCount -= 1;
                    countTv.setText(String.valueOf(MainActivity.mCount));
                    MainActivity.countTv.setText(String.valueOf(MainActivity.mCount));

                }
            }
        });
        snackbar.show();
    }
}
