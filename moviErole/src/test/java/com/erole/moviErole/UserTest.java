package com.erole.moviErole;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.erole.moviErole.APIQuery.model.contentQuery.Actor;
import com.erole.moviErole.model.Role;
import com.erole.moviErole.model.User;

class UserTest {

	User user;
	
	@BeforeEach
	public void inic() {
		user = new User();
	}
	
	@AfterEach
	public void terminate() {
		user = null;
	}
	
	@Test //Un usuario sin argumentos no contiene información
	void inicialmenteEstaVacio() {
		assertEquals(user.getName(), null);
	}

	@Test //Tras insertar datos, el usuario contiene información
	void contieneInformacion() {
		@SuppressWarnings("deprecation")
		Date date = new Date(1,1,1);
		Collection<Role> roles;
		Role rol = new Role("Rol");
		roles = new LinkedList<Role>();
		roles.add(rol);
		user = new User("email", "userName", "password", "name", "surname", date,
				"bio", roles);
		/*public User(String email, String userName, String password, String name, String surname, Date birthdate,
				String bio, Collection<Role> roles)*/
		assertEquals(false, user.getEmail().isEmpty());
		assertEquals(false, user.getName().isEmpty());
		assertEquals(false, user.getPassword().isEmpty());
		assertEquals(false, user.getUserName().isEmpty());
		assertEquals(false, user.getSurname().isEmpty());
		assertEquals(false, user.getBirthdate().equals(null));
		assertEquals(false, user.getBio().isEmpty());
		assertEquals(false, user.getRoles().isEmpty());
	}
	
	@Test //Tras cambiar los atributos a unos diferentes, debería ser distintos al usuario original
	void setTest() {
		@SuppressWarnings("deprecation")
		Date date = new Date(1,1,1);
		@SuppressWarnings("deprecation")
		Date date2 = new Date(2,2,2);
		Collection<Role> roles;
		Role rol = new Role("Rol");
		roles = new LinkedList<Role>();
		roles.add(rol);
		user = new User("email", "userName", "password", "name", "surname", date,
				"bio", roles);
		User auxUser = user;
		auxUser.setBio("bio2");
		auxUser.setBirthdate(date2);
		auxUser.setEmail("email2");
		auxUser.setName("name2");
		auxUser.setPassword("password2");
		Collection<Role> rolesAux;
		Role rolAux = new Role("Rol2");
		rolesAux = new LinkedList<Role>();
		rolesAux.add(rolAux);
		auxUser.setRoles(rolesAux);
		auxUser.setSurname("surname2");
		auxUser.setUserName("userName2");
		assertEquals(false, user.getEmail().compareTo(auxUser.getEmail()) != 0);
		assertEquals(false, user.getUserName().compareTo(auxUser.getUserName()) != 0);
		assertEquals(false, user.getPassword().compareTo(auxUser.getPassword()) != 0);
		assertEquals(false, user.getName().compareTo(auxUser.getName()) != 0);
		assertEquals(false, user.getSurname().compareTo(auxUser.getSurname()) != 0);
		assertEquals(false, user.getBirthdate().compareTo(auxUser.getBirthdate()) != 0);
		assertEquals(false, user.getBio().compareTo(auxUser.getBio()) != 0);
		assertEquals(true, user.getRoles().containsAll(auxUser.getRoles()));
	}
	
}
