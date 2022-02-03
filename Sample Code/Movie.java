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
public class Movie {
	private final List<String> mpcrRatings;
	private String name;
	private String description;
	private String mpcr;
	private Float userRating;

	public Movie(){
		mpcrRatings = new ArrayList<>(Arrays.asList("G","PG","PG-13","R","NR"));
	}

	public Movie(String name, String description, String mpcr, Float userRating) {
		mpcrRatings = new ArrayList<>(Arrays.asList("G","PG","PG-13","R","NR"));
		this.name = name;
		this.description = description;
		if(mpcrRatings.contains(mpcr.toUpperCase())){
			this.mpcr = mpcr;
		}
		else {
			this.mpcr = "NOT SET";
		}
		this.userRating = userRating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMpcr() {
		return mpcr;
	}

	public boolean setMpcr(String mpcr) {
		if(!mpcrRatings.contains(mpcr.toUpperCase())){
			return false;
		}
		this.mpcr = mpcr.toUpperCase();
		return true;
	}

	public Float getUserRating() {
		return userRating;
	}

	public void setUserRating(Float userRating) {
		this.userRating = userRating;
	}

	public void setUserRating(float userRating) {
		this.userRating = Float.valueOf(userRating);
	}
	
}
