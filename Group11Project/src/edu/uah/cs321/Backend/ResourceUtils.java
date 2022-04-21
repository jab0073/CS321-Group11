package edu.uah.cs321.Backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/***
 * File Name: ResourceUtils
 * Description: The ResourceUtils class is a utility class that provides methods for reading and writing files from the resource folder
 * as well as retrieving and setting the user specified locations for the AuthSystem map and UserDatabase list.
 * @author justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class ResourceUtils {
	// This is a variable that is used to store the master movie list.
	private static MovieList masterMovieLst;
	/**
	 * Given a file name, return the InputStream for that file
	 *
	 * @param fileName the name of the file to be read.
	 * @return The input stream for the file.
	 */
	private static InputStream getFileFromResourceAsStream(String fileName) {
		ClassLoader classLoader = ResourceUtils.class.getClassLoader();
		InputStream input = classLoader.getResourceAsStream(fileName);
		if (input == null) {
			throw new IllegalArgumentException("file not found: " + fileName);
		}
		else {
			return input;
		}
	}
	
	/**
	 * Create a copy of the requested file to return to the caller.
	 *
	 * @param fileName The name of the file to be returned.
	 * @return A FileInputStream object.
	 */
	public static FileInputStream getFile(String fileName) throws IOException {
		Path temp = Files.createTempFile("resource-", ".tmp");
		Files.copy(ResourceUtils.getFileFromResourceAsStream(fileName), temp, StandardCopyOption.REPLACE_EXISTING);
		return new FileInputStream(temp.toFile());
	}

	/**
	 * This function returns the path to the user database.
	 *
	 * @return The path to the user database.
	 */
	public static String getUserDatabase() {
		if(System.getProperty("os.name").toLowerCase().startsWith("win")) {
			return Constants.WindowsBeginningDefaultDir + System.getProperty("user.name") + Constants.WindowsEndingDefaultDir + Constants.UserDatabaseFileName;
		}
		else if(System.getProperty("os.name").toLowerCase().startsWith("mac")) {
			return Constants.MacBeginningDir + System.getProperty("user.name") + Constants.MacDefaultDir + Constants.UserDatabaseFileName;
		}
		return null;
	}

	/**
	 * This function returns the path to the authmap file.
	 *
	 * @return The path to the authmap file.
	 */
	public static String getAuthMap() {
		if(System.getProperty("os.name").toLowerCase().startsWith("win")) {
			return Constants.WindowsBeginningDefaultDir + System.getProperty("user.name") + Constants.WindowsEndingDefaultDir + Constants.AuthMapFileName;
		}
		else if(System.getProperty("os.name").toLowerCase().startsWith("mac")) {
			return Constants.MacBeginningDir + System.getProperty("user.name") + Constants.MacDefaultDir + Constants.AuthMapFileName;
		}
		return null;
	}

	/**
<<<<<<< Updated upstream
	 * returns the file directory path to where the masterMovieList cache is
	 * @return
=======
	 * If the OS is Windows, return the Windows directory, else if the OS is Mac, return the Mac directory
	 *
	 * @return The path to the master movie list cache file.
>>>>>>> Stashed changes
	 */
	public static String getMasterMovieListCache() {
		if(System.getProperty("os.name").toLowerCase().startsWith("win")) {
			return Constants.WindowsBeginningDefaultDir + System.getProperty("user.name") + Constants.WindowsEndingDefaultDir + Constants.MasterMovieListCache;
		}
		else if(System.getProperty("os.name").toLowerCase().startsWith("mac")) {
			return Constants.MacBeginningDir + System.getProperty("user.name") + Constants.MacDefaultDir + Constants.MasterMovieListCache;
		}
		return null;
	}

	/**
<<<<<<< Updated upstream
	 * returns the file directory path to where necessary program files are stored.
	 * @return
=======
	 * If the OS is Windows, return the Windows default directory, else if the OS is Mac, return the Mac default directory,
	 * else return null
	 *
	 * @return The directory where the GoodWatches.txt file is located.
>>>>>>> Stashed changes
	 */
	public static String getGoodWatchesDirectory() {
		if(System.getProperty("os.name").toLowerCase().startsWith("win")) {
			return Constants.WindowsBeginningDefaultDir + System.getProperty("user.name") + Constants.WindowsEndingDefaultDir;
		}
		else if(System.getProperty("os.name").toLowerCase().startsWith("mac")) {
			return Constants.MacBeginningDir + System.getProperty("user.name") + Constants.MacDefaultDir;
		}
		return null;
	}

	/**
	 * If the path doesn't exist, create it
	 *
	 * @param path The path to the directory you want to create.
	 */
	public static void ensurePath(String path) {
		if (!Files.exists(Paths.get(path))){
			try {
				Files.createDirectories(Paths.get(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This function creates the directory structure for the user's default stored database directory
	 */
	public static void init() {
		String dir = "";
		if(System.getProperty("os.name").toLowerCase().startsWith("win")) {
			dir = Constants.WindowsBeginningDefaultDir + System.getProperty("user.name") + Constants.WindowsEndingDefaultDir;
		}
		else if(System.getProperty("os.name").toLowerCase().startsWith("mac")) {
			dir = Constants.MacBeginningDir + System.getProperty("user.name") + Constants.MacDefaultDir;
		}

		ResourceUtils.ensurePath(dir);
	}

	/**
<<<<<<< Updated upstream
	 * initialises masterMovieList with the inputted List of Movies
	 * @param ml
	 */
	public static void setMasterMovieList(List<Movie> ml) {ResourceUtils.masterMovieLst = new MovieList(ml); }

	/**
	 * Sets the masterMovieList to the inputted MovieList
	 * @param ml
=======
	 * > This function takes a list of movies and sets the master movie list to be a new movie list with the given list of
	 * movies
	 *
	 * @param ml The list of movies to be set as the master list.
	 */
	public static void setMasterMovieList(List<Movie> ml) {
		ResourceUtils.masterMovieLst = new MovieList(ml);
	}

	/**
	 * > This function sets the master movie list to the movie list passed in as a parameter
	 *
	 * @param ml The MovieList object that contains the list of movies to be displayed.
>>>>>>> Stashed changes
	 */
	public static void setMasterMovieList(MovieList ml) {
		ResourceUtils.masterMovieLst = ml;
	}

	/**
<<<<<<< Updated upstream
	 * returns the masterMovieList
	 * @return MovieList
=======
	 * > This function returns the master movie list
	 *
	 * @return The masterMovieLst object is being returned.
>>>>>>> Stashed changes
	 */
	public static MovieList getMasterMovieList() {
		return ResourceUtils.masterMovieLst;
	}
}

