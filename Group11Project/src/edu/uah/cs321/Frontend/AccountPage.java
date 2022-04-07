package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.Movie;
import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/***
 * File Name: AccountPage
 * Description: 
 * @auth justinbushue & JamesHaywood
 * @version 1.1
 */
public class AccountPage extends JPanel {
	private static JPanel contentPanel;
	private User u;
	private static JLabel usersNameLabel;
	private static JPanel aboutPanel;
	private static JTextArea aboutMeTextArea;
	private static JPanel customListPanel;
	private static JPanel favoritesPanel;
	private static JPanel movieListPanel;
	private static JScrollPane aboutMeScroller;
	private static JScrollPane favoriteScroller;
	private static JScrollPane customListScroller;
	private static JPanel usersMovieLists;
	private static JPanel favoriteMovieList;

	private static JButton editPreferencesButton;
	private static JButton movieSearchButton;
	private static JButton createMovieList;

	private static JLabel movieListLabel;
	private static JLabel favoriteListLabel;


	public AccountPage(User u) {
		super();
		this.setLayout(new BorderLayout());
		this.u = u;
		System.out.println(u);

		//about Panel has information about the user. (username, description, preferences??)
		//aboutPanel will go into content panel first.
		//content panel is what holds everything
		contentPanel = new JPanel();
		aboutPanel = new JPanel();

		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		//this setLayout makes it so the content panels layout is stacked from top to bottom.

		//This sets the layout of the aboutPanel to top to bottom
		aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.PAGE_AXIS));
		//This makes everything in the content panel stick to the left wall.
		aboutPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


		//This gets the aboutMeTextArea and usersNameLabel.
		if(u != null) {
			usersNameLabel = new JLabel(u.getFirstName() + " " + u.getLastName());
			usersNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			aboutMeTextArea = new JTextArea(u.getAboutMe());
			aboutMeTextArea.setLineWrap(true);
			aboutMeScroller = new JScrollPane(aboutMeTextArea);
		}
		else {
			usersNameLabel = new JLabel("Error Occurred");
			usersNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			aboutMeTextArea = new JTextArea("Some kind of error happened.",3,10);
			aboutMeTextArea.setLineWrap(true);
			aboutMeScroller = new JScrollPane(aboutMeTextArea);
		}


		//adds the username to the contentLabel
		contentPanel.add(usersNameLabel);

		//adds the aboutPanel to the contentPanel
		aboutPanel.setMinimumSize(new Dimension(100, 150));
		aboutPanel.setMaximumSize(new Dimension(500,150));
		aboutPanel.add(aboutMeScroller);
		contentPanel.add(aboutPanel);


		//Buttons allows the user to open up a DIALOGUE BOX that edits the users preferences.
		editPreferencesButton = new JButton("Edit user preferences");
		editPreferencesButton.setMaximumSize(new Dimension(175,50));
		editPreferencesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel.add(editPreferencesButton);





		//Adds a button to go to movie search
		movieSearchButton = new JButton("Search for a movie!");
		//movieSearchButton.setMinimumSize(new Dimension(300,50));
		movieSearchButton.setMaximumSize(new Dimension(175,50));
		movieSearchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel.add(movieSearchButton);
		movieSearchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Application.showPage("searchPage");
			}
		});

		//Adds a button to create a custom movie list
		createMovieList = new JButton("Create a New Movie List!");
		createMovieList.setMinimumSize(new Dimension(175,50));
		createMovieList.setMaximumSize(new Dimension(175,50));
		createMovieList.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel.add(createMovieList);


		movieListPanel = new JPanel();
		favoritesPanel = new JPanel();
		favoritesPanel.setLayout(new BoxLayout(favoritesPanel, BoxLayout.PAGE_AXIS));
		customListPanel = new JPanel();
		customListPanel.setLayout(new BoxLayout(customListPanel, BoxLayout.PAGE_AXIS));

		movieListLabel = new JLabel("User's Movie Lists");
		movieListLabel.setAlignmentX(LEFT_ALIGNMENT);
		movieListLabel.setAlignmentY(TOP_ALIGNMENT);
		favoriteListLabel = new JLabel("User's favorite movies");
		favoriteListLabel.setAlignmentX(LEFT_ALIGNMENT);
		favoriteListLabel.setAlignmentY(TOP_ALIGNMENT);

		customListPanel.add(movieListLabel);
		customListPanel.setAlignmentY(TOP_ALIGNMENT);
		favoritesPanel.add(favoriteListLabel);
		favoritesPanel.setAlignmentY(TOP_ALIGNMENT);


		//This entire thing is for creating the user's list of custom lists. The left side of the window
		usersMovieLists = new JPanel();
		usersMovieLists.setLayout(new BoxLayout(usersMovieLists, BoxLayout.PAGE_AXIS));
		usersMovieLists.setAlignmentX(LEFT_ALIGNMENT);
		//adds buttons to the User's custom lists
		for (int i=0; i<50; i++){
			JButton movieListButton = new JButton("Movie List");
			movieListButton.setMaximumSize(new Dimension(400, 100));
			movieListButton.setMinimumSize(new Dimension(400, 100));
			movieListButton.setAlignmentX(LEFT_ALIGNMENT);
			movieListButton.setHorizontalAlignment(SwingConstants.LEFT);
			usersMovieLists.add(movieListButton);
		}

		customListScroller = new JScrollPane(usersMovieLists);
		customListScroller.setAlignmentX(LEFT_ALIGNMENT);
		customListPanel.add(customListScroller);
		customListPanel.setMaximumSize(new Dimension(415,800));

		//Right side of the window. Creates the user's list of favorite movies.
		favoriteMovieList = new JPanel();
		favoriteMovieList.setLayout(new BoxLayout(favoriteMovieList, BoxLayout.PAGE_AXIS));
		favoriteMovieList.setAlignmentX(LEFT_ALIGNMENT);

		for (int i=0; i<50; i++){
			JButton movieButton = new JButton("Favorite Movie");
			movieButton.setMaximumSize(new Dimension(400, 100));
			movieButton.setMinimumSize(new Dimension(400, 100));
			movieButton.setAlignmentX(LEFT_ALIGNMENT);
			movieButton.setHorizontalAlignment(SwingConstants.LEFT);
			favoriteMovieList.add(movieButton);
		}
		//This bit of code should work (since its identical to the search Page code) but it can't be tested right now because user can't add to favorites.
