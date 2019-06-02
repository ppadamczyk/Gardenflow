package com.example.gardenflow;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPlants extends AppCompatActivity {
    private ListView apiList;
    List<Object> participantJsonList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_plants);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        apiList = (ListView) findViewById(R.id.List);

        try {
            List<JSONObject> listPlants = readJsonFromUrl("https://trefle.io/api/plants/?token=UmJSVE9UOFp4bng1Q2NxZzlUQ3dKQT09");

            String[] plantNames = new String[listPlants.size()];

            for (int i = 0; i < listPlants.size(); i++) {
                plantNames[i] = listPlants.get(i).get("scientific_name").toString();
            }

            ArrayList<String> names = new ArrayList<String>();
            names.addAll(Arrays.asList(plantNames));
            adapter = new ArrayAdapter<String>(this, R.layout.row, names);
            apiList.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static List<JSONObject> readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            List<JSONObject> list = new ArrayList<JSONObject>();
            try {
                int i;
                JSONArray array = new JSONArray(jsonText);
                for (i = 0; i < array.length(); i++)
                    list.add(array.getJSONObject(i));
            } catch (JSONException e) {
                System.out.println(e.getMessage());
            }
//            System.out.print("LIST" + list);
            return list;
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
