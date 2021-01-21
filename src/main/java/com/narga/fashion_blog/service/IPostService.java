package com.narga.fashion_blog.service;

import java.util.List;

import com.narga.fashion_blog.controller.form_object.NewPostForm;
import com.narga.fashion_blog.entity.Post;

public interface IPostService {

	List<Post> getRecentPosts();
	
	void createNewPost(NewPostForm newPostForm) throws PostCreationException;
	
}
