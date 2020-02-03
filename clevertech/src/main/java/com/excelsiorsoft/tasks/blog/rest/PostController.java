package com.excelsiorsoft.tasks.blog.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.excelsiorsoft.tasks.blog.model.dto.CommentDto;
import com.excelsiorsoft.tasks.blog.model.dto.NewCommentDto;
import com.excelsiorsoft.tasks.blog.model.dto.PostDto;
import com.excelsiorsoft.tasks.blog.service.CommentService;
import com.excelsiorsoft.tasks.blog.service.PostService;

@Controller
@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;
	private final CommentService commentService;


	public PostController(PostService postService, CommentService commentService) {
		this.postService = postService;
		this.commentService = commentService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PostDto getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}
	
	@GetMapping(value = "/{id}/comments")
	@ResponseStatus(HttpStatus.OK)
	public List<CommentDto> getCommentsForPost(@PathVariable Long id) {
		return commentService.getCommentsForPost(id);
	}
	
	@PostMapping(value = "/{id}/comments")
	@ResponseStatus(HttpStatus.CREATED)
	public CommentDto addCommentForPost(@PathVariable Long id, @RequestBody NewCommentDto newComment) {
		Long commentIid = commentService.addComment(newComment);
		CommentDto dto = new CommentDto(commentIid, newComment.getContent(), newComment.getAuthor(),LocalDateTime.now());
		return null;
	}


}
