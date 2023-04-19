package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.dtos.DetailDto;
import com.example.studioLocatorApp.entities.Detail;
import com.example.studioLocatorApp.entities.User;
import com.example.studioLocatorApp.repositories.DetailRepository;
import com.example.studioLocatorApp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DetailRepository detailRepository;

    @Override
    @Transactional
//    need to use studioId as well, how to add a row in postgres using duo id?
    public void addDetail(DetailDto detailDto, Long userId, Long studioId) {
        Optional<User> userOptional = userRepository.findById(userId);
//        Detail detail = new Detail(detailDto);
//        userOptional.ifPresent(detail::setUser);
//        detailRepository.saveAndFlush(detail);
    }

//    @Override
//    @Transactional
//    public void deleteDetailById(Long detailId) {
//        Optional<Detail> detailOptional = detailRepository.findById(detailId);
//        detailOptional.ifPresent(detail -> detailRepository.delete(detail));
//    }
//
//    @Override
//    @Transactional
//    public void updateDetailById(DetailDto detailDto) {
//        Optional<Detail> detailOptional = detailRepository.findById(detailDto.getUserId());
//        detailOptional.ifPresent(detail -> {
//            detail.setNote(detailDto.getNote());
//            detailRepository.saveAndFlush(detail);
//        });
//    }
//
//    @Override
//    @Transactional
//    public List<DetailDto> getAllDetailsByUserId(Long userId){
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()){
//            List<Detail> detailList = detailRepository.findAllByUserEquals(userOptional.get());
//            return detailList.stream().map(detail -> new DetailDto(detail)).collect(Collectors.toList());
//        }
//        return Collections.emptyList();
//    }
//
//    @Override
//    @Transactional
//    public Optional<DetailDto> getDetailbyId(Long noteId) {
//        Optional<Detail> detailOptional = detailRepository.findById(noteId);
//        if (detailOptional.isPresent()) {
//            return Optional.of(new DetailDto(detailOptional.get()));
//        }
//        return Optional.empty();
//    }
}
