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
	// Used to hold the reviews author.
	User author;
	// Used to hold the movie the review is for.
	Movie movie;
	// Used to hold the reviews rating.
	Integer rating;
	// Used to hold the body of the review.
	String body;

	// This is a constructor that sets the default values for the Review class.
	public Review() {
		author = null;
		movie = null;
		rating = 0;
		body = "";
	}

	// This is a constructor that sets the default values for the Review class.
	public Review(User author, Movie movie, Integer rating, String body) {
		this.author = author;
		this.movie = movie;
		this.rating = rating;
		this.body = body;
	}

	/**
	 * This function returns the author of the post.
	 *
	 * @return The author of the post.
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * This function sets the author of the post to the user passed in as a parameter.
	 *
	 * @param author The author of the post.
	 */
	public void setAuthor(User author) {
		this.author = author;
	}

	/**
	 * This function returns the movie.
	 *
	 * @return The movie object.
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * This function sets the movie of the current object to the movie passed in as a parameter.
	 *
	 * @param movie The movie object that will be used to populate the form.
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * > This function returns the rating of the movie
	 *
	 * @return The rating of the movie.
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * > This function sets the rating of the movie
	 *
	 * @param rating The rating of the movie.
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * > This function returns the body of the email
	 *
	 * @return The body of the email.
	 */
	public String getBody() {
		return body;
	}

	/**
	 * > This function sets the body of the email
	 *
	 * @param body The body of the message.
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * If the author, movie, rating, and body of the current review are equal to the author, movie, rating, and body of the
	 * review passed in, then the reviews are equal
	 *
	 * @param o The object to compare to.
	 * @return The hashcode of the object.
	 */
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

	/**
	 * > The hashCode() function returns a unique integer for each unique Review object
	 *
	 * @return The hash code of the object.
	 */
	@Override
	public int hashCode() {
		int result = getAuthor().hashCode();
		result = 31 * result + getMovie().hashCode();
		result = 31 * result + getRating().hashCode();
		result = 31 * result + getBody().hashCode();
		return result;
	}
}
