package com.example.janmatthewmiranda.contactslist;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by Jan on 10/17/2017.
 */

public class ContactProfileFragment extends Fragment implements View.OnClickListener {


    ListView relationPView;
    ArrayList<SimpleContact> relationVL = new ArrayList<SimpleContact>();
    ContactAdapter relationAdapter;
    TextView nText;
    TextView pText;
    String name, phone;
    ContactListFragment f1;
    SimpleContact contact;
    View view;
    ContactProfileFragment f2;
    int display;

    public ContactProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_profile, container, false);

        nText = (TextView) view.findViewById(R.id.nameT);
        nText.setText(name);
        pText = (TextView) view.findViewById(R.id.phoneT);
        pText.setText(phone);

        relationPView = (ListView) view.findViewById(R.id.relationPView);
        relationAdapter = new ContactAdapter(relationVL, getContext());
        relationPView.setAdapter(relationAdapter);
        setupListViewListener();

        return view;
    }

    private void setupListViewListener() {
        relationPView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View item, int pos, long id) {
                        f2 = new ContactProfileFragment();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        SimpleContact tempC = relationVL.get(pos);
                        relationPView.setAdapter(relationAdapter);
                        f2.setContact(tempC);
                        if(display == 1) {
                            ft.replace(R.id.id1, f2);
                        } else {
                            ft.replace(R.id.idRight, f2);
                        }
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                });
    }

    @Override
    public void onClick(View v) {
    }
    public void setContact(SimpleContact myc) {
        this.contact = myc;
        name = myc.getName();
        phone = myc.getPhone();
        relationVL = myc.getRelationList();
        System.out.println(name);
        int i = 0;
        while (i < relationVL.size()){
            System.out.println("relation with " + relationVL.get(i).getName());
            i++;
        }
    }

}