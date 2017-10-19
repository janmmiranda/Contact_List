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
    private ArrayList<String> relation;

    protected SimpleContact(Parcel in) {
        mData = in.readInt();
        name = in.readString();
        phone = in.readString();
        relation = in.createStringArrayList();
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }



    public SimpleContact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public boolean setRelation(ArrayList rName){
        relation = new ArrayList();

        return true;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
