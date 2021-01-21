package com.narga.fashion_blog.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.narga.fashion_blog.entity.*;

@Repository
public interface IPostRepository extends CrudRepository<Post, Integer> {
	List<Post> findByDateBetween(Date begin, Date end);
}
