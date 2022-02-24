package edu.uah.cs321;

import java.io.IOException;
import java.util.List;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: Main
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class Main {

	private static MovieList ml;

	public static void main(String[] args) throws IOException {

		JsonReader js = new JsonReader();

		List<Movie> movies = js.getMasterMovieList();

		//movies.forEach(m -> System.out.println(m.toString()));

		MovieList ml = new MovieList(movies);

		List<Movie> yearList = ml.filterByYear(2000, '>');

		yearList.forEach(m -> System.out.println("year filter > 2000: " + m.getTitle() + " year: " + m.getYear()));

		List<Movie> actorListByGt2000 = ml.filterByActor("Zendaya");

		actorListByGt2000.forEach(m -> System.out.println("year filter > 2000 and actors include Zendaya: " + m.getTitle() + " year: " + m.getYear() + " actors: " + String.join(", ",m.getActors())));

		ml.clearFilteredList();

		//ml.getAllTitles().forEach(m -> System.out.println("get all titles: " + m));

		String key = "Star";

		ml.searchForMovie(key).forEach(m ->  System.out.println("search: " + m.getTitle()));
	}
}
