package com.android.zerobracket.demoecommerce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllProductsFragment extends Fragment {


    public AllProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_all_products, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recylerViewAllProducts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        AllProductsAdapter adapter = new AllProductsAdapter(getContext());
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

}
