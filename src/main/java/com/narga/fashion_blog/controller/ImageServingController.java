package com.narga.fashion_blog.controller;

import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.narga.fashion_blog.service.IResourceService;

@Controller
public class ImageServingController {
	
	@Autowired
	private IResourceService resourceService;
	
	
	@GetMapping("/image/{imageName}")
	ResponseEntity<Resource> image(@PathVariable String imageName) {
		Resource resource = resourceService.loadImage(imageName);
		ResponseEntity<Resource> responseEntity = ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_TYPE, URLConnection.guessContentTypeFromName(imageName))
				.header(HttpHeaders.CONTENT_DISPOSITION, "\"attachment; filename=\"" + imageName + "\"")
				.body(resource);
		return responseEntity;
	}
}
