package com.erole.moviErole.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Esta clase se correspondera con una entidad de la base de datos.
 * Todos los atributos marcados con @column se corresponden con los atributos de la clase.
 * El atributo primario es ID, que sera autogenerado, y los atributos unicos son: email y username.
 * Atributos no nulos: id, email, username, password, name.
 * @author pepes
 * 
 */

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;
	@Column(name = "username", unique = true, nullable = false, length = 16)
	private String username;
	@Column(name = "password", nullable = false)
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
	@Column(name = "img")
	private String img;
	@Column(name = "watchLater")
	private String watchLater;
	@Column(name = "myMovies")
	private String myMovies;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_roles", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
	public static final String DEFAULTIMG = "https://mercatmollet.aprop.online/5372-large_default/bote-garbanzos-cocidos.jpg"; 
	
	public User() {
		this.img = DEFAULTIMG;
	}

	public User(String email, String userName, String password, String name, String surname, Date birthdate,
			String bio, Collection<Role> roles, String watchLater, String myMovies) {
		super();
		this.email = email;
		this.username = userName;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.bio = bio;
		this.roles = roles;
		this.watchLater = watchLater;
		this.myMovies = myMovies;
		this.img = DEFAULTIMG;
	}

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
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
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
	
	public String getImg() {
		return this.img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getWatchLater() {
		return this.watchLater;
	}
	
	public void setWatchLater(String watchLater) {
		this.watchLater = watchLater;
	}
	
	public String getMyMovies() {
		return this.myMovies;
	}
	
	public void setMyMovies(String myMovies) {
		this.myMovies = myMovies;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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
			res = this.username.equals(u.username) && this.password.equals(u.password);
		}
		return res;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + username + ", name=" + name + ", password=" + password + "]";
	}
}