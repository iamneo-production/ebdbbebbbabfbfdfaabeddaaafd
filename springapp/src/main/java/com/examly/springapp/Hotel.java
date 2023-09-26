package com.examly.springapp;



public class Hotel {

    private int id;
    private String hotelName;
    private String location;
    private float rating;
    private boolean pool;
    private boolean gym;
    private boolean spa;

    
    public Hotel() {
    }

    public Hotel(int id, String hotelName, String location, float rating, boolean pool, boolean gym, boolean spa) {
        this.id = id;
        this.hotelName = hotelName;
        this.location = location;
        this.rating = rating;
        this.pool = pool;
        this.gym = gym;
        this.spa = spa;
    }
  
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public boolean isPool() {
        return pool;
    }
    public void setPool(boolean pool) {
        this.pool = pool;
    }
    public boolean isGym() {
        return gym;
    }
    public void setGym(boolean gym) {
        this.gym = gym;
    }
    public boolean isSpa() {
        return spa;
    }
    public void setSpa(boolean spa) {
        this.spa = spa;
    }
    

    
}
