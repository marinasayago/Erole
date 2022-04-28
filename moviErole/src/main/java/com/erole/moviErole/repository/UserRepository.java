package com.erole.moviErole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erole.moviErole.model.User;

/**
 * Conecta la base de datos con nuestro proyecto java permitiendonos manipularla con los metodos ofrecidos
 * @author pepes
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String userName);
}
