package edu.uah.cs321.Backend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: UserDatabase
 * Description: This class is used to store and retrieve user accounts
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public final class UserDatabase {
	private static List<User> users = new ArrayList<>();
	private final static UserDatabase instance = new UserDatabase();

	// This is the constructor for the UserDatabase class. It is used to initialize the users list.
	private UserDatabase() {
		try {
			FileInputStream fileIn = new FileInputStream(Objects.requireNonNull(ResourceUtils.getUserDatabase()));
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try {
				users = (ArrayList<User>) in.readObject();
			}
			catch(ClassNotFoundException e) {
				System.out.println("Unable to read Username and Password File. Creating a new data set.");
				users = new ArrayList<>();
			}
		}
		catch(IOException ioe) {
			System.out.println("User File not found. Creating a new data set.");
			users = new ArrayList<>();
		}
	}

	/**
	 * Add a user to the list of users
	 *
	 * @param u The user to be added to the list.
	 */
	public static void addUser(User u) {
		if(checkUserExists(u)){
			System.out.println("User already exists");
			return;
		}
		System.out.println("Adding user: " + u);
		users.add(u);
	}

	public static boolean checkUserExists(User u) {
		return users.stream().anyMatch(user -> user.getThis() == u);
	}

	/**
	 * Remove the user from the list of users
	 *
	 * @param u The user to be removed.
	 */
	public static void removeUser(User u) {
		users.remove(u);
	}

	/**
	 * Given a username, return the user account with that name
	 *
	 * @param userName The username to search for.
	 * @return Nothing or a user.
	 */
	public static User getUserAccount(String userName) {
		Optional<User> ou = users.stream()
				.filter(u -> {
					if(u != null) {
						return userName.equals(u.getUserName());
					}
					return false;
				})
				.findFirst();
		if(ou.isPresent()) {
			System.out.println("User account found with username: " + userName);
			return ou.get();
		}
		return null;
	}

	/**
	 * Writes the users object to a file
	 */
	public static void close() throws IOException {
		FileOutputStream fileOut = new FileOutputStream(Objects.requireNonNull(ResourceUtils.getUserDatabase()));
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(users);
	}

	/**
	 * Returns the singleton instance of the UserDatabase class
	 *
	 * @return The instance of the UserDatabase class.
	 */
	public static UserDatabase getInstance() {
		return instance;
	}
}
