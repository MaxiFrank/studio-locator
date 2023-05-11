package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.dtos.UserDto;
import com.example.studioLocatorApp.entities.User;
import com.example.studioLocatorApp.repositories.UserRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        response.add("You have successfully registered");
        return response;
    }

    @Override
    @Transactional
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();
        response.add("/index.html");
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                response.add("You've logged in");
                response.add(String.valueOf(userOptional.get().getUserId()));
            } else {
                response.add("Username or password incorrect");
            }
        } else {
            response.add("Username or password incorrect");
        }
        return response;
    }

    @Override
    @Transactional
    public List<String> userLogout(UserDto userDto) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()) {
            response.add("You've been logged out");
        } else {
            response.add("You were not logged in");
        }
        return response;
    }
}
