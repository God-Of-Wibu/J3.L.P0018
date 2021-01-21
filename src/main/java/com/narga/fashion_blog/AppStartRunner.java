package com.narga.fashion_blog;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.narga.fashion_blog.entity.Post;
import com.narga.fashion_blog.repository.IPostRepository;

@Component
public class AppStartRunner implements ApplicationRunner {

	@Autowired
	IPostRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repository.save(new Post("New York", null, null, null, "ollaaa"));
	}

}
