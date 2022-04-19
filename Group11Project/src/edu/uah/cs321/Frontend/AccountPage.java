package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.Movie;
import edu.uah.cs321.Backend.MovieList;
import edu.uah.cs321.Backend.ResourceUtils;
import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/***
 * File Name: AccountPage
 * Description: 
 * @auth justinbushue & JamesHaywood
 * @version 1.1
 */
public class AccountPage extends JPanel {
	private static JPanel contentPanel;
	private static User u;
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
	private static JButton logoutButton;
	private static JButton recommendButton;

	private static JLabel movieListLabel;
	private static JLabel favoriteListLabel;

	private static java.util.List<MovieList> usersCustomMovieLists;
	private static java.util.List<Movie> usersCustomFavoriteMovies;


	public AccountPage(User u) {
		super();
		this.setLayout(new BorderLayout());
		AccountPage.u = u;
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
			usersCustomMovieLists = u.getMovieLists();
			usersCustomFavoriteMovies = u.getFavoriteMovies();
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
		editPreferencesButton.addActionListener(e->{
			PreferencePage ac = new PreferencePage(u, 0);
			Application.getContentPanel().add(ac, "preferencePage0");
			Application.showPage("preferencePage0");
		});
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
		createMovieList.addActionListener(a -> {
			String listName = (String) JOptionPane.showInputDialog(this,
					"Name your custom movie list:",
					"Custom list creator",
					JOptionPane.PLAIN_MESSAGE,
					null,null,null);
			if (listName != null && listName.length() > 0){
				System.out.println("creating custom movie list " + listName);
				MovieList customMovieList = new MovieList();
				customMovieList.setListName(listName);
				JButton movieListButton = new JButton(customMovieList.getListName());
				movieListButton.setMaximumSize(new Dimension(400, 40));
				movieListButton.setMinimumSize(new Dimension(400, 40));
				movieListButton.setAlignmentX(LEFT_ALIGNMENT);
				movieListButton.setHorizontalAlignment(SwingConstants.LEFT);
				movieListButton.addActionListener(e -> {
					openMovieList(customMovieList);
				});
				usersMovieLists.add(movieListButton);
				u.addMovieListToMovieLists(customMovieList);
				contentPanel.revalidate();
			} else {
				System.out.println("Cancel or invalid name");
			}
		});
		contentPanel.add(createMovieList);

		//Adds a button to log out
		logoutButton = new JButton("Log out");
		logoutButton.setHorizontalTextPosition(0);
		logoutButton.setVerticalTextPosition(0);
		logoutButton.addActionListener(e -> {
				Application.showPage("mainPage");
		});

		//Adds a button that recommends a movie
		recommendButton = new JButton("Movie Recommendation");
		recommendButton.addActionListener(e -> {
			//goToMoviePage();
		});

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
		if(usersCustomMovieLists != null) {
			populateCustomList(usersCustomMovieLists);
		}
		customListScroller = new JScrollPane(usersMovieLists);
		customListScroller.setAlignmentX(LEFT_ALIGNMENT);
		customListPanel.add(customListScroller);
		customListPanel.setMaximumSize(new Dimension(415,800));


		//Right side of the window. Creates the user's list of favorite movies.
		favoriteMovieList = new JPanel();
		favoriteMovieList.setLayout(new BoxLayout(favoriteMovieList, BoxLayout.PAGE_AXIS));
		favoriteMovieList.setAlignmentX(LEFT_ALIGNMENT);

		if(usersCustomFavoriteMovies != null) {
			populateFavoriteList(usersCustomFavoriteMovies);
		}

		favoriteScroller = new JScrollPane(favoriteMovieList);
		favoriteScroller.setAlignmentX(LEFT_ALIGNMENT);
		favoritesPanel.add(favoriteScroller);
		favoritesPanel.setMaximumSize(new Dimension(415,800));

		movieListPanel.setLayout(new BoxLayout(movieListPanel, BoxLayout.X_AXIS));

		movieListPanel.add(Box.createRigidArea(new Dimension(25,10)));
		movieListPanel.add(customListPanel);
		movieListPanel.add(Box.createHorizontalGlue());
		movieListPanel.add(favoritesPanel);
		contentPanel.add(movieListPanel);
		movieListPanel.add(Box.createRigidArea(new Dimension(25,10)));


		if (!u.getEntitlementType()){
			contentPanel.remove(createMovieList);
			contentPanel.remove(movieListPanel);
			contentPanel.remove(editPreferencesButton);
			contentPanel.revalidate();
		}
		//adds content panel to scroller
		this.add(contentPanel);
		aboutPanel.setVisible(true);
		contentPanel.setVisible(true);
		this.setVisible(true);
	}

