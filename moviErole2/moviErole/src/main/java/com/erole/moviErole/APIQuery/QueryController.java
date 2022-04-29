package com.erole.moviErole.APIQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.erole.moviErole.APIQuery.model.titleQuery.Result;

public class QueryController {
	private static HttpsURLConnection connection;
	private static final String APIKey = "k_97ji7chr";
	private static final String URL = "https://imdb-api.com/en/API/";
	
	/**
	 * recibiendo los campos de la consulta del usuario, la realiza y devuelve los resultados
	 * @param query campos de la consulta a realizar
	 * @return el resultado de la consulta
	 * @throws UnsupportedEncodingException 
	 */
	public static List<Result> makeTitleQuery(Query query) {
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		List<Result> list = null;
		
		
		try {
			URL url = new URL(URL + query.getType() + "/" + APIKey + "/" + query.getKeyWord());
			connection = (HttpsURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();	//200 representa conexion establecida
			//System.out.println(status);
			
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
			System.out.println(newObj);
		}
		
		
		return list;
	}
}
