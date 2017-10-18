package com.example.janmatthewmiranda.contactslist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jan on 10/17/2017.
 */

public class ContactProfileFragment extends Fragment {

    public ContactProfileFragment() {

    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_profile, container, false);
        return view;
    }
}
