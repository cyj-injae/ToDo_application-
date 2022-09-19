package com.example.finalapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText t1 = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText t2 = (EditText) findViewById(R.id.editTextTextPassword);
        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = t1.getText().toString();
                String pass = t2.getText().toString();
                if (name.equals("admin") && pass.equals("admin")) {

                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);


                } else {
                    Toast.makeText(getApplicationContext(), "please enter a valid username or valid password ", Toast.LENGTH_LONG).show();


                }
            }
        });


    }
}

