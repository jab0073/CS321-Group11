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

	public List<String> getDistinctWords() {
		return distinctWords;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Movie)) return false;

		Movie movie = (Movie) o;

		if (mpcrRatings != null ? !mpcrRatings.equals(movie.mpcrRatings) : movie.mpcrRatings != null) return false;
		if (!getTitle().equals(movie.getTitle())) return false;
		if (!getPlot().equals(movie.getPlot())) return false;
		if (getRating() != null ? !getRating().equals(movie.getRating()) : movie.getRating() != null) return false;
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

	@Override
	public int hashCode() {
		int result = mpcrRatings != null ? mpcrRatings.hashCode() : 0;
		result = 31 * result + getTitle().hashCode();
		result = 31 * result + getPlot().hashCode();
		result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
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

	@Override
	public String toString() {
		return String.join("; ",Title, Rating, Year, Genre, Director, Writer, Language, Actors);	}

	public static void openMovie(Movie m){
		JDialog movieInfo = new JDialog();
		movieInfo.setMaximumSize(new Dimension(750,1000));
		movieInfo.setMinimumSize(new Dimension(750,1000));
		MoviePage moviePage = new MoviePage(m);
		movieInfo.add(moviePage);
		movieInfo.setVisible(true);
		movieInfo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
}
