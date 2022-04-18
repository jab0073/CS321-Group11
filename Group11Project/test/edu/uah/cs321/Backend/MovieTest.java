package edu.uah.cs321.Backend;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/***
 * Project Name: Group11Project
 * File Name: MovieTest
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class MovieTest {
	Movie movieUnderTest;
	@Before
	public void setUp() throws Exception {
		movieUnderTest = new Movie("title", "plot", "PG-13", "year", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors");
		movieUnderTest.setCountry("country");
	}

	@Test
	public void getTitle() {
		assertEquals("title", movieUnderTest.getTitle());
	}

	@Test
	public void setTitle() {
		String expected = "newTitle";
		movieUnderTest.setTitle(expected);

		assertEquals(expected, movieUnderTest.getTitle());
	}

	@Test
	public void getPlot() {
		assertEquals("plot", movieUnderTest.getPlot());
	}

	@Test
	public void setPlot() {
		String expected = "newPlot";

		movieUnderTest.setPlot(expected);

		assertEquals(expected, movieUnderTest.getPlot());
	}

	@Test
	public void getRating() {
		assertEquals("PG-13", movieUnderTest.getRating());
	}

	@Test
	public void setRating() {
		String expected = "R";

		movieUnderTest.setRating(expected);

		assertEquals(expected, movieUnderTest.getRating());
	}

	@Test
	public void getYear() {
		assertEquals("year", movieUnderTest.getYear());
	}

	@Test
	public void setYear() {
		String expected = "newYear";

		movieUnderTest.setYear(expected);

		assertEquals(expected, movieUnderTest.getYear());
	}

	@Test
	public void getReleased() {
		assertEquals("released", movieUnderTest.getReleased());
	}

	@Test
	public void setReleased() {
		String expected = "newReleased";

		movieUnderTest.setReleased(expected);

		assertEquals(expected, movieUnderTest.getReleased());
	}

	@Test
	public void getGenre() {
		assertTrue(movieUnderTest.getGenre().contains("genre"));
	}

	@Test
	public void setGenre() {
		List<String> expected = new ArrayList<>(Arrays.asList("newGenre"));

		movieUnderTest.setGenre(expected);

		assertEquals(expected,movieUnderTest.getGenre());
	}

	@Test
	public void getRuntime() {
		assertEquals("runtime", movieUnderTest.getRuntime());
	}

	@Test
	public void setRuntime() {
		String expected = "newRuntime";

		movieUnderTest.setRuntime(expected);

		assertEquals(expected,movieUnderTest.getRuntime());
	}

	@Test
	public void getDirector() {
		assertEquals("director", movieUnderTest.getDirector());
	}

	@Test
	public void setDirector() {
		String expected = "newDirector";

		movieUnderTest.setDirector(expected);

		assertEquals(expected,movieUnderTest.getDirector());
	}

	@Test
	public void getWriter() {
		assertEquals("writer", movieUnderTest.getWriter());
	}

	@Test
	public void setWriter() {
		String expected = "newWriter";

		movieUnderTest.setWriter(expected);

		assertEquals(expected,movieUnderTest.getWriter());
	}

	@Test
	public void getAwards() {
		assertEquals("awards", movieUnderTest.getAwards());
	}

	@Test
	public void setAwards() {
		String expected = "newAwards";

		movieUnderTest.setAwards(expected);

		assertEquals(expected,movieUnderTest.getAwards());
	}

	@Test
	public void getLanguage() {
		assertEquals("language", movieUnderTest.getLanguage());
	}

	@Test
	public void setLanguage() {
		String expected = "newLanguage";

		movieUnderTest.setLanguage(expected);

		assertEquals(expected, movieUnderTest.getLanguage());
	}

	@Test
	public void getCountry() {
		assertEquals("country", movieUnderTest.getCountry());
	}

	@Test
	public void setCountry() {
		String expected = "newCountry";

		movieUnderTest.setCountry(expected);

		assertEquals(expected, movieUnderTest.getCountry());
	}

	@Test
	public void getPoster() {
		assertEquals("poster",movieUnderTest.getPoster());
	}

	@Test
	public void setPoster() {
		String expected = "newPoster";

		movieUnderTest.setPoster(expected);

		assertEquals(expected, movieUnderTest.getPoster());
	}

	@Test
	public void getRatings() {
		assertNotNull(movieUnderTest.getRatings());
	}

	@Test
	public void setRatings() {
		Rating rating = new Rating("source","value");

		movieUnderTest.setRatings(List.of(rating));

		assertEquals(1, movieUnderTest.getRatings().size());
	}

	@Test
	public void getMetascore() {
		assertEquals("metaScore",movieUnderTest.getMetascore());
	}

	@Test
	public void setMetascore() {
		String expected = "newMetaScore";

		movieUnderTest.setMetascore(expected);

		assertEquals(expected, movieUnderTest.getMetascore());
	}

	@Test
	public void getImdbRating() {
		assertEquals("imdbRating", movieUnderTest.getImdbRating());
	}

	@Test
	public void setImdbRating() {
		String expected = "newImdbRating";

		movieUnderTest.setImdbRating(expected);

		assertEquals(expected, movieUnderTest.getImdbRating());
	}

	@Test
	public void getImdbVotes() {
		assertEquals("imdbVotes", movieUnderTest.getImdbVotes());
	}

	@Test
	public void setImdbVotes() {
		String expected = "newImdbVotes";

		movieUnderTest.setImdbVotes(expected);

		assertEquals(expected, movieUnderTest.getImdbVotes());
	}

	@Test
	public void getImdbID() {
		assertEquals("imdbID", movieUnderTest.getImdbID());
	}

	@Test
	public void setImdbID() {
		String expected = "newImdbID";

		movieUnderTest.setImdbID(expected);

		assertEquals(expected, movieUnderTest.getImdbID());
	}

	@Test
	public void getType() {
		assertEquals("type", movieUnderTest.getType());
	}

	@Test
	public void setType() {
		String expected = "newType";

		movieUnderTest.setType(expected);

		assertEquals(expected, movieUnderTest.getType());
	}

	@Test
	public void getDVD() {
		assertEquals("dvd", movieUnderTest.getDVD());
	}

	@Test
	public void setDVD() {
		String expected = "newDVD";

		movieUnderTest.setDVD(expected);

		assertEquals(expected, movieUnderTest.getDVD());
	}

	@Test
	public void getBoxOffice() {
		assertEquals("boxOffice", movieUnderTest.getBoxOffice());
	}

	@Test
	public void setBoxOffice() {
		String expected = "newBoxOffice";

		movieUnderTest.setBoxOffice(expected);

		assertEquals(expected, movieUnderTest.getBoxOffice());
	}

	@Test
	public void getProduction() {
		assertEquals("production", movieUnderTest.getProduction());
	}

	@Test
	public void setProduction() {
		String expected = "newProduction";

		movieUnderTest.setProduction(expected);

		assertEquals(expected, movieUnderTest.getProduction());
	}

	@Test
	public void getWebsite() {
		assertEquals("website", movieUnderTest.getWebsite());
	}

	@Test
	public void setWebsite() {
		String expected = "newWebsite";

		movieUnderTest.setWebsite(expected);

		assertEquals(expected, movieUnderTest.getWebsite());
	}

	@Test
	public void getResponse() {
		assertEquals("response", movieUnderTest.getResponse());
	}

	@Test
	public void setResponse() {
		String expected = "newResponse";

		movieUnderTest.setResponse(expected);

		assertEquals(expected, movieUnderTest.getResponse());
	}

	@Test
	public void getActors() {
		assertEquals(List.of("actors"), movieUnderTest.getActors());
	}

	@Test
	public void setActors() {
		List<String> expected = new ArrayList<>(Arrays.asList("actor1", "actor2"));

		movieUnderTest.setActors(expected);

		assertEquals(expected, movieUnderTest.getActors());
	}

	@Test
	public void getUserReviews() {
		assertNotNull(movieUnderTest.getUserReviews());
	}

	@Test
	public void setUserReviews() {
		Review r = new Review(new User("firstName", "lastName", "aboutMe", "userName"), movieUnderTest , 5, "review");

		movieUnderTest.setUserReviews(List.of(r));

		assertEquals(List.of(r), movieUnderTest.getUserReviews());
	}

	@Test
	public void addReview() {
		Review r = new Review(new User("firstName", "lastName", "aboutMe", "userName"), movieUnderTest , 5, "review");
		movieUnderTest.addReview(r);

		assertTrue(movieUnderTest.getUserReviews().contains(r));
	}

	@Test
	public void getThis() {
		assertEquals(movieUnderTest, movieUnderTest.getThis());
	}

	@Test
	public void getAttributes() {
		String atts = String.join("; ", movieUnderTest.getTitle(), movieUnderTest.getRating(), movieUnderTest.getYear(), String.join(", ", movieUnderTest.getGenre()), movieUnderTest.getDirector(), movieUnderTest.getWriter(), movieUnderTest.getLanguage(), String.join(", ", movieUnderTest.getActors()));
		assertEquals(atts, movieUnderTest.getAttributes());
	}

	@Test
	public void testEquals() {
		Movie mv = new Movie("title", "plot", "PG-13", "year", "released", "genre", "runtime", "director", "writer",
				"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
				"boxOffice", "production", "website", "response", "actors");
		mv.setCountry("country");
		assertEquals(mv, movieUnderTest);
	}
}