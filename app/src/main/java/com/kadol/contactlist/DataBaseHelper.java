package com.kadol.contactlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Nafi on 3/31/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ContactDatabase.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_PHONE = "phone";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating a table on the designated Database
        db.execSQL(
                "create table contacts" +
                        "(id integer primary key, name text, phone text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public void onDelete() {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertContact (String name, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id",id);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        db.insert("contacts", null, contentValues);
        return true;
    }


    public ArrayList<Contact> GroupContact(){

        ArrayList<Contact> contactArrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from contacts",null);

        res.moveToFirst();

        while(res.isAfterLast()==false){
            String id=res.getString(res.getColumnIndex(DataBaseHelper.CONTACTS_COLUMN_ID));
            String name=res.getString(res.getColumnIndex(DataBaseHelper.CONTACTS_COLUMN_NAME));
            String number=res.getString(res.getColumnIndex(DataBaseHelper.CONTACTS_COLUMN_PHONE));

            contactArrayList.add(new Contact(name,number));

            res.moveToNext();
        }

        return contactArrayList;
    };

}
