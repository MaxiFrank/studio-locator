package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.controllers.YelpController;

public class YelpService {
    YelpController yelpController = new YelpController();
    yelpController.connect();

}
