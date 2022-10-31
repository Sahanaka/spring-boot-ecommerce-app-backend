package com.syscoshop.miniprojectbackend.config;

import com.syscoshop.miniprojectbackend.files.LocalFileUploader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileUploadConfig {
    @Bean
    public LocalFileUploader localFileUploader() {
        return new LocalFileUploader();
    }
}
