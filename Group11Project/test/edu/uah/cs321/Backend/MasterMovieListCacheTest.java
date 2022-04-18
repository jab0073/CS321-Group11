package edu.uah.cs321.Backend;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class MasterMovieListCacheTest {

	@Test
	public void testInit() throws Exception {
		// Setup
		// Run the test
		MasterMovieListCache.init();

		assertTrue(ResourceUtils.getMasterMovieList().getMovieList().size() > 0);
	}

	@Test
	public void testInit_ThrowsIOException() {
		// Setup
		// Run the test
		assertThrows(IOException.class, () -> MasterMovieListCache.init());
	}

	@Test
	public void testClose() throws Exception {
		// Setup
		// Run the test
		MasterMovieListCache.close();
	}

	@Test
	public void testClose_ThrowsIOException() {
		// Setup
		// Run the test
		assertThrows(IOException.class, () -> MasterMovieListCache.close());
	}
}
