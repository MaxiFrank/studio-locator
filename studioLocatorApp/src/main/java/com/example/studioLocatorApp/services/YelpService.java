package com.example.studioLocatorApp.services;

import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.List;

public interface YelpService {
    @Transactional
    List<String> findStudios(String zipCode) throws IOException;
}
