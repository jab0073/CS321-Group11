package edu.uah.cs321.Backend;

import java.io.Serializable;

/***
 * File Name: Rating
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class Rating implements Serializable {
	private String Source;
	private String Value;

	public Rating() {
		Source = "";
		Value = "";
	}

	public Rating(String source, String value) {
		Source = source;
		Value = value;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Rating)) return false;

		Rating rating = (Rating) o;

		if (!getSource().equals(rating.getSource())) return false;
		return getValue().equals(rating.getValue());
	}

	@Override
	public int hashCode() {
		int result = getSource().hashCode();
		result = 31 * result + getValue().hashCode();
		return result;
	}
}
