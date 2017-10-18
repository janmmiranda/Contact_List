package com.example.janmatthewmiranda.contactslist;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends Fragment implements View.OnClickListener {

    Button addContact;

    public ContactListFragment() {
        // Required empty public constructor
    }

    ContactDetailFragment f1;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        addContact = (Button) view.findViewById(R.id.addBtnCL);
        addContact.setOnClickListener(this);
        return view;
    }


    public void onClick(View v) {
        f1 = new ContactDetailFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.id1, f1);
        ft.commit();
    }

}
