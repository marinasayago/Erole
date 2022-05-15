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

class ActorTest {

	Actor actor;

	@BeforeEach
	public void inic() {
		actor = new Actor();
	}
	
	@AfterEach
	public void terminate() {
		actor = null;
	}
	
	@Test //Un actor sin argumentos no contiene información
	void inicialmenteEstaVacio() {
		assertEquals(actor.getName(), null);
	}

	@Test //Tras insertar datos, el usuario contiene información
	void contieneInformacion() {
		actor = new Actor("id", "image", "name", "asCharacter");
		/*public User(String email, String userName, String password, String name, String surname, Date birthdate,
				String bio, Collection<Role> roles)*/
		assertEquals(false, actor.getId().isEmpty());
		assertEquals(false, actor.getImage().isEmpty());
		assertEquals(false, actor.getName().isEmpty());
		assertEquals(false, actor.getName().isEmpty());
	}
	
	@Test //Tras cambiar los atributos a unos diferentes, debería ser distintos al actor original
	void setTest() {
		actor = new Actor("id", "image", "name", "asCharacter");
		Actor auxActor = actor;
		auxActor.setId("id2");
		auxActor.setImage("image2");
		auxActor.setName("name2");
		auxActor.setAsCharacter("asCharacter2");
		assertEquals(false, actor.getId().compareTo(auxActor.getId()) != 0);
		assertEquals(false, actor.getImage().compareTo(auxActor.getImage()) != 0);
		assertEquals(false, actor.getName().compareTo(auxActor.getName()) != 0);
		assertEquals(false, actor.getAsCharacter().compareTo(auxActor.getAsCharacter()) != 0);
	}
	
}
