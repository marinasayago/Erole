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
				"bio", roles, "watchLater", "myMovies");

		assertEquals(false, user.getEmail().isEmpty());
		assertEquals(false, user.getName().isEmpty());
		assertEquals(false, user.getPassword().isEmpty());
		assertEquals(false, user.getUserName().isEmpty());
		assertEquals(false, user.getSurname().isEmpty());
		assertEquals(false, user.getBirthdate().equals(null));
		assertEquals(false, user.getBio().isEmpty());
		assertEquals(false, user.getRoles().isEmpty());
		assertEquals(false, user.getMyMovies().isEmpty());
		assertEquals(false, user.getWatchLater().isEmpty());
	} 

	
	public void setTest(){
		User user1 = mock(User.class); //Creamos mock de dos objetos usuario
		User user2 = mock(User.class);
		
		Integer id1 = 0;
		Integer id2 = 1;
		
		when(user1.getId()).thenReturn(id1); //Asignamos un identificador
		when(user2.getId()).thenReturn(id2); 
		user1.setId(id2); //Cambiamos el identificador del primer usuario al del segundo
		
		Collection<Role> roles1;
		Role rol1 = new Role("Rol1");
		roles1 = new LinkedList<Role>();
		roles1.add(rol1);
		
		Collection<Role> roles2;
		Role rol2 = new Role("Rol2");
		roles2 = new LinkedList<Role>();
		roles2.add(rol2);
		
		when(user1.getRoles()).thenReturn(roles1); //Asignamos los roles
		when(user2.getRoles()).thenReturn(roles2);
		user1.setRoles(roles2); //Cambiamos el rol del primer usuario
		
		@SuppressWarnings("deprecation")
		Date date1 = new Date(1,1,1);
		@SuppressWarnings("deprecation")
		Date date2 = new Date(2,2,2);
		
		when(user1.getBirthdate()).thenReturn(date1); //Asignamos las fechas
		when(user2.getBirthdate()).thenReturn(date2);
		user1.setBirthdate(date2); //Cambiamos la fecha de nacimiento del primer usuario
		
		String email1 = "1";
		String email2 = "2";
		
		when(user1.getEmail()).thenReturn(email1); //Asignamos los emails
		when(user2.getEmail()).thenReturn(email2);
		user1.setEmail(email2); //Cambiamos el email del primer usuario
		
		String uName1 = "1";
		String uName2 = "2";
		
		when(user1.getUserName()).thenReturn(uName1); //Asignamos los nombres de usuario
		when(user2.getUserName()).thenReturn(uName2);
		user1.setUserName(uName2); //Cambiamos el nombre de usuario del primer usuario
		
		String pass1 = "1";
		String pass2 = "2";
		
		when(user1.getPassword()).thenReturn(pass1); //Asignamos la contrasenya
		when(user2.getPassword()).thenReturn(pass2);
		user1.setPassword(pass2); //Cambiamos la contrasenya del primer usuario
		
		String name1 = "1";
		String name2 = "2";
		
		when(user1.getName()).thenReturn(name1); //Asignamos los nombres
		when(user2.getName()).thenReturn(name2);
		user1.setName(name2); //Cambiamos el nombre del primer usuario
		
		String sur1 = "1";
		String sur2 = "2";
		
		when(user1.getSurname()).thenReturn(sur1); //Asignamos el apellido
		when(user2.getSurname()).thenReturn(sur2);
		user1.setSurname(sur2); //Cambiamos el apellido del primer usuario
		
		String bio1 = "1";
		String bio2 = "2";
		
		when(user1.getBio()).thenReturn(bio1); //Asignamos la bio
		when(user2.getBio()).thenReturn(bio2);
		user1.setBio(bio2); //Cambiamos la bio del primer usuario
		
		String wL1 = "1";
		String wL2 = "2";
		when(user1.getWatchLater()).thenReturn(wL1); //Asignamos la lista de ver mas tarde
		when(user2.getWatchLater()).thenReturn(wL2);
		user1.setWatchLater(wL2); //Cambiamos la del primer usuario
		
		String mMovies1 = "1";
		String mMovies2 = "2";
		
		when(user1.getMyMovies()).thenReturn(mMovies1); //Asignamos la lista de peliculas
		when(user2.getMyMovies()).thenReturn(mMovies2);
		user1.setMyMovies(mMovies2); //Cambiamos la del primer usuario
		
		assertEquals(false, user1.getId().equals(user2.getId())); //Comprueba el id
		assertEquals(false, user1.getRoles().equals(user2.getRoles())); //Comprueba los roles
		assertEquals(false, user1.getBirthdate().equals(user2.getBirthdate())); //Comprueba la fecha
		assertEquals(false, user1.getEmail().equals(user2.getEmail())); //Comprueba el email
		assertEquals(false, user1.getUserName().equals(user2.getUserName())); //Comprueba el nombre de usuario
		assertEquals(false, user1.getPassword().equals(user2.getPassword())); //Comprueba la contrasenya
		assertEquals(false, user1.getName().equals(user2.getName())); //Comprueba el nombre
		assertEquals(false, user1.getSurname().equals(user2.getSurname())); //Comprueba el usuario
		assertEquals(false, user1.getBio().equals(user2.getBio())); //Comprueba la bio
		assertEquals(false, user1.getMyMovies().equals(user2.getMyMovies())); //Comprueba la lista de peliculas
		assertEquals(false, user1.getWatchLater().equals(user2.getWatchLater())); //Comprueba la lista de ver mas tarde
		
	}

	
}
