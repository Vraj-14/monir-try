package com.example.monir_try;

// ITEM_MODEL FOR HOME PAGE -> Delicious food near you

public class ItemModel {
//    private  String price;
    private int imageResource; // Holds the resource ID for the image
    private String itemName; // Holds the name of the item

    // Constructor
    public ItemModel(int imageResource, String itemName) {
        this.imageResource = imageResource;
        this.itemName = itemName;
//        this.price = price;
    }

    // Getters
    public int getImageResource() {
        return imageResource;
    }

    public String getItemName() {
        return itemName;
    }
//    public String getPrice() {
//        return price;
//    }

    // Setters (optional, depending on if you need to modify data)
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
