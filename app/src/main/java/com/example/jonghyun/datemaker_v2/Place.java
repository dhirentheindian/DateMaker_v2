package com.example.jonghyun.datemaker_v2;

/**
 * Created by JongHyun on 2017-03-18.
 */

public class Place {
    private int id;
    private String sName;
    private String sLocation;
    private String sPrice;

    public Place(int id, String sName, String sLocation, String sPrice) {
        this.id = id;
        this.sName = sName;
        this.sLocation = sLocation;
        this.sPrice = sPrice;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsLocation() {
        return sLocation;
    }

    public void setsLocation(String sLocation) {
        this.sLocation = sLocation;
    }

    public String getsPrice() {
        return sPrice;
    }

    public void setsPrice(String sPrice) {
        this.sPrice = sPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}