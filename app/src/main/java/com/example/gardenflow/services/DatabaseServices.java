package com.example.gardenflow.services;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


@RequiresApi(api = Build.VERSION_CODES.P)
public class DatabaseServices {

    public void addPlant(final String name, final String species,final String age, final String gardenName, final String imageString) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    String uniqueID = UUID.randomUUID().toString();
                    MediaType mediaType = MediaType.parse("application/json");
                    RequestBody body = RequestBody.create(mediaType, " { \"fields\": {\n" +
                            "    \"plantName\": {\n" +
                            "      \"stringValue\": \"" + name + "\"\n" +
                            "    },\n" +
                            "    \"plantSpecies\": {\n" +
                            "      \"stringValue\": \""+ species +"\"\n" +
                            "    },\n" +
                            "    \"gardenName\": {\n" +
                            "      \"stringValue\": \"" + gardenName +"\"\n" +
                            "    },\n" +
                            "    \"plantId\": {\n" +
                            "      \"stringValue\": \"" + uniqueID + "\"\n" +
                            "    },\n" +
                            "    \"plantAge\": {\n" +
                            "      \"stringValue\": \"" + age + "\"\n" +
                            "    },\n" +
                            "    \"imageString\": {\n" +
                            "      \"stringValue\": \"" + imageString + "\"\n" +
                            "    }\n" +
                            "  }}");
                    Request request = new Request.Builder()
                            .url("https://firestore.googleapis.com/v1beta1/projects/gardenflow-1b727/databases/%28default%29/documents/plants/")
                            .post(body)
                            .addHeader("Content-Type", "application/json")
                            .addHeader("User-Agent", "PostmanRuntime/7.13.0")
                            .addHeader("Accept", "/")
                            .addHeader("Cache-Control", "no-cache")
                            .addHeader("Postman-Token", "81675e0a-8151-4774-a628-6d9f56561227,406ab0a5-38e0-4976-8d20-f84a0faf1efb")
                            .addHeader("Host", "firestore.googleapis.com")
                            .addHeader("accept-encoding", "gzip, deflate")
                            .addHeader("content-length", "467")
                            .addHeader("Connection", "keep-alive")
                            .addHeader("cache-control", "no-cache")
                            .build();

                    try {
                        Response response = client.newCall(request).execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}


