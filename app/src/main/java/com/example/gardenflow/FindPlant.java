package com.example.gardenflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindPlant extends AppCompatActivity {
    private Button searchForPlantButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_plant);

        searchForPlantButton = (Button) findViewById(R.id.searchForPlantButton);
        searchForPlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchForPlantActivity();
            }
        });
    }

    public void openSearchForPlantActivity() {
        Intent intent = new Intent(this, SearchForPlant.class);
        startActivity(intent);

    }
}
