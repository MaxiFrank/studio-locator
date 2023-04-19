package com.example.studioLocatorApp.repositories;

import com.example.studioLocatorApp.entities.Detail;
import com.example.studioLocatorApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    List<Detail> findAllByUserEquals(User user);
}
