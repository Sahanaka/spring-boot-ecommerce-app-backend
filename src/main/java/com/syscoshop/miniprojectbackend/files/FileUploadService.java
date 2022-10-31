package com.syscoshop.miniprojectbackend.files;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    Resource uploadFile(MultipartFile file);
}
