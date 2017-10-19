package com.example.janmatthewmiranda.contactslist;


import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends Fragment implements View.OnClickListener {

    ArrayList<SimpleContact> list = new ArrayList<SimpleContact>();
    ArrayList<Map<String,String>> items;
    onAddPersonClickListener mCallback;
    ListView lvContacts;
    SimpleAdapter contactAdapter;
    Button addContact;
    View view;
    ListView contactList;
    ContactDetailFragment f1;
    String[] from = {"name", "number"};
    int[] to = {R.id.nameStore, R.id.nameText};

    public void addListE(SimpleContact c) {
        list.add(c);
        items = getItems();
    }

    public interface onAddPersonClickListener {
        public void onAddPersonClick();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (ContactListFragment.onAddPersonClickListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnSelectListener");
        }
    }

    public ContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        addContact = (Button) view.findViewById(R.id.addBtnCL);
        addContact.setOnClickListener(this);
        items = getItems();
        lvContacts = (ListView) view.findViewById(R.id.contactView);
        contactAdapter = new SimpleAdapter(getContext(), items, R.layout.contact_list_adapter, from, to);
        lvContacts.setAdapter(contactAdapter);
        return view;
    }

//    private void setuoListViewListener() {
//        lvContacts.setOnItemClickListener(
//                new AdapterView.OnItemClick() {
//                    @Override
//                    public boolean onItemClickListener(AdapterView<?> adapter, View item, int pos, long id) {
//                        String task;
//                        return true;
//                    }
//                });
//    }

    public void onClick(View v) {
        f1 = new ContactDetailFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.id1, f1);
        ft.commit();
    }

    public ArrayList<Map<String,String>> getItems() {
        ArrayList<Map<String,String>> array_list = new ArrayList<Map<String, String>>();
        int i = 0;
        String name,phone;
        SimpleContact myC;
        while(i < list.size()) {
            HashMap<String,String> task = new HashMap<String, String>();
            myC = list.get(i);
            name = myC.getName();
//            System.out.println(i + " name " + name);
            phone = myC.getPhone();
//            System.out.println(i + " phone " + phone);
            task.put("name", name);
            task.put("phone", phone);
            array_list.add(task);
            i++;
        }
        return array_list;
    }

}
