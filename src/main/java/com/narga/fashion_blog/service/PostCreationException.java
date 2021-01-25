package com.narga.fashion_blog.service;

public class PostCreationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostCreationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PostCreationException(String message) {
		super(message);
	}

}
