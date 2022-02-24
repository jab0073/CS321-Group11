package edu.uah.cs321;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: UserDatabase
 * Description: This class is used to store and retrieve user accounts
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class UserDatabase {
	private static List<User> users;
	private final static UserDatabase instance = new UserDatabase();

	// This is the constructor for the UserDatabase class. It is used to initialize the users list.
	private UserDatabase() {
		try {
			FileInputStream fileIn = new FileInputStream(ResourceUtils.getUserDatabase());
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try {
				users = (List<User>) in.readObject();
			}
			catch(ClassNotFoundException e) {
				System.out.println("Unable to read Username and Password File. Creating a new data set.");
				users = new ArrayList<>();
			}
		}
		catch(IOException ioe) {
			System.out.println("Username and Password File not found. Creating a new data set.");
			users = new ArrayList<>();
		}
	}

	/**
	 * Add a user to the list of users
	 *
	 * @param u The user to be added to the list.
	 */
	public void addUser(User u) {
		users.add(u);
	}

	/**
	 * Remove the user from the list of users
	 *
	 * @param u The user to be removed.
	 */
	public void removeUser(User u) {
		users.remove(u);
	}

	/**
	 * Given a username, return the user account with that name
	 *
	 * @param userName The username to search for.
	 * @return Nothing or a user.
	 */
	public Optional<User> getUserAccount(String userName) {
		return users.stream()
				.filter(u -> u.compareUserNameTo(userName))
				.findFirst();
	}

	/**
	 * Writes the users object to a file
	 */
	public void close() throws IOException {
		FileOutputStream fileOut = new FileOutputStream(ResourceUtils.getUserDatabase());
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(users);
	}

	/**
	 * Returns the singleton instance of the UserDatabase class
	 *
	 * @return The instance of the UserDatabase class.
	 */
	public UserDatabase getInstance() {
		return instance;
	}
}
