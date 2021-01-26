package com.narga.fashion_blog.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.narga.fashion_blog.entity.Image;
import com.narga.fashion_blog.repository.IImageRepository;

@Service
public class ImageStorageService implements IImageStorageService {
	private final static int BUFF_SIZE = 1024 * 100;
	private Logger logger = LoggerFactory.getLogger(ImageStorageService.class);

	@Value("${narga.fashion_blog.file_dir:/fashion_blog}")
	private String imageDirectoryPath;

	@Value("${narga.fashion_blog.image_url_prefix:/image}")
	private String imageUrlPrefix;

	@Value("${narga.fashion_blog.clean_image_dir:on_init}")
	private String cleanImageDirOption;

	private static final String CLEAN_OPTION_ON_STARTUP = "on_init";
	private static final String CLEAN_OPTION_ON_SHUTDOWN = "on_destroy";

	@Autowired
	private IImageRepository repository;

	@Override
	public Image store(MultipartFile part, String name) throws IOException {
		return store(part.getInputStream(), name);
	}

	private void deleteImageDirectory() {
		try {
			File file = new File(imageDirectoryPath);
			if (file.exists()) {
				FileUtils.deleteDirectory(file);
			}
		} catch (IOException e) {
			logger.error("fail to delete image directory", e);
		}
	}
	
	private void createImageDirectory() {
		File file = new File(imageDirectoryPath);
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
	@PostConstruct
	private void init() {

		if (cleanImageDirOption.equals(CLEAN_OPTION_ON_STARTUP)) {
			deleteImageDirectory();
		}

		createImageDirectory();
		
	}

	@PreDestroy
	private void fini() {
		if(cleanImageDirOption.equals(CLEAN_OPTION_ON_SHUTDOWN)) {
			deleteImageDirectory();
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

		String fileLocation = imageDirectoryPath + "/" + name;

		writeToFile(stream, fileLocation);
		return repository.save(new Image(imageUrlPrefix + "/" + name, fileLocation));
	}

	@Override
	public Image store(String url) {
		return repository.save(new Image(url));
	}

}