package com.example.imageuploaddownload.repo;

import com.example.imageuploaddownload.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageDataRepo extends JpaRepository<ImageData, Integer> {
    Optional<ImageData> findByName(String  name);
}
