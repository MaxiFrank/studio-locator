package com.example.studioLocatorApp.services;

import com.example.studioLocatorApp.dtos.DetailDto;
import com.example.studioLocatorApp.entities.Detail;
import com.example.studioLocatorApp.entities.User;
import com.example.studioLocatorApp.repositories.DetailRepository;
import com.example.studioLocatorApp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DetailRepository detailRepository;

    @Override
    @Transactional
    public void addDetail(DetailDto detailDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Detail detail = new Detail(detailDto);
        userOptional.ifPresent(detail::setUser);
        detailRepository.saveAndFlush(detail);
    }

    @Override
    @Transactional
    public void deleteDetailByIds(Long userUserId, Long studioId) {
        Optional<Detail> detailOptional = detailRepository.findAllByUserUserIdAndStudioId(userUserId, studioId);
        detailOptional.ifPresent(detail -> detailRepository.delete(detail));
    }

    @Override
    @Transactional
    public void updateDetailByIds(DetailDto detailDto, Long userUserId, Long studioId) {
        Optional<Detail> detailOptional = detailRepository.findByUserUserIdAndStudioId(userUserId, studioId);
        detailOptional.ifPresent(detail -> {
            detail.setNote(detailDto.getNote());
            detailRepository.saveAndFlush(detail);
        });
    }

@Override
@Transactional
public List<DetailDto> getAllDetailsByUserId(Long userId){
    Optional<User> userOptional = userRepository.findById(userId);
    List<String> responseArr = new ArrayList<>();
    if (userOptional.isPresent()){
        List<Detail> detailList = detailRepository.findAllByUserEquals(userOptional.get());

        System.out.println("this is what detail list looks like");
        return detailList.stream().map(detail -> new DetailDto(detail)).collect(Collectors.toList());
    }
    return Collections.emptyList();
}

    @Override
    @Transactional
    public Optional<DetailDto> getDetailbyIds(Long userUserId, Long studioId) {
        Optional<Detail> detailOptional = detailRepository.findAllByUserUserIdAndStudioId(userUserId, studioId);
        if (detailOptional.isPresent()) {
            return Optional.of(new DetailDto(detailOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<DetailDto> getDetailsByStudioName(@PathVariable String studioName) {
        System.out.println(studioName);
        Optional<Detail> detailOptional = detailRepository.findByStudioNameAndIsPublic(studioName, true);
        if (detailOptional.isPresent()) {
            return Optional.of(new DetailDto(detailOptional.get()));
        }
        return Optional.empty();
    }
}
