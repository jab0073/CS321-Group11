package edu.uah.cs321;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")
/**
 * A Movie object contains all the information about a movie
 * Project Name: GroupProject-InitialThoughts
 * File Name: AuthSystem
 * Description:
 * @author justinbushue
 * @version 1.0
 */
public class Movie {
	private final List<String> mpcrRatings = new ArrayList<>(Arrays.asList("G","PG","PG-13","R","NR"));
	private String title;
	private String plot;
	private String rating;
	private String year;
	private String released;
	private String genre;
	private String runtime;
	private String director;
	private String writer;
	private String awards;
	private String language;
	private String poster;
	private String metaScore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String type;
	private String dvd;
	private String boxOffice;
	private String production;
	private String website;
	private String response;
	private String actors;
	private List<Review> userReviews = null;

	// This is a constructor for the Movie class. It initializes the userReviews list to an empty list.
	public Movie(){
		userReviews = new ArrayList<>();
	}
	// This is a constructor for the Movie class. It initializes all the fields to their corresponding parameter.
	public Movie(String title, String plot, String rating, String year, String released, String genre, String runtime, String director, String writer, String awards, String language, String poster, String metaScore, String imdbRating, String imdbVotes, String imdbID, String type, String dvd, String boxOffice, String production, String website, String response, String actors) {
		userReviews = new ArrayList<>();
		this.title = title;
		this.plot = plot;
		if (mpcrRatings.contains(rating.toUpperCase())) {
			this.rating = rating;
		} else {
			this.rating = "N/A";
		}
		this.year = year;
		this.released = released;
		this.genre = genre;
		this.runtime = runtime;
		this.director = director;
		this.writer = writer;
		this.awards = awards;
		this.language = language;
		this.poster = poster;
		this.metaScore = metaScore;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.imdbID = imdbID;
		this.type = type;
		this.dvd = dvd;
		this.boxOffice = boxOffice;
		this.production = production;
		this.website = website;
		this.response = response;
		this.actors = actors;
	}

	// This is a constructor for the Movie class. It initializes all the fields to their corresponding parameter.
	public Movie(String title, String plot, String rating, String year) {
		this.title = title;
		this.plot = plot;
		this.rating = rating;
		this.year = year;
	}

	/**
	 * It sets the plot of the movie.
	 *
	 * @param plot The plot of the movie.
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/**
	 * Returns the year of the movie.
	 *
	 * @return The year as an integer.
	 */
	public int getYear() {
		return Integer.parseInt(this.year);
	}

	/**
	 * It sets the year of the movie.
	 *
	 * @param year The year of the movie.
	 */
	public void setYear(int year) {
		this.year = String.valueOf(year);
	}

	/**
	 * Returns the value of the released property
	 *
	 * @return The released variable.
	 */
	public String getReleased() {
		return released;
	}

	/**
	 * It sets the released attribute of the object to the value passed in.
	 *
	 * @param released The date the movie was released.
	 */
	public void setReleased(String released) {
		this.released = released;
	}

	/**
	 * Returns the genre of the movie
	 *
	 * @return The genre of the movie.
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * It sets the genre of the movie.
	 *
	 * @param genre The genre of the movie.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Returns the runtime of the movie
	 *
	 * @return The runtime of the movie.
	 */
	public String getRuntime() {
		return runtime;
	}

	/**
	 * It sets the runtime of the movie.
	 *
	 * @param runtime The runtime to use for the job.
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	/**
	 * Returns the director of the movie
	 *
	 * @return The director field of the Movie object.
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * It sets the director of the movie.
	 *
	 * @param director The name of the director of the movie.
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Returns the writer of the movie
	 *
	 * @return The writer variable.
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * It sets the writer of the movie.
	 *
	 * @param writer The name of the writer.
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}

	/**
	 * Returns the awards field
	 *
	 * @return The awards string.
	 */
	public String getAwards() {
		return awards;
	}

	/**
	 * It sets the awards field of the object to the value of the awards parameter.
	 *
	 * @param awards The awards the movie won.
	 */
	public void setAwards(String awards) {
		this.awards = awards;
	}

	/**
	 * Returns the language of the movie
	 *
	 * @return The language variable is being returned.
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * It sets the language of the movie.
	 *
	 * @param language The language of the movie.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * This function returns the poster url of the movie
	 *
	 * @return The method returns the value of the poster field.
	 */
	public String getPoster() {
		return poster;
	}

