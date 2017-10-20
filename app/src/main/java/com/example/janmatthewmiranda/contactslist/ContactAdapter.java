package com.example.janmatthewmiranda.contactslist;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jan on 10/20/2017.
 */




public class ContactAdapter extends ArrayAdapter<SimpleContact> implements View.OnClickListener {

    private ArrayList<SimpleContact> contactList;
    Context mContext;
    private int lastPos = -1;

    private static class ViewHolder {
        TextView nameText;
        CheckBox checkBox;
    }

    public ContactAdapter(ArrayList<SimpleContact> contacts, Context context) {
        super(context, R.layout.contact_list_adapter, contacts);
        contactList = contacts;
        mContext = context;
    }

    public void onClick(View v) {

    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        SimpleContact contact = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.contact_list_adapter, parent, false);
            viewHolder.nameText = (TextView) convertView.findViewById(R.id.nameStore);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    viewHolder.checkBox.setChecked(true);
                    contactList.get(position).setSelected(true);
                } else {
                    viewHolder.checkBox.setChecked(false);
                    contactList.get(position).setSelected(false);
                }
            }
        });

        lastPos = position;
        viewHolder.nameText.setText(contact.getName());
        viewHolder.checkBox.setChecked(contactList.get(position).isSelected());
        return convertView;
    }
}
