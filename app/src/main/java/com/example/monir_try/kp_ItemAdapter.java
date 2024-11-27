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

public class kp_ItemAdapter extends RecyclerView.Adapter<kp_ItemAdapter.ViewHolder> {

    private List<kp_ItemModel> itemList;
    private Context context;

    public kp_ItemAdapter(Context context, List<kp_ItemModel> kp_ItemList){
        this.context = context;
        this.itemList = kp_ItemList;
    }


    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kp_itemlayout, parent, false);
        return new ViewHolder(view);
    }



    public void onBindViewHolder(@NonNull kp_ItemAdapter.ViewHolder holder, int position) {
        kp_ItemModel item = itemList.get(position);
        holder.itemimage.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView itemimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemimage = itemView.findViewById(R.id.imageView);
        }
    }


}
