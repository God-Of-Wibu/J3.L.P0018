package com.narga.fashion_blog.service;

import com.narga.fashion_blog.controller.form_object.NewMessageForm;

public interface IMessageService {
	void sendMessage(NewMessageForm form);
}