	/**
	 * Returns the User the AccountPage is using
	 * @return User
	 */
	public static User getUser() {
		return u;
	}


	/***
	 * Opens up a dialog containing the inputted movieList
	 * @param movieList
	 */
	public void openMovieList(MovieList movieList){
		System.out.println("Opened movie list: " + movieList.getListName());
		JDialog jd = new JDialog();
		JLabel confirmation = new JLabel("Now viewing movie list: " + movieList.getListName());
		jd.setMaximumSize(new Dimension(700,800));
		jd.setMinimumSize(new Dimension(700,800));
		jd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JButton deleteMovieListButton = new JButton("Delete this movie list?");
		deleteMovieListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteMovieListButton.setMaximumSize(new Dimension(100,50));
		deleteMovieListButton.setMinimumSize(new Dimension(100,50));
		deleteMovieListButton.addActionListener(a ->{
			int n = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this list?","Deletion Confirmation",JOptionPane.YES_NO_OPTION);
			//n=0 is yes and n=1 is no
			if (n==0){
				AccountPage.getUser().removeMovieListFromMovieLists(movieList);
				jd.dispose();
				usersMovieLists.removeAll();
				populateCustomList(u.getMovieLists());
				usersMovieLists.revalidate();
				usersMovieLists.repaint();
			}
		});

		//This listViewer is just for testing purposes to see if a list will load.
		//SearchPage listViewer = new SearchPage(ResourceUtils.getMasterMovieList());
		//This is the actual listViewer
		SearchPage listViewer = new SearchPage(movieList);
		listViewer.removeHeader();

//		JButton refreshListViewer = new JButton("refresh");
//		refreshListViewer.addActionListener(e->{
//
//		});

		JPanel contentPanel = new JPanel();
		contentPanel.add(confirmation);
		contentPanel.add(deleteMovieListButton);
//		contentPanel.add(refreshListViewer);
		contentPanel.add(listViewer);

		jd.add(contentPanel);

		jd.setVisible(true);
	}

	public void populateCustomList(java.util.List<MovieList> usersCustomLists){
		usersCustomLists.forEach(ml -> {
			JButton movieListButton = new JButton(ml.getListName());
			movieListButton.setMaximumSize(new Dimension(400, 40));
			movieListButton.setMinimumSize(new Dimension(400, 40));
			movieListButton.setAlignmentX(LEFT_ALIGNMENT);
			movieListButton.setHorizontalAlignment(SwingConstants.LEFT);
			movieListButton.addActionListener(a -> {
				openMovieList(ml);
			});
			usersMovieLists.add(movieListButton);
		});
	}

	public void populateFavoriteList(java.util.List<Movie> usersCustomFavoriteMovies){
		favoriteMovieList.removeAll();
		usersCustomFavoriteMovies.forEach(m -> {
			JButton movieButton = new JButton(m.getTitle() + " | " + m.getYear());
			movieButton.setMaximumSize(new Dimension(400, 40));
			movieButton.setMinimumSize(new Dimension(400, 40));
			movieButton.setAlignmentX(LEFT_ALIGNMENT);
			movieButton.setHorizontalAlignment(SwingConstants.LEFT);
			movieButton.addActionListener(a -> {
				JDialog movieInfo = new JDialog();
				movieInfo.setMaximumSize(new Dimension(750,1000));
				movieInfo.setMinimumSize(new Dimension(750,1000));
				MoviePage moviePage = new MoviePage(m);
				movieInfo.add(moviePage);
				movieInfo.setVisible(true);
				movieInfo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			});
			favoriteMovieList.add(movieButton);
		});
	}

	public void goToMoviePage(Movie m){
		JDialog movieInfo = new JDialog();
		movieInfo.setMaximumSize(new Dimension(750,1000));
		movieInfo.setMinimumSize(new Dimension(750,1000));
		MoviePage moviePage = new MoviePage(m);
		movieInfo.add(moviePage);
		movieInfo.setVisible(true);
		movieInfo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}


