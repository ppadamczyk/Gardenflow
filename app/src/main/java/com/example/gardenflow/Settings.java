package com.example.gardenflow;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {
    private Button logoutBtn, deletePlantsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        logoutBtn = (Button) findViewById(R.id.logOutButton);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        deletePlantsBtn = (Button) findViewById(R.id.deleteAllPlantsButton);
        deletePlantsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                deleteAllPlants();
            }
        });
    }

    public void logout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void deleteAllPlants(){
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name", "");
        editor.commit();
    }
}
