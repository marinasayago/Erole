package com.erole.moviErole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erole.moviErole.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
