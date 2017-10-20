package com.example.janmatthewmiranda.contactslist;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jan on 10/17/2017.
 */

public class SimpleContact implements Parcelable{
    private int mData;
    private String name;
    private String phone;
    private  Boolean selected;
    private ArrayList<SimpleContact> relationList;

    protected SimpleContact(Parcel in) {
        mData = in.readInt();
        name = in.readString();
        phone = in.readString();
        relationList = in.createTypedArrayList(SimpleContact.CREATOR);
    }

    public static final Creator<SimpleContact> CREATOR = new Creator<SimpleContact>() {
        @Override
        public SimpleContact createFromParcel(Parcel in) {
            return new SimpleContact(in);
        }

        @Override
        public SimpleContact[] newArray(int size) {
            return new SimpleContact[size];
        }
    };

    public Boolean isSelected() {
        return selected;
    }

    SimpleContact(String name, String number){
        this.setName(name);
        this.setPhone(number);
        //this.setRelation(relationList);
        this.setSelected(false);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    public void setName(String n) {
        this.name = n;
    }

    public  void setPhone(String p) {
        this.phone = p;
    }

    public void setRelation(ArrayList<SimpleContact> rList){
        this.relationList = rList;
    }

    public void  setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public  ArrayList<SimpleContact> getRelationList() {
        return this.relationList;
    }


}
