package com.erole.moviErole.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.erole.moviErole.model.Role;
import com.erole.moviErole.model.User;
import com.erole.moviErole.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRep;
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	@Autowired
	RoleService roleServ;
	
	public User save(User u) {
		Role role = roleServ.searchByName("USER");
		if(role == null) { role = new Role("USER"); } 
		u.setPassword(passEncoder.encode(u.getPassword()));
		u.setRoles(Arrays.asList(role));
		return userRep.saveAndFlush(u);
	}
	
	public User searchById(Integer id) {
		return userRep.getById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRep.findByUsername(userName);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
