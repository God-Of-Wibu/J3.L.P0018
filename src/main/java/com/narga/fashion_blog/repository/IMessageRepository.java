package com.narga.fashion_blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.narga.fashion_blog.entity.Message;

public interface IMessageRepository extends CrudRepository<Message, Integer>{
}
