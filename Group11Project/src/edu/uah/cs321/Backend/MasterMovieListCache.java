package edu.uah.cs321.Backend;

import com.google.gson.JsonObject;

import java.io.*;
import java.util.Objects;

/***
 * Project Name: Group11Project
 * File Name: MasterMovieListCache
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class MasterMovieListCache {

	// Creating a private static variable called masterMovieLst that is of type MovieList.
	private static MovieList masterMovieLst;

	/**
	 * If the cache exists, read it in and set the masterMovieLst to it. If it doesn't exist, create a new one
	 */
	public static void init() throws IOException {
		try {
			FileInputStream fileIn = new FileInputStream(Objects.requireNonNull(ResourceUtils.getMasterMovieListCache()));
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try {
				masterMovieLst = (MovieList) in.readObject();
				ResourceUtils.setMasterMovieList(masterMovieLst);
				System.out.println("Master Movie List Cache found.");
			}
			catch(ClassNotFoundException e) {
				System.out.println("Unable to read Master MovieList cache. Creating a new one.");
				JsonReader json = new JsonReader();
				masterMovieLst = ResourceUtils.getMasterMovieList();
			}
		}
		catch(IOException ioe) {
			System.out.println("Master MovieList cache not found. Creating a new one.");
			JsonReader json = new JsonReader();
			masterMovieLst = ResourceUtils.getMasterMovieList();
		}
	}

	/**
	 * > This function writes the master movie list to a file
	 */
	public static void close() throws IOException {
		ResourceUtils.ensurePath(ResourceUtils.getGoodWatchesDirectory());
		FileOutputStream fileOut = new FileOutputStream(Objects.requireNonNull(ResourceUtils.getMasterMovieListCache()));
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(masterMovieLst);
	}
}
