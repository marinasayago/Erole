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

import com.erole.moviErole.MoviEroleApplication;
import com.erole.moviErole.APIQuery.Query;
import com.erole.moviErole.APIQuery.QueryController;
import com.erole.moviErole.APIQuery.model.contentQuery.ContentQuery;
import com.erole.moviErole.APIQuery.model.mostPopularQuery.MostPopularQuery;
import com.erole.moviErole.APIQuery.model.titleQuery.Result;
import com.erole.moviErole.model.Comment;
import com.erole.moviErole.service.CommentService;
import com.erole.moviErole.model.User;
import com.erole.moviErole.service.UserServiceImp;

import dataStructures.Tuple2;

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
	private CommentService commentServ;
	@Autowired
	private UserServiceImp userServ;
	
	/**
	 * recibe la consulta a realizar, ejecuta su llamada y muestra los resultados
	 * @param query consulta a realizar por el usuario
	 * @return direccion del archivo html donde se muestran los resultados
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("/app/query")
	public String doQuery(Query query, Model model) throws UnsupportedEncodingException{
		List<Result> result = QueryController.makeTitleQuery(query);
		if(result.toString().equals("[]")) {
			model.addAttribute("lista", result);
			model.addAttribute("loggedUser", userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));
			System.out.println("ERROR AL HACER LA BUSQUEDA EN LA API");
			return "/app/searchError";
		}else {
			System.out.println(result.toString());
			model.addAttribute("lista", result);
			model.addAttribute("loggedUser", userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));
			return "/app/searchResult";

		}
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
		Tuple2<List<Comment>, Double> tuple = commentServ.getCommentsFromContent(id);
		model.addAttribute("commentList", tuple._1());
		model.addAttribute("averageRating", tuple._2());
		model.addAttribute("loggedUser", userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));

		return "app/content";
	}
	
	@PostMapping("/app/comment")
	public String addComment(Comment newComment) {
		User loggedUser = userServ.searchByUsername(MoviEroleApplication.getLoggedUser());
		newComment.setUser(loggedUser);
		commentServ.saveComment(newComment);
		return "redirect:/app/content/" + newComment.getContentId();
	}
	
	/*@RequestMapping("/app/deleteComment/{id}")
	public String deleteComment(@PathVariable("id") Integer id) {
		
		return "redirect:/app/content/";
	}*/
	
	/**
	 * Recoge peticion de mostrar la pagina con el top de peliculas
	 * @return Direccion del HTML en cuestion
	 */
	@RequestMapping("/app/topMovies")
	public String topMovies(Model model) {
		List<MostPopularQuery> list = QueryController.topMoviesQuery(true);
		model.addAttribute("list", list);
		model.addAttribute("loggedUser", userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));
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
		model.addAttribute("loggedUser", userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));
		return "app/topMovies";
	}
	
	
	/**
	 * Método para acceder al perfil del propio usuario que está registrado. Esta página tendrá
	 * más funcionalidades que los perfiles de otros usuarios
	 * @param username
	 * @param model
	 * @return
	 */
	@GetMapping("/app/myUser")
	public String userProfilePage(Model model) {
		User usuario = userServ.searchByUsername(MoviEroleApplication.getLoggedUser());
		model.addAttribute("usr", usuario);
		List<ContentQuery> wl = QueryController.getContentList(usuario.getWatchLater());
		System.out.println(wl.toString());
		model.addAttribute("watchLater", wl);
		List<ContentQuery> mm = QueryController.getContentList(usuario.getMyMovies());
		System.out.println(mm.toString());
		model.addAttribute("myMovies", mm);
		return "app/profile";
	}
	
	/**
	 * Método para entrar en el perfil de otro usuario, donde no tendremos las funcionalidades que sí
	 * tenemos en nuestro propio perfil (como editarlo o borrar elementos de las listas) 
	 * @param username
	 * @param model
	 * @return
	 */
	
	@GetMapping("app/user/{usr}")
	public String anotherUserProfilePage(@PathVariable("usr") String username, Model model) {
		User usuario = userServ.searchByUsername(username);
		model.addAttribute("usr", usuario);
		User loggedUser = userServ.searchByUsername(MoviEroleApplication.getLoggedUser());
		model.addAttribute("loggedUser", loggedUser);
		List<ContentQuery> wl = QueryController.getContentList(usuario.getWatchLater());
		System.out.println(wl.toString());
		model.addAttribute("watchLater", wl);
		List<ContentQuery> mm = QueryController.getContentList(usuario.getMyMovies());
		System.out.println(mm.toString());
		model.addAttribute("myMovies", mm);
		return "app/otherProfile";
	}
	
	@RequestMapping("/app/about")
	public String about(Model model) {
		model.addAttribute("loggedUser", userServ.searchByUsername(MoviEroleApplication.getLoggedUser()));
		return "app/about";
	}
	
	@RequestMapping("/app/watchLater/{id}")
	public String saveMovieToWatchLater(@PathVariable("id") String id) {
		userServ.addMovieToWatchLater(id);
		return "redirect:/app/content/" + id;
	}
	
	@RequestMapping("/app/myMovies/{id}")
	public String saveMovieToMyMovies(@PathVariable("id") String id) {
		userServ.addMovieToMyMovies(id);
		return "redirect:/app/content/" + id;
	}
	
	@RequestMapping("/app/deleteMyMovies/{id}")
	public String deleteMovieFromMyMovies(@PathVariable("id") String id) {
		userServ.deleteMovieFromMyMovies(id);
		return "redirect:/app/myUser";
	}
	
	@RequestMapping("/app/deleteWatchLater/{id}")
	public String deleteMovieFromWatchLater(@PathVariable("id") String id) {
		userServ.deleteMovieFromWatchLater(id);
		return "redirect:/app/myUser";
	}
	
	@RequestMapping("/app/deleteComment/{idCont}/{idComen}")
	public String deleteComment(@PathVariable("idCont") String idCont, 
			@PathVariable("idComen") String idComen) {
		commentServ.deleteComment(Integer.parseInt(idComen));
		return "redirect:/app/content/" + idCont;
	}
}
