package com.erole.moviErole.APIQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.erole.moviErole.APIQuery.model.contentQuery.Actor;
import com.erole.moviErole.APIQuery.model.contentQuery.ContentQuery;
import com.erole.moviErole.APIQuery.model.contentQuery.Similar;
import com.erole.moviErole.APIQuery.model.titleQuery.Result;

/**
 * Esta clase sera la encargada de gestionar todas las peticiones que se quieran hacer a la api
 * @author pepes
 *
 */
public class QueryController {
	private static HttpsURLConnection connection;
	private static final String[] APIKey = {"k_92xgf69t"};	//"k_97ji7chr", 
	private static final String URL = "https://imdb-api.com/en/API/";
	
	/**
	 * recibiendo los campos de la consulta del usuario, la realiza y devuelve los resultados en forma de lista de objetos resultado
	 * @param query campos de la consulta a realizar
	 * @return lista de resultados
	 */
	public static List<Result> makeTitleQuery(Query query) {
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		List<Result> list = null;
		Random rnd = new Random();
		
		
		try {
			URL url = new URL(URL + query.getType() + "/" + APIKey[rnd.nextInt()%APIKey.length] + "/" + query.getKeyWord());
			connection = (HttpsURLConnection) url.openConnection();
			
			/*establece los parametros de la conexion
			 * GET porque lo que queremos es obtener el resultado de la busqueda
			 * y 5000 ms para que si a los 5 segundos no se establece la conexion, directamente se corte y mostremos mensaje de error
			 */
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();	//200 representa conexion establecida
			
			if(status > 299) {
				//en caso de error, leemos el error que obtenemos
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}else {
				//en otro caso, leemos el resultado obtenido de la consulta
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			}
			while((line = reader.readLine()) != null)
				responseContent.append(line);
			
			reader.close();
		} catch (MalformedURLException e) {
			
		} catch (IOException e) {

		}finally {
			connection.disconnect();			
			list = parseToResultList("[" + responseContent.toString().split("\\[")[1]);
		}
		
		return list;
	}
	
	/**
	 * Dado un string en formato JSON, extrae la informacion de cada campo y crea una
	 * lista de objetos Result
	 * @param response El string en formato JSON
	 * @return Lista de objetos de la clase Result, que representa los resultados de una busqueda por titulo
	 */
	public static List<Result> parseToResultList(String response) {
		JSONArray results = new JSONArray(response);
		List<Result> list = new ArrayList<Result>();
		for(int i = 0; i < results.length(); i++) {
			JSONObject obj = results.getJSONObject(i);
			String id = obj.getString("id");
			String resultType = obj.getString("resultType");
			String image = obj.getString("image");
			String title = obj.getString("title");
			String desc = obj.getString("description");
			
			Result newObj = new Result(id, resultType, image, title, desc);
			list.add(newObj);
		}
		
		
		return list;
	}
	
	public static ContentQuery contentQuery(String id) {
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		Random rnd = new Random();
		
		String URI = URL + "Title/" + APIKey[rnd.nextInt()%APIKey.length] + "/" + id;
		
		try {
			URL url = new URL(URI);
			connection = (HttpsURLConnection) url.openConnection();
			
			/*establece los parametros de la conexion
			 * GET porque lo que queremos es obtener el resultado de la busqueda
			 * y 5000 ms para que si a los 5 segundos no se establece la conexion, directamente se corte y mostremos mensaje de error
			 */
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();	//200 representa conexion establecida
			
			if(status > 299) {
				//en caso de error, leemos el error que obtenemos
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}else {
				//en otro caso, leemos el resultado obtenido de la consulta
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			}
			while((line = reader.readLine()) != null)
				responseContent.append(line);
			
			reader.close();
		} catch (MalformedURLException e) {
			
		} catch (IOException e) {

		}
		
		System.out.println(responseContent.toString());
		ContentQuery content = parseToContentQuery(responseContent.toString());
		
		return content;
	}
	
	public static ContentQuery parseToContentQuery(String result) {
		JSONObject obj = new JSONObject(result);
		String id = obj.getString("id");
		String title = obj.getString("title");
		String originalTitle = obj.getString("originalTitle");
		String type = obj.getString("type");
		String year = obj.getString("year");
		String image = obj.getString("image");
		String releaseDate = obj.getString("releaseDate");
		String runtimeMins = null;
		if(type.contentEquals("Movie")) {
			runtimeMins = obj.getString("runtimeMins");
		}
	    String plot = obj.getString("plot");
	    String awards = obj.getString("awards");
	    String directors = obj.getString("directors");
	    String writers = obj.getString("writers");
	    String stars = obj.getString("stars");
	    List<Actor> actorList = new ArrayList<Actor>();
	    String genres = obj.getString("genres");
	    String companies = obj.getString("companies");
	    String countries = obj.getString("countries");
	    String languages = obj.getString("languages");
	    String contentRating = obj.getString("contentRating");
	    String imDbRating = obj.getString("imDbRating");
	    String imDbRatingVotes = obj.getString("imDbRatingVotes");
	    String metacriticRating = obj.getString("metacriticRating");
	    //Object trailer = obj.getString("trailer");
	    //Object tagline = obj.getString("tagline");
	    String keywords = obj.getString("keywords");
	    List<Similar> similars = new ArrayList<Similar>();
	    //String errorMessage = obj.getString("errorMessage");
	    
	    JSONArray actorsJSON = obj.getJSONArray("actorList");
	    for(int i = 0; i < actorsJSON.length(); i++) {
	    	JSONObject act = actorsJSON.getJSONObject(i);
	    	String actId = act.getString("id");
	    	String actImage = act.getString("image");
	    	String actName = act.getString("name");
	    	String actAsCharacter = act.getString("asCharacter");
	    	Actor actor = new Actor(actId, actImage, actName, actAsCharacter);
	    	actorList.add(actor);
	    }
	    
	    JSONArray similarJSON = obj.getJSONArray("similars");
	    for(int i = 0; i < similarJSON.length(); i++) {
	    	JSONObject sim = similarJSON.getJSONObject(i);
	    	String simId = sim.getString("id");
	    	String simTitle = sim.getString("title");
	    	String simImage = sim.getString("image");
	    	String simimDbRating = sim.getString("imDbRating");
	    	Similar similar = new Similar(simId, simTitle, simImage, simimDbRating);
	    	similars.add(similar);
	    }
	    
	    ContentQuery content = new ContentQuery(id, title, originalTitle, type, year, image, releaseDate, runtimeMins, plot, awards, directors, writers, stars, actorList, genres, companies, countries, languages, contentRating, imDbRating, imDbRatingVotes, metacriticRating, null, null, keywords, similars, null);
		
		
		return content;
	}
}
