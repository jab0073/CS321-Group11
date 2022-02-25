package edu.uah.cs321;

import java.io.IOException;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: Main
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws IOException {

		ResourceUtils.init();

		User u;
		if(!AuthSystem.checkUserName("master")) {
			u = AuthSystem.addUser("master", "password");
			u.setFirstName("master");
			u.setLastName("account");
			u.setAboutMe("master account");
			//UserDatabase.addUser(u);
		}
		else {
			u = AuthSystem.login("master", "password");
		}
		System.out.println(u);

		/*
		
		JsonReader js = new JsonReader();

		List<Movie> movies = js.getMasterMovieList();

		movies.forEach(m -> System.out.println(m.toString()));

		MovieList ml = new MovieList(movies);

		List<Movie> yearList = ml.filterByYear(2000, '>');

		yearList.forEach(m -> System.out.println("year filter > 2000: " + m.getTitle() + " year: " + m.getYear()));

		List<Movie> actorListByGt2000 = ml.filterByActor("Zendaya");

		actorListByGt2000.forEach(m -> System.out.println("year filter > 2000 and actors include Zendaya: " + m.getTitle() + " year: " + m.getYear() + " actors: " + String.join(", ",m.getActors())));

		ml.clearFilteredList();

		//ml.getAllTitles().forEach(m -> System.out.println("get all titles: " + m));

		String key = "Star";

		ml.searchForMovie(key).forEach(m ->  System.out.println("search: " + m.getTitle()));*/

		AuthSystem.close();
		UserDatabase.close();
	}
}
