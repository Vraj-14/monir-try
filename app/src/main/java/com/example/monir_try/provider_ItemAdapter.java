package com.example.monir_try;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// ADAPTER FOR PROVIDER PAGE -> Orders
public class provider_ItemAdapter extends RecyclerView.Adapter<provider_ItemAdapter.ViewHolder> {

    private Context context;
    private List<provider_ItemModel> provider_itemList;
    private OnItemClickListener listener;

    // Interface for custom OnClickListener
    public interface OnItemClickListener {
        void onItemClick(provider_ItemModel item);
    }

    // Constructor
    public provider_ItemAdapter(Context context, List<provider_ItemModel> itemList, OnItemClickListener listener) {
        this.context = context;
        this.provider_itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public provider_ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.provider_itemlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull provider_ItemAdapter.ViewHolder holder, int position) {
        provider_ItemModel item = provider_itemList.get(position);

        // Bind data to the views in the ViewHolder
        holder.itemImage.setImageResource(item.getImageResId());
        holder.itemOrder.setText(item.getOrder());
        holder.itemAmount.setText(String.valueOf(item.getAmount()));


        // Set OnClickListener for each item
        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return provider_itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemOrder;
        public TextView itemAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.imageView33);
            itemOrder = itemView.findViewById(R.id.textView70);
            itemAmount = itemView.findViewById(R.id.textView80);
        }
    }
}
