package com.example.imageuploaddownload.service;

import com.example.imageuploaddownload.entity.ImageData;
import com.example.imageuploaddownload.repo.ImageDataRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageDataService {
    @Autowired
    private final ImageDataRepo repo;

//    public String uploadImage(MultipartFile file) throws IOException {
//        ImageData imageData = repo.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(file.getBytes())).build());
//        if (imageData != null) {
//            return "File upload successfully : " + file.getOriginalFilename();
//        }
//        return  null;
//    }


//    public byte[] downloadImage(String filename) {
//        Optional<ImageData> dbImageData = repo.findByName(filename);
//        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
//        return images;
//    }
}
