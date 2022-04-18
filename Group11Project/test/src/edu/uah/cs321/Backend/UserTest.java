package src.edu.uah.cs321.Backend;

import edu.uah.cs321.Backend.Movie;
import org.junit.Test;

import edu.uah.cs321.Backend.User;

import java.util.List;

/***
 * Project Name: Group11Project
 * File Name: UserTest
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class UserTest {
	@Test
	public void CreateUserTest() {
		User u = new User("test","account","i like to test","test");
		u.setFavoriteActors(List.of("Joe Smith"));
		u.setFavoriteDirectors(List.of("John Smith"));
		Movie testMovie = new Movie("Test Movie","Test Plot","PG-13","2022");
		testMovie.setGenre(List.of("Funny","Comedy","Something"));
		u.addMovieToFavoriteMovies(testMovie);

		assert(u.getFirstName() == "test");
		assert(u.getLastName() == "account");
		assert(u.getUserName() == "test");
		assert(u.getAboutMe() == "i like to test");
		assert(u.getFavoriteActors().get(0) == "Joe Smith");
		assert(u.getFavoriteDirectors().get(0) == "John Smith");
		assert(u.getFavoriteMovies().get(0).getTitle() == "Test Movie");
	}
}
