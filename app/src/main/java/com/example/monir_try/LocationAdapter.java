package com.example.monir_try;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private List<LocationItem> locationItems;
    private Context context;

    //Constructor
    public LocationAdapter(Context context,List<LocationItem> locationItems) {
        this.context = context;
        this.locationItems = locationItems;
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView TextViewdistance;
        public TextView TextViewlandmark;
        public TextView TextViewarea;

        public LocationViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView17);
            TextViewdistance = itemView.findViewById(R.id.textView37);
            TextViewlandmark = itemView.findViewById(R.id.textView38);
            TextViewarea = itemView.findViewById(R.id.textView39);

         }
    }

    @Override
    @NonNull
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_location,parent,false);
        return new LocationViewHolder(view);
    }
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        // Get the current item based on position
        LocationItem locationItem = locationItems.get(position);
        // Set the data in the views
        holder.imageView.setImageResource(locationItem.getImageResourceId());
        holder.TextViewdistance.setText(String.valueOf(locationItem.getDistance()));
        holder.TextViewlandmark.setText(locationItem.getLandmark());
        holder.TextViewarea.setText(locationItem.getArea());
    }
    @Override
    public int getItemCount() {
        return locationItems.size();
    }



}

