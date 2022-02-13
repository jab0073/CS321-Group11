package edu.uah.cs321;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: MovieList
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class MovieList {
	private static List<Movie> movieList;
	private static List<Movie> filteredMovies;

	public MovieList() {
		movieList = new ArrayList<>();
		filteredMovies = new ArrayList<>();
	}

	public MovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public void addMovie(Movie movie) {
		movieList.add(movie);
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public List<Movie> filterByActor(String actor) {
		if(filteredMovies.isEmpty()) {
			filteredMovies = movieList.stream()
					.filter(a -> a.getActors().contains(actor))
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		else {
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getActors().contains(actor))
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		return filteredMovies;
	}

	public List<Movie> filterByDirector(String director) {
		if(filteredMovies.isEmpty()) {
			filteredMovies = movieList.stream()
					.filter(a -> a.getDirector().equals(director))
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		else {
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getDirector().equals(director))
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		return filteredMovies;
	}
	public List<Movie> filterByGenre(String genre) {
		if(filteredMovies.isEmpty()) {
			filteredMovies = movieList.stream()
					.filter(a -> a.getGenre().equals(genre))
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		else {
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getGenre().equals(genre))
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		return filteredMovies;
	}
	public List<Movie> filterByRating(String rating) {
		if(filteredMovies.isEmpty()) {
			filteredMovies = movieList.stream()
					.filter(a -> a.getRating().equals(rating))
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		else {
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getRating().equals(rating))
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		return filteredMovies;
	}

	public List<Movie> filterByYear(int year) {
		if(filteredMovies.isEmpty()) {
			filteredMovies = movieList.stream()
					.filter(a -> a.getYear() == year)
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		else {
			filteredMovies = filteredMovies.stream()
					.filter(a -> a.getYear() == year)
					.map(Movie::getThis)
					.collect(Collectors.toList());
		}
		return filteredMovies;
	}
	
	public void clearFilteredList() {
		filteredMovies.clear();
	}
}
