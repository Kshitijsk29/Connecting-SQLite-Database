package com.nextin.sqlitedatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ContactDB";
    private static final int VERSION = 1;
    private static final  String TABLE_NAME = "contacts";
    private static final  String COLUMN_ONE_NAME = "name";
    private static final  String COLUMN_TWO_EMAIL = "email";
    private static final String COLUMN_THREE_ROLL_NO = "roll_no";
    private static final String COLUMN_FOUR_PHONE_NO = " phone_no";


    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // create table contacts (roll_no Integer primary key autoincrement,
                                // name text, email text unique,
                                // phone_no text not null)

        db.execSQL(" create table "+TABLE_NAME + " ("+ COLUMN_THREE_ROLL_NO + " INTEGER primary key autoincrement ,"
        + COLUMN_ONE_NAME + " TEXT NOT NULL ,"+COLUMN_TWO_EMAIL +" TEXT UNIQUE ,"+ COLUMN_FOUR_PHONE_NO +
                " INTEGER NOT NULL "+")");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public void addData(String name , String email , int phone){

         SQLiteDatabase database = this.getWritableDatabase();

         ContentValues values = new ContentValues();
         values.put(COLUMN_ONE_NAME , name);
         values.put(COLUMN_TWO_EMAIL , email);
         values.put(COLUMN_FOUR_PHONE_NO, phone);

         database.insert(TABLE_NAME, null, values);
    }


    public ArrayList<ContactList> fetchData(){

        SQLiteDatabase database = this.getReadableDatabase();

       Cursor cursor = database.rawQuery(" Select * from "+TABLE_NAME ,
               null);

       ArrayList<ContactList> arrayList = new ArrayList<>();

       while(cursor.moveToNext()){

           ContactList conList = new ContactList();

           conList.rollno = cursor.getInt(0);
           conList.name = cursor.getString(1);
           conList.email = cursor.getString(2);
           conList.phone_no = cursor.getInt(3);

           arrayList.add(conList);

       }
        return arrayList;
    }

    public void updateData(ContactList contacts){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FOUR_PHONE_NO ,contacts.phone_no);

        database.update(TABLE_NAME,cv, COLUMN_THREE_ROLL_NO + " = "+contacts.phone_no , null);
    }

}
