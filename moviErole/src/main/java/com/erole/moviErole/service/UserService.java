package com.erole.moviErole.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.erole.moviErole.model.User;

public interface UserService extends UserDetailsService{
	User save(User form);
}