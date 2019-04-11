package com.dayandtime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView tvDate, tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String m="";
        switch (month){

            case 0:
               m = "Jan";
                break;

            case 1:
                 m = "Feb";
                break;
            case 2:
                 m = "March";
                break;
            case 3:
                 m = "April";
                break;
            case 4:
                 m = "May";
                break;
            case 5:
                 m = "June";
                break;
            case 6:
                m = "July";
                break;
            case 7:
                m = "August";
                break;
            case 8:
                m = "September";
                break;
            case 9:
                m = "October";
                break;
            case 10:
                m = "November";
                break;
            case 11:
                m = "December";
                break;
        }
        String date = m + "/" + dayOfMonth + "/" + year;
        tvDate.setText(date);

    }
    private void loadDatePicker(){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        c.add(Calendar.DATE,3);
        //c.add(Calendar.DATE,-1);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,this,year,month,day);
         datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis());
         //datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
        datePickerDialog.show();
    }

    private void loadTime(){
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tvTime.setText("Time is :" + hourOfDay + ":" + minute);
            }
        },hour,minute,false);
        timePickerDialog.show();
    }
}
