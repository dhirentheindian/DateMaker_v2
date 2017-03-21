package com.example.jonghyun.datemaker_v2;

/**
 * Created by dev on 21/03/2017.
 */

public class Restaurant {
    private String title, openTime, closeTime, city, address, cuisine;
    private int budget;
    public Restaurant(String title, String openTime, String closeTime, String city, String address, int budget, String cuisine) {
        this.title = title;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.city = city;
        this.address = address;
        this.budget = budget;
        this.cuisine = cuisine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBudget() {
        return budget;
    }

    public Restaurant() {
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}
