package com.example.gardenflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    private Button addPlantButton, settingsButton, findPlantButton, yourPlantsButton;

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
                openSpeciesActivity();
            }
        });

        yourPlantsButton = (Button) findViewById(R.id.yourPlantsButton);
        yourPlantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYourPlantsActivity();
            }
        });

      Bundle extras = getIntent().getExtras();
      if (extras != null) {
        String gardenName = extras.getString("gardenName");

        //The key argument here must match that used in the other activity
      }
    }

    public void openAddPlantActivity() {
        Intent intent = new Intent(this, AddPlant.class);
        startActivity(intent);
    }

    public void openSettingsActivity() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openSpeciesActivity() {
        Intent intent = new Intent(this, AllPlants.class);
        startActivity(intent);
    }

    public void openYourPlantsActivity() {
        Intent intent = new Intent(this, YourPlants.class);
        startActivity(intent);
    }
}
