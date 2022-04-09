package com.erole.moviErole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erole.moviErole.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String userName);
}
