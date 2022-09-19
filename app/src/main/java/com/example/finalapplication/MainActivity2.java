package com.example.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG ="MainActivity2";

    DatabaseHelper MyDataBase;
    Button Add;
    Button ViewContent;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=findViewById(R.id.EditText);
        Add=findViewById(R.id.add);
        ViewContent=findViewById(R.id.view);
        MyDataBase = new DatabaseHelper(this);

        Button call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent2);
            }
        });

        Button ti = findViewById(R.id.ti);
        ti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 =new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(intent3);
            }
        });



        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newitem= editText.getText().toString();
                if(editText.length() !=0)
                {
                    AddData(newitem);
                    editText.setText("");
                }
                else
                {
                    Toast.makeText(MainActivity2.this,"You Must Put Something in Task",Toast.LENGTH_LONG).show();
                }
            }
        });

        ViewContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this,ViewListContents.class);
                startActivity(intent);
            }
        });

    }
    public void AddData(String newitem)
    {
        boolean insert=MyDataBase.addData(newitem);
        if(insert==true)
        {
            Toast.makeText(MainActivity2.this,"Successfully Entered Data !",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(MainActivity2.this,"Somthing Wrong ,Please Try agine",Toast.LENGTH_LONG).show();
        }
    }
}