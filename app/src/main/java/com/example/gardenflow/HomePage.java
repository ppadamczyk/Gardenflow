package com.example.gardenflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    private Button addPlantButton;
    private Button settingsButton;
    private Button findPlantButton;
    private Button yourPlantsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        addPlantButton = (Button) findViewById(R.id.addPlantButton);
        addPlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddPlantActivity();
            }
        });

        settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity();
            }
        });

        findPlantButton = (Button) findViewById(R.id.findPlantButton);
        findPlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFindAPlantActivity();
            }
        });

        yourPlantsButton = (Button) findViewById(R.id.yourPlantsButton);
        yourPlantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYourPlantsActivity();
            }
        });


    }

    public void openAddPlantActivity() {
        Intent intent = new Intent(this, AddPlant.class);
        startActivity(intent);
    }

    public void openSettingsActivity() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openFindAPlantActivity() {
        Intent intent = new Intent(this, FindPlant.class);
        startActivity(intent);
    }

    public void openYourPlantsActivity() {
        Intent intent = new Intent(this, YourPlants.class);
        startActivity(intent);
    }
}
