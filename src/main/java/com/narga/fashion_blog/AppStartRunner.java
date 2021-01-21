package com.narga.fashion_blog;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.narga.fashion_blog.entity.Article;
import com.narga.fashion_blog.repository.IArticleRepository;

@Component
public class AppStartRunner implements ApplicationRunner {

	@Autowired
	IArticleRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repository.save(new Article("New York", null, null, null, "ollaaa"));
	}

}
