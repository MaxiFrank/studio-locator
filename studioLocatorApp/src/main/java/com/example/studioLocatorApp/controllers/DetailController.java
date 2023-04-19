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

//    @GetMapping("/user/{userId}")
//    public List<DetailDto> getDetailsByUser(@PathVariable Long userId) {
//        return detailService.getAllDetailsByUserId(userId);
//    }
//
    @PostMapping("/user/{userId}")
    public void addDetail(@RequestBody DetailDto detailDto, @PathVariable Long userId, @PathVariable Long studioId){
        detailService.addDetail(detailDto, userId, studioId);
    }
//
//    @DeleteMapping("/{detailId}")
//    public void deleteDetailById(@PathVariable Long detailId){
//        detailService.deleteDetailById(detailId);
//    }
//
//    @PutMapping
//    public void updateDetail(@RequestBody DetailDto detailDto){
//        detailService.updateDetailById(detailDto);
//    }
//
//    @GetMapping("/{detailId}")
//    public Optional<DetailDto> getDetailById(@PathVariable Long detailId) {
//        return detailService.getDetailbyId(detailId);
//    }
}