package com.ecomweb.demo.service.impl;

import com.ecomweb.demo.service.interf.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private static final String UPLOAD_DIR = "uploads/";

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        // Generate a unique file name
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();
        Files.createDirectories(uploadPath); // Make sure the directory exists

        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, file.getBytes());

        // Return the relative URL to access the file (adjust if using a controller to serve files)
        return "/uploads/" + fileName;
    }
}
