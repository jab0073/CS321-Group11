package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.Movie;
import edu.uah.cs321.Backend.MovieList;
import edu.uah.cs321.Backend.Review;
import edu.uah.cs321.Backend.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.Kernel;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

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
	private static JTextArea moviePlotLabel;
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

	private static JTextArea reviewTextArea;

	private static JButton addToFavoritesButton;
	private static JButton addToCustomListButton;
	private static JButton saveReviewButton;

	private static Color avgColor;
	private static Color contrastColor;
	private static Image backgroundImage;


	public MoviePage(Movie movie){
		super();
		MoviePage.movie = movie;
		u=AccountPage.getUser();


		contentPanel = new JPanel();

		contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
		movieInfoPanel = new JPanel();
		movieInfoPanel.setLayout(new BoxLayout(movieInfoPanel,BoxLayout.Y_AXIS));
		userReviewPanel = new JPanel();
		userReviewPanel.setLayout(new BoxLayout(userReviewPanel,BoxLayout.Y_AXIS));

		String posterURL = MoviePage.movie.getPoster();
		if(posterURL != null && posterURL.length() > 0) {
			JLabel posterLabel = new JLabel();
			try {
				URL url = new URL(posterURL);
				BufferedImage image = ImageIO.read(url);
				avgColor = averageColor(image);
				contrastColor = getContrastColor(avgColor);
				ImageIcon imgicon = new ImageIcon(image);
				Image img = imgicon.getImage().getScaledInstance((int)(image.getWidth()*.8),(int)(image.getHeight()*.8),Image.SCALE_DEFAULT);
				imgicon = new ImageIcon(img);
				posterLabel.setIcon(imgicon);
				movieInfoPanel.add(posterLabel);
			} catch(IOException ignored) {}
		}

		contentPanel.setBackground(avgColor);
		movieInfoPanel.setBackground(avgColor);
		userReviewPanel.setBackground(avgColor);
		this.setBackground(avgColor);

		movieTitleLabel = new JLabel("Title:  " + MoviePage.movie.getTitle());
		movieTitleLabel.setBackground(avgColor);
		movieTitleLabel.setForeground(contrastColor);
		movieDirectorLabel = new JLabel("Director:  " + MoviePage.movie.getDirector());
		movieDirectorLabel.setBackground(avgColor);
		movieDirectorLabel.setForeground(contrastColor);
		movieWritersLabel = new JLabel("Writers:  " + MoviePage.movie.getWriter());
		movieWritersLabel.setBackground(avgColor);
		movieWritersLabel.setForeground(contrastColor);
		moviePlotLabel = new JTextArea("Plot:  " + MoviePage.movie.getPlot(),5,25);
		moviePlotLabel.setMaximumSize(new Dimension(400,100));
		moviePlotLabel.setLineWrap(true);
		moviePlotLabel.setBackground(avgColor);
		moviePlotLabel.setForeground(contrastColor);
		moviePlotLabel.setWrapStyleWord(true);
		moviePlotLabel.setEditable(false);
		moviePlotLabel.setAlignmentX(LEFT_ALIGNMENT);
		movieGenresLabel = new JLabel("Genre:  " + String.join(", ", MoviePage.movie.getGenre()));
		movieGenresLabel.setBackground(avgColor);
		movieGenresLabel.setForeground(contrastColor);
		movieReleaseLabel = new JLabel("Release Date:  " + MoviePage.movie.getReleased());
		movieReleaseLabel.setBackground(avgColor);
		movieReleaseLabel.setForeground(contrastColor);
		movieActorsLabel = new JLabel("Actors:  " + String.join(", ", MoviePage.movie.getActors()));
		movieActorsLabel.setBackground(avgColor);
		movieActorsLabel.setForeground(contrastColor);
		movieRuntimesLabel = new JLabel("Runtime:  " + MoviePage.movie.getRuntime());
		movieRuntimesLabel.setBackground(avgColor);
		movieRuntimesLabel.setForeground(contrastColor);
		ratingLabel = new JLabel("Rating (1-5)");
		ratingLabel.setBackground(avgColor);
		ratingLabel.setForeground(contrastColor);
		reviewLabel = new JLabel("Review");
		reviewLabel.setBackground(avgColor);
		reviewLabel.setForeground(contrastColor);


		addToFavoritesButton = new JButton("Favorite");
		//addToFavoritesButton.setForeground(avgColor.darker());
		//addToFavoritesButton.setBackground(avgColor);
		if (u.getFavoriteMovies().contains(movie)){
			addToFavoritesButton.setText("Unfavorite");
		}
		addToFavoritesButton.addActionListener(a -> {
			//if it contains the movie
			if (u.getFavoriteMovies().contains(movie)){
				addToFavoritesButton.setText("Favorite");
				u.getFavoriteMovies().remove(movie);
			} else { //if it does not contain the movie
				addToFavoritesButton.setText("Unfavorite");
				u.getFavoriteMovies().add(movie);
			}
			Application.getAccountPage().populateFavoriteList(u.getFavoriteMovies());
			Application.getAccountPage().revalidate();

		});


		//Add to custom list goes here
		addToCustomListButton = new JButton("Add movie to a custom list!");
		addToCustomListButton.addActionListener(e->{
			JDialog jd = new JDialog();
			jd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			JPanel cP = new JPanel();

			JComboBox customListSelector = new JComboBox();
			java.util.List<String> ls = new ArrayList<String>();
			java.util.List<MovieList> mL = new ArrayList<MovieList>();
			u.getMovieLists().forEach(m->{
				ls.add(m.getListName());
				mL.add(m);
			});
			customListSelector.setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));


			JPanel listPanel = new JPanel();
			listPanel.setLayout(new BoxLayout(listPanel,BoxLayout.Y_AXIS));
			listPanel.setMinimumSize(new Dimension(100,50));
			listPanel.add(customListSelector);
			cP.add(listPanel);

			JButton addButton = new JButton("Add to selected list");
			if (mL.get(customListSelector.getSelectedIndex()).getMovieList().contains(movie)){
				addButton.setText("Remove from selected list");
			} else {
				addButton.setText("Add to selected list");
			}

			addButton.addActionListener(a->{
				if (mL.get(customListSelector.getSelectedIndex()).getMovieList().contains(movie)){
					mL.get(customListSelector.getSelectedIndex()).removeMovie(movie);
					addButton.setText("Add to selected list");
				} else {
					mL.get(customListSelector.getSelectedIndex()).addMovie(movie);
					addButton.setText("Remove from selected list");
				}
			});
			cP.revalidate();

			customListSelector.addActionListener(n->{
				if (mL.get(customListSelector.getSelectedIndex()).getMovieList().contains(movie)){
					addButton.setText("Remove from selected list");
				} else {
					addButton.setText("Add to selected list");
				}

				cP.revalidate();
			});


			cP.add(addButton);
			jd.add(cP);
			jd.setMinimumSize(new Dimension(300,300));
			jd.setVisible(true);
		});




		//im unsure how to make this less wide.
		Integer value = 1;
		Integer min = 1;
		Integer max = 5;
		Integer step = 1;
		SpinnerNumberModel numberspinmodel = new SpinnerNumberModel(value,min,max,step);
		JSpinner ratingspinner = new JSpinner(numberspinmodel);
		ratingspinner.setMaximumSize(new Dimension(150,20));
		//ratingspinner.setBackground(avgColor);
		//ratingspinner.setForeground(contrastColor);
		reviewTextArea = new JTextArea(10,15);
		reviewTextArea.setBackground(avgColor.brighter());
		reviewTextArea.setForeground(contrastColor);

		reviewPane = new JScrollPane(reviewTextArea);
		reviewPane.setBackground(avgColor);

		reviewTextArea.setLineWrap(true);

		saveReviewButton = new JButton("Save");
		//saveReviewButton.setBackground(avgColor);
		//saveReviewButton.setForeground(avgColor.darker());
		saveReviewButton.addActionListener(e -> {
			try {
				Integer rating = (Integer) ratingspinner.getValue();
				String review = reviewTextArea.getText();
				Review userReview = new Review(AccountPage.getUser(), MoviePage.movie,rating,review);
				AccountPage.getUser().addReview(userReview);
				MoviePage.movie.addReview(userReview);
				SimpleDialog sd = new SimpleDialog("Review Added", "Review Added\nRating: " + rating + "\nReview: " + review);
				sd.setMaximumSize(new Dimension(400,100)); sd.setMinimumSize(new Dimension(400,100));
				sd.revalidate();
			}catch(NullPointerException f){
				SimpleDialog sd = new SimpleDialog("Error...", "Error");
				System.out.println(f.getMessage());
				sd.setMaximumSize(new Dimension(400,100)); sd.setMinimumSize(new Dimension(400,100));
				sd.revalidate();
				return;
			}
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
		movieInfoPanel.add(moviePlotLabel,Component.CENTER_ALIGNMENT);
		userReviewPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));

		userReviewPanel.add(addToFavoritesButton, Component.CENTER_ALIGNMENT);
		userReviewPanel.add(new Box.Filler(new Dimension(0,5),new Dimension(0,5),new Dimension(0,5)));
		userReviewPanel.add(addToCustomListButton);
		userReviewPanel.add(new Box.Filler(new Dimension(0,20),new Dimension(0,20),new Dimension(0,20)));
		userReviewPanel.add(ratingLabel,Component.CENTER_ALIGNMENT);
		userReviewPanel.add(ratingspinner, Component.CENTER_ALIGNMENT);
		userReviewPanel.add(new Box.Filler(new Dimension(0,10),new Dimension(0,	10),new Dimension(0,10)));
		userReviewPanel.add(reviewLabel,Component.CENTER_ALIGNMENT);
		userReviewPanel.add(reviewPane, Component.CENTER_ALIGNMENT);
		userReviewPanel.add(saveReviewButton, Component.CENTER_ALIGNMENT);

		contentPanel.add(new Box.Filler(new Dimension(0,10),new Dimension(0,10),new Dimension(0,10)));
		contentPanel.add(movieInfoPanel, Component.CENTER_ALIGNMENT);
		if (u.getEntitlementType()){
			contentPanel.add(userReviewPanel, Component.CENTER_ALIGNMENT);
		}
		contentPanel.setPreferredSize(new Dimension(600,800));
		add(contentPanel,Component.CENTER_ALIGNMENT);
	}

	public static Color averageColor(BufferedImage bi) {
		int step = 5;

		int sampled = 0;
		long sumr = 0, sumg = 0, sumb = 0;
		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				if (x % step == 0 && y % step == 0) {
					Color pixel = new Color(bi.getRGB(x, y));
					sumr += pixel.getRed();
					sumg += pixel.getGreen();
					sumb += pixel.getBlue();
					sampled++;
				}
			}
		}
		//int dim = bi.getWidth()*bi.getHeight();
		return new Color(Math.round(sumr / sampled), Math.round(sumg / sampled), Math.round(sumb / sampled));
	}

	public static Color getContrastColor(Color color) {
		double y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
		return y >= 128 ? Color.black : Color.white;
	}
}
