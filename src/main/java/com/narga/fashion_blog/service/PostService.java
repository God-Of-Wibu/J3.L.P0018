package com.narga.fashion_blog.service;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.narga.fashion_blog.controller.form_object.NewPostForm;
import com.narga.fashion_blog.entity.Image;
import com.narga.fashion_blog.entity.Post;
import com.narga.fashion_blog.repository.IPostRepository;

@Service
public class PostService implements IPostService {

	@Autowired
	private IImageStorageService imageSorageService;

	@Autowired
	private IPostRepository postRepository;

	@Override
	public List<Post> getRecentPosts() {

		return null;
	}

	@Override
	@Transactional
	public void createNewPost(NewPostForm form) {
		Post post = postRepository.save(new Post(form.getTitle(), Date.valueOf(LocalDate.now()), null, form.getType(), form.getContent()));
		try {
			MultipartFile imagePart = form.getImage();

			Image image = imageSorageService.store(imagePart,
					"post_image_" + post.getId() + "." + FilenameUtils.getExtension(imagePart.getOriginalFilename()));
			
			post.setImage(image);
			
		} catch (IOException e) {
			throw new PostCreationException("Unable to save image", e);
		}
	}

	@Override
	public List<Post> getNewestPosts() {
		return postRepository.findAll(PageRequest.of(0, 4, Sort.by("date").descending()));
	}

}
