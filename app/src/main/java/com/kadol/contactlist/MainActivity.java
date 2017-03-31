package com.kadol.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contact> contactList=new ArrayList<>();

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
