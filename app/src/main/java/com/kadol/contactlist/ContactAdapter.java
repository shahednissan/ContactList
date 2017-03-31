package com.kadol.contactlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nafi on 3/31/2017.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {
        public ContactAdapter(Context context, List<Contact> contactList) {
        super(context, 0, contactList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView=convertView;

        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Contact currentContact=getItem(position);

        TextView contactName=(TextView) listItemView.findViewById(R.id.contact_name);
        contactName.setText(currentContact.getmContactName());

        TextView contactNumber=(TextView) listItemView.findViewById(R.id.contact_number);
        contactNumber.setText(currentContact.getmContactNumber());

        return listItemView;
    }
}
