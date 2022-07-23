package com.example.projectplany;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserInfo extends SQLiteOpenHelper {
    ////////////////////////////////////////
    public static String DB_NAME = "UserInfo" ;
    public static String TABLE_NAME = "UserInfo" ;
    public static String DB_COL1 = "ID" ;
    public static String DB_COL2 = "Name" ;
    public static String DB_COL3 = "Email" ;
    public static String DB_COL4 = "Password" ;
    public static String DB_COL5 = "Age" ;
    public static String DB_COL6 = "FName" ;

    public UserInfo(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }
    /////////////////////////////////////


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table UserInfo ( ID Integer primary key autoincrement , Name Text , Email Text , Password Text , Age Text )  "); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists UserInfo");
        onCreate(db);
    }
//==========================================================
    public boolean addUser(String name, String email, String pass, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email", email);
        contentValues.put("Password", pass);
        contentValues.put("Age", age);
             long res = db.insert("UserInfo", null, contentValues);
        if (res == -1) return false;
        else return true; }

    //===================================================
    public boolean cheackUser (String name , String pass )
    {
    SQLiteDatabase db = getWritableDatabase();
    String [] selsectonarg = {name, pass};
        Cursor cursor= db.rawQuery("SELECT * from UserInfo WHERE Name =? and Password=? " , selsectonarg);
    int count = cursor.getCount();
    cursor.close();
    db.close();
    if (count>0) return true ;
    else return false;}
//=======================================================

}
