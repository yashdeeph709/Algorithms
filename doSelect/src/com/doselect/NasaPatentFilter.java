package com.doselect;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NasaPatentFilter{
	public static void main(String args[]) throws Exception{
		URL url = new URL("https://api.nasa.gov/patents/content?query=temperature&limit=5&api_key=DEMO_KEY");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept","application/json");
		
		if( conn.getResponseCode() != 200 ){
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String output,fullResponse="";
		System.out.println("Output from Server -- \n");

		while( (output = br.readLine())!=null){
			fullResponse+=output;	
		}
		System.out.println(fullResponse);
		JSONParser parser = new JSONParser();
		JSONObject obj =(JSONObject)parser.parse(fullResponse);
		System.out.println(obj);
		conn.disconnect();

	}
}
