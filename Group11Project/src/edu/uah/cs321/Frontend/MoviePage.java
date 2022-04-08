package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/***
 * File Name: MoviePage
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class MoviePage extends JPanel {
	private static Movie movie;

	private static JLabel movieTitleLabel;
	private static JLabel movieDirectorLabel;
	private static JLabel movieWritersLabel;
	private static JLabel movieYearLabel;
	private static JLabel moviePlotLabel;
	private static JLabel movieGenresLabel;
	private static JLabel movieReleaseLabel;
	private static JLabel movieActorsLabel;
	private static JLabel movieRuntimesLabel;

	private static JPanel contentPanel;
	private static JPanel movieInfoPanel;

	private static JButton addToFavoritesButton;


	public MoviePage(Movie movie) {
		super();
		this.movie = movie;

		contentPanel = new JPanel();
		movieInfoPanel = new JPanel();

		movieTitleLabel = new JLabel(this.movie.getTitle());
		movieDirectorLabel = new JLabel(this.movie.getDirector());
		movieWritersLabel = new JLabel(this.movie.getWriter());
		movieYearLabel = new JLabel(String.valueOf(this.movie.getYear()));
		moviePlotLabel = new JLabel(this.movie.getPlot());
		movieGenresLabel = new JLabel(this.movie.getGenre());
		movieReleaseLabel = new JLabel(this.movie.getReleased());
		movieActorsLabel = new JLabel(String.join(", ", this.movie.getActors()));
		movieRuntimesLabel = new JLabel(this.movie.getRuntime());

		addToFavoritesButton = new JButton("<3");
		addToFavoritesButton.addActionListener(a -> {
			AccountPage.getUser().addMovieToFavoriteMovies(movie);
		});

		movieInfoPanel.add(movieTitleLabel, Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(movieActorsLabel, Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(movieDirectorLabel,Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(movieYearLabel, Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(movieGenresLabel,Component.CENTER_ALIGNMENT);

		contentPanel.add(movieInfoPanel, Component.CENTER_ALIGNMENT);
		contentPanel.add(addToFavoritesButton, Component.CENTER_ALIGNMENT);
		add(contentPanel,Component.CENTER_ALIGNMENT);
	}
}
