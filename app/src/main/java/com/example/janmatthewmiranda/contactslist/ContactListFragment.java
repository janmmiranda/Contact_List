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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
    ContactAdapter conAdapter;
    SimpleAdapter contactAdapter;
    Button addContact, deleteContact;
    View view;
    ContactDetailFragment f1;
    ContactProfileFragment f2;
    String[] from = {"name", "number"};
    int[] to = {R.id.nameStore, R.id.nameText};
    int display;

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
        deleteContact = (Button) view.findViewById(R.id.deleteBtnCL);
        deleteContact.setOnClickListener(this);
        items = getItems();
        lvContacts = (ListView) view.findViewById(R.id.contactView);
        conAdapter = new ContactAdapter(list, getContext());
        lvContacts.setAdapter(conAdapter);
        setupListViewListener();
        display = getResources().getConfiguration().orientation;

        return view;
    }

    private void setupListViewListener() {
        lvContacts.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View item, int pos, long id) {
                        f2 = new ContactProfileFragment();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        SimpleContact tempC = list.get(pos);
                        lvContacts.setAdapter(conAdapter);
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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addBtnCL:
                if(display == 1) {
                    f1 = new ContactDetailFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.id1, f1);
                    ft.addToBackStack(null);
                    ft.commit();
                }
                break;
            case R.id.deleteBtnCL:
                System.out.println("delete");
                int k = 0;
                while (k < list.size()) {
                    if (list.get(k).isSelected()) {
                        list.remove(k);
                        conAdapter.notifyDataSetChanged();
                        k--;
                    }
                    k++;
                }
                break;
            default:
                break;
        }


    }

    public void setList(ArrayList<SimpleContact> list) {
        this.list = list;
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
