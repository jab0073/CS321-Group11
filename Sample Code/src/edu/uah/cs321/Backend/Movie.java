package edu.uah.cs321.Backend;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")
/**
 * Project Name: GroupProject-InitialThoughts
 * File Name: AuthSystem
 * Description: A Movie object contains all the information about a movie
 * @author justinbushue
 * @version 1.0
 */
public class Movie {
	private final List<String> mpcrRatings = new ArrayList<>(Arrays.asList("G","PG","PG-13","R","NR"));
	private String Title;
	private String Plot;
	private String Rating;
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
	private List<Review> userReviews = null;

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
			this.Rating = rating;
		} else {
			this.Rating = "N/A";
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
		this.Rating = rating;
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

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public int getYear() {
		return Integer.parseInt(Year);
	}

	public void setYear(int year) {
		Year = Integer.toString(year);
	}

	public String getReleased() {
		return Released;
	}

	public void setReleased(String released) {
		Released = released;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
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

	public String getBoxOffice() {
		return BoxOffice;
	}

	public void setBoxOffice(String boxOffice) {
		BoxOffice = boxOffice;
	}

	public String getProduction() {
		return Production;
	}

	public void setProduction(String production) {
		Production = production;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}

	public List<String> getActors() {
		return Arrays.asList(Actors.split(", "));
	}

	public void setActors(List<String> actors) {
		Actors = String.join(", ", actors);
	}

	public List<Review> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(List<Review> userReviews) {
		this.userReviews = userReviews;
	}

	public void addReview(Review review) {
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

	@Override
	public String toString() {
		return String.join("; ",Title, Rating, Year, Genre, Director, Writer, Language, Actors);	}
}
