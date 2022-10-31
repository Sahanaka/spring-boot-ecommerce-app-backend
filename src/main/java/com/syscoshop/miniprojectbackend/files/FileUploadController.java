package com.syscoshop.miniprojectbackend.files;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/files")
public class FileUploadController {
    private final FileUploadService fileUploadService;

    @PostMapping
    public Resource uploadProductImage(@RequestParam("file")MultipartFile file) {
        return fileUploadService.uploadFile(file);
    }
}
