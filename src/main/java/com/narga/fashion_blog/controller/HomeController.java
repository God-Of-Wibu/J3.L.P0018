package com.narga.fashion_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.narga.fashion_blog.service.IPostService;

@Controller
public class HomeController {
	
	@Autowired
	private IPostService postService;

	@GetMapping
	private String uploadPost(Model model) {
		model.addAttribute("post", postService.getNewestPosts());
		return "home";
	}
}
