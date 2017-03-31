package com.kadol.contactlist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contact> contactList=new ArrayList<>();

        dataBaseHelper=new DataBaseHelper(this);

        boolean state = dataBaseHelper.insertContact("Aaabbb","12345");

        if(state==true)
            Toast.makeText(getApplicationContext(),"Database updated",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Database is not updated",Toast.LENGTH_SHORT).show();

        Cursor res=dataBaseHelper.getData(1);

        contactList.add(new Contact(res.getString(res.getColumnIndex(DataBaseHelper.CONTACTS_COLUMN_NAME)),
                res.getString(res.getColumnIndex(DataBaseHelper.CONTACTS_COLUMN_PHONE))));


        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));
        contactList.add(new Contact("Aabbb","12345"));


        ListView listView=(ListView) findViewById(R.id.list);

        ContactAdapter contactAdapter=new ContactAdapter(this,contactList);

        listView.setAdapter(contactAdapter);



    }
}
