package com.example.gardenflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class CalendarWatering extends AppCompatActivity {
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_watering);

        CalendarView calendarView =findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView1, int i,int i1, int i2){
                String date3 = "";
                date3 = i +"/" + i1 +"/" + i2;

                Intent intent = new Intent(CalendarWatering.this, PlantDetails.class);
                intent.putExtra("date3", date3);
                startActivity(intent);
            }
        });
    }
}