	/**
	 * It sets the poster url of the movie.
	 *
	 * @param poster The URL of the poster image.
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}

	/**
	 * This function returns the value of the metaScore variable
	 *
	 * @return The value of the metaScore variable.
	 */
	public String getMetaScore() {
		return metaScore;
	}

	/**
	 * This function sets the value of the metaScore variable to the value of the metaScore parameter
	 *
	 * @param metaScore The Metascore (out of 100?) for the movie, if available.
	 */
	public void setMetaScore(String metaScore) {
		this.metaScore = metaScore;
	}

	/**
	 * This function returns the imdbRating of the movie
	 *
	 * @return The imdbRating field of the Movie object.
	 */
	public String getImdbRating() {
		return imdbRating;
	}

	/**
	 * It sets the imdbRating of the movie.
	 *
	 * @param imdbRating The IMDB rating of the movie.
	 */
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	/**
	 * This function returns the value of the imdbVotes field
	 *
	 * @return The imdbVotes variable is being returned.
	 */
	public String getImdbVotes() {
		return imdbVotes;
	}

	/**
	 * This function sets the imdbVotes field of the Movie object to the value of the imdbVotes parameter
	 *
	 * @param imdbVotes The number of votes the movie received on IMDb.
	 */
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	/**
	 * This function returns the imdbID of the movie
	 *
	 * @return The imdbID is being returned as a float.
	 */
	public float getImdbID() {
		return Float.parseFloat(imdbID);
	}

	/**
	 * This function sets the imdbID of the movie to the value of the imdbID parameter
	 *
	 * @param imdbID The IMDB ID of the movie.
	 */
	public void setImdbID(float imdbID) {
		this.imdbID = String.valueOf(imdbID);
	}

	/**
	 * Returns the type of the movie
	 *
	 * @return The type of the movie.
	 */
	public String getType() {
		return type;
	}

	/**
	 * It sets the type of the movie.
	 *
	 * @param type The type of the parameter. This is a string.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the value of the dvd field
	 *
	 * @return The value of the dvd field.
	 */
	public String getDvd() {
		return dvd;
	}

	/**
	 * It sets the dvd field to the value of the dvd parameter.
	 *
	 * @param dvd The name of the DVD.
	 */
	public void setDvd(String dvd) {
		this.dvd = dvd;
	}

	/**
	 * It returns the box office of the movie.
	 *
	 * @return The box office value.
	 */
	public String getBoxOffice() {
		return boxOffice;
	}

	/**
	 * It sets the box office value.
	 *
	 * @param boxOffice The box office of the movie.
	 */
	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	/**
	 * It returns the production of the movie.
	 *
	 * @return The production of the movie.
	 */
	public String getProduction() {
		return production;
	}

	/**
	 * It sets the production of the movie.
	 *
	 * @param production The name of the production.
	 */
	public void setProduction(String production) {
		this.production = production;
	}

	/**
	 * This function returns the website of the movie
	 *
	 * @return The website field of the Movie object.
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * It sets the website of the Movie.
	 *
	 * @param website The website of the Movie.
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * This function returns the response of the Movie
	 *
	 * @return The response string.
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * It sets the response variable to the value of the response parameter.
	 *
	 * @param response The response of the movie.
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * Returns a list of actors in the movie
	 *
	 * @return A list of actors as strings.
	 */
	public List<String> getActors() {
		return Arrays.asList(actors.split(", "));
	}

	/**
	 * It takes a list of actors as strings and joins them with a comma and space.
	 *
	 * @param actors A list of actors that are in the movie.
	 */
	public void setActors(List<String> actors) {
		this.actors = String.join(", ", actors);
	}

	/**
	 * It returns the title of the movie.
	 *
	 * @return The title of the movie.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * It sets the title of the movie.
	 *
	 * @param title The title of the movie.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * It returns the plot of the movie.
	 *
	 * @return The plot of the movie.
	 */
	public String getPlot() {
		return plot;
	}

	/**
	 * This function returns the rating of the movie
	 *
	 * @return The rating of the movie.
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * This function sets the rating of the movie to the given MPCR rating
	 *
	 * @param mpcr The MPCR rating.
	 * @return Nothing.
	 */
	public boolean setRating(String mpcr) {
		if(!mpcrRatings.contains(mpcr.toUpperCase())){
			return false;
		}
		this.rating = mpcr.toUpperCase();
		return true;
	}

	/**
	 * Adds a review to the user's list of reviews
	 *
	 * @param r The review to add to the user's list of reviews.
	 */
	public void addUserRating(Review r) {
		userReviews.add(r);
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
		return String.join("; ",title, rating, year, genre, director, writer, language, actors);
	}
}
