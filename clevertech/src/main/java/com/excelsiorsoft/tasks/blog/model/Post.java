package com.excelsiorsoft.tasks.blog.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@Column(length = 4096)
	private String content;

	private LocalDateTime creationDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}
	
	@OneToMany(
	        mappedBy = "post",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Comment> comments = new ArrayList<>();
	 
 
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }
    
    public List<Comment>getComments() {
    	return this.comments;
    }
 
	/*
	 * public void removeComment(Comment comment) { comments.remove(comment);
	 * comment.setPost(null); }
	 */

}