//		for (Movie m : u.getFavoriteMovies()){
//			JButton movieButton = new JButton(m.getTitle());
//			movieButton.setMaximumSize(new Dimension(400, 100));
//			movieButton.setMinimumSize(new Dimension(400, 100));
//			movieButton.setAlignmentX(LEFT_ALIGNMENT);
//			movieButton.setHorizontalAlignment(SwingConstants.LEFT);
//			movieButton.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent event){
//					JDialog movieInfo = new JDialog();
//					movieInfo.setMaximumSize(new Dimension(750,750));
//					movieInfo.setMinimumSize(new Dimension(750,750));
//					MoviePage moviePage = new MoviePage(m);
//					movieInfo.add(moviePage);
//					movieInfo.setVisible(true);
//					movieInfo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//				}
//			});
//			favoriteMovieList.add(movieButton);
//		}


		favoriteScroller = new JScrollPane(favoriteMovieList);
		favoriteScroller.setAlignmentX(LEFT_ALIGNMENT);
		favoritesPanel.add(favoriteScroller);
		favoritesPanel.setMaximumSize(new Dimension(415,800));

		movieListPanel.setLayout(new BoxLayout(movieListPanel, BoxLayout.X_AXIS));
		movieListPanel.add(customListPanel);
		movieListPanel.add(Box.createHorizontalGlue());
		movieListPanel.add(favoritesPanel);
		contentPanel.add(movieListPanel);


		//adds content panel to scroller
		this.add(contentPanel);
		aboutPanel.setVisible(true);
		contentPanel.setVisible(true);
		this.setVisible(true);
	}


}


