package edu.uah.cs321.Backend;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

	private User userUnderTest;

	@Before
	public void setUp() {
		userUnderTest = new User("firstName", "lastName", "aboutMe", "userName");
	}

	@Test
	public void testGetEntitlementType() {
		assertTrue(userUnderTest.getEntitlementType());
	}

	@Test
	public void testAddReview() {
		// Setup
		final Review r = new Review(new User("firstName", "lastName", "aboutMe", "userName"),
				new Movie("title", "plot", "rating", "year", "released", "genre", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "actors"), 0, "body");

		// Run the test
		userUnderTest.addReview(r);

		// Verify the results
		assertTrue(userUnderTest.getReviews().contains(r));
	}

	@Test
	public void testCompareUserNameTo() {
		assertTrue(userUnderTest.compareUserNameTo("userName"));
	}

	@Test
	public void testGetThis() {
		// Setup
		final User expectedResult = new User("firstName", "lastName", "aboutMe", "userName");

		// Run the test
		final User result = userUnderTest.getThis();

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testAddMovieListToMovieLists() {
		// Setup
		List<Movie> movies = new java.util.ArrayList<>();
		movies.add(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director",
				"writer", "awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID",
				"type", "dvd", "boxOffice", "production", "website", "response", "actors"));
		movies.add(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director",
				"writer", "awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID",
				"type", "dvd", "boxOffice", "production", "website", "response", "actors"));
		MovieList ml = new MovieList("listName",
				movies);
		// Run the test
		userUnderTest.addMovieListToMovieLists(ml);

		// Verify the results
		assertTrue(userUnderTest.getMovieLists().contains(ml));
	}

	@Test
	public void testRemoveMovieListFromMovieLists() {
		// Setup
		List<Movie> movies = new java.util.ArrayList<>();
		movies.add(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director",
				"writer", "awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID",
				"type", "dvd", "boxOffice", "production", "website", "response", "actors"));
		movies.add(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director",
				"writer", "awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID",
				"type", "dvd", "boxOffice", "production", "website", "response", "actors"));
		MovieList ml = new MovieList("listName",
				movies);

		// Run the test
		userUnderTest.removeMovieListFromMovieLists("listName");

		// Verify the results
		assertFalse(userUnderTest.getMovieLists().contains(ml));
	}

	@Test
	public void testAddMovieToFavoriteMovies() {
		// Setup
		final Movie movie = new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director",
				"writer", "awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type",
				"dvd", "boxOffice", "production", "website", "response", "actors");

		// Run the test
		userUnderTest.addMovieToFavoriteMovies(movie);

		// Verify the results
		assertTrue(userUnderTest.getFavoriteMovies().contains(movie));
	}
}
