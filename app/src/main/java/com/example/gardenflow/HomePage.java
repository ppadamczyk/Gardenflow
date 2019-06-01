package com.example.gardenflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    private Button addPlantButton;

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
    }

    public void openAddPlantActivity() {
        Intent intent = new Intent(this, AddPlant.class);
        startActivity(intent);
    }
}
