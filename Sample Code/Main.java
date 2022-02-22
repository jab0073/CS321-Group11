package edu.uah.cs321;

import java.util.List;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: Main
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		Movie FellowshipOfTheRings = new Movie("Lord of the Rings: Fellowship of the Ring", "A 2001 epic fantasy adventure film directed by Peter Jackson, based on the 1954 novel The Fellowship of the Ring,\nthe first volume of J. R. R. Tolkien's The Lord of the Rings.\n\nThe film is the first installment in the Lord of the Rings trilogy.\n\nSet in Middle-earth, the story tells of the Dark Lord Sauron, who seeks the One Ring, which contains part of his soul,in order to return to power.\nThe Ring has found its way to the young hobbit Frodo Baggins.The fate of Middle-earth hangs in the balance as Frodo and eight companions\n(who form the Fellowship of the Ring) begin their journey to Mount Doom in the land of Mordor,the only place where the Ring can be destroyed.", "PG-13", "2001");

		Movie GenericMovie = new Movie();
		GenericMovie.setTitle("Lord of the Rings: The Two Towers");
		if(GenericMovie.setRating("PG-13")) {
			System.out.println();
		}
		GenericMovie.setLanguage("English");
		GenericMovie.setDirector("Peter Jackson");
		GenericMovie.setYear(2002);
		MovieList ml = new MovieList();

		ml.addMovie(FellowshipOfTheRings);
		ml.addMovie(GenericMovie);

		List<Movie> yearList = ml.filterByYear(2001);

		yearList.forEach(m -> System.out.println("year filter: " + m.getTitle()));

		ml.clearFilteredList();

		ml.getAllTitles().forEach(m -> System.out.println("get all titles: " + m));

		String key = "Lord";

		ml.searchForMovie(key).forEach(m -> System.out.println("search: " + m.getTitle()));

	}
}
