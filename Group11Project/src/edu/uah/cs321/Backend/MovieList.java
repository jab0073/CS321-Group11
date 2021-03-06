package edu.uah.cs321.Backend;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/***
 * File Name: MovieList
 * Description: MovieList is a class that holds a list of movies and provides methods to filter the list of movies by actor, director, genre, rating, year, and title
 * @author justinbushue shawnburnham
 * @version 1.0
 */
@SuppressWarnings("unused")
public class MovieList implements Serializable {
	//Used to hold the movie lists name.
	private String listName;
	// Used to hold the list of movies in the movie list.
	private List<Movie> movieList;
	// Used to hold the movie lists filtered results.
	private List<Movie> filteredMovies;

	// This is the constructor for the MovieList class. It initializes the movieList and filteredMovies variables to an empty
	// list.
	public MovieList() {
		listName = "Default Name";
		movieList = new ArrayList<>();
		filteredMovies = new ArrayList<>();
	}

	// This is the constructor for the MovieList class. It initializes the movieList and filteredMovies variables to an empty
	// list.
	public MovieList(List<Movie> movieList) {
		listName = "Default Name";
		this.movieList = movieList;
		this.movieList.sort(Comparator.comparing(m -> m.getTitle()));
		filteredMovies = new ArrayList<>();
	}


	public MovieList(String listName, List<Movie> movieList) {
		this.listName = listName;
		this.movieList = movieList;
		this.movieList.sort(Comparator.comparing(Movie::getTitle));
		filteredMovies = new ArrayList<>();
	}

	/**
	 * Returns the name of the list
	 *
	 * @return The listName variable is being returned.
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * It sets the listName variable to the value of the parameter listName.
	 *
	 * @param listName The name of the list to be created.
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * Add a movie to the movie list
	 *
	 * @param movie The movie to be added to the list.
	 */
	public void addMovie(Movie movie) {
		if(!movieList.contains(movie)) {
			movieList.add(movie);
		}
	}

	/**
	 * Remove a movie from the movie list
	 *
	 * @param movie The movie to be removed from the list.
	 */
	public void removeMovie(Movie movie) {
		movieList.remove(movie);
	}

