package edu.uah.cs321.Backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: User
 * Description: A user has a first name, last name, about me, and a username. The user can have a list of movie lists. The user can have a list of favorite actors, movies, genres, directors, and other
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class User implements Serializable {
	protected String firstName, lastName, aboutMe, userName;
	protected List<MovieList> movieLists;
	protected List<String> favoriteActors;
	protected List<Movie> favoriteMovies;
	protected List<String> favoriteGenres;
	protected List<String> favoriteDirectors;
	protected List<String> favoriteOther;
	protected boolean entitlement;

	// This is the default constructor for the User class. It sets the default values for the first name, last name, about me,
	// and username. It also sets up the movie lists, favorite movies, favorite actors, favorite genres, favorite directors,
	// and favorite other.
	public User() {
		entitlement = false;
		firstName = "";
		lastName = "";
		aboutMe = "";
		userName = null;
		movieLists = new ArrayList<>();
		favoriteMovies = new ArrayList<>();
		favoriteActors = new ArrayList<>();
		favoriteDirectors = new ArrayList<>();
		favoriteGenres = new ArrayList<>();
		favoriteOther = new ArrayList<>();
	}

	// This is a constructor for the User class. It sets the default values for the first name, last name, about me,
	// and username. It also sets up the movie lists, favorite movies, favorite actors, favorite genres, favorite directors,
	// and favorite other.
	public User(String firstName, String lastName, String userName) {
		entitlement = true;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		aboutMe = "I like long walks on the beach.";
		movieLists = new ArrayList<>();
		favoriteMovies = new ArrayList<>();
		favoriteActors = new ArrayList<>();
		favoriteDirectors = new ArrayList<>();
		favoriteGenres = new ArrayList<>();
		favoriteOther = new ArrayList<>();
	}

	// This is a constructor for the User class. It sets the default values for the first name, last name, about me,
	// and username. It also sets up the movie lists, favorite movies, favorite actors, favorite genres, favorite directors,
	// and favorite other.
	public User(String firstName, String lastName, String aboutMe, String userName) {
		entitlement = true;
		this.firstName = firstName;
		this.lastName = lastName;
		this.aboutMe = aboutMe;
		this.userName = userName;
		movieLists = new ArrayList<>();
		favoriteMovies = new ArrayList<>();
		favoriteActors = new ArrayList<>();
		favoriteDirectors = new ArrayList<>();
		favoriteGenres = new ArrayList<>();
		favoriteOther = new ArrayList<>();
	}

	/**
	 * Returns the entitlement type of the User
	 *
	 * @return The boolean value of the entitlement variable.
	 */
	public boolean getEntitlementType() {
		return entitlement;
	}

	/**
	 * It sets the entitlement to true or false.
	 *
	 * @param entitlement true if the user has the entitlement, false otherwise.
	 */
	public void setEntitlement(boolean entitlement) {
		this.entitlement = entitlement;
	}

	/**
	 * Returns the username of the user object
	 *
	 * @return The userName field of the User object.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This function compares the username of the current user to the username passed in as a parameter
	 *
	 * @param u the username to compare to
	 * @return The boolean value of the equals method.
	 */
	public boolean compareUserNameTo(String u) {
		return u.equals(this.userName);
	}

	/**
	 * This function returns the current user
	 *
	 * @return The current instance of the class.
	 */
	public User getThis() {
		return this;
	}

	/**
	 * It sets the userName field to the userName parameter.
	 *
	 * @param userName The name of the user to be created.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Get the first name of the user
	 *
	 * @return The firstName variable is being returned.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * It sets the first name of the user.
	 *
	 * @param firstName The first name of the user.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the last name of the user
	 *
	 * @return The lastName variable.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * It sets the last name of the user.
	 *
	 * @param lastName The last name of the user.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * It returns the value of the aboutMe variable.
	 *
	 * @return The aboutMe variable is being returned.
	 */
	public String getAboutMe() {
		return aboutMe;
	}

	/**
	 * It sets the aboutMe field to the value of the aboutMe parameter.
	 *
	 * @param aboutMe The user's about me.
	 */
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	/**
	 * This function returns a list of MovieList objects
	 *
	 * @return A list of MovieList objects.
	 */
	public List<MovieList> getMovieLists() {
		return movieLists;
	}

	/**
	 * This function sets the movieLists field of the Movie object to the value of the movieLists parameter
	 *
	 * @param movieLists A list of MovieList objects.
	 */
	public void setMovieLists(List<MovieList> movieLists) {
		this.movieLists = movieLists;
	}

	/**
	 * Returns a list of favorite actors
	 *
	 * @return A list of Strings.
	 */
	public List<String> getFavoriteActors() {
		return favoriteActors;
	}

	/**
	 * This function sets the favoriteActors list to the list passed in as a parameter
	 *
	 * @param favoriteActors A list of favorite actors.
	 */
	public void setFavoriteActors(List<String> favoriteActors) {
		this.favoriteActors = favoriteActors;
	}

	/**
	 * This function returns a list of favorite movies
	 *
	 * @return A list of Movie objects.
	 */
	public List<Movie> getFavoriteMovies() {
		return favoriteMovies;
	}

	/**
	 * This function sets the favoriteMovies field of the user object to the list of movies passed in
	 *
	 * @param favoriteMovies A list of movies that the user has favorited.
	 */
	public void setFavoriteMovies(List<Movie> favoriteMovies) {
		this.favoriteMovies = favoriteMovies;
	}

	/**
	 * Get the list of favorite genres
	 *
	 * @return A list of Strings.
	 */
	public List<String> getFavoriteGenres() {
		return favoriteGenres;
	}

	/**
	 * It sets the favoriteGenres field to the list of strings passed in.
	 *
	 * @param favoriteGenres A list of favorite genres.
	 */
	public void setFavoriteGenres(List<String> favoriteGenres) {
		this.favoriteGenres = favoriteGenres;
	}

	/**
	 * This function returns a list of strings that contains the names of the favorite directors of the user
	 *
	 * @return A list of Strings.
	 */
	public List<String> getFavoriteDirectors() {
		return favoriteDirectors;
	}

	/**
	 * It sets the favoriteDirectors field to the list of favoriteDirectors.
	 *
	 * @param favoriteDirectors A list of the favorite directors of the user.
	 */
	public void setFavoriteDirectors(List<String> favoriteDirectors) {
		this.favoriteDirectors = favoriteDirectors;
	}

	/**
	 * This function returns a list of strings that are the names of the other favorite things
	 *
	 * @return A list of Strings.
	 */
	public List<String> getFavoriteOther() {
		return favoriteOther;
	}

	/**
	 * This function sets the favoriteOther field of the class to the value of the favoriteOther parameter
	 *
	 * @param favoriteOther A list of other things the user likes.
	 */
	public void setFavoriteOther(List<String> favoriteOther) {
		this.favoriteOther = favoriteOther;
	}

	@Override
	public String toString() {
		return String.join("; ", entitlement ? "Registered User" : "Guest User",firstName, lastName, aboutMe);
	}
}
