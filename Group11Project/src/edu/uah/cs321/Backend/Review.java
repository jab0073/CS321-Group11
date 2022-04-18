package edu.uah.cs321.Backend;

import java.io.Serializable;

/***
 * File Name: Review
 * Description: A Review is a movie review written by a user
 * @auth justinbushue
 * @version 1.0
 */
@SuppressWarnings("unused")
public class Review implements Serializable {
	User author;
	Movie movie;
	Integer rating;
	String body;

	public Review() {
		author = null;
		movie = null;
		rating = 0;
		body = "";
	}

	public Review(User author, Movie movie, Integer rating, String body) {
		this.author = author;
		this.movie = movie;
		this.rating = rating;
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Review)) return false;

		Review review = (Review) o;

		if (!getAuthor().equals(review.getAuthor())) return false;
		if (!getMovie().equals(review.getMovie())) return false;
		if (!getRating().equals(review.getRating())) return false;
		return getBody().equals(review.getBody());
	}

	@Override
	public int hashCode() {
		int result = getAuthor().hashCode();
		result = 31 * result + getMovie().hashCode();
		result = 31 * result + getRating().hashCode();
		result = 31 * result + getBody().hashCode();
		return result;
	}
}