	/**
	 * This function returns a list of movies
	 *
	 * @return A list of Movie objects.
	 */
	public List<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * It sets the movieList to the movieList passed in.
	 *
	 * @param movieList The list of movies to be displayed.
	 */
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	/**
	 * Given a string, return a list of movies that have that string in their actors list
	 *
	 * @param actor The actor to filter by.
	 * @return A list of movies that match the actor.
	 */
	public List<Movie> filterByActor(String actor) {
		actor = actor.toLowerCase();
		if(filteredMovies.isEmpty()) {
			String finalActor = actor;
			filteredMovies = movieList.stream()
					.filter(a -> a.getActorsLower().contains(finalActor))
					.collect(toList());
		}
		else {
			String finalActor1 = actor;
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getActorsLower().contains(finalActor1))
					.collect(toList());
		}
		return filteredMovies;
	}

	/**
	 * This function filters the movie list by director
	 *
	 * @param director The director to filter by.
	 * @return A list of movies that match the director.
	 */
	public List<Movie> filterByDirector(String director) {
		if(filteredMovies.isEmpty()) {
			filteredMovies = movieList.stream()
					.filter(a -> a.getDirector().equalsIgnoreCase(director))
					.map(Movie::getThis)
					.collect(toList());
		}
		else {
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getDirector().equalsIgnoreCase(director))
					.map(Movie::getThis)
					.collect(toList());
		}
		return filteredMovies;
	}

	/**
	 * This function filters the movie list by genre
	 *
	 * @param genre The genre to filter by.
	 * @return A list of movies that match the genre.
	 */
	public List<Movie> filterByGenre(String genre) {
		genre = genre.toLowerCase();
		if(filteredMovies.isEmpty()) {
			String finalGenre = genre;
			filteredMovies = movieList.stream()
					.filter(a -> a.getGenreLower().contains(finalGenre))
					.collect(toList());
		}
		else {
			String finalGenre1 = genre;
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getGenreLower().contains(finalGenre1))
					.map(Movie::getThis)
					.collect(toList());
		}
		return filteredMovies;
	}

	/**
	 * This function filters the movie list by rating
	 *
	 * @param rating The rating to filter by.
	 * @return A list of movies that match the rating.
	 */
	public List<Movie> filterByRating(String rating) {
		rating = rating.toLowerCase();
		if(filteredMovies.isEmpty()) {
			String finalRating = rating;
			filteredMovies = movieList.stream()
					.filter(a -> a.getRated().equalsIgnoreCase(finalRating))
					.map(Movie::getThis)
					.collect(toList());
		}
		else {
			String finalRating1 = rating;
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getRated().equalsIgnoreCase(finalRating1))
					.map(Movie::getThis)
					.collect(toList());
		}
		return filteredMovies;
	}

	/**
	 * This function filters the movie list by year
	 *
	 * @param year the year to filter by
	 * @return A list of movies that match the year.
	 */
	public List<Movie> filterByYear(int year , char greaterThanLessThanEqual) {
		switch (greaterThanLessThanEqual) {
			case '<' -> {
				if (filteredMovies.isEmpty()) {
					filteredMovies = movieList.stream()
							.filter(a -> Integer.parseInt(a.getYear()) < year)
							.map(Movie::getThis)
							.collect(toList());
				} else {
					filteredMovies = filteredMovies.stream()
							.filter(a -> Integer.parseInt(a.getYear()) < year)
							.map(Movie::getThis)
							.collect(toList());
				}
				return filteredMovies;
			}
			case '>' -> {
				if (filteredMovies.isEmpty()) {
					filteredMovies = movieList.stream()
							.filter(a -> Integer.parseInt(a.getYear()) > year)
							.map(Movie::getThis)
							.collect(toList());
				} else {
					filteredMovies = filteredMovies.stream()
							.filter(a -> Integer.parseInt(a.getYear()) > year)
							.map(Movie::getThis)
							.collect(toList());
				}
				return filteredMovies;
			}
			case '=' -> {
				if (filteredMovies.isEmpty()) {
					filteredMovies = movieList.stream()
							.filter(a -> Integer.parseInt(a.getYear()) == year)
							.map(Movie::getThis)
							.collect(toList());
				} else {
					filteredMovies = filteredMovies.stream()
							.filter(a -> Integer.parseInt(a.getYear()) == year)
							.map(Movie::getThis)
							.collect(toList());
				}
				return filteredMovies;
			}
		}
		return null;
	}

	/**
	 * For each word in the query, check if the movie contains that word, if it does, add it to the search results
	 *
	 * @param query The query string that the user entered.
	 * @return A list of movies that contain any of the words in the query.
	 */
	public List<Movie> searchForAny(String query) {
		if(query.equals("")) {
			return movieList;
		}
		List<String> query_split = List.of(query.replaceAll("[^A-Za-z0-9 ]", "").split(" "));
		query_split = query_split.stream().map(String::toLowerCase).collect(Collectors.toList());
		List<Movie> searchResults = new ArrayList<>();

		query_split.forEach(q -> {
			movieList.forEach(m -> {
				if(m.getDistinctWords().contains(q)) {
					if(!searchResults.contains(m))
						searchResults.add(m);
				}
			});
		});
		System.out.println("Result Size: " + searchResults.size());
		return searchResults;
	}

	/**
	 * Clear the filteredMovies list
	 */
	public void clearFilteredList() {
		filteredMovies.clear();
	}

	/**
	 * This function returns the filteredMovies list.
	 *
	 * @return The filteredMovies list is being returned.
	 */
	public List<Movie> getFilteredMovies() {
		return filteredMovies;
	}

	/**
	 * This function searches for a movie in the movieList by title and returns a list of movies that match the title
	 *
	 * @param title The title of the movie to search for.
	 * @return A list of movies that match the search criteria.
	 */
	public List<Movie> searchForMovie(String title) {
		if(title.equals("")) {
			return movieList;
		}
		String finalTitle = title.toLowerCase();
		return movieList.stream()
				.filter(a -> a.getTitle().toLowerCase().contains(finalTitle))
				.collect(Collectors.toList());
	}

	/**
	 * Get all actors from all movies in the movie list
	 *
	 * @return A list of all the actors in the movie list.
	 */
	public List<String> getAllActors() {
		return movieList.stream()
				.map(Movie::getActors)
				.flatMap(Collection::stream)
				.sorted(Comparator.naturalOrder())
				.collect(toList());
	}

	/**
	 * Get all the genres of the movies in the movie list
	 *
	 * @return A list of all the genres in the movie list.
	 */
	public List<String> getAllGenres() {
		return movieList.stream()
				.map(Movie::getGenre)
				.flatMap(Collection::stream)
				.sorted(Comparator.naturalOrder())
				.collect(toList());
	}

	/**
	 * Get all the titles of the movies in the movie list
	 *
	 * @return A list of all the titles in the movie list.
	 */
	public List<String> getAllTitles() {
		return movieList.stream()
				.map(Movie::getTitle)
				.sorted(Comparator.naturalOrder())
				.collect(toList());
	}

	/**
	 * Get all the directors of the movies in the movie list
	 *
	 * @return A list of all the directors in the movie list.
	 */
	public List<String> getAllDirectors() {
		return movieList.stream()
				.map(Movie::getDirector)
				.sorted(Comparator.naturalOrder())
				.collect(toList());
	}

	/**
	 * Get all the writers of all the movies in the movie list
	 *
	 * @return A list of all the writers in the movie list.
	 */
	public List<String> getAllWriters() {
		return movieList.stream()
				.map(Movie::getWriter)
				.sorted(Comparator.naturalOrder())
				.collect(toList());
	}

	/**
	 * Get all the languages of the movies in the list
	 *
	 * @return A list of all the languages in the movie list.
	 */
	public List<String> getAllLanguages() {
		return movieList.stream()
				.map(Movie::getLanguage)
				.sorted(Comparator.naturalOrder())
				.collect(toList());
	}

	/**
	 * We create a new AtomicReference object, which is a mutable object that can be used in a multi-threaded environment. We
	 * then use the forEach method to iterate through the movieList and append the title of each movie to the AtomicReference
	 * object
	 *
	 * @return A string of all the movie titles in the movieList.
	 */
	@Override
	public String toString() {
		AtomicReference<String> str = new AtomicReference<>("");
		movieList.forEach(m -> {
			String curr = str.get();
			curr += m.getTitle() + "\n";
			str.set(curr);
		});
		return str.get();
	}

	/**
	 * Print() prints the object.
	 */
	public void print() {
		System.out.println(this);
	}
}
