package com.example.gardenflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class CalendarFertilization extends AppCompatActivity {
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_fertilization);

        CalendarView calendarView =findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView1, int i,int i1, int i2){
                String date2 = "";
                date2 = i +"/" + i1 +"/" + i2;

                Intent intent = new Intent(CalendarFertilization.this, PlantDetails.class);
                intent.putExtra("date2", date2);
                startActivity(intent);
            }
        });
    }
}
