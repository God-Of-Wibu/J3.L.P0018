package com.narga.fashion_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {
	
	@GetMapping("index")
	@ResponseBody
	public String index() {
		return "fuck";
	}
}
