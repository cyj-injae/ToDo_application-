package com.example.finalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    CalendarView calendarView;
    TextView myDate;
    private Object CalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        calendarView =(CalendarView)  findViewById(R.id.calenderview);
        myDate =  (TextView) findViewById(R.id.mydate);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull android.widget.CalendarView view, int year, int month, int dayOfMonth) {
                String date=dayOfMonth +"/"+ (month+1)+ "/"+year;
                myDate.setText(date);
            }
        });
    }
}