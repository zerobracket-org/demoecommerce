package com.android.zerobracket.demoecommerce;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.ViewHolder> {
    private Context context;

    AllProductsAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public AllProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bottom_cart_view, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AllProductsAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemImage.setOnClickListener(detailsListener);
        viewHolder.tvItemName.setOnClickListener(detailsListener);
        viewHolder.tvprice.setOnClickListener(detailsListener);

        viewHolder.btnAddItemToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private View.OnClickListener detailsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context, ItemDetailsViewActivity.class));
        }
    };

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView tvItemName, tvprice;
        Button btnAddItemToCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvprice = itemView.findViewById(R.id.tvprice);
            btnAddItemToCart = itemView.findViewById(R.id.btnAddItemToCart);
        }
    }

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected();
    }

}
