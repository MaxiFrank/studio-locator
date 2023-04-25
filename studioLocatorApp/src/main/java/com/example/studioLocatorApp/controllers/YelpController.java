package com.example.studioLocatorApp.controllers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class YelpController {
    public YelpController(){

    }

    public void connect() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.yelp.com/v3/businesses/search?sort_by=best_match&limit=20")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "fake-token")
                .build();

        Response response = client.newCall(request).execute();
    }
}
