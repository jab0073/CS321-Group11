package edu.uah.cs321.Backend;

import org.junit.Test;

import java.io.IOException;

import static edu.uah.cs321.Backend.UserDatabase.getUserAccount;
import static org.junit.Assert.*;

public class UserDatabaseTest {

	@Test
	public void testAddUser() {
		// Setup
		final User u = new User("firstName", "lastName", "aboutMe", "userName");

		// Run the test
		UserDatabase.addUser(u);

		// Verify the results
		User result = UserDatabase.getUserAccount("userName");

		assertEquals(u, result);
	}

	@Test
	public void testCheckUserExists() {
		// Setup
		final User u = new User("firstName", "lastName", "aboutMe", "userName");

		// Run the test
		final boolean result = UserDatabase.checkUserExists(u);

		// Verify the results
		assertTrue(result);
	}

	@Test
	public void testGetUserAccount() {
		// Setup
		final User expectedResult = new User("firstName", "lastName", "aboutMe", "userName");

		// Run the test
		final User result = getUserAccount("userName");

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testRemoveUser() {
		// Setup
		final User u = new User("firstName", "lastName", "aboutMe", "userName");

		// Run the test
		UserDatabase.removeUser(u);

		// Verify the results
		assertFalse(UserDatabase.checkUserExists(u));
	}

	@Test
	public void testClose() throws Exception {
		// Setup
		// Run the test
		UserDatabase.close();

		// Verify the results
	}
}
