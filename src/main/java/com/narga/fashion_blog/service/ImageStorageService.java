package com.narga.fashion_blog.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.narga.fashion_blog.entity.Image;
import com.narga.fashion_blog.repository.IImageRepository;

@Service
public class ImageStorageService implements IImageStorageService {
	private final static int BUFF_SIZE = 1024 * 100;

	
	@Value("${narga.fashion_blog.file_dir}")
	private String fileDirectory;

	@Value("${narga.fashion_blog.file_url_prefix}")
	private String fileUrlPrefix;

	@Autowired
	private IImageRepository repository;

	@Override
	public Image store(MultipartFile part, String name) throws IOException {
		return store(part.getInputStream(), name);
	}
	
	@PostConstruct
	private void init() {
		File file = new File(fileDirectory);
		if(!file.exists()) {
			file.mkdir();
		}	
	}
	
	private void writeToFile(InputStream inputStream, String fileName) throws IOException {
		File file = new File(fileName);
		System.out.println(file.getAbsolutePath());
		try (inputStream; OutputStream outputStream = new FileOutputStream(file);) {
			byte[] buffer = new byte[BUFF_SIZE];
			int read = -1;
			while ((read = inputStream.read(buffer, 0, BUFF_SIZE)) != -1) {
				outputStream.write(buffer, 0, read);
			}
		}
	}

	@Override
	public Image store(InputStream stream, String name) throws IOException {
		
		String fileLocation = fileDirectory + "/" + name;
		
		writeToFile(stream, fileLocation);
		return repository.save(new Image(fileUrlPrefix + "/"  + name, fileLocation));
	}


	@Override
	public Image store(String url) {
		return repository.save(new Image(url));
	}
	
	
}