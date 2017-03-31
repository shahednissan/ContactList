package com.kadol.contactlist;


public class Contact {

    private String mContactName;
    private String mContactNumber;

    public Contact(String mContactName,String mContactNumber){
        this.mContactName=mContactName;
        this.mContactNumber=mContactNumber;
    }

    public String getmContactName() {
        return mContactName;
    }

    public String getmContactNumber() {
        return mContactNumber;
    }
}
