package com.narga.fashion_blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.narga.fashion_blog.entity.Image;


@Repository
public interface IImageRepository extends CrudRepository<Image, Integer>{

}
