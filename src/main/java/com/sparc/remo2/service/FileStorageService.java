package com.sparc.remo2.service;

import org.springframework.web.multipart.MultipartFile;

import com.sparc.remo2.response.FileUploadResponse;

public interface FileStorageService {

	FileUploadResponse uploadImage(MultipartFile file);

}
