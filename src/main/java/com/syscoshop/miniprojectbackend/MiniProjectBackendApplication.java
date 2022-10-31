package com.syscoshop.miniprojectbackend;

import com.syscoshop.miniprojectbackend.files.LocalFileUploader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class MiniProjectBackendApplication {
	@Resource
	LocalFileUploader fileUploader;

	public static void main(String[] args) {

		SpringApplication.run(MiniProjectBackendApplication.class, args);
		System.out.println("BACKEND RUNNING!!!");
	}

	public void run(String... arg) throws Exception {
		fileUploader.deleteAll();
		fileUploader.init();
	}

}
