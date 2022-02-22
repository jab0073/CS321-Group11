package edu.uah.cs321;

import java.io.*;
import java.util.HashMap;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: AuthSystem
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class AuthSystem {
	private static HashMap<String,String> userPass;
	private final static AuthSystem instance = new AuthSystem();

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

	public void close() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("userpass.gw");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(userPass);
	}


	public static boolean checkUserName(String userName) {
		return userPass.containsKey(userName);
	}

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

	private boolean checkPassword(String userName, String password) {
		return userPass.get(userName).equals(password);
	}

	public User addUser(String userName, String password) {
		if(checkUserName(userName) && checkPasswordComplexity(password)) {
			userPass.put(userName, password);
			return new User();
		}
		return null;
	}

	public boolean removeUser(String userName, String password) {
		if(checkPassword(userName, password)){
			userPass.remove(userName);
			return true;
		}
		return false;
	}

	public boolean login(String userName, String password) {
		return checkPassword(userName, password);
	}

	public AuthSystem getInstance() {
		return instance;
	}
}
