package src.edu.uah.cs321.Backend;

import edu.uah.cs321.Backend.AuthSystem;
import edu.uah.cs321.Backend.User;
import org.junit.Test;

/***
 * Project Name: Group11Project
 * File Name: AuthSystemTest
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class AuthSystemTest {
	@Test
	public void loginTest() {
		AuthSystem.addUser("Test","Account","test","password");
		User u = AuthSystem.login("test","password");
		assert(u.getFirstName() == "Test");
		assert(u.getLastName() == "Account");
		assert(u.getUserName() == "test");

		AuthSystem.removeUser("test", "password");
	}
}
