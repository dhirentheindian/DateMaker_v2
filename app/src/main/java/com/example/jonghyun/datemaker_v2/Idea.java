package com.example.jonghyun.datemaker_v2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Deran on 3/27/2017.
 */

public class Idea implements Parcelable{
    private String title, openTime, closeTime,city, address, subtitle;
    int budget;


    public Idea(String title, String openTime, String closeTime, String city, String address, int budget, String subtitle) {
        this.title = title;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.city = city;
        this.address = address;
        this.budget = budget;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }
    public String getSubtitle(){
        return subtitle;
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

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<Idea> CREATOR = new Parcelable.Creator<Idea>() {
        public Idea createFromParcel(Parcel in) {
            return new Idea(in);
        }

        public Idea[] newArray(int size) {

            return new Idea[size];
        }

    };
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(openTime);
        dest.writeString(closeTime);
        dest.writeString(city);
        dest.writeString(address);
        dest.writeString(subtitle);
        dest.writeInt(budget);
    }
    public Idea(Parcel in){
        super();
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        title = in.readString();
        openTime = in.readString();
        closeTime = in.readString();
        city = in.readString();
        address = in.readString();
        subtitle = in.readString();
        budget = in.readInt();
    }
}
