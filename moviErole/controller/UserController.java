package com.erole.moviErole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erole.moviErole.model.User;
import com.erole.moviErole.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;
	
	@RequestMapping("/user/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "/user/add";
	}
	
	@PostMapping("/user/add")
	public String saveUser(User user) {
		userServ.save(user);
		return "redirect:/?registration";
	}
	
	@RequestMapping("/user/login")
	public String moveToLogin(Model model) {
		model.addAttribute("user", new User());
		return "/user/login";
	}
	
	@RequestMapping("/app")
	public String mainPage() {
		return "app/index";
	}
}
