package com.excelsiorsoft.tasks.blog.service;


import org.springframework.stereotype.Service;

import com.excelsiorsoft.tasks.blog.model.dto.PostDto;
import com.excelsiorsoft.tasks.blog.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public PostDto getPost(Long id) {
		return postRepository.findById(id)
				.map(post -> new PostDto(post.getTitle(), post.getContent(), post.getCreationDate()))
				.orElse(null);
	}
}
