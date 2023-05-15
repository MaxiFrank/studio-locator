package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    @Transactional
    List<String> userLogin(UserDto userDto);

    @Transactional
    List<String> userLogout(UserDto userDto);

}