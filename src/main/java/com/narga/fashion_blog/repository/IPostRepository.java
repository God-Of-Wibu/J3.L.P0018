package com.narga.fashion_blog.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.narga.fashion_blog.entity.Post;

@Repository
public interface IPostRepository extends CrudRepository<Post, Integer> {
	List<Post> findAll(Pageable pageable);
}
