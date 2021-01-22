package com.narga.fashion_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.narga.fashion_blog.controller.form_object.NewMessageForm;
import com.narga.fashion_blog.service.IMessageService;

@Controller
public class SendMessageController {
	
	@Autowired
	 private IMessageService meassageService;
	
	@GetMapping("/send-message")
	private String sendMessage(Model model) {
		model.addAttribute("formObject", new NewMessageForm() );
		return "send-mesage";
	};
	
	@PostMapping
	private String sendMessage(@ModelAttribute NewMessageForm form) {
		meassageService.sendMessage(form);
		return "redirect:/";
	}

}
