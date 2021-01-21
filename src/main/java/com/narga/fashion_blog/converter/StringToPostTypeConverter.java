package com.narga.fashion_blog.converter;

import org.springframework.core.convert.converter.Converter;

import com.narga.fashion_blog.entity.Post;

public class StringToPostTypeConverter implements Converter<String, Post.Type>{
	public Post.Type convert(String src) {
		return Post.Type.valueOf(src.toUpperCase());
	}
}
