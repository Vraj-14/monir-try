package com.example.monir_try;

// ADAPTER FOR HOME PAGE -> Tiffin's Available

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ta_ItemAdapter extends RecyclerView.Adapter<ta_ItemAdapter.ViewHolder> {

    private Context context;
    private List<ta_ItemModel> ta_itemList;

    //Constructor
    public ta_ItemAdapter(Context context, List<ta_ItemModel> itemList) {
        this.context = context;
        this.ta_itemList = itemList;
    }
    @NonNull
    @Override
    public ta_ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ta_itemlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ta_ItemAdapter.ViewHolder holder, int position) {
        ta_ItemModel item = ta_itemList.get(position);

        // Bind data to the views in the ViewHolder
        holder.itemImage.setImageResource(item.getImageResId());
        holder.itemProviderName.setText(item.getProviderName());
        holder.itemMenuType.setText(item.getMenuType());
        holder.itemDistance.setText(item.getDistance());
        holder.itemRating.setRating(item.getRating());
    }


    @Override
    public int getItemCount() {
        return ta_itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemProviderName;
        public TextView itemMenuType;
        public TextView itemDistance;
        public RatingBar itemRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.imageView12);
            itemProviderName = itemView.findViewById(R.id.provider_name);
            itemMenuType = itemView.findViewById(R.id.menu_type);
            itemDistance = itemView.findViewById(R.id.distance);
            itemRating = itemView.findViewById(R.id.ratingBar);

        }
    }



}
