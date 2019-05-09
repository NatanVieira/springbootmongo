package com.natanaelvieira.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.natanaelvieira.workshopmongo.domain.Post;
import com.natanaelvieira.workshopmongo.domain.User;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	public PostDTO() {
		
	}

	public PostDTO(Post obj) {
		this.author = obj.getAuthor();
		this.id = obj.getId();
		this.date = obj.getDate();
		this.title = obj.getTitle();
		this.body = obj.getBody();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
