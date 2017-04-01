package com.kadol.contactlist;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    Button loadMore;
    int counter;
    Cursor cursor;
    int numberOfTimesLoadButtonClicked=0;
    ListView listView;
    ArrayList<Contact> contactList=new ArrayList<>();
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Checking the length of the username and deciding whether we need to use double line or not
        TextView userName=(TextView) findViewById(R.id.textView_user_name);
        String name=userName.getText().toString();
        if(name.length()>16){
            name=name.substring(0,16)+"\n"+name.substring(16,name.length());
        }
        userName.setText(name);

        //Creating the Database.
        dataBaseHelper=new DataBaseHelper(this);

        //Deleting the old Database as it is a demo app.
        dataBaseHelper.onDelete();

        //getContacts();

        //Inserting the element to the database (static elements)
        insertDatabase();

        //calling out whole contacts table at once and saving all the contact information on a ArrayList
        contactList=dataBaseHelper.GroupContact();

        listView=(ListView) findViewById(R.id.list);

        contactAdapter=new ContactAdapter(this,fillingUpTheList());

        //Populating the first ten contacts to the ListView
        listView.setAdapter(contactAdapter);

        loadMore=(Button) findViewById(R.id.load_more_button);

        loadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfTimesLoadButtonClicked++;

                int startPoint=numberOfTimesLoadButtonClicked*10;

                if(startPoint>contactList.size()){

                    //Checking whether there is any contacts left to show or not

                    loadMore.setText("No More Result to Show");
                    loadMore.setEnabled(false);
                }else{

                    //Contacts left to show
                    contactAdapter=new ContactAdapter(getApplicationContext(),fillingUpTheList());
                    listView.setAdapter(contactAdapter);
                }
            }
        });



    }

    public void getContacts() {
        Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;

        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;

        String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

        ContentResolver contentResolver = getContentResolver();

        cursor = contentResolver.query(CONTENT_URI, null,null, null, null);

        if(cursor.getCount()>0){
            counter=0;
            while(cursor.moveToNext()){

                String name = cursor.getString(cursor.getColumnIndex( DISPLAY_NAME ));
                String number = cursor.getString(cursor.getColumnIndex( NUMBER ));

                dataBaseHelper.insertContact(name,number);
            }
        }


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

        //creating subList from the main Contact list
        List<Contact> subListOf10= contactList.subList(startPoint,endPoint);

        return  subListOf10;

    }
}
