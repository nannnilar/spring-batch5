package com.example.imageuploaddownload.service;

import com.example.imageuploaddownload.entity.ImageFileData;
import com.example.imageuploaddownload.repo.ImageFileDataRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageFileDataService {
    @Autowired
    private final ImageFileDataRepo repo;

    private final String FOLDER_PATH = "E:\\files";

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        ImageFileData fileData = repo.save(ImageFileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));
        if (file != null) {
            return "File upload successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws  IOException {
        Optional<ImageFileData> fileData = repo.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }


}
