package com.example.studioLocatorApp.dtos;

import com.example.studioLocatorApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long userId;
    private String username;
    private String password;


    public UserDto(User user) {
        if (user.getUserId() != null) {
            this.userId = user.getUserId();
        }
        if (user.getUsername() != null) {
            this.username = user.getUsername();
        }
        if (user.getPassword() != null) {
            this.password = user.getPassword();
        }
    }
}