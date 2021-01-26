package com.narga.fashion_blog.service;

import org.springframework.core.io.Resource;

public interface IResourceService {
	
	Resource loadImage(String name);

}
