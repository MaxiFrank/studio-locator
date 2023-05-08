package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.repositories.DetailRepository;
import com.example.studioLocatorApp.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class YelpServiceImpl implements YelpService {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private DetailRepository detailRepository;

    @Transactional
    public String findStudios(String zipCode) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("https://api.yelp.com/v3/businesses/search").newBuilder();
        urlBuilder.addQueryParameter("location", zipCode)
                .addQueryParameter("term", "pole dance");
        String url = urlBuilder.build().toString();
        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "fake-bearer-token")
                .build();

        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        System.out.println("Yelp API response is received and processed");
        ObjectMapper mapper = new ObjectMapper();
        YelpResponse yelpResponse = mapper.readValue(responseString, YelpResponse.class);
        System.out.println(yelpResponse);

        return responseString;

    }
}
