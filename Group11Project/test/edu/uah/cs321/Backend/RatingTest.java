package edu.uah.cs321.Backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatingTest {

	private Rating ratingUnderTest;

	@Before
	public void setUp() {
		ratingUnderTest = new Rating("source", "value");
	}

	@Test
	public void testEquals() {
		// Setup
		// Run the test
		final boolean result = ratingUnderTest.equals(new Rating("notSource","notValue"));

		// Verify the results
		assertFalse(result);
	}

	@Test
	public void testHashCode() {
		// Setup
		// Run the test
		final int result = ratingUnderTest.hashCode();
		final int tst = new Rating("source","value").hashCode();

		// Verify the results
		assertEquals(result, tst);
	}
}
