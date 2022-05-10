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
	private static final String[] APIKey = {"k_92xgf69t","k_6xmd9wpr","k_wostrryl","k_53ahgski","k_9eekuzyy"};	//"k_97ji7chr",
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
			String cositas = URL + query.getType() + "/" + APIKey[rnd.nextInt(APIKey.length)] + "/" + query.getKeyWord();
			System.out.println(cositas);
			URL url = new URL(cositas);
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
			System.out.println(responseContent.toString());
			list = parseToResultList("[" + responseContent.toString().split("\\[")[1]);
		}
		System.out.println(responseContent.toString());
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
			String id = obj.optString("id");
			String resultType = obj.optString("resultType");
			String image = obj.optString("image");
			String title = obj.optString("title");
			String desc = obj.optString("description");
			
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
		
		String URI = URL + "Title/" + APIKey[rnd.nextInt(APIKey.length)] + "/" + id;
		System.out.println(URI);
		
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
		String id = obj.optString("id");
		String title = obj.optString("title");
		String originalTitle = obj.optString("originalTitle");
		String type = obj.optString("type");
		String year = obj.optString("year");
		String image = obj.optString("image");
		String releaseDate = obj.optString("releaseDate");
		String runtimeMins = null;
		if(type.contentEquals("Movie")) {
			runtimeMins = obj.optString("runtimeMins");
		}
	    String plot = obj.optString("plot");
	    String awards = obj.optString("awards");
	    String directors = obj.optString("directors");
	    String writers = obj.optString("writers");
	    String stars = obj.optString("stars");
	    List<Actor> actorList = new ArrayList<Actor>();
	    String genres = obj.optString("genres");
	    String companies = obj.optString("companies");
	    String countries = obj.optString("countries");
	    String languages = obj.optString("languages");
	    String contentRating = obj.optString("contentRating");
	    String imDbRating = obj.optString("imDbRating");
	    String imDbRatingVotes = obj.optString("imDbRatingVotes");
	    String metacriticRating = obj.optString("metacriticRating");
	    //Object trailer = obj.optString("trailer");
	    //Object tagline = obj.optString("tagline");
	    String keywords = obj.optString("keywords");
	    List<Similar> similars = new ArrayList<Similar>();
	    //String errorMessage = obj.optString("errorMessage");
	    
	    JSONArray actorsJSON = obj.getJSONArray("actorList");
	    for(int i = 0; i < actorsJSON.length(); i++) {
	    	JSONObject act = actorsJSON.getJSONObject(i);
	    	String actId = act.optString("id");
	    	String actImage = act.optString("image");
	    	String actName = act.optString("name");
	    	String actAsCharacter = act.optString("asCharacter");
	    	Actor actor = new Actor(actId, actImage, actName, actAsCharacter);
	    	actorList.add(actor);
	    }
	    
	    JSONArray similarJSON = obj.getJSONArray("similars");
	    for(int i = 0; i < similarJSON.length(); i++) {
	    	JSONObject sim = similarJSON.getJSONObject(i);
	    	String simId = sim.optString("id");
	    	String simTitle = sim.optString("title");
	    	String simImage = sim.optString("image");
	    	String simimDbRating = sim.optString("imDbRating");
	    	Similar similar = new Similar(simId, simTitle, simImage, simimDbRating);
	    	similars.add(similar);
	    }
	    
	    ContentQuery content = new ContentQuery(id, title, originalTitle, type, year, image, releaseDate, runtimeMins, plot, awards, directors, writers, stars, actorList, genres, companies, countries, languages, contentRating, imDbRating, imDbRatingVotes, metacriticRating, null, null, keywords, similars, null);
		
		
		return content;
	}
}
