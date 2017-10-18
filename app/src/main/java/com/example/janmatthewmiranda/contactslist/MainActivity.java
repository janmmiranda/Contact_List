package com.example.janmatthewmiranda.contactslist;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    ContactDetailFragment f1;
    ContactListFragment f2;
    private ArrayList<SimpleContact> contacts;
    private ListView lvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContacts = (ListView) findViewById(R.id.contactView);
        contacts = new ArrayList<SimpleContact>();

        f1 = new ContactDetailFragment();
        f2 = new ContactListFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.id1, f2);
        ft.commit();

        addToList();
    }

    public void addToList() {

    }
}
