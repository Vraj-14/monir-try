package com.example.monir_try;

public class ac_ItemModel {

    private int imageResId;
    private String itemName;
    private String itemPrice;
    private int quantity;

    // Constructor
    public ac_ItemModel(int imageResId, String itemName, String itemPrice, int quantity) {
        this.imageResId = imageResId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    //Getters and setters
    public int getImageResId(){
        return imageResId;
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemPrice(){
        return itemPrice;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setItemPrice(String itemPrice){
        this.itemPrice = itemPrice;
    }

    //   Setters
    public void setImageResId(int imageResId){
        this.imageResId = imageResId;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}
