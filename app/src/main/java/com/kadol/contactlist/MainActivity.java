package com.kadol.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;

    Button loadMore;

    int numberOfTimesLoadButtonClicked=0;
    ListView listView;

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

        listView=(ListView) findViewById(R.id.list);

        contactAdapter=new ContactAdapter(this,fillingUpTheList());

        listView.setAdapter(contactAdapter);

        loadMore=(Button) findViewById(R.id.load_more_button);

        loadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfTimesLoadButtonClicked++;

                int startPoint=numberOfTimesLoadButtonClicked*10;

                if(startPoint>contactList.size()){
                    loadMore.setText("No More Result to Show");
                    loadMore.setEnabled(false);
                }else{

                    contactAdapter=new ContactAdapter(getApplicationContext(),fillingUpTheList());
                    listView.setAdapter(contactAdapter);
                }
            }
        });



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

        if(startPoint>contactList.size()){
            loadMore.setText("No More Result to Show");
            loadMore.setEnabled(false);

        }

        int endPoint=startPoint+10;

        if(endPoint>contactList.size()){
            endPoint=contactList.size();
        }

        List<Contact> subListOf10= contactList.subList(startPoint,endPoint);

        return  subListOf10;

    }
}
