package edu.uah.cs321.Backend;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AuthSystemTest {

	@Test
	public void testCheckUserName() {
		assertTrue(AuthSystem.checkUserName("userName"));
	}

	@Test
	public void testAddUser() {
		// Setup
		User result = null;
		User expectedResult = null;
		int unameinc = 0;
		while(result == null) {
			System.out.println("Trying a different username");
			 expectedResult = new User("firstName", "lastName", "I like long walks on the beach.", "userName" + unameinc);

			// Run the test
			result = AuthSystem.addUser("firstName", "lastName", "userName" + unameinc, "password");
			unameinc += 1;
		}
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

	@Test
	public void testClose() throws Exception {
		// Setup
		// Run the test
		AuthSystem.close();

		// Verify the results
	}
}
