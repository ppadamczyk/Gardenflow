package com.example.gardenflow;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AddPlant extends AppCompatActivity {
    ImageView plantImage;
    private Button addPlantButton;
    private ImageButton openCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        Button btnCamera = (Button) findViewById(R.id.addImg);
        plantImage = (ImageView)findViewById(R.id.plantImage);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });



        addPlantButton = (Button) findViewById(R.id.addPlantToCollectionButton);
        addPlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlantDetailsActivity();
            }
        });

        TextView plantAge = findViewById(R.id.plantAge);

        String date = getIntent().getStringExtra("date");
        if(date!= null)
        plantAge.setText(date);

        openCalendar = (ImageButton) findViewById(R.id.openCalendar);
        openCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarActivity();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        plantImage.setImageBitmap(bitmap);
    }

    public void openPlantDetailsActivity() {
        Intent intent = new Intent(this, PlantDetails.class);
        startActivity(intent);
    }
    public void openCalendarActivity() {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }
}
