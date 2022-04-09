package com.erole.moviErole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erole.moviErole.model.Role;
import com.erole.moviErole.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRep;
	
	public Role searchByName(String name) {
		return roleRep.findByName(name);
	}
}
