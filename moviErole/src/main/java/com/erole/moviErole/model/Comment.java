package com.erole.moviErole.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Integer id;
	//RELACION DE UNO A MUCHOS
	@Column(name = "userId", nullable = false)
	private String userId;
	@Column(name = "contentId", nullable = false)
	private String contentId;
	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;
	@Column(name = "comment", length = 500)
	private String comment;
	@Column(name = "rating", nullable = false)
	private int rating;
	
	public Comment() {}
	
	public Comment(String userId, String contentId, String comment, int rating) {
		super();
		this.userId = userId;
		this.contentId = contentId;
		this.date = new Date();
		this.comment = comment;
		this.rating = rating;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	
	
}
