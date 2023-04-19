package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.dtos.DetailDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface DetailService {
    @Transactional
    void addDetail(DetailDto detailDto, Long userId, Long studioId);

//    @Transactional
//    void deleteDetailById(Long detailId);
//
//    @Transactional
//    void updateDetailById(DetailDto detailDto);
//
//    @Transactional
//    List<DetailDto> getAllDetailsByUserId(Long userId);
//
//    @Transactional
//    Optional<DetailDto> getDetailbyId(Long noteId);
}
