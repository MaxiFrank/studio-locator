package com.example.studioLocatorApp.controllers;


import com.example.studioLocatorApp.dtos.DetailDto;
import com.example.studioLocatorApp.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/details")
public class DetailController {
    @Autowired
    private DetailService detailService;

    @GetMapping("/user/{userId}")
    public List<DetailDto> getDetailsByUser(@PathVariable Long userId) {
        return detailService.getAllDetailsByUserId(userId);
    }

//    @PostMapping("/matching-studios")
//    public String addDetail(@ModelAttribute DetailDto detailDto, Model model){
//        model.addAttribute("detailDto", detailDto);
//        detailService.addDetail(detailDto, userId, studioId);
//        return "studio details added";
//    }

    @PostMapping("/user/{userId}/studio/{studioId}")
    public String addDetail(@RequestBody DetailDto detailDto, @PathVariable Long userId, @PathVariable Long studioId){
        detailService.addDetail(detailDto, userId, studioId);
        return "studio details added";
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
}