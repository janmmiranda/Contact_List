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
    EditText etName, etPhone;
    String conName, conPhone;
    ContactDetailFragment detailFrag;
    FragmentManager fm;

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
            f2.addListE(myC);

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
    }
}
