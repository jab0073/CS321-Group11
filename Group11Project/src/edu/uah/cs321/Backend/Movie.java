package edu.uah.cs321.Backend;

import edu.uah.cs321.Frontend.MoviePage;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

@SuppressWarnings("unused")
/**
 * File Name: AuthSystem
 * Description: A Movie object contains all the information about a movie
 * @author justinbushue
 * @version 1.0
 */
public class Movie implements Serializable {
	private final List<String> mpcrRatings = new ArrayList<>(Arrays.asList("G","PG","PG-13","R","NR"));
	private String Title;
	private String Plot;
	private String Rated;
	private String Year;
	private String Released;
	private String Genre;
	private String Runtime;
	private String Director;
	private String Writer;
	private String Awards;
	private String Language;
	private String Country;
	private String Poster;
	private List<Rating> Ratings;
	private String Metascore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String Type;
	private String DVD;
	private String BoxOffice;
	private String Production;
	private String Website;
	private String Response;
	private String Actors;
	private List<String> distinctWords;

	private List<Review> userReviews;

	// This is a constructor for the Movie class. It initializes the userReviews list to an empty list.
	public Movie(){
		userReviews = new ArrayList<>();
		Ratings = new ArrayList<>();
	}
	// This is a constructor for the Movie class. It initializes all the fields to their corresponding parameter.
	public Movie(String title, String plot, String rating, String year, String released, String genre, String runtime, String director, String writer, String awards, String language, String poster, String metaScore, String imdbRating, String imdbVotes, String imdbID, String type, String dvd, String boxOffice, String production, String website, String response, String actors) {
		userReviews = new ArrayList<>();
		Ratings = new ArrayList<>();
		this.Title = title;
		this.Plot = plot;
		if (mpcrRatings.contains(rating.toUpperCase())) {
			this.Rated = rating;
		} else {
			this.Rated = "N/A";
		}
		this.Year = year;
		this.Released = released;
		this.Genre = genre;
		this.Runtime = runtime;
		this.Director = director;
		this.Writer = writer;
		this.Awards = awards;
		this.Language = language;
		this.Poster = poster;
		this.Metascore = metaScore;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.imdbID = imdbID;
		this.Type = type;
		this.DVD = dvd;
		this.BoxOffice = boxOffice;
		this.Production = production;
		this.Website = website;
		this.Response = response;
		this.Actors = actors;

	}

	// This is a constructor for the Movie class. It initializes all the fields to their corresponding parameter.
	public Movie(String title, String plot, String rating, String year) {
		userReviews = new ArrayList<>();
		Ratings = new ArrayList<>();
		this.Title = title;
		this.Plot = plot;
		this.Rated = rating;
		this.Year = year;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		Plot = plot;
	}

	public String getRated() {
		return Rated;
	}

