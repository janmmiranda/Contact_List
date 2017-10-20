package com.example.janmatthewmiranda.contactslist;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jan on 10/20/2017.
 */

public class RelationAdapter extends BaseAdapter {

    EditText inputName, inputNumber;
    Button addPersonBtn;
    ListView relationView;
    ArrayList<SimpleContact> contactAL, relationAL, copyAL;
    RelationAdapter relationAdapter;

    @Override
    public int getCount() {
        if(copyAL == null) {
            return 0;
        }
        return copyAL.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
//        view = getLayoutInflater().inflate(R.layout.add_contact_layout, null);
//        TextView contactN = (TextView) view.findViewById(R.id.)
        return null;
    }
}
