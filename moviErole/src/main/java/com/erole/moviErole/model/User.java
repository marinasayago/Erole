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
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;
	@Column(name = "userName", unique = true, nullable = false, length = 16)
	private String userName;
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	@Column(name = "surname", length = 20)
	private String surname;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date birthdate;
	@Column(name = "bio", length = 200)
	private String bio;
	
	public User() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof User) {
			User u = (User) obj;
			res = this.userName.equals(u.userName) && this.password.equals(u.password);
		}
		return res;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", name=" + name + ", password=" + password + "]";
	}
}
