package com.example.monir_try;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ac_ItemAdapter  extends RecyclerView.Adapter<ac_ItemAdapter.ViewHolder>   {

    private List<ac_ItemModel> ac_itemList;

    //Constructor
    public ac_ItemAdapter(List<ac_ItemModel> ac_itemList) {
        this.ac_itemList = ac_itemList;
    }


    @NonNull
    @Override
    public ac_ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ac_itemlayout, parent, false);
        return new ac_ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ac_ItemAdapter.ViewHolder holder, int position) {

        ac_ItemModel currentitem = ac_itemList.get(position);

        holder.itemImage.setImageResource(currentitem.getImageResId());
        holder.itemName.setText(currentitem.getItemName());
        holder.itemPrice.setText(currentitem.getItemPrice());
        holder.itemQuantity.setText(String.valueOf(currentitem.getQuantity()));

        holder.incrementQuantity.setOnClickListener(v -> {
            int quantity = currentitem.getQuantity();
            currentitem.setQuantity(quantity + 1);
            holder.itemQuantity.setText(String.valueOf(currentitem.getQuantity()));
        });

        holder.decrementQuantity.setOnClickListener(v -> {
            int quantity = currentitem.getQuantity();
            if (quantity > 0) {
                currentitem.setQuantity(quantity - 1);
                holder.itemQuantity.setText(String.valueOf(currentitem.getQuantity()));
            }
        });

    }

    @Override
    public int getItemCount() {
       return ac_itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView itemImage;
        private TextView itemName;
        private TextView itemPrice;
        private TextView itemQuantity;
        private ImageView incrementQuantity;
        private ImageView decrementQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.imageView21); // image of food item
            itemName = itemView.findViewById(R.id.textView52); // item name
            itemPrice = itemView.findViewById(R.id.textView53); //
            itemQuantity = itemView.findViewById(R.id.textView55); // quantity
            incrementQuantity = itemView.findViewById(R.id.imageView23); // increment
            decrementQuantity = itemView.findViewById(R.id.imageView26); // decrement


        }
    }
}