package edu.uah.cs321.Backend;

/***
 * Project Name: Group11Project
 * File Name: Rating
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class Rating {
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
}
