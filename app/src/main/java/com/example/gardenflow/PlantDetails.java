package com.example.gardenflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlantDetails extends AppCompatActivity {
    private Button changeDetailsButton, addWateringNotificationsButton, addFertilizationNotificationsButton, clonePlantButton, deletePlantButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_details);

        changeDetailsButton = (Button) findViewById(R.id.changeDetailsButton);
        changeDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDetails();
            }
        });

        addWateringNotificationsButton = (Button) findViewById(R.id.addWateringNotificationsButton);
        addWateringNotificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWateringNotifications();
            }
        });

        addFertilizationNotificationsButton = (Button) findViewById(R.id.addFertilizationNotificationsButton);
        addFertilizationNotificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFertilizationNotifications();
            }
        });

        clonePlantButton = (Button) findViewById(R.id.clonePlantButton);
        clonePlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clonePlant();
            }
        });

        deletePlantButton = (Button) findViewById(R.id.deletePlantButon);
        deletePlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePlant();
            }
        });
    }

    // methods for all buttons on PlantDetails Page
    public void changeDetails() {}
    public void addWateringNotifications() {}
    public void addFertilizationNotifications() {}
    public void clonePlant() {}
    public void deletePlant() {}
}
