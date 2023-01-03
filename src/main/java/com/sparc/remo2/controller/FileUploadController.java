package com.sparc.remo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sparc.remo2.response.FileUploadResponse;
import com.sparc.remo2.service.FileStorageService;


@RestController
@RequestMapping("/api/v1/uploadController")
public class FileUploadController {
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping("/uploadImage")
	public FileUploadResponse uploadImage(@RequestParam("file") MultipartFile file) {
		return fileStorageService.uploadImage(file);
	}
}
