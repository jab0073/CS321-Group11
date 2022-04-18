package src.edu.uah.cs321.Backend;

import edu.uah.cs321.Backend.Movie;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/***
 * Project Name: Group11Project
 * File Name: MovieTest
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class MovieTest {
	@Test
	public void CreateMovieTest() {
		Movie test = new Movie();
		test.setTitle("test");
		test.setPlot("test movie plot");
		test.setActors(List.of("Joe","John","Ford","Smith"));
		test.setDirector("Ima Director");
		test.setWriter("Yoo Uhwritter");
		test.setRating("PG-13");

		assert(Objects.equals(test.getTitle(), "test"));
		assert(Objects.equals(test.getPlot(), "test movie plot"));
		assert(test.getActors().equals(List.of("Joe","John","Ford","Smith")));
		assert(test.getDirector().equals("Ima Director"));
		assert(test.getWriter().equals("Yoo Uhwritter"));
		assert(test.getRating().equals("PG-13"));
	}
}
