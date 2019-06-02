package com.example.gardenflow.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;

import com.example.gardenflow.R;

import java.io.ByteArrayOutputStream;

public class ImgServices {

    public static String imgEncode(Context ctx){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap2 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.rose);
        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return imageString;
    }

    public static ImageView imgDecode(String imageString){
        byte[] imageBytes;
        ImageView image = null;
        imageBytes = Base64.decode(imageString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        image.setImageBitmap(decodedImage);
        return image;
    }
}
