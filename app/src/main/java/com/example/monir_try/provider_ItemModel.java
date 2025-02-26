package com.example.monir_try;

// ITEM LAYOUT FOR PROVIDER PAGE -> Orders

public class provider_ItemModel {

    private int imageResId;
    private String order;
    private int amount;

    // Constructor
    public provider_ItemModel(int imageResId, String order, int amount){
        this.imageResId = imageResId;
        this.order = order;
        this.amount = amount;
    }



    //Getter methods
    public int getImageResId(){
        return imageResId;
    }

    public String getOrder(){
        return order;
    }
    public int getAmount(){
        return amount;
    }

}
