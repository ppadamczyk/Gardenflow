package com.example.gardenflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlantDetails extends AppCompatActivity {
    private Button changeDetailsButton, addWateringNotificationsButton, addFertilizationNotificationsButton, viewAllPlantsBtn;

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

        viewAllPlantsBtn = (Button) findViewById(R.id.ViewAllPlantsButon);
        viewAllPlantsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAllPlants();
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
}
