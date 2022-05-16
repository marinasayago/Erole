package com.erole.moviErole.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	@Column(name = "contentId", nullable = false)
	private String contentId;
	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;
	@Column(name = "text", length = 500)
	private String text;
	@Column(name = "rating", nullable = false)
	private int rating;
	
	public Comment() {}
	
	public Comment(User user, String contentId, String comment, int rating) {
		super();
		this.user = user;
		this.contentId = contentId;
		this.date = new Date();
		this.text = comment;
		this.rating = rating;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public String getText() {
		return text;
	}
	public void setText(String comment) {
		this.text = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", contentId=" + contentId + ", date=" + date + ", text="
				+ text + ", rating=" + rating + "]";
	}
}
