package com.kadol.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;

    int numberOfTimesLoadButtonClicked=0;

    ArrayList<Contact> contactList=new ArrayList<>();

    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHelper=new DataBaseHelper(this);

        dataBaseHelper.onDelete();

        insertDatabase();

        contactList=dataBaseHelper.GroupContact();

        ListView listView=(ListView) findViewById(R.id.list);

        contactAdapter=new ContactAdapter(this,fillingUpTheList());

        listView.setAdapter(contactAdapter);



    }

    private void insertDatabase() {

        dataBaseHelper.insertContact("Aaabbb1","12345");
        dataBaseHelper.insertContact("Aaabbb2","12345");
        dataBaseHelper.insertContact("Aaabbb3","12345");
        dataBaseHelper.insertContact("Aaabbb4","12345");
        dataBaseHelper.insertContact("Aaabbb5","12345");
        dataBaseHelper.insertContact("Aaabbb6","12345");
        dataBaseHelper.insertContact("Aaabbb7","12345");
        dataBaseHelper.insertContact("Aaabbb8","12345");
        dataBaseHelper.insertContact("Aaabbb9","12345");
        dataBaseHelper.insertContact("Aaabbb10","12345");
        dataBaseHelper.insertContact("Aaabbb11","12345");
        dataBaseHelper.insertContact("Aaabbb12","12345");
        dataBaseHelper.insertContact("Aaabbb13","12345");
        dataBaseHelper.insertContact("Aaabbb14","12345");
        dataBaseHelper.insertContact("Aaabbb15","12345");
        dataBaseHelper.insertContact("Aaabbb16","12345");
        dataBaseHelper.insertContact("Aaabbb17","12345");
        dataBaseHelper.insertContact("Aaabbb18","12345");
        dataBaseHelper.insertContact("Aaabbb19","12345");
        dataBaseHelper.insertContact("Aaabbb20","12345");
        dataBaseHelper.insertContact("Aaabbb21","12345");
        dataBaseHelper.insertContact("Aaabbb22","12345");
    }

    public List<Contact> fillingUpTheList(){
        int startPoint=numberOfTimesLoadButtonClicked*10;
        int endPoint=startPoint+10;

        if(endPoint>contactList.size()){
            endPoint=contactList.size()-1;
        }

        List<Contact> subListOf10= contactList.subList(startPoint,endPoint);

        return  subListOf10;

    }
}
