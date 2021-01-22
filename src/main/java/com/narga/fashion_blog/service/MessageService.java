package com.narga.fashion_blog.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narga.fashion_blog.controller.form_object.NewMessageForm;
import com.narga.fashion_blog.entity.Message;
import com.narga.fashion_blog.repository.IMessageRepository;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private IMessageRepository messageRepository;

	@Override
	public void sendMessage(NewMessageForm form) {
		messageRepository
				.save(new Message(form.getName(), form.getEmail(), form.getMeassage(), Date.valueOf(LocalDate.now())));
	}

}
