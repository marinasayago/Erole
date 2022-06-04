package com.erole.moviErole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class MoviEroleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviEroleApplication.class, args);
	}
	
	public static String getLoggedUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = null;
		if (userDetails != null) {
			userName = userDetails.getUsername();
		}
		return userName;
	}
}