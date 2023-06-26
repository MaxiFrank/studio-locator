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
import java.util.ArrayList;
import java.util.List;

@Service
public class YelpServiceImpl implements YelpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetailRepository detailRepository;

    @Transactional
    public List<String> findStudios(String zipCode) throws IOException {
        List<String> responseArr = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("https://api.yelp.com/v3/businesses/search").newBuilder();
        urlBuilder.addQueryParameter("location", zipCode)
                .addQueryParameter("term", "pole dance");
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "fake token")
                .build();
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        responseArr.add("/matching-studios.html");
        responseArr.add(responseString);

        return responseArr;

    }
}
