package com.erole.moviErole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erole.moviErole.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}