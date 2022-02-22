package edu.uah.cs321;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: User
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class User implements Serializable {
	private String firstName, lastName, aboutMe, userName;
	private List<MovieList> movieLists;
	private List<String> favoriteActors;
	private List<Movie> favoriteMovies;
	private List<String> favoriteGenres;
	private List<String> favoriteDirectors;
	private List<String> favoriteOther;

	public User() {
		firstName = "Joe";
		lastName = "Smith";
		aboutMe = "I like long walks on the beach.";
		userName = null;
		movieLists = new ArrayList<>();
		favoriteMovies = new ArrayList<>();
		favoriteActors = new ArrayList<>();
		favoriteDirectors = new ArrayList<>();
		favoriteGenres = new ArrayList<>();
		favoriteOther = new ArrayList<>();
	}

	public User(String firstName, String lastName, String userName) {
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

	public String getUserName() {
		return userName;
	}
	public boolean compareUserNameTo(String u) {
		return this.userName.equals(u);
	}

	public User getThis() {
		return this;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(String firstName, String lastName, String aboutMe, String userName) {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public List<MovieList> getMovieLists() {
		return movieLists;
	}

	public void setMovieLists(List<MovieList> movieLists) {
		this.movieLists = movieLists;
	}

	public List<String> getFavoriteActors() {
		return favoriteActors;
	}

	public void setFavoriteActors(List<String> favoriteActors) {
		this.favoriteActors = favoriteActors;
	}

	public List<Movie> getFavoriteMovies() {
		return favoriteMovies;
	}

	public void setFavoriteMovies(List<Movie> favoriteMovies) {
		this.favoriteMovies = favoriteMovies;
	}

	public List<String> getFavoriteGenres() {
		return favoriteGenres;
	}

	public void setFavoriteGenres(List<String> favoriteGenres) {
		this.favoriteGenres = favoriteGenres;
	}

	public List<String> getFavoriteDirectors() {
		return favoriteDirectors;
	}

	public void setFavoriteDirectors(List<String> favoriteDirectors) {
		this.favoriteDirectors = favoriteDirectors;
	}

	public List<String> getFavoriteOther() {
		return favoriteOther;
	}

	public void setFavoriteOther(List<String> favoriteOther) {
		this.favoriteOther = favoriteOther;
	}
}
