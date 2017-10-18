package com.example.janmatthewmiranda.contactslist;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

import static android.R.attr.button;
import static com.example.janmatthewmiranda.contactslist.R.id.add;
import static com.example.janmatthewmiranda.contactslist.R.id.addBtnPerson;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDetailFragment extends Fragment implements View.OnClickListener{

    Button addPerson;
    Bundle bundle;
    OnPersonListener mlistener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mlistener = (OnPersonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnPersonListener");
        }
    }

    public ContactDetailFragment() {
        // Required empty public constructor
    }

    ContactListFragment f2;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_detail, container, false);
        addPerson = (Button) view.findViewById(R.id.addBtnPerson);
        addPerson.setOnClickListener(this);
        bundle = new Bundle();

        return view;
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
    }

    public void onClick(View v){
        EditText etName = (EditText) view.findViewById(R.id.nameText);
        String contactName = etName.getText().toString();
        EditText etPhone = (EditText) view.findViewById(R.id.phoneText);
        String contactPhone = etName.getText().toString();

        boolean check = checkText(etName, etPhone);
        if(check) {
            SimpleContact person = new SimpleContact(contactName, contactPhone);


            f2 = new ContactListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.id1, f2);
            ft.commit();
        }
    }

    public interface OnPersonListener {
        public void OnPersonSelected(Uri personUri);
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
