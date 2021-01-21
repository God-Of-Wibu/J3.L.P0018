package com.narga.fashion_blog.service;

public class PostCreationException extends RuntimeException {

	public PostCreationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PostCreationException(String message) {
		super(message);
	}

}
