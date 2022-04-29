package com.erole.moviErole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Esta clase se correspondera con una entidad de la base de datos.
 * Todos los atributos marcados con @column se corresponden con los atributos de la clase.
 * El atributo primario es ID, que sera autogenerado, y nombre sera un atributo unico y no nulo.
 * @author pepes
 * 
 */

@Entity
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "name", nullable = false, length = 20, unique = true)
	private String name;
	
	public Role() {}

	public Role(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
