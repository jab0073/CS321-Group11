package edu.uah.cs321;

import java.io.IOException;

import edu.uah.cs321.Backend.*;
import edu.uah.cs321.Frontend.Application;

/***
 * File Name: Main
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws IOException {

		Application app = new Application("GoodWatches");
		app.setVisible(true);

		ResourceUtils.init();

		JsonReader js = new JsonReader();




	}
}
