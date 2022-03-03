package edu.uah.cs321;

import java.io.IOException;
import java.util.List;

import edu.uah.cs321.Backend.*;
import edu.uah.cs321.Frontend.Application;

/***
 * Project Name: GroupProject-InitialThoughts
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
		User u;
		if(!AuthSystem.checkUserName("master")) {
			u = AuthSystem.addUser("master", "account","master","password");
			u.setAboutMe("master account");
		}
		else {
			u = new User("master","account","master account","master");
		}
		System.out.println(u);

		User p = AuthSystem.login("master", "password");

		System.out.println(p);



		List<Movie> movies = JsonReader.getMasterMovieList();

		MovieList ml = new MovieList(movies);

		List<Movie> yearList = ml.filterByYear(2000, '>');

		yearList.forEach(m -> System.out.println("year filter > 2000: " + m.getTitle() + " year: " + m.getYear()));

		List<Movie> actorListByGt2000 = ml.filterByActor("Zendaya");

		actorListByGt2000.forEach(m -> System.out.println("year filter > 2000 and actors include Zendaya: " + m.getTitle() + " year: " + m.getYear() + " actors: " + String.join(", ",m.getActors())));

		ml.clearFilteredList();

		//ml.getAllTitles().forEach(m -> System.out.println("get all titles: " + m));

		String key = "Star";

		ml.searchForMovie(key).forEach(m ->  System.out.println("search: " + m.getTitle()));

		AuthSystem.close();
		UserDatabase.close();
	}
}
