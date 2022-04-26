package com.erole.moviErole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erole.moviErole.model.Role;

/**
 * Conecta la base de datos con nuestro proyecto java permitiendonos manipularla con los metodos ofrecidos
 * @author pepes
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}