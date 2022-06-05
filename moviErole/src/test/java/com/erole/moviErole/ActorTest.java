package com.erole.moviErole;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.erole.moviErole.APIQuery.model.contentQuery.Actor;

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

	@Test //Tras insertar datos, el actor contiene información
	void contieneInformacion() {
		actor = new Actor("id", "image", "name", "asCharacter");
		
		assertEquals(false, actor.getId().isEmpty());
		assertEquals(false, actor.getImage().isEmpty());
		assertEquals(false, actor.getName().isEmpty());
		assertEquals(false, actor.getName().isEmpty());
	}
	
	@Test //Tras cambiar los atributos a unos diferentes, debería ser distintos al actor original
	void setTest() {
		Actor actor1 = mock(Actor.class); //Creamos los mock de dos objetos Actor
		Actor actor2 = mock(Actor.class);
			
		String id1 = "1";
		String id2 = "2";
		
		when(actor1.getId()).thenReturn(id1); //Asignamos los id de los actores
		when(actor2.getId()).thenReturn(id2);
		actor1.setId(id2); //Cambiamos el id del primer actor
			
		String img1 = "1";
		String img2 = "2";
			
		when(actor1.getImage()).thenReturn(img1); //Asignamos las imagenes
		when(actor2.getImage()).thenReturn(img2);
		actor1.setImage(img2); //Cambiamos la imagen del primer actor
			
		String name1 = "1";
		String name2 = "2";
			
		when(actor1.getName()).thenReturn(name1); //Asignamos los nombres
		when(actor2.getName()).thenReturn(name2);
		actor1.setName(name2); //Cambiamos el nombre del primer actor
			
		String char1 = "1";
		String char2 = "2";
			
		when(actor1.getAsCharacter()).thenReturn(char1); //Asigna los papeles
		when(actor2.getAsCharacter()).thenReturn(char2);
		actor1.setAsCharacter(char2); //Cambia el papel del primer actor
			
		assertEquals(false, actor1.getId().equals(actor2.getId())); //Comprueba el id
		assertEquals(false, actor1.getImage().equals(actor2.getImage())); //Comprueba la imagen
		assertEquals(false, actor1.getName().equals(actor2.getName())); //Comprueba el nombre
		assertEquals(false, actor1.getAsCharacter().equals(actor2.getAsCharacter())); //Comprueba el personaje
	}
	
}
