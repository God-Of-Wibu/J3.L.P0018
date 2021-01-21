package com.narga.fashion_blog.controller.form_object;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.narga.fashion_blog.entity.Post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewPostForm {
	String title;
	
	String content;
	
	MultipartFile image;
	
	Post.Type type;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	Date date;
}
