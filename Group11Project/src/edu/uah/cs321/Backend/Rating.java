package edu.uah.cs321.Backend;

import java.io.Serializable;

/***
 * File Name: Rating
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class Rating implements Serializable {
	// Used to hold the ratings source.
	private String Source;
	// Used to hold the ratings value.
	private String Value;

	// This is a constructor that sets the source and value to empty strings.
	public Rating() {
		Source = "";
		Value = "";
	}

	// This is a constructor that sets the source and value to the values passed in.
	public Rating(String source, String value) {
		Source = source;
		Value = value;
	}

	/**
	 * It returns the value of the Source variable.
	 *
	 * @return The Source variable is being returned.
	 */
	public String getSource() {
		return Source;
	}

	/**
	 * > This function sets the source of the current object to the source passed in as a parameter
	 *
	 * @param source The source of the tweet.
	 */
	public void setSource(String source) {
		Source = source;
	}

	/**
	 * This function returns the value of the variable Value
	 *
	 * @return The value of the variable Value.
	 */
	public String getValue() {
		return Value;
	}

	/**
	 * This function sets the value of the Value variable to the value of the value parameter.
	 *
	 * @param value The value of the parameter.
	 */
	public void setValue(String value) {
		Value = value;
	}

	/**
	 * If the source and value are equal, then the objects are equal.
	 *
	 * @param o The object to compare to.
	 * @return The hashcode of the object.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Rating)) return false;

		Rating rating = (Rating) o;

		if (!getSource().equals(rating.getSource())) return false;
		return getValue().equals(rating.getValue());
	}

	/**
	 * > The hashCode() function returns a unique integer for each unique object
	 *
	 * @return The hash code of the object.
	 */
	@Override
	public int hashCode() {
		int result = getSource().hashCode();
		result = 31 * result + getValue().hashCode();
		return result;
	}
}
