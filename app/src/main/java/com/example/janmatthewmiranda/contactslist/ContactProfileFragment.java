package com.example.janmatthewmiranda.contactslist;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jan on 10/17/2017.
 */

public class ContactProfileFragment extends Fragment implements View.OnClickListener {

    onAddPersonClickListener mCallback;
    TextView nText;
    TextView pText;
    String name, phone;
    ContactListFragment f1;
    Button backBtn;

    public interface onAddPersonClickListener {
        public void onAddPersonClick();
    }

    public ContactProfileFragment() {

    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_profile, container, false);
        backBtn = (Button) view.findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);

        nText = (TextView) view.findViewById(R.id.nameT);

        return view;
    }

    @Override
    public void onClick(View v) {
        f1 = new ContactListFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.id1, f1);
        ft.commit();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (ContactProfileFragment.onAddPersonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnSelectListener");
        }
    }

    public void setContact(SimpleContact myc) {
        SimpleContact tempC = myc;
        nText.setText(tempC.getName());
        pText.setText(tempC.getPhone());
    }

    public TextView getnText() {
        return  nText;
    }

    public void setText(String s){
        nText.setText(s);
    }

    public  void setPhone(String p) {
        pText.setText(p);
    }

}