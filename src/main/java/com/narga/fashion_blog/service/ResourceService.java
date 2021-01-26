package com.narga.fashion_blog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class ResourceService implements IResourceService, ResourceLoaderAware {

	@Value("${narga.fashion_blog.file_dir}")
	private String fileDirectory;

	private String FILE_PREFIX = "file:";
	
	private ResourceLoader resourceLoader;

	@Override
	public Resource loadImage(String name) {
		return resourceLoader.getResource(FILE_PREFIX + fileDirectory + "/" + name);
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;

	}

}
