package edu.uah.cs321;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: UserDatabase
 * Description:
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class UserDatabase {
	private static List<User> users;
	private final static UserDatabase instance = new UserDatabase();

	private UserDatabase() {
		try {
			FileInputStream fileIn = new FileInputStream("users.gw");
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

	public void addUser(User u) {
		users.add(u);
	}

	public void removeUser(User u) {
		users.remove(u);
	}

	public Optional<User> getUserAccount(String userName) {
		return users.stream()
				.filter(u -> u.compareUserNameTo(userName))
				.findFirst();
	}

	public void close() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("users.gw");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(users);
	}

	public UserDatabase getInstance() {
		return instance;
	}
}
