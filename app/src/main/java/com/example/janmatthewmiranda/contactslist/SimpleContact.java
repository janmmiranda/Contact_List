package com.example.janmatthewmiranda.contactslist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jan on 10/17/2017.
 */

public class SimpleContact implements Serializable{
    private String name;
    private String phone;
    private ArrayList<String> relation;

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
