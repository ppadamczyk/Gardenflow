package com.example.gardenflow;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PlantDetails extends AppCompatActivity {
    private Button changeDetailsButton, fertilizationButton, wateringButton, viewAllPlantsBtn;
    EditText fertilizationDate, wateringDate;
    private ImageButton openCalendarForFertilization, openCalendarForWatering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_details);

        fertilizationButton = (Button) findViewById(R.id.fertilizationButton);
        changeDetailsButton = (Button) findViewById(R.id.changeDetailsButton);
        changeDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDetails();
            }
        });

        fertilizationDate = (EditText) findViewById(R.id.fertilizationDate);


        wateringDate = (EditText) findViewById(R.id.wateringDate);


        viewAllPlantsBtn = (Button) findViewById(R.id.ViewAllPlantsButon);
        viewAllPlantsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAllPlants();
            }
        });

        fertilizationDate = (EditText) findViewById(R.id.fertilizationDate);
        TextView fertilizationDate = findViewById((R.id.fertilizationDate));
        TextView wateringDate = findViewById((R.id.wateringDate));
        String date2 ="";
        date2 = getIntent().getStringExtra("date2");
        if(date2!=null){
            fertilizationDate.setText(date2);
        }
        String date3 ="";
        date3 = getIntent().getStringExtra("date3");
        if(date3!=null){
            wateringDate.setText(date3);
        }
        openCalendarForFertilization = (ImageButton) findViewById(R.id.openCalendarForFertilization);
        openCalendarForFertilization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarFertilization();

            }
        });
        openCalendarForWatering = (ImageButton) findViewById(R.id.openCalendarForWatering);
        openCalendarForWatering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarWatering();

            }
        });
    }

    // methods for all buttons on PlantDetails Page
    public void changeDetails() {}
    public void addWateringNotifications() {}
    public void addFertilizationNotifications() {}
    public void viewAllPlants() {
        Intent intent = new Intent(this, YourPlants.class);
        startActivity(intent);
    }
    public void openCalendarFertilization() {
        Intent intent = new Intent(this, CalendarFertilization.class);
        startActivity(intent);
    }
    public void openCalendarWatering() {
        Intent intent = new Intent(this, CalendarWatering.class);
        startActivity(intent);
    }
    public void fertilizationNotification(View view) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Intent i = new Intent();
        Date date = (Date) sdf.parse(fertilizationDate.getText().toString());
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(date);


        i.setType("vnd.android.cursor.item/event");

        i.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,beginTime.getTimeInMillis());
        i.putExtra(CalendarContract.Events.TITLE, "GardenFlow");
        i.putExtra(CalendarContract.Events.DESCRIPTION, "Your plant need fertilization");
        i.setAction(Intent.ACTION_EDIT);
        startActivity(i);
    }
    public void wateringNotification(View view) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Intent i = new Intent();
        Date date = (Date) sdf.parse(wateringDate.getText().toString());
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(date);


        i.setType("vnd.android.cursor.item/event");

        i.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,beginTime.getTimeInMillis());
        i.putExtra(CalendarContract.Events.TITLE, "GardenFlow");
        i.putExtra(CalendarContract.Events.DESCRIPTION, "Your plant need watering");
        i.setAction(Intent.ACTION_EDIT);
        startActivity(i);
    }
}

