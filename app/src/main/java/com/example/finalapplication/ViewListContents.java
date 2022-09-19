package com.example.finalapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class ViewListContents extends AppCompatActivity {
    DatabaseHelper MyDataBase;
    private ListView mylistview;
    private static final String TAG ="ViewListContents";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontent);

        mylistview=findViewById(R.id.Content);
        MyDataBase =new DatabaseHelper(this);



        Cursor data =MyDataBase.getlistContents();
        ArrayList<String>List=new ArrayList<>();
        if(data.getCount() ==0 )
        {
            Toast.makeText(ViewListContents.this,"No Task YOu Save",Toast.LENGTH_LONG).show();
        }
        else
        {
            while (data.moveToNext())
            {
                List.add(data.getString(1));
            }
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,List);
            mylistview.setAdapter(listAdapter);
        }

    }

}