package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.dtos.DetailDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface DetailService {
//    @Transactional
//    void addDetail(DetailDto detailDto, Long studioName, String studioDetail, String isPrivate);

//    @Transactional
//    need to use studioId as well, how to add a row in postgres using duo id?
//    user is here but details haven't been created, shouldn't I be passing in the userDto instead of detailDto?
//    void addDetail(DetailDto detailDto, String studioName, String studioDetail, String isPrivate);

    @Transactional
    void addDetail(DetailDto detailDto, Long userId);

    @Transactional
    void deleteDetailByIds(Long userUserId, Long studioId);

    @Transactional
    void updateDetailByIds(DetailDto detailDto, Long userUserId, Long studioId);

    @Transactional
    List<DetailDto> getAllDetailsByUserId(Long userId);

    @Transactional
    Optional<DetailDto> getDetailbyIds(Long userUserId, Long studioId);
}
