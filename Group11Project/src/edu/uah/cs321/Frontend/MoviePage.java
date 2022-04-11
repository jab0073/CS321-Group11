package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.Movie;
import edu.uah.cs321.Backend.Review;
import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * File Name: MoviePage
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class MoviePage extends JPanel {
	private static Movie movie;
	private static User u;

	private static JLabel movieTitleLabel;
	private static JLabel movieDirectorLabel;
	private static JLabel movieWritersLabel;
	private static JLabel moviePlotLabel;
	private static JLabel movieGenresLabel;
	private static JLabel movieReleaseLabel;
	private static JLabel movieActorsLabel;
	private static JLabel movieRuntimesLabel;
	private static JLabel ratingLabel;
	private static JLabel reviewLabel;

	private static JPanel contentPanel;
	private static JPanel movieInfoPanel;
	private static JPanel userReviewPanel;

	private static JScrollPane reviewPane;

	private static JTextField ratingTextField;
	private static JTextArea reviewTextArea;

	private static JButton addToFavoritesButton;
	private static JButton saveReviewButton;


	public MoviePage(Movie movie) {
		super();
		this.movie = movie;
		u=AccountPage.getUser();

		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
		movieInfoPanel = new JPanel();
		movieInfoPanel.setLayout(new BoxLayout(movieInfoPanel,BoxLayout.Y_AXIS));
		userReviewPanel = new JPanel();
		userReviewPanel.setLayout(new BoxLayout(userReviewPanel,BoxLayout.Y_AXIS));

		movieTitleLabel = new JLabel("Title:  " + this.movie.getTitle());
		movieDirectorLabel = new JLabel("Director:  " + this.movie.getDirector());
		movieWritersLabel = new JLabel("Writers:  " + this.movie.getWriter());
		moviePlotLabel = new JLabel("Plot:  " + this.movie.getPlot());
		movieGenresLabel = new JLabel("Genre:  " + this.movie.getGenre());
		movieReleaseLabel = new JLabel("Release Date:  " + this.movie.getReleased());
		movieActorsLabel = new JLabel("Actors:  " + String.join(", ", this.movie.getActors()));
		movieRuntimesLabel = new JLabel("Runtime:  " + this.movie.getRuntime());
		ratingLabel = new JLabel("Rating");
		reviewLabel = new JLabel("Review");


		addToFavoritesButton = new JButton("Favorite");
		addToFavoritesButton.addActionListener(a -> {
			User u = AccountPage.getUser();
			u.addMovieToFavoriteMovies(movie);
			AccountPage ac = new AccountPage(u);
			Application.setAccountPage(ac);
		});

		//im unsure how to make this less wide.
		ratingTextField = new JTextField(5);
		reviewTextArea = new JTextArea(10,25);
		reviewPane = new JScrollPane(reviewTextArea);
		reviewTextArea.setLineWrap(true);

		saveReviewButton = new JButton("Save");
		saveReviewButton.addActionListener(e -> {
			//unfinished
		});

		movieInfoPanel.add(movieTitleLabel, Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));
		movieInfoPanel.add(movieActorsLabel, Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));
		movieInfoPanel.add(movieDirectorLabel,Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));
		movieInfoPanel.add(movieWritersLabel,Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));
		movieInfoPanel.add(movieGenresLabel,Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));
		movieInfoPanel.add(movieReleaseLabel,Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));
		movieInfoPanel.add(movieRuntimesLabel,Component.CENTER_ALIGNMENT);
		movieInfoPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));
		//Plot Label shifts everything to the right and I can't figure out how to fix it
		//movieInfoPanel.add(moviePlotLabel,Component.CENTER_ALIGNMENT);
		//userReviewPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));

		userReviewPanel.add(addToFavoritesButton, Component.CENTER_ALIGNMENT);
		userReviewPanel.add(new Box.Filler(new Dimension(0,20),new Dimension(0,20),new Dimension(0,20)));
		userReviewPanel.add(ratingLabel,Component.CENTER_ALIGNMENT);
		userReviewPanel.add(ratingTextField, Component.CENTER_ALIGNMENT);
		userReviewPanel.add(new Box.Filler(new Dimension(0,10),new Dimension(0,	10),new Dimension(0,10)));
		userReviewPanel.add(reviewLabel,Component.CENTER_ALIGNMENT);
		userReviewPanel.add(reviewPane, Component.CENTER_ALIGNMENT);
		userReviewPanel.add(saveReviewButton, Component.CENTER_ALIGNMENT);

		contentPanel.add(new Box.Filler(new Dimension(0,10),new Dimension(0,10),new Dimension(0,10)));
		contentPanel.add(movieInfoPanel, Component.CENTER_ALIGNMENT);
		if (u.getEntitlementType()){
			contentPanel.add(userReviewPanel, Component.CENTER_ALIGNMENT);
		}
		add(contentPanel,Component.CENTER_ALIGNMENT);
	}
}
