package com.example.janmatthewmiranda.contactslist;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ContactDetailFragment.onAddPersonClickListener{

    ContactDetailFragment f1 = new ContactDetailFragment();;
    ContactListFragment f2 = new ContactListFragment();;
    EditText etName, etPhone;
    String conName, conPhone;
    ContactDetailFragment detailFrag;
    FragmentManager fm;
    int display;
    SimpleContact myC;
    ArrayList<SimpleContact> list = new ArrayList<SimpleContact>();
    ArrayList<SimpleContact> relationList = new ArrayList<SimpleContact>();

    public void onAddPersonClick() {
        if(display == 1) {
            detailFrag = (ContactDetailFragment) fm.findFragmentById(R.id.id1);
            if (detailFrag != null) {
                //fragments
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ContactListFragment fragment = new ContactListFragment();

                //getting elements to put in contact object
                etName = detailFrag.getNameText();
                conName = etName.getText().toString();
                etPhone = detailFrag.getPhoneText();
                conPhone = etPhone.getText().toString();
                //create and set new contact
                //relationList = f1.getRelationList();
                int k = 0;
                SimpleContact tempC;
                while (k < list.size()) {
                    if (list.get(k).isSelected()) {
                        tempC = list.get(k);
                        relationList.add(tempC);
                        //System.out.println("rname " + k + " " + relationList.get(k).getName());
                    }
                    k++;
                }
                myC = new SimpleContact(conName, conPhone, relationList);
                //myC.setRelation(relationList);
                f2.setList(list);
                addlistContact(myC);

                Bundle bundle = new Bundle();
                bundle.putParcelable("contact", myC);
                fragment.setArguments(bundle);
                ft.remove(detailFrag);
                ft.add(R.id.id1, f2);
                ft.commit();
            }
        } else {
            detailFrag = (ContactDetailFragment) fm.findFragmentById(R.id.idRight);
            if (detailFrag != null) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ContactListFragment fragment = new ContactListFragment();

                etName = detailFrag.getNameText();
                conName = etName.getText().toString();
                etPhone = detailFrag.getPhoneText();
                conPhone = etPhone.getText().toString();
                SimpleContact myC = new SimpleContact(conName, conPhone, relationList);
                Log.d("list1", list.toString());
                f2.setList(list);
                f1.setRelList(list);
                addlistContact(myC);

                etName.setText("");
                etPhone.setText("");
                Bundle bundle = new Bundle();
                bundle.putParcelable("contact", myC);
                fragment.setArguments(bundle);
            }
        }

    }

    public void addlistContact(SimpleContact contact) {
        list.add(contact);
    }

    public ArrayList<SimpleContact> getList(){
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        display = getResources().getConfiguration().orientation;
        super.onCreate(savedInstanceState);

        if(display == 1) {
            setContentView(R.layout.activity_main);
            fm = getFragmentManager();
            f1.setRelList(list);
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.id1, f2);
            ft.commit();
        } else {
            setContentView(R.layout.land_layout);
            Log.d("list", list.toString());
            f2.setList(list);
            f1.setRelList(list);
            fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.idLeft, f2);
            ft.add(R.id.idRight, f1);
            ft.commit();
        }


    }
}
