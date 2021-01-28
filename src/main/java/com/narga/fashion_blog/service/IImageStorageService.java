package com.narga.fashion_blog.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.narga.fashion_blog.entity.Image;

public interface IImageStorageService {
	Image store(MultipartFile part, String name) throws IOException;
	Image store(InputStream stream, String name) throws IOException;
	Image store(String url);
}
