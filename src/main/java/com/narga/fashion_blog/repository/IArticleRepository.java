package com.narga.fashion_blog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.narga.fashion_blog.entity.*;

@Repository
public interface IArticleRepository extends CrudRepository<Article, Integer> {
	List<Article> findAll();

}
