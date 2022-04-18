package edu.uah.cs321.Backend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReviewTest {

	@Mock
	private User mockAuthor;
	@Mock
	private Movie mockMovie;

	private Review reviewUnderTest;

	@Before
	public void setUp() {
		reviewUnderTest = new Review(mockAuthor, mockMovie, 0, "body");
	}

	@Test
	public void testEquals() {
		// Setup
		when(mockAuthor.equals(new User("firstName", "lastName", "aboutMe", "userName"))).thenReturn(false);
		when(mockMovie.equals(
				new Movie("title", "plot", "rating", "year", "released", "genre", "runtime", "director", "writer",
						"awards", "language", "poster", "metaScore", "imdbRating", "imdbVotes", "imdbID", "type", "dvd",
						"boxOffice", "production", "website", "response", "actors"))).thenReturn(false);

		// Run the test
		final boolean result = reviewUnderTest.equals("o");

		// Verify the results
		assertTrue(result);
	}

	@Test
	public void testHashCode() {
		// Setup
		when(mockAuthor.hashCode()).thenReturn(0);
		when(mockMovie.hashCode()).thenReturn(0);

		// Run the test
		final int result = reviewUnderTest.hashCode();

		// Verify the results
		assertEquals(0, result);
	}
}
