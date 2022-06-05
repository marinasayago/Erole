package com.erole.moviErole;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.erole.moviErole.model.Comment;
import com.erole.moviErole.model.User;

public class CommentTest {

	Comment comment;
	
	@BeforeEach
	public void inic() {
		comment = new Comment();
	}
	
	@AfterEach
	public void terminate() {
		comment = null;
	}

	@Test //Un comentario sin argumentos no contiene información
	void inicialmenteEstaVacio() {
		assertEquals(comment.getId(), null);
	}

	@Test //Tras insertar datos, el comentario contiene información
	void contieneInformacion() {
		User user = new User();
		comment = new Comment(user, "1", "comment", 0); //Creamos un objeto de tipo comentario
		assertEquals(false, comment.getUser() == null);
		assertEquals(false, comment.getContentId() == null);
		assertEquals(false, comment.getText() == null);
	}
	
}

