package com.syscoshop.miniprojectbackend.files;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploader {
    Resource uploadFile(MultipartFile file);

    void deleteAll();
}
