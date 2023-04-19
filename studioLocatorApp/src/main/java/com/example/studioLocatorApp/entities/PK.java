package com.example.studioLocatorApp.entities;

import lombok.NoArgsConstructor;

import java.io.Serializable;

public class PK implements Serializable {
    private String userId;

    private String studioId;

    public PK(String userId, String studioId) {
        this.userId = userId;
        this.studioId = studioId;
    }
    private PK(){

    }
}
