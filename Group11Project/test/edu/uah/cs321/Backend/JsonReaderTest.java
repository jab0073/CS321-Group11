package edu.uah.cs321.Backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonReaderTest {

	private JsonReader jsonReaderUnderTest;

	@Before
	public void setUp() throws Exception {
		jsonReaderUnderTest = new JsonReader();
	}

	@Test
	public void FileReadTest() {
		assertTrue(ResourceUtils.getMasterMovieList().getMovieList().size() > 0);
	}
}
