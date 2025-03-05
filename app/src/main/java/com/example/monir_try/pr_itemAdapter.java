package com.example.monir_try;

// ADAPTER FOR ROTI

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class pr_itemAdapter extends RecyclerView.Adapter<pr_itemAdapter.ViewHolder> {
    private Context context;
    private List<pr_itemModel> pr_itemList;
    private OnItemClickListener listener; // Use the correct interface

    // Define the OnItemClickListener inside pr_itemAdapter
    public interface OnItemClickListener {
        void onItemClick(pr_itemModel item);
    }

    // Correct constructor
    public pr_itemAdapter(Context context, List<pr_itemModel> pr_itemList, OnItemClickListener listener) {
        this.context = context;
        this.pr_itemList = pr_itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public pr_itemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pr_itemlayout, parent, false);
        return new pr_itemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pr_itemAdapter.ViewHolder holder, int position) {
        pr_itemModel item1 = pr_itemList.get(position);

        holder.itemRoti.setText(item1.getRoti());

        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemClick(item1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pr_itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemRoti;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRoti = itemView.findViewById(R.id.textView90);
        }
    }
}
