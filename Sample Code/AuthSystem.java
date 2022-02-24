package edu.uah.cs321;

import java.io.*;
import java.util.HashMap;


@SuppressWarnings("unused")
/**
 * Project Name: GroupProject-InitialThoughts
 * File Name: AuthSystem
 * Description: The AuthSystem class is a class that contains a HashMap of usernames and passwords. It also contains a method to add a
 * user to the HashMap, a method to remove a user from the HashMap, a method to check if a username is in the HashMap, a
 * method to check if a password is correct for a given username, and a method to log in a user
 * @author justinbushue
 * @version 1.0
 */
public class AuthSystem {
	private static HashMap<String,String> userPass;
	private final static AuthSystem instance = new AuthSystem();

	// The constructor is private, so it cannot be called outside the class.
	// Tries to open the userpass.gw that contains the username password map
	private AuthSystem() {
		try {
			FileInputStream fileIn = new FileInputStream("userpass.gw");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try {
				userPass = (HashMap<String, String>) in.readObject();
			}
			catch(ClassNotFoundException e) {
				System.out.println("Unable to read Username and Password File. Creating a new data set.");
				userPass = new HashMap<>();
			}
		}
		catch(IOException ioe) {
			System.out.println("Username and Password File not found. Creating a new data set.");
			userPass = new HashMap<>();
		}
	}

	/**
	 * This function writes the userPass object to a file called userpass.gw
	 */
	public void close() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("userpass.gw");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(userPass);
	}


	/**
	 * Check if the username is in the userPass dictionary
	 *
	 * @param userName The username to check.
	 * @return The method returns a boolean value.
	 */
	public static boolean checkUserName(String userName) {
		return userPass.containsKey(userName);
	}

	/**
	 * Check if the password is at least 8 characters long and contains at least 8 letters and contains only letters and digits
	 *
	 * @param password The password to check.
	 * @return A boolean value.
	 */
	private boolean checkPasswordComplexity(String password) {
		if(password.length() >= 8) {
			for(int i = 0 ; i < password.length() ; i++) {
				if (!Character.isLetterOrDigit(password.charAt(i)) || Character.isWhitespace(password.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Given a username and a password, return true if the password is correct for the username
	 *
	 * @param userName The username of the user attempting to log in.
	 * @param password The password to check.
	 * @return The return value is boolean.
	 */
	private boolean checkPassword(String userName, String password) {
		return userPass.get(userName).equals(password);
	}

	/**
	 * Add a user to the userPass map
	 *
	 * @param userName The name of the user to be added.
	 * @param password The password to be added to the userPass map.
	 * @return Nothing.
	 */
	public User addUser(String userName, String password) {
		if(checkUserName(userName) && checkPasswordComplexity(password)) {
			userPass.put(userName, password);
			return new User();
		}
		return null;
	}

	/**
	 * Remove a user from the userPass map
	 *
	 * @param userName The name of the user to be removed.
	 * @param password The password to check.
	 * @return A boolean value.
	 */
	public boolean removeUser(String userName, String password) {
		if(checkPassword(userName, password)){
			userPass.remove(userName);
			return true;
		}
		return false;
	}

	/**
	 * Check the password for the given username
	 *
	 * @param userName The username of the user attempting to log in.
	 * @param password The password to check.
	 * @return A boolean value.
	 */
	public boolean login(String userName, String password) {
		return checkPassword(userName, password);
	}

	/**
	 * Get the instance of the AuthSystem class
	 *
	 * @return The instance of the AuthSystem class.
	 */
	public AuthSystem getInstance() {
		return instance;
	}
}
