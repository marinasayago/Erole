package com.erole.moviErole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/user/save")
	public String saveUser(User user) {
		userServ.save(user);
		return "redirect:/";
	}
	
	@RequestMapping("/user/login")
	public String moveToLogin(Model model) {
		model.addAttribute("user", new User());
		return "/user/login";
	}
	
	@PostMapping("/user/checking")
	public String login(User user, Model model) {
		User dbUser = userServ.search(user);
		if(dbUser != null) {
			model.addAttribute("user", dbUser);
			//return "/user/checking/index";
			return "/app/index";
		}else {
			return "redirect:/user/login";
		}
	}
	
	@RequestMapping("/app/{id}")
	public String moveToMainPage(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("user", userServ.searchById(id));
		return "/app/index";
	}
}
