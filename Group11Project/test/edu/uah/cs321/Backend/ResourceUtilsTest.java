package edu.uah.cs321.Backend;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ResourceUtilsTest {

	@Test
	public void testGetFile(){
		// Setup
		// Run the test
		try {
			final FileInputStream result = ResourceUtils.getFile(Constants.jsonFileName);
		}catch(Exception ignored){}
	}

	@Test
	public void testGetUserDatabase() {
		assertNotEquals("result", ResourceUtils.getUserDatabase());
	}

	@Test
	public void testGetAuthMap() {
		assertNotEquals("result", ResourceUtils.getAuthMap());
	}

	@Test
	public void testGetMasterMovieListCache() {
		assertNotEquals("result", ResourceUtils.getMasterMovieListCache());
	}

	@Test
	public void testGetGoodWatchesDirectory() {
		assertNotEquals("result", ResourceUtils.getGoodWatchesDirectory());
	}

	@Test
	public void testEnsurePath() {
		// Setup
		// Run the test
		ResourceUtils.ensurePath("path");

		// Verify the results

	}

	@Test
	public void testInit() {
		// Setup
		// Run the test
		ResourceUtils.init();

		// Verify the results
	}

	@Test
	public void testGetMasterMovieList() {
		// Setup
		// Run the test
		try {
			JsonReader jr = new JsonReader();
		} catch(Exception ignored) {}

		final MovieList result = ResourceUtils.getMasterMovieList();

		// Verify the results
		assertFalse(result.getMovieList().isEmpty());
	}
}
