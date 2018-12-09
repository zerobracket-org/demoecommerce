
package com.android.zerobracket.demoecommerce;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Context context;

    int totalValue = MainActivity.mCount;

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
    public void onBindViewHolder(@NonNull final CartAdapter.ViewHolder viewHolder, int i) {

       viewHolder.btnView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               context.startActivity(new Intent(context, ItemDetailsViewActivity.class));
           }
       });
        viewHolder.imageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalValue>0){
                    totalValue--;
                    if(MainActivity.mCount > 0) {
                        MainActivity.mCount--;
                        MainActivity.countTv.setText(String.valueOf(MainActivity.mCount));
                    }
                    notifyDataSetChanged();
                }
            }
        });
        viewHolder.buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue = viewHolder.tvQuantityValue.getText().toString();
                int temp = Integer.valueOf(currentValue);
                if(temp>0){
                    temp--;
                    if(MainActivity.mCount > 0) {
                        MainActivity.mCount--;
                        MainActivity.countTv.setText(String.valueOf(MainActivity.mCount));
                    }
                }
                viewHolder.tvQuantityValue.setText(String.valueOf(temp));
            }
        });
        viewHolder.buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue = viewHolder.tvQuantityValue.getText().toString();
                int temp = Integer.valueOf(currentValue);
                if(temp<10){
                    temp++;
                    if(MainActivity.mCount <10) {
                        MainActivity.mCount++;
                        MainActivity.countTv.setText(String.valueOf(MainActivity.mCount));
                    }
                }
                viewHolder.tvQuantityValue.setText(String.valueOf(temp));
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
        return totalValue;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton buttonLeft, buttonRight, imageButtonDelete ;
        TextView tvQuantityValue; Button btnView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonLeft = itemView.findViewById(R.id.buttonLeft);
            tvQuantityValue = itemView.findViewById(R.id.tvQuantityValue);
            buttonRight = itemView.findViewById(R.id.buttonRight);
            imageButtonDelete = itemView.findViewById(R.id.imageButtonDelete);
            btnView = itemView.findViewById(R.id.btnView);
        }
    }
}
