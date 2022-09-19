package com.example.finalapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private  static  final String TAG = "DatabaseHelper";

    public static final String DataBase_Name="mylist.sqLiteDatabase";

    public static final String Table_Name= " Tasks ";
    public static final String Col1 ="ID";
    public static final String Col2 ="ITem1";

    public DatabaseHelper(@Nullable Context context) {
        super(context, Table_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="CREATE TABLE " + Table_Name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " ITEM1 TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i ,int i1 ) {
        sqLiteDatabase.execSQL(" DROP IF TABLE EXISTS " + Table_Name);
        onCreate(sqLiteDatabase);
    }
    public  boolean addData(String item)
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col2,item);

        Log.d(TAG,"addData: Adding "+ item + " to "+Table_Name);

        long result = sqLiteDatabase.insert(Table_Name,null,contentValues);
        if(result ==    -1)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getlistContents()
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        String query ="SELECT * FROM "+Table_Name;
        Cursor Data = sqLiteDatabase.rawQuery(query,null);
        return Data;
    }


}