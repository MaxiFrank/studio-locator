package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.dtos.DetailDto;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface DetailService {
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

    @Transactional
    Optional<DetailDto> getDetailsByStudioName(@PathVariable String studioName);
}
