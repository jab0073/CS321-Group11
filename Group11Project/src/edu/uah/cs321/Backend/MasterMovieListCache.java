package edu.uah.cs321.Backend;

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

	private static MovieList masterMovieLst;
	private final static MasterMovieListCache mlc = new MasterMovieListCache();

	private MasterMovieListCache() {
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
				masterMovieLst = ResourceUtils.getMasterMovieList();
			}
		}
		catch(IOException ioe) {
			System.out.println("Master MovieList cache not found. Creating a new one.");
			masterMovieLst = ResourceUtils.getMasterMovieList();
		}
	}

	public static void close() throws IOException {
		ResourceUtils.ensurePath(ResourceUtils.getGoodWatchesDirectory());
		FileOutputStream fileOut = new FileOutputStream(Objects.requireNonNull(ResourceUtils.getMasterMovieListCache()));
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(masterMovieLst);
	}
}