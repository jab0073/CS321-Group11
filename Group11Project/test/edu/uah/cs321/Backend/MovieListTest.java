package edu.uah.cs321.Backend;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieListTest {

	private MovieList movieListUnderTest;

	@Before
	public void setUp() {
		movieListUnderTest = new MovieList();
	}

	@Test
	public void testAddMovie() {
		// Setup
		final Movie movie = new Movie("title3", "plot", "rating", "2022", "released", "genre", "runtime", "director",
				"writer", "awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type",
				"dvd", "boxOffice", "production", "website", "response", "actors");

		// Run the test
		movieListUnderTest.addMovie(movie);

		// Verify the results
		assertTrue(movieListUnderTest.getMovieList().contains(movie));
	}

	@Test
	public void testRemoveMovie() {
		// Setup
		final Movie movie = new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director",
				"writer", "awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type",
				"dvd", "boxOffice", "production", "website", "response", "actors");

		// Run the test
		movieListUnderTest.removeMovie(movie);

		// Verify the results
		assertFalse(movieListUnderTest.getMovieList().contains(movie));
	}

	@Test
	public void testFilterByActor() {
		// Setup
		final List<Movie> expectedResult = List.of(
				new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "joe"));
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "joe"));
		// Run the test
		final List<Movie> result = movieListUnderTest.filterByActor("joe");

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFilterByDirector() {
		// Setup
		final List<Movie> expectedResult = List.of(
				new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "actors"));
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		// Run the test
		final List<Movie> result = movieListUnderTest.filterByDirector("director");

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFilterByGenre() {

		// Setup
		final List<Movie> expectedResult = List.of(
				new Movie("title", "plot", "rating", "2022", "released", "Comedy", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "actors"));
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "Comedy", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		// Run the test
		final List<Movie> result = movieListUnderTest.filterByGenre("Comedy");

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFilterByRating() {
		// Setup
		final List<Movie> expectedResult = List.of(
				new Movie("title", "plot", "R", "2022", "released", "genre", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "actors"));
		movieListUnderTest.addMovie(new Movie("title", "plot", "R", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		// Run the test
		final List<Movie> result = movieListUnderTest.filterByRating("R");

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFilterByYear() {
		// Setup
		final List<Movie> expectedResult = List.of(
				new Movie("title", "plot", "rating", "2019", "released", "genre", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "actors"));
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2019", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		// Run the test
		final List<Movie> result = movieListUnderTest.filterByYear(2020, '<');

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testSearchForAny() {
		// Setup

		final List<Movie> expectedResult = List.of(
				new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "actors"));
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		movieListUnderTest.getMovieList().forEach(Movie::generateDistinctWords);
		// Run the test
		final List<Movie> result = movieListUnderTest.searchForAny("title");

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testClearFilteredList() {
		// Setup
		// Run the test
		movieListUnderTest.clearFilteredList();

		// Verify the results
		assertTrue(movieListUnderTest.getFilteredMovies().isEmpty());
	}

	@Test
	public void testSearchForMovie() {
		// Setup
		final List<Movie> expectedResult = List.of(
				new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "actors"));
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		// Run the test
		final List<Movie> result = movieListUnderTest.searchForMovie("title");

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGetAllActors() {
		// Setup
		// Run the test
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		final List<String> result = movieListUnderTest.getAllActors();

		// Verify the results
		assertEquals(List.of("actors"), result);
	}

	@Test
	public void testGetAllGenres() {
		// Setup
		// Run the test
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		final List<String> result = movieListUnderTest.getAllGenres();

		// Verify the results
		assertEquals(List.of("genre"), result);
	}

	@Test
	public void testGetAllTitles() {
		// Setup
		// Run the test
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		final List<String> result = movieListUnderTest.getAllTitles();

		// Verify the results
		assertEquals(List.of("title"), result);
	}

	@Test
	public void testGetAllDirectors() {
		// Setup
		// Run the test
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		final List<String> result = movieListUnderTest.getAllDirectors();

		// Verify the results
		assertEquals(List.of("director"), result);
	}

	@Test
	public void testGetAllWriters() {
		// Setup
		// Run the test
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		final List<String> result = movieListUnderTest.getAllWriters();

		// Verify the results
		assertEquals(List.of("writer"), result);
	}

	@Test
	public void testGetAllLanguages() {
		// Setup
		// Run the test
		movieListUnderTest.addMovie(new Movie("title", "plot", "rating", "2022", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors"));
		final List<String> result = movieListUnderTest.getAllLanguages();

		// Verify the results
		assertEquals(List.of("language"), result);
	}
}
