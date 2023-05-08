package com.example.studioLocatorApp.services;

import jakarta.transaction.Transactional;
import java.io.IOException;

public interface YelpService {
    @Transactional
    String findStudios(String zipCode) throws IOException;
}
