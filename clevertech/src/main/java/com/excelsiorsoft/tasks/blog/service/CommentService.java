package com.excelsiorsoft.tasks.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsiorsoft.tasks.blog.model.Comment;
import com.excelsiorsoft.tasks.blog.model.Post;
import com.excelsiorsoft.tasks.blog.model.dto.CommentDto;
import com.excelsiorsoft.tasks.blog.model.dto.NewCommentDto;
import com.excelsiorsoft.tasks.blog.repository.CommentRepository;
import com.excelsiorsoft.tasks.blog.repository.PostRepository;

@Service
public class CommentService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	

	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 */
	public List<CommentDto> getCommentsForPost(Long postId) {
		List<Comment> commentsForPost = commentRepository.findByPostId(postId);
		//List<Comment> comments = postRepository.getOne(postId).getComments();
		List<CommentDto> result = new ArrayList<>();
		commentsForPost.forEach(comment -> {
			result.add(new CommentDto(comment.getId(), comment.getComment(), comment.getAuthor(), comment.getCreationDate()));
		});
		return result;
	}

	/**
	 * Creates a new comment
	 *
	 * @param newCommentDto data of new comment
	 * @return id of the created comment
	 *
	 * @throws IllegalArgumentException if there is no blog post for passed newCommentDto.postId
	 */
	public Long addComment(NewCommentDto newCommentDto) {
		try {
			Post post = postRepository.findById(newCommentDto.getPostId()).get();

			Comment comment = new Comment();
			comment.setComment(newCommentDto.getContent());
			comment.setAuthor(newCommentDto.getAuthor());
			

			comment.setPost(post);
			//post.addComment(comment);
			comment = commentRepository.save(comment);
			return comment.getId();
		} catch (Exception e) {
			throw new IllegalArgumentException("There's no posts for given ID.");
		}

	}
}
