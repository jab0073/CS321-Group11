package edu.uah.cs321;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: Movie
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class Movie {
	private final List<String> mpcrRatings;
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

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public int getYear() {
		return Integer.parseInt(this.year);
	}

	public void setYear(int year) {
		this.year = String.valueOf(year);
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(String metaScore) {
		this.metaScore = metaScore;
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

	public float getImdbID() {
		return Float.parseFloat(imdbID);
	}

	public void setImdbID(float imdbID) {
		this.imdbID = String.valueOf(imdbID);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDvd() {
		return dvd;
	}

	public void setDvd(String dvd) {
		this.dvd = dvd;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<String> getActors() {
		return Arrays.asList(actors.split(", "));
	}

	public void setActors(List<String> actors) {

		this.actors = String.join(", ", actors);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlot() {
		return plot;
	}

	public void setDescription(String description) {
		this.plot = description;
	}

	public String getRating() {
		return rating;
	}

	public boolean setRating(String mpcr) {
		if(!mpcrRatings.contains(mpcr.toUpperCase())){
			return false;
		}
		this.rating = mpcr.toUpperCase();
		return true;
	}

	public Movie(){
		mpcrRatings = new ArrayList<>(Arrays.asList("G","PG","PG-13","R","NR"));
	}

	public Movie(String title, String plot, String rating, String year, String released, String genre, String runtime, String director, String writer, String awards, String language, String poster, String metaScore, String imdbRating, String imdbVotes, String imdbID, String type, String dvd, String boxOffice, String production, String website, String response, String actors) {
		mpcrRatings = new ArrayList<>(Arrays.asList("G","PG","PG-13","R","NR"));
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
}
