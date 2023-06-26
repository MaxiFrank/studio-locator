package com.example.studioLocatorApp.controllers;


import com.example.studioLocatorApp.dtos.DetailDto;
import com.example.studioLocatorApp.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/details")
public class DetailController {
    @Autowired
    private DetailService detailService;

    @GetMapping("/visited/user/{userId}")
    public List<DetailDto> getDetailsByUser(@PathVariable Long userId) {
        return detailService.getAllDetailsByUserId(userId);
    }

    @PostMapping("/matching-studios/user/{userId}")
    public void addDetail(@RequestBody DetailDto detailDto, @PathVariable Long userId){
        detailService.addDetail(detailDto, userId);
    }

    @DeleteMapping("/{userUserId}/{studioId}")
    public void deleteDetailByIds(@PathVariable Long userUserId, @PathVariable Long studioId){
        detailService.deleteDetailByIds(userUserId, studioId);
    }

    @PutMapping("/user/{userUserId}/studio/{studioId}")
    public void updateDetailByIds(@RequestBody DetailDto detailDto, @PathVariable Long userUserId, @PathVariable Long studioId){
        detailService.updateDetailByIds(detailDto, userUserId, studioId);
    }

    @GetMapping("/user/{userUserId}/studio/{studioId}")
    public Optional<DetailDto> getDetailByIds(@PathVariable Long userUserId, @PathVariable Long studioId) {
        return detailService.getDetailbyIds(userUserId, studioId);
    }

    @GetMapping("/{studioName}")
    public Optional<DetailDto> getDetailsByStudioName(@PathVariable String studioName) {
        return detailService.getDetailsByStudioName(studioName);
    }
}