package edu.uah.cs321;

import edu.uah.cs321.Backend.JsonReader;
import edu.uah.cs321.Backend.MasterMovieListCache;
import edu.uah.cs321.Backend.ResourceUtils;
import edu.uah.cs321.Frontend.Application;

import java.io.IOException;

/***
 * File Name: Main
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws IOException {

		ResourceUtils.init();
		//JsonReader js = new JsonReader();
		MasterMovieListCache.init();
		Application app = new Application("GoodWatches");
		app.setVisible(true);








	}
}
