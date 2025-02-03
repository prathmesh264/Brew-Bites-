package com.example.pro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pro.Entity.Image;
import com.example.pro.Repo.ImageRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
	
    @Autowired
    private ImageRepository imageRepository;

    // Save image to the database
    public Image saveImage(MultipartFile file) throws IOException {
        Image image = new Image(
            file.getOriginalFilename(),
            file.getContentType(),
            file.getBytes()
           
        );
        return imageRepository.save(image);
    }

    // Retrieve image by ID
    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }
}
