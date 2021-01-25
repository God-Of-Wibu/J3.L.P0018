package com.narga.fashion_blog.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Controller
public class FileServingController implements ResourceLoaderAware{
	
	private ResourceLoader resourceLoader;
	
	@Value("${narga.fashion_blog.file_dir}")
	private String fileDirectory;
	
	private String FILE_PREFIX = "file:";
	
	@GetMapping("/file/**")
	ResponseEntity<Resource> file(WebRequest request) {
		String fileName = getFileName(((ServletWebRequest) request).getRequest().getRequestURI());
		Resource resource = resourceLoader.getResource(FILE_PREFIX + fileDirectory + fileName);
		ResponseEntity<Resource> responseEntity = ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "\"attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
		return responseEntity;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	private String getFileName(String URI)
	{
		return URI.substring("/file".length());
	}
}
