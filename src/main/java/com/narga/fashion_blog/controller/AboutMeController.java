package com.narga.fashion_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutMeController {
	
	@GetMapping("/about-me")
	public String aboutMe() {
		return "about-me";
	}

}
