package com.syscoshop.miniprojectbackend.files;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final LocalFileUploader localFileUploader;

    @Override
    public Resource uploadFile(MultipartFile file) {
       return localFileUploader.uploadFile(file);
    }
}
