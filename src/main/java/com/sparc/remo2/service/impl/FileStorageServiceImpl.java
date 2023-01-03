package com.sparc.remo2.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sparc.remo2.response.FileUploadResponse;
import com.sparc.remo2.service.FileStorageService;


@Service
public class FileStorageServiceImpl implements FileStorageService {

	
	@Value("${file.upload-dir}")
	private String path;
	
	@Autowired
	ServletContext context;

	@Override
	public FileUploadResponse uploadImage(MultipartFile file) {
		String originalFilename=null;
		try {
			Random random = new Random(); 
			//String fileNameWithOutExt = FilenameUtils.removeExtension(file.getOriginalFilename());
			//String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			//originalFilename=fileNameWithOutExt+"_"+random.nextInt(1000)+"."+extension;  
			originalFilename=file.getOriginalFilename();
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, Paths.get(path+"/"+ originalFilename),
                    StandardCopyOption.REPLACE_EXISTING);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	
		FileUploadResponse fileUploadResponse = new FileUploadResponse();
		fileUploadResponse.setFileName(originalFilename);
		return fileUploadResponse;
	}
}
