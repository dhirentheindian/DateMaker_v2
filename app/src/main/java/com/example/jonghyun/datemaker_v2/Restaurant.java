package com.example.jonghyun.datemaker_v2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dev on 21/03/2017.
 */

public class Restaurant implements Parcelable {
    private String title;
    private String openTime;
    private String closeTime;
    private String city;
    private String address;
    private String cuisine;
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "title='" + title + '\'' +
                ", openTime='" + openTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", budget=" + budget +
                '}';
    }

    protected Restaurant(Parcel in) {
        title = in.readString();
        openTime = in.readString();
        closeTime = in.readString();
        city = in.readString();
        address = in.readString();
        cuisine = in.readString();
        budget = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(openTime);
        dest.writeString(closeTime);
        dest.writeString(city);
        dest.writeString(address);
        dest.writeString(cuisine);
        dest.writeInt(budget);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}
