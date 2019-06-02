package com.example.gardenflow;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gardenflow.services.DatabaseServices;
import com.example.gardenflow.services.ImgServices;

import java.io.ByteArrayOutputStream;

@RequiresApi(api = Build.VERSION_CODES.P)
public class AddPlant extends AppCompatActivity {
    ImageView plantImage;
    public Boolean age = false;
    public Boolean fertilization = false;
    public Boolean watering = false;
    final String gardenName = "Garden";
    EditText plantName, plantSpecies, plantAge, plantFertilization,  plantWatering;
    DatabaseServices dbServices = new DatabaseServices();
    private Button addPlantButton;
    private ImageButton openCalendarForAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        plantName = (EditText) findViewById(R.id.plantName);
        plantSpecies = (EditText) findViewById(R.id.plantSpecies);
        plantAge = (EditText) findViewById(R.id.plantAge);
        plantFertilization = (EditText) findViewById(R.id.fertilizationDate);
        plantWatering = (EditText) findViewById(R.id.wateringDate);

        Button btnCamera = (Button) findViewById(R.id.addImg);
        plantImage = (ImageView) findViewById(R.id.plantImage);

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

                //img encode
                String imageString = ImgServices.imgEncode(getApplicationContext());

                //adding plant to database
                dbServices.addPlant(plantName.getText().toString(),plantSpecies.getText().toString(),plantAge.getText().toString(), gardenName, plantFertilization.getText().toString(), plantWatering.getText().toString(), imageString);
                openPlantDetailsActivity();

            }
        });


        String date = "";
        if(savedInstanceState != null) {
            date = savedInstanceState.getString("date");
        }

        if(date != null && date != "") {
            plantAge.setText(date);
        }

        openCalendarForAge = (ImageButton) findViewById(R.id.openCalendarForAge);
        openCalendarForAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = true;
                openCalendarActivity();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
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
