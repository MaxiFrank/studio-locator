package com.example.studioLocatorApp.controllers;

import com.example.studioLocatorApp.dtos.DetailDto;
import com.example.studioLocatorApp.services.YelpResponse;
import com.example.studioLocatorApp.services.YelpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/studios")
public class YelpController {
    public YelpController(){

    }
    @Autowired
    private YelpService yelpService;
//    @GetMapping("/user/{userId}")
//    public List<DetailDto> getNotesByUser(@PathVariable Long userId) {
//        return detailService.getAllNotesByUserId(userId);
//    }

    @GetMapping("/find-studios/zipcode/{zipCode}")
    public String getStudios(@PathVariable String zipCode) throws IOException {
        return yelpService.findStudios(zipCode);
    }


    @PostMapping("/user/{userId}/add-favorites")
    public void addFavorites(){

    }

    @GetMapping("/user/{userId}/favorites")
//    Shoud return a list of YelpResponses
    public void favorites(){
//        need to query database to find the favoriates by userId
    }

    @GetMapping("/public-reviews/studio/{studioId}/")
    public YelpResponse displayStudiosWithPublicReview(){
        YelpResponse defaultResponse = new YelpResponse(displayStudiosWithPublicReview().getBusinesses());
        return defaultResponse;
    }
}
