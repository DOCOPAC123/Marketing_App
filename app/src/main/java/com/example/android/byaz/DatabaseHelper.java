package com.example.android.byaz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 12/19/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="ctc.db";
    private static final String TABLE_NAME="contacts";
    SQLiteDatabase db=this.getWritableDatabase();
    //public static final String DATABASE_NAME = "MyDBName.db";
    //public static final String CONTACTS_TABLE_NAME = "contacts";
    //public static final String CONTACTS_COLUMN_ID = "id";
    public static final String NAME = "name";
    // public static final String col_1 ="ID";
    //public static final String col_2 ="NAME";
    //public static final String col_3="SURNAME";
    //public static final String col_4="MARKS";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, AMOUNT INTEGER  , DURATION INTEGER,DATE TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

//halat kharab ho gayi yaar get data with a value me

    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //Toast.makeText(DatabaseHelper.class,str,Toast.LENGTH_SHORT).show();
       // String selectQuery =  "SELECT * FROM " + TABLE_NAME + " WHERE NAME like ' " + "str"+" ' ";
        Cursor cursor;
        cursor = null;
        String s;
        cursor = db.rawQuery("SELECT * FROM contacts WHERE 1",null);//isko dhyan rakhna...
        return cursor;
        //Toast.makeText(DatabaseHelper.this,"cursor null nahi hai", Toast.LENGTH_LONG).show();
        //Toast.makeText(DatabaseHelper.this ,"Inserted successfully",Toast.LENGTH_LONG).show();
        //return cursor;
    }

    public int delete(String name, int amount, String date)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int m=0;
        m=db.delete(TABLE_NAME, "date=? and amount=? and name=?", new String[] {date, String.valueOf(amount),name});
        if(m==0)
            return 0;
        else
            return 1;
    }

    public boolean insertData(String name, int amount, int duration, String strDate) {
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("AMOUNT",amount);
        contentValues.put("DURATION",duration);
        contentValues.put("DATE",strDate);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }


    public Cursor getData2(String str) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Toast.makeText(DatabaseHelper.class,str,Toast.LENGTH_SHORT).show();
        String selectQuery =  "SELECT * FROM " + TABLE_NAME + " WHERE NAME like ' " + "str"+" ' ";
        Cursor cursor;
        cursor = null;
        String s;
        s="rohit";
        System.out.print(s);
        cursor = db.rawQuery("SELECT * FROM contacts WHERE name like '"+str+"' ",null);//isko dhyan rakhna...
        return cursor;
    }
}


