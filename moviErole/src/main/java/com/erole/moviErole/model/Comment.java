package com.erole.moviErole.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "user", nullable = false)
	private String user_id;
	@Column(name = "content", nullable = false)
	private String content_id;
	@Column(name = "comment", length = 500)
	private String comment;
	@Column(name = "rating")
	private int rating;
	@Column(name = "date", nullable = false)
	private Date date;
	
	public Comment() {}
	
	public Comment(String user, String content, int rating, String comment) {
		user_id = user;
		content_id = content;
		this.rating = rating;
		this.comment = comment;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
