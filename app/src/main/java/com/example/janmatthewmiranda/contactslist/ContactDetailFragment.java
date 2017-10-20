package com.example.janmatthewmiranda.contactslist;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.net.wifi.aware.PublishConfig;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.R.attr.button;
import static com.example.janmatthewmiranda.contactslist.R.id.add;
import static com.example.janmatthewmiranda.contactslist.R.id.addBtnPerson;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDetailFragment extends Fragment implements View.OnClickListener{

    ArrayList<SimpleContact> list = new ArrayList<SimpleContact>();
    ContactAdapter relAdapter;
    onAddPersonClickListener mCallback;
    ListView setRelationList;
    Button addPerson;
    View view;
    int display;

    public interface onAddPersonClickListener {
        public void onAddPersonClick();
    }

    public ContactDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_detail, container, false);
        addPerson = (Button) view.findViewById(R.id.addBtnPerson);
        addPerson.setOnClickListener(this);

        setRelationList = (ListView) view.findViewById(R.id.setRelationList);
        relAdapter = new ContactAdapter(list, getContext());
        setRelationList.setAdapter(relAdapter);

        return view;
    }

    public void setRelList(ArrayList<SimpleContact> list) {
        this.list = list;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (onAddPersonClickListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnSelectListener");
        }
    }

    public void onClick(View v){
        EditText etName = (EditText) view.findViewById(R.id.nameText);
        EditText etPhone = (EditText) view.findViewById(R.id.phoneText);

        System.out.println("Add Person");

        boolean check = checkText(etName, etPhone);
        if(check) {
            switch(v.getId()) {
                case R.id.addBtnPerson:
                    mCallback.onAddPersonClick();
                    break;
                default:
                    break;
            }
        }
    }

    public EditText getNameText() {
        EditText etName = (EditText) view.findViewById(R.id.nameText);
        return etName;
    }

    public EditText getPhoneText() {
        EditText etPhone = (EditText) view.findViewById(R.id.phoneText);
        return etPhone;
    }

    public boolean checkText(EditText checkName,EditText checkPhone) {
        if (checkName.getText().toString().trim().equals("") && checkPhone.getText().toString().trim().equals("")){
            return false;
        }
        else{
            return true;
        }
    }

}