	public void setRated(String rated) {
		Rated = rated;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getReleased() {
		return Released;
	}

	public void setReleased(String released) {
		Released = released;
	}

	public List<String> getGenre() {
		return List.of(Genre.split(", "));
	}

	public List<String> getGenreLower() {
		return List.of(Genre.toLowerCase().split(", "));
	}

	public void setGenre(List<String> genre) {
		Genre = String.join(", ", genre);
	}

	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String runtime) {
		Runtime = runtime;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getAwards() {
		return Awards;
	}

	public void setAwards(String awards) {
		Awards = awards;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public List<Rating> getRatings() {
		return Ratings;
	}

	public void setRatings(List<Rating> ratings) {
		Ratings = ratings;
	}

	public String getMetascore() {
		return Metascore;
	}

	public void setMetascore(String metascore) {
		Metascore = metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDVD() {
		return DVD;
	}

	public void setDVD(String DVD) {
		this.DVD = DVD;
	}

	/**
	 * This function returns the box office of the movie
	 *
	 * @return The BoxOffice variable is being returned.
	 */
	public String getBoxOffice() {
		return BoxOffice;
	}

	/**
	 * This function sets the box office of the movie
	 *
	 * @param boxOffice The box office revenue of the movie.
	 */
	public void setBoxOffice(String boxOffice) {
		BoxOffice = boxOffice;
	}

	/**
	 * This function returns the production of the movie
	 *
	 * @return The Production variable is being returned.
	 */
	public String getProduction() {
		return Production;
	}

	/**
	 * This function sets the production of the movie
	 *
	 * @param production The name of the production you want to use.
	 */
	public void setProduction(String production) {
		Production = production;
	}

	/**
	 * This function returns the website of the Movie
	 *
	 * @return The website of the company.
	 */
	public String getWebsite() {
		return Website;
	}

	/**
	 * This function sets the website of the Movie
	 *
	 * @param website The website you want to get the data from.
	 */
	public void setWebsite(String website) {
		Website = website;
	}

	/**
	 * This function returns the response of the Movie
	 *
	 * @return The response is being returned.
	 */
	public String getResponse() {
		return Response;
	}

	/**
	 * This function sets the response of the Movie
	 *
	 * @param response The response of the Movie.
	 */
	public void setResponse(String response) {
		Response = response;
	}

	/**
	 * Return a list of strings, where each string is an actor's name, and the list is populated by splitting the Actors
	 * property on commas.
	 *
	 * @return A list of strings.
	 */
	public List<String> getActors() {
		return Arrays.asList(Actors.split(", "));
	}

	public List<String> getActorsLower() {
		return Arrays.asList(Actors.toLowerCase().split(", "));
	}

	/**
	 * > The function takes a list of strings and joins them together with a comma and a space in between each string
	 *
	 * @param actors A list of actors in the movie.
	 */
	public void setActors(List<String> actors) {
		Actors = String.join(", ", actors);
	}

	/**
	 * > This function returns a list of reviews that the user has written
	 *
	 * @return A list of reviews.
	 */
	public List<Review> getUserReviews() {
		return userReviews;
	}

	/**
	 * This function sets the userReviews variable to the userReviews parameter
	 *
	 * @param userReviews A list of reviews that the user has written.
	 */
	public void setUserReviews(List<Review> userReviews) {
		this.userReviews = userReviews;
	}

	/**
	 * If the userReviews list is null, create a new list and add the review to it
	 *
	 * @param review The review object that is to be added to the list of reviews.
	 */
	public void addReview(Review review) {
		if(userReviews == null) {
			userReviews = new ArrayList<>();
		}
		this.userReviews.add(review);
	}

	/**
	 * Returns a reference to the current Movie object
	 *
	 * @return The Movie object that is being returned is the object that is being called in the getThis() method.
	 */
	public Movie getThis() {
		return this;
	}

	/**
	 * This function returns a string of all the movie's attributes separated by semicolons
	 *
	 * @return The string "title; rating; year; genre; director; writer; language; actors"
	 */
	public String getAttributes() {
		return toString();
	}

	/**
	 * It takes the title, plot, genre, director, writer, and actors of the movie and adds them to a list of words. It then
	 * converts all the words to lowercase and removes duplicates
	 */
	public void generateDistinctWords() {
		List<String> words = new ArrayList<String>();
		words.addAll(List.of(getTitle().replaceAll("[^A-Za-z0-9 ]", "").split(" ")));
		words.addAll(List.of(getPlot().replaceAll("[^A-Za-z0-9 ]", "").split(" ")));
		words.addAll(getGenre());
		words.addAll(List.of(getDirector().replaceAll("[^A-Za-z0-9 ]", "").split(" ")));
		words.addAll(List.of(getWriter().replaceAll("[^A-Za-z0-9 ]", "").split(" ")));
		words.addAll(getActors());
		words = words.stream().map(String::toLowerCase).collect(Collectors.toList());
		distinctWords = words.stream().distinct().collect(Collectors.toList());
	}

	/**
	 * This function returns a list of distinct words
	 *
	 * @return A list of distinct words.
	 */
	public List<String> getDistinctWords() {
		if(distinctWords == null) {
			generateDistinctWords();
		}
		return distinctWords;
	}

	/**
	 * If the two movies have the same title, plot, rated, year, released, genre, runtime, director, writer, awards, language,
	 * country, poster, ratings, metascore, imdbRating, imdbVotes, imdbID, type, DVD, boxOffice, production, website,
	 * response, actors, and userReviews, then they are equal
	 *
	 * @param o The object to be compared.
	 * @return The hashcode of the object.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Movie)) return false;

		Movie movie = (Movie) o;

		if (mpcrRatings != null ? !mpcrRatings.equals(movie.mpcrRatings) : movie.mpcrRatings != null) return false;
		if (!getTitle().equals(movie.getTitle())) return false;
		if (!getPlot().equals(movie.getPlot())) return false;
		if (getRated() != null ? !getRated().equals(movie.getRated()) : movie.getRated() != null) return false;
		if (!getYear().equals(movie.getYear())) return false;
		if (!getReleased().equals(movie.getReleased())) return false;
		if (!getGenre().equals(movie.getGenre())) return false;
		if (getRuntime() != null ? !getRuntime().equals(movie.getRuntime()) : movie.getRuntime() != null) return false;
		if (!getDirector().equals(movie.getDirector())) return false;
		if (!getWriter().equals(movie.getWriter())) return false;
		if (getAwards() != null ? !getAwards().equals(movie.getAwards()) : movie.getAwards() != null) return false;
		if (getLanguage() != null ? !getLanguage().equals(movie.getLanguage()) : movie.getLanguage() != null)
			return false;
		if (getCountry() != null ? !getCountry().equals(movie.getCountry()) : movie.getCountry() != null) return false;
		if (getPoster() != null ? !getPoster().equals(movie.getPoster()) : movie.getPoster() != null) return false;
		if (getRatings() != null ? !getRatings().equals(movie.getRatings()) : movie.getRatings() != null) return false;
		if (getMetascore() != null ? !getMetascore().equals(movie.getMetascore()) : movie.getMetascore() != null)
			return false;
		if (getImdbRating() != null ? !getImdbRating().equals(movie.getImdbRating()) : movie.getImdbRating() != null)
			return false;
		if (getImdbVotes() != null ? !getImdbVotes().equals(movie.getImdbVotes()) : movie.getImdbVotes() != null)
			return false;
		if (getImdbID() != null ? !getImdbID().equals(movie.getImdbID()) : movie.getImdbID() != null) return false;
		if (getType() != null ? !getType().equals(movie.getType()) : movie.getType() != null) return false;
		if (getDVD() != null ? !getDVD().equals(movie.getDVD()) : movie.getDVD() != null) return false;
		if (getBoxOffice() != null ? !getBoxOffice().equals(movie.getBoxOffice()) : movie.getBoxOffice() != null)
			return false;
		if (getProduction() != null ? !getProduction().equals(movie.getProduction()) : movie.getProduction() != null)
			return false;
		if (getWebsite() != null ? !getWebsite().equals(movie.getWebsite()) : movie.getWebsite() != null) return false;
		if (getResponse() != null ? !getResponse().equals(movie.getResponse()) : movie.getResponse() != null)
			return false;
		if (!getActors().equals(movie.getActors())) return false;
		return getUserReviews() != null ? getUserReviews().equals(movie.getUserReviews()) : movie.getUserReviews() == null;
	}

	/**
	 * The hashCode() function returns a unique integer value for each unique movie object
	 *
	 * @return The hashcode of the object.
	 */
	@Override
	public int hashCode() {
		int result = mpcrRatings != null ? mpcrRatings.hashCode() : 0;
		result = 31 * result + getTitle().hashCode();
		result = 31 * result + getPlot().hashCode();
		result = 31 * result + (getRated() != null ? getRated().hashCode() : 0);
		result = 31 * result + getYear().hashCode();
		result = 31 * result + getReleased().hashCode();
		result = 31 * result + getGenre().hashCode();
		result = 31 * result + (getRuntime() != null ? getRuntime().hashCode() : 0);
		result = 31 * result + getDirector().hashCode();
		result = 31 * result + getWriter().hashCode();
		result = 31 * result + (getAwards() != null ? getAwards().hashCode() : 0);
		result = 31 * result + (getLanguage() != null ? getLanguage().hashCode() : 0);
		result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
		result = 31 * result + (getPoster() != null ? getPoster().hashCode() : 0);
		result = 31 * result + (getRatings() != null ? getRatings().hashCode() : 0);
		result = 31 * result + (getMetascore() != null ? getMetascore().hashCode() : 0);
		result = 31 * result + (getImdbRating() != null ? getImdbRating().hashCode() : 0);
		result = 31 * result + (getImdbVotes() != null ? getImdbVotes().hashCode() : 0);
		result = 31 * result + (getImdbID() != null ? getImdbID().hashCode() : 0);
		result = 31 * result + (getType() != null ? getType().hashCode() : 0);
		result = 31 * result + (getDVD() != null ? getDVD().hashCode() : 0);
		result = 31 * result + (getBoxOffice() != null ? getBoxOffice().hashCode() : 0);
		result = 31 * result + (getProduction() != null ? getProduction().hashCode() : 0);
		result = 31 * result + (getWebsite() != null ? getWebsite().hashCode() : 0);
		result = 31 * result + (getResponse() != null ? getResponse().hashCode() : 0);
		result = 31 * result + getActors().hashCode();
		result = 31 * result + (getUserReviews() != null ? getUserReviews().hashCode() : 0);
		return result;
	}

	/**
	 * The function `toString()` is a method of the class `Object` that returns a string representation of the object
	 *
	 * @return A string of the movie's title, rating, year, genre, director, writer, language, and actors.
	 */
	@Override
	public String toString() {
		return String.join("; ",Title, Rated, Year, Genre, Director, Writer, Language, Actors);
	}

	/**
	 * This function creates a new JDialog, sets its size, creates a new MoviePage object, adds the MoviePage object to the
	 * JDialog, and makes the JDialog visible
	 */
	public void openMovie(){
		JDialog movieInfo = new JDialog();
		movieInfo.setMaximumSize(new Dimension(750,1000));
		movieInfo.setMinimumSize(new Dimension(750,1000));
		MoviePage moviePage = new MoviePage(this);
		movieInfo.add(moviePage);
		movieInfo.setVisible(true);
		movieInfo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
