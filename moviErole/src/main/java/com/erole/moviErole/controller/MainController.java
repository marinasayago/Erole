package com.erole.moviErole.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erole.moviErole.APIQuery.Query;
import com.erole.moviErole.APIQuery.QueryController;
import com.erole.moviErole.APIQuery.model.contentQuery.ContentQuery;
import com.erole.moviErole.APIQuery.model.mostPopularQuery.MostPopularQuery;
import com.erole.moviErole.APIQuery.model.titleQuery.Result;
import com.erole.moviErole.model.Comment;
import com.erole.moviErole.service.CommentService;

/**
 * Esta clase servira para gestionar las peticiones del usuario en el navegador que se realicen dentro de la pagina ppal,
 *  es decir, cuando el usuario introduzca una direccion en el navegador, se buscara en este metodo si hay alguna
 * etiquete @RequestMapping, @PostMapping que se corresponda.
 * En caso de haberla, se procede a ejecutar el metodo asosciado.
 * En otro caso, recibiremos un error 404 en el navegador.
 * @author pepes
 *
 */

@Controller
public class MainController {
	@Autowired
	CommentService commentServ;
	
	/**
	 * recibe la consulta a realizar, ejecuta su llamada y muestra los resultados
	 * @param query consulta a realizar por el usuario
	 * @return direccion del archivo html donde se muestran los resultados
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("/app/query")
	public String doQuery(Query query, Model model) throws UnsupportedEncodingException{
		List<Result> result = QueryController.makeTitleQuery(query);
		if(result == null) {
			System.out.println("ERROR AL HACER LA BUSQUEDA EN LA API");
		}else {
			System.out.println(result.toString());
			model.addAttribute("lista", result);
		}
		return "/app/searchResult";
	}
	
	/**
	 * Recoge la peticion de trasladarnos a la pagina con toda la informacion de una pelicula
	 * @param id Identificador del contenido en la API
	 * @return La direccion del HTML a cargar en navegador
	 */
	@RequestMapping("/app/content/{id}")
	public String contentPage(@PathVariable("id") String id, Model model) {
		ContentQuery result = QueryController.contentQuery(id);
		model.addAttribute("result", result);
		model.addAttribute("newComment", new Comment(null, id, null, 0));
		model.addAttribute("commentList", commentServ.getCommentsFromContent(id));

		return "app/content";
	}
	
	@PostMapping("/app/comment")
	public String addComment(Comment newComment) {
		commentServ.saveComment(newComment);
		return "redirect:/app/content/" + newComment.getContentId();
	}
	
	/**
	 * Recoge peticion de mostrar la pagina con el top de peliculas
	 * @return Direccion del HTML en cuestion
	 */
	@RequestMapping("/app/topMovies")
	public String topMovies(Model model) {
		List<MostPopularQuery> list = QueryController.topMoviesQuery(true);
		model.addAttribute("list", list);
		return "app/topMovies";
	}
	
	/**
	 * Recoge peticion de mostrar la pagina con el top de series
	 * @return Direccion del HTML en cuestion
	 */
	@RequestMapping("/app/topSeries")
	public String topSeries(Model model) {
		List<MostPopularQuery> list = QueryController.topMoviesQuery(false);
		model.addAttribute("list", list);
		return "app/topMovies";
	}
}
