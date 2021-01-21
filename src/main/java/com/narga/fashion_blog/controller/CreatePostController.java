package com.narga.fashion_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.narga.fashion_blog.controller.form_object.NewPostForm;
import com.narga.fashion_blog.service.IPostService;
import com.narga.fashion_blog.service.PostCreationException;

@Controller
public class CreatePostController {
	@Autowired
	private IPostService postService;
	
	@GetMapping("/create-post")
	private String createPost(Model model) {
		model.addAttribute("formObject", new NewPostForm());
		return "create-post";
	}
	
	@PostMapping
	private String createPost(@ModelAttribute NewPostForm form) {
		postService.createNewPost(form);
		return "redirect:/";
	}
	
	@ExceptionHandler(PostCreationException.class)
	public String createPostFail(Model model, PostCreationException e) {
		model.addAttribute("reason", e.getMessage());
		return "fail";
	}

}
