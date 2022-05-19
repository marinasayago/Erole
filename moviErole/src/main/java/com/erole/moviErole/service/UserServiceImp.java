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

import com.erole.moviErole.MoviEroleApplication;
import com.erole.moviErole.model.Role;
import com.erole.moviErole.model.User;
import com.erole.moviErole.repository.UserRepository;

/**
 * Implemetacion de la interfaz que funciona como capa intermedia entre el controller y repository.
 * @author pepes
 *
 */
@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRep;
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	@Autowired
	RoleService roleServ;
	
	/**
	 * Recibe la orden de guardar un usuario en la base de datos.
	 * Se comprueba si existe el rol USER, y en caso de que no exista se crea uno nuevo.
	 * Al usuario se le encripta la contraseña y se le asigna rol USER.
	 * Por ultimo se guarda en la base de datos.
	 * @param -> usuario para almacenar en la BD.
	 * @return -> la entidad almacenada.
	 */
	public User save(User u) {
		Role role = roleServ.searchByName("USER");
		if(role == null) { role = new Role("USER"); } 
		u.setPassword(passEncoder.encode(u.getPassword()));
		u.setRoles(Arrays.asList(role));
		return userRep.saveAndFlush(u);
	}
	
	/**
	 * Dado un id, nos devuelve un usuario que se corresponda con ese id.
	 * @param id -> id del usuario que queremos buscar.
	 * @return -> devuelve objeto user que se corresponda. En caso de no existir devuelve null.
	 */
	public User searchById(Integer id) {
		return userRep.getById(id);
	}

	/**
	 * Dado un userName, nos devuelve la informacion del usuario que se corresponda con ese nombre.
	 * @throws UserNameNotFoundException en caso de que el usuario no exista en la BD.
	 * @param userName -> nombre de usuario del usuario que queremos buscar.
	 * @return -> devuelve objeto user que se corresponda. En caso de no existir devuelve null.
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRep.findByUsername(userName);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	/**
	 * Metodo necesario para convertir los roles de usuario en permisos de acceso.
	 * @param roles -> lista de roles pertenecientes a un usuario.
	 * @return -> conversion.
	 */
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	

	public User searchByUsername(String username) {
		return userRep.findByUsername(username);
	}
	
	public boolean addMovieToWatchLater(String id) {
		User user = searchByUsername(MoviEroleApplication.getLoggedUser());
		try {
			String[] ids = user.getWatchLater().split(";");
			System.out.println("Entro por aqui");
			for(String s : ids) {
				if(s.equals(id)) return false;
			}
			System.out.println("No esta en la lista");
			user.setWatchLater(user.getWatchLater() + id + ";");
		} catch (NullPointerException e) {
			user.setWatchLater(id + ";");
		}
		
		System.out.println(user.getWatchLater());
		userRep.saveAndFlush(user);
		return true;
	}
	
	public boolean addMovieToMyMovies(String id) {
		User user = searchByUsername(MoviEroleApplication.getLoggedUser());
		try {
			String[] ids = user.getMyMovies().split(";");
			for(String s : ids) {
				if(s.equals(id)) return false;
			}
			user.setMyMovies(user.getMyMovies() + id + ";");
		} catch (NullPointerException e) {
			user.setMyMovies(id + ";");
		}
		
		System.out.println(user.getMyMovies());
		userRep.saveAndFlush(user);
		return true;
	}
}
