package com.example.monir_try;

public class LocationItem {
    private int imageResourceId;
    private String distance;
    private String landmark;
    private String area;

    //Constructor
    public LocationItem(int imageResourceId, String distance, String landmark, String area) {
        this.imageResourceId=imageResourceId;
        this.distance = distance;
        this.landmark = landmark;
        this.area = area;
    }

    //Getters
    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDistance() {
        return distance;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getArea() {
        return area;
    }

    //Setters (optional, depending on if you need to modify data)
    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    public void setLandmark(String landmark){
        this.landmark=landmark;
    }
    public void setArea(String area){
        this.area=area;
    }
}
