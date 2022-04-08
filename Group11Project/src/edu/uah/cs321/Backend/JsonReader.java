package edu.uah.cs321.Backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/***
 * File Name: JsonReader
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public final class JsonReader {

	private static Gson gson;
	private static List<Movie> movieList;

	// Used to read the json file of the master movie list
	public JsonReader() throws IOException {
		gson = new Gson();
		Reader json = new InputStreamReader(ResourceUtils.getFile(Constants.jsonFileName));

		Type movieListType = new TypeToken<ArrayList<Movie>>(){}.getType();

		movieList = gson.fromJson(json, movieListType);
		ResourceUtils.setMasterMovieList(movieList);
	}

}
