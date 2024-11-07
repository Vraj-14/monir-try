package com.example.monir_try;

// ITEM MODEL FOR HOME PAE -> Tiffin's Available

public class ta_ItemModel {
    private int imageResId;
    private String providerName;
    private String menuType;
    private String distance;
    private Float rating;

    // Constructor
    public ta_ItemModel(int imageResId, String providerName, String menuType, String distance, Float rating){
        this.imageResId = imageResId;
        this.providerName = providerName;
        this.menuType = menuType;
        this.distance = distance;
        this.rating = rating;
    }

    //Getter methods
    public int getImageResId(){
        return imageResId;
    }

    public String getProviderName(){
        return providerName;
    }

    public String getMenuType(){
        return menuType;
    }

    public String  getDistance(){
        return distance;
    }
    public float getRating(){
        return rating;
    }
}
