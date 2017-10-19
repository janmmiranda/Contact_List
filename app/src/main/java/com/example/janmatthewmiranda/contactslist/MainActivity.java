package com.example.janmatthewmiranda.contactslist;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ContactDetailFragment.onAddPersonClickListener, ContactListFragment.onAddPersonClickListener {

//    ContactDetailFragment f1 = new ContactDetailFragment();;
    ContactListFragment f2 = new ContactListFragment();;
//    private ArrayList<SimpleContact> list = new ArrayList<SimpleContact>();
//    private ArrayList<Map<String,String>> items;
//    private ListView lvContacts;
//    private SimpleAdapter contactAdapter;
    EditText etName, etPhone;
    String conName, conPhone;
    ContactDetailFragment detailFrag;
    ContactListFragment listFrag;
    FragmentManager fm;
//    FragmentTransaction fragmentTransaction;
//    String[] from = {"name", "number"};
//    int[] to = {R.id.nameStore, R.id.nameText};

    public void onAddPersonClick() {
        detailFrag = (ContactDetailFragment) fm.findFragmentById(R.id.id1);
        if (detailFrag != null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ContactListFragment fragment = new ContactListFragment();

            etName = detailFrag.getNameText();
            conName = etName.getText().toString();
            etPhone = detailFrag.getPhoneText();
            conPhone = etPhone.getText().toString();
            SimpleContact myC = new SimpleContact(conName, conPhone);
//            list.add(myC);
//            items = getItems();
            f2.addListE(myC);
            //contactAdapter = new SimpleAdapter(this, items, R.layout.contact_list_adapter, from, to);
            //lvContacts.setAdapter(contactAdapter);

            Bundle bundle = new Bundle();
            bundle.putParcelable("contact", myC);
            fragment.setArguments(bundle);
            ft.remove(detailFrag);
            ft.add(R.id.id1, f2);
            ft.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.id1, f2);
        ft.commit();

//        listFrag = new ContactListFragment();
//        list = new ArrayList<SimpleContact>();
//        items = getItems();
//        lvContacts = configureLV();
//        contactAdapter = new SimpleAdapter(this, items, R.layout.contact_list_adapter, from, to);
//        lvContacts.setAdapter(contactAdapter);

    }

//    public ArrayList<Map<String,String>> getItems() {
//        ArrayList<Map<String,String>> array_list = new ArrayList<Map<String, String>>();
//        int i = 0;
//        String name,phone;
//        SimpleContact myC;
//        while(i < list.size()) {
//            HashMap<String,String> task = new HashMap<String, String>();
//            myC = list.get(i);
//            name = myC.getName();
//            System.out.println(i + " name " + name);
//            phone = myC.getPhone();
//            System.out.println(i + " phone " + phone);
//            task.put("name", name);
//            task.put("phone", phone);
//            array_list.add(task);
//            i++;
//        }
//        return array_list;
//    }
}
