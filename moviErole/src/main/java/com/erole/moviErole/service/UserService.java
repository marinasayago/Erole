package com.erole.moviErole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erole.moviErole.model.User;
import com.erole.moviErole.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRep;
	
	public void save(User user) {
		userRep.saveAndFlush(user);
	}
	
	public User search(User user) {
		List<User> list = userRep.findAll();
		for(User u : list) {
			if(user.equals(u)) {
				return u;
			}
		}
		return null;
	}
	
	public User searchById(Integer id) {
		return userRep.getById(id);
	}
}
