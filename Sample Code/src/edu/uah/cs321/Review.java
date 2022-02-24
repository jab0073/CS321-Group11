package edu.uah.cs321;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: Review
 * Description: A Review is a movie review written by a user
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class Review {
	String author;
	Movie movie;
	Double rating;
	String body;

	public Review() {
		author = "";
		movie = null;
		rating = 0.0;
		body = "";
	}

	public Review(String author, Movie movie, Double rating, String body) {
		this.author = author;
		this.movie = movie;
		this.rating = rating;
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
