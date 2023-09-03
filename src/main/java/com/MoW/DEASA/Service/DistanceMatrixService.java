package com.MoW.DEASA.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DistanceMatrixService {
	
	private static final String API_KEY = "AIzaSyDwQBEos3sYt-AqeOdQPg07zx7IQnsYrHg";
	
	public static float[][] distance;
	public static float[][] times;

//	DOWNLOAD DATA
	public static void getData(String source, String destination) throws Exception {
		var url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + source +
				"&destinations=" + destination + "&key=" + API_KEY;
       var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
       var client = HttpClient.newBuilder().build();
       var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
       
//       System.out.println(response);
       long distance = -1L;
       long time = -1L;
       
       
//       PARSE DATA
       JSONParser jp = new JSONParser();
       JSONObject jo = (JSONObject) jp.parse(response);
       JSONArray ja = (JSONArray) jo.get("rows");
       
       jo = (JSONObject) ja.get(0);
       ja = (JSONArray) jo.get("elements");
       jo = (JSONObject) ja.get(0);
       
       JSONObject je = (JSONObject) jo.get("distance");
       JSONObject jf = (JSONObject) jo.get("duration");
       
       distance = (long) je.get("value");
       time = (long) jf.get("value");
       
       
       System.out.println(je.toString());
       System.out.println(jf.toString());
	}
}
