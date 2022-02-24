package edu.uah.cs321;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.platform.win32.WinReg.HKEY;

/***
 * Project Name: GroupProject-InitalThoughts
 * File Name: ResourceUtils
 * Description: The ResourceUtils class is a utility class that provides methods for reading and writing files from the resource folder
 * as well as retrieving and setting the user specified locations for the AuthSystem map and UserDatabase list.
 * @author justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class ResourceUtils {
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
		} else {
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

	private static final String preferencesPath = "SOFTWARE\\CS321G11\\GoodWatches\\Preferences";
	private static final HKEY REGKEY = WinReg.HKEY_CURRENT_USER;

	private static final String LOCAL_USER_DATABASE_LOCATION = "UserDatabaseLoc";
	public static final String LOCAL_AUTH_MAP_LOCATION = "AuthSystemMapLoc";

	private static String udCache = null;
	private static String amCache = null;

	/**
	 * This function returns the path to the user database.
	 *
	 * @return The path to the user database.
	 */
	public static String getUserDatabase() {
		if (udCache == null) {
			udCache = ResourceUtils.getPreferenceString(LOCAL_USER_DATABASE_LOCATION);
			if (udCache != null && !"".equals(udCache)) {
				udCache = udCache + "\\";
				if (!Files.exists(Paths.get(udCache)))
					return "";
				ResourceUtils.ensurePath(udCache);
				return udCache + Constants.UserDatabaseFileName;
			}
			else
				udCache = null;
			return "";
		}
		else {
			return udCache + Constants.UserDatabaseFileName;
		}
	}

	/**
	 * This function sets the value of the user database location preference
	 *
	 * @param value the value to set the preference to.
	 */
	public static void setUserDatabase(String value) {
		ResourceUtils.setPreferenceString(LOCAL_USER_DATABASE_LOCATION, value);
	}

	/**
	 * This function returns the path to the authmap file.
	 *
	 * @return The path to the authmap file.
	 */
	public static String getAuthMap() {
		if (amCache == null) {
			amCache = ResourceUtils.getPreferenceString(LOCAL_AUTH_MAP_LOCATION);
			if (amCache != null && !"".equals(amCache)) {
				amCache = amCache + "\\";
				if (!Files.exists(Paths.get(amCache)))
					return "";
				ResourceUtils.ensurePath(amCache);
				return amCache + Constants.AuthMapFileName;
			}
			else
				amCache = null;
			return "";
		}
		else {
			return amCache + Constants.AuthMapFileName;
		}
	}

	/**
	 * This function sets the value of the local auth map location
	 *
	 * @param value the value to set the preference to
	 */
	public static void setAuthMap(String value) {
		ResourceUtils.setPreferenceString(LOCAL_AUTH_MAP_LOCATION, value);
	}

	/**
	 * This function sets a string value in the registry
	 *
	 * @param keyName The name of the preference to be set.
	 * @param value the value to set
	 */
	private static void setPreferenceString(String keyName, String value) {
		checkAndCreate(keyName);
		Advapi32Util.registrySetStringValue(REGKEY, preferencesPath, keyName, value);
	}

	/**
	 * This function checks to see if the keyName exists in the registry. If it does not exist, it creates it.
	 *
	 * Then it returns the value of the keyName.
	 *
	 * @param keyName The name of the preference to retrieve.
	 * @return A string.
	 */
	private static String getPreferenceString(String keyName) {
		checkAndCreate(keyName);
		return Advapi32Util.registryGetStringValue(REGKEY, preferencesPath, keyName);
	}

	/**
	 * If the preferences path doesn't exist, create it. If the key doesn't exist, create it
	 *
	 * @param key The key to create.
	 */
	private static void checkAndCreate(String key) {
		if (!pathExists())
			Advapi32Util.registryCreateKey(REGKEY, preferencesPath);
		if (!keyExists(key)) {
			Advapi32Util.registryCreateKey(REGKEY, preferencesPath, key);
			Advapi32Util.registrySetStringValue(REGKEY, preferencesPath, key, "");
		}
	}

	/**
	 * This function checks to see if the registry key exists
	 *
	 * @return A boolean value.
	 */
	private static boolean pathExists() {
		return Advapi32Util.registryKeyExists(REGKEY, preferencesPath);
	}

	/**
	 * This function checks to see if the key exists in the registry
	 *
	 * @param key The registry key to check.
	 * @return Nothing.
	 */
	private static boolean keyExists(String key) {
		try {
			Advapi32Util.registryGetStringValue(REGKEY, preferencesPath, key);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * If the path doesn't exist, create it
	 *
	 * @param path The path to the directory you want to create.
	 */
	public static void ensurePath(String path) {
		if (!Files.exists(Paths.get(path))){
			try {
				Files.createDirectory(Paths.get(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void init() {
		ResourceUtils.setAuthMap(Constants.DefaultAuthMapDir);
		ResourceUtils.setUserDatabase(Constants.DefaultUserDatabaseDir);

		File dir = new File(Constants.DefaultAuthMapDir);
		if (!dir.exists()){
			dir.mkdirs();
		}

		dir = new File(Constants.DefaultUserDatabaseDir);
		if (!dir.exists()){
			dir.mkdirs();
		}
	}
}

