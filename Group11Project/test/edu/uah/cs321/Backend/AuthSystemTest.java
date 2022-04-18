package edu.uah.cs321.Backend;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AuthSystemTest {

	@Test
	public void testClose() throws Exception {
		// Setup
		// Run the test
		AuthSystem.close();

		// Verify the results
	}

	@Test
	public void testClose_ThrowsIOException() {
		// Setup
		// Run the test
		assertThrows(IOException.class, () -> AuthSystem.close());
	}

	@Test
	public void testCheckUserName() {
		assertTrue(AuthSystem.checkUserName("userName"));
	}

	@Test
	public void testAddUser() {
		// Setup
		final User expectedResult = new User("firstName", "lastName", "aboutMe", "userName");

		// Run the test
		final User result = AuthSystem.addUser("firstName", "lastName", "userName", "password");

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testRemoveUser() {
		assertTrue(AuthSystem.removeUser("userName", "password"));
	}

	@Test
	public void testLogin() {
		// Setup
		final User expectedResult = new User("firstName", "lastName", "aboutMe", "userName");

		// Run the test
		final User result = AuthSystem.login("userName", "password");

		// Verify the results
		assertEquals(expectedResult, result);
	}
}
