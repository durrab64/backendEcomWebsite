package com.ecomweb.demo.service.interf;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface FileUploadService {
    String uploadFile(MultipartFile file) throws IOException;
}
