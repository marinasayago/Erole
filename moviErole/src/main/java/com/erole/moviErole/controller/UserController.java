package com.erole.moviErole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erole.moviErole.MoviEroleApplication;
import com.erole.moviErole.APIQuery.Query;
import com.erole.moviErole.model.User;
import com.erole.moviErole.service.UserServiceImp;

/**
 * Esta clase servira para gestionar las peticiones del usuario en el navegador, es decir,
 * cuando el usuario introduzca una direccion en el navegador, se buscara en este metodo si hay alguna
 * etiquete @RequestMapping, @PostMapping que se corresponda.
 * En caso de haberla, se procede a ejecutar el metodo asosciado.
 * En otro caso, recibiremos un error 404 en el navegador.
 * @author pepes
 *
 */

@Controller
public class UserController {
	@Autowired
	private UserServiceImp userServ;
	
	/**
	 * Cuando se solicite la direccion /user/add, nos dirigira al formulario de registro
	 * @param model -> este atributo conecta el html con el proyecto java
	 * @return -> nos mostrara en el navegador el archivo html alojado en esa direccion
	 */
	@RequestMapping("/user/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "/user/add";
	}
	
	/**
	 * Recibira la peticion de registro del formulario html(submit) y guardara el usuario
	 * @param user -> el usuario creado tras rellenar el formulario
	 * @return -> nos devuelve a la pagina ppal con mensaje de exito
	 */
	@PostMapping("/user/add")
	public String saveUser(User user) {
		if(userServ.save(user) == null) return "redirect:/user/add?repeated";
		else return "redirect:/?registration";
	}
	
	/**
	 * Recoge la peticion de movernos al login 
	 * @param model -> este atributo conecta el html con el proyecto java
	 * @return -> nos mostrara en el navegador el archivo html alojado en esa direccion
	 */
	@RequestMapping("/user/login")
	public String moveToLogin(Model model) {
		model.addAttribute("user", new User());
		return "/user/login";
	}
	
	/**
	 * Recoge la peticion de movernos a la pagina ppal del proyecto.
	 * @return -> nos devuelve el html correspondiente a la pagina ppal
	 */
	@RequestMapping("/app")
	public String mainPage(Model model) {
		model.addAttribute("query", new Query());
		model.addAttribute("loggedUser", userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));
		return "app/index";
	}
	
	@RequestMapping("/app/user/edit")
	public String editProfile(Model model) {
		model.addAttribute("user", userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));
		return "user/edit";
	}
	
	@RequestMapping("/user/edit")
	public String saveChanges(User user) {
		if(userServ.save(user) != null) return "redirect:/logout?edit";
		else return "redirect:/app/myUser?error";
	}
	
	@RequestMapping("/app/user/delete")
	public String deleteProfile() {
		userServ.deleteUser(userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));
		return "redirect:/logout?delete";
	}
}
