
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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Context context;

    CartAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder viewHolder, int i) {

       /* viewHolder.itemImage.setOnClickListener(detailsListener);
        viewHolder.tvItemName.setOnClickListener(detailsListener);
        viewHolder.tvprice.setOnClickListener(detailsListener);*/

    }

    private View.OnClickListener detailsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context, ItemDetailsViewActivity.class));
        }
    };

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView tvItemName, tvprice;
        Button btnAddItemToCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            /*itemImage = itemView.findViewById(R.id.itemImage);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvprice = itemView.findViewById(R.id.tvprice);
            btnAddItemToCart = itemView.findViewById(R.id.btnAddItemToCart);*/
        }
    }
}
