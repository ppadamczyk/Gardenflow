package com.example.gardenflow;

import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.gardenflow.services.CustomAdapter;
import com.example.gardenflow.services.Plant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class YourPlants extends AppCompatActivity {
  private Button getApi;
  private ListView apiList;
  List<Object> participantJsonList;
  private ArrayAdapter<String> adapter ;

  @RequiresApi(api = Build.VERSION_CODES.N)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_your_plants);
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);

    apiList = (ListView) findViewById(R.id.lvMain);

    try {
      List<JSONObject> listPlants = Arrays.asList(readJsonFromUrl("https://firestore.googleapis.com/v1beta1/projects/gardenflow-1b727/databases/%28default%29/documents/plants/"));
      ArrayList<Plant> plants = new ArrayList<>();

      listPlants.forEach(plant -> {
        try {


          Plant plant1 = new Plant(plant.get("imageString").toString(),
            plant.get("plantName").toString(),
            plant.get("plantSpecies").toString());
          plants.add(plant1);
        } catch (JSONException e) {
          e.printStackTrace();
        }
      });

      CustomAdapter customAdapter = new CustomAdapter(this, plants);
      apiList.setAdapter(customAdapter);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public static JSONObject[] readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = (String) readAll(rd);
      List<JSONObject> list = new ArrayList<JSONObject>();
      JSONObject myjson = new JSONObject(jsonText);
      JSONArray the_json_array = myjson.getJSONArray("documents");
      int size = the_json_array.length();
      ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
      for (int i = 0; i < size; i++) {
        JSONObject another_json_object = (JSONObject) the_json_array.getJSONObject(i).get("fields");
        arrays.add(another_json_object);
      }

      //Finally
      JSONObject[] jsons = new JSONObject[arrays.size()];
      arrays.toArray(jsons);
      return jsons;
    } finally {
      is.close();
    }
  }

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

}
