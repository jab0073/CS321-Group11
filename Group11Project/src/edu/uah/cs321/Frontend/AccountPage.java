package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

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
	private static User clone;
	private static JPanel headerPanel;
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
	private static JButton saveButton;
	private static JButton logoutButton;
	private static JButton recommendButton;

	private static JLabel movieListLabel;
	private static JLabel favoriteListLabel;

	private static java.util.List<MovieList> usersCustomMovieLists;
	private static java.util.List<Movie> usersCustomFavoriteMovies;

	/**
	 * AccountPage is a JPanel that serves as the hub for user Input.
	 * @param u
	 */
	public AccountPage(User u) {
		super();
		this.setLayout(new BorderLayout());
		AccountPage.u = u;
		AccountPage.clone = AccountPage.u.clone();
		System.out.println(u);

		//about Panel has information about the user. (username, description)
		//aboutPanel will go into content panel first.
		//content panel is what holds everything
		contentPanel = new JPanel();
		aboutPanel = new JPanel();
		aboutPanel.setMinimumSize(new Dimension(100, 150));
		aboutPanel.setMaximumSize(new Dimension(500,150));

		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		//this setLayout makes it so the content panels layout is stacked from top to bottom.

		//This sets the layout of the aboutPanel to top to bottom
		aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
		//This makes everything in the content panel stick to the left wall.
		aboutPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		//If the user is actually logged in then it retrieves their account info. Otherwise they are a guest.
		if(u != null) {
			usersNameLabel = new JLabel("Name: " + u.getFirstName() + " " + u.getLastName());
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

		//This adds the header which is a logout button and the username.
		// (It's sloppy so if anyone wants to improve it go ahead)
		headerPanel = new JPanel();
		headerPanel.setLayout(new BoxLayout(headerPanel,BoxLayout.X_AXIS));
		//adds the username to the contentLabel
		headerPanel.add(usersNameLabel);
		headerPanel.add(Box.createHorizontalGlue());


		/*
		 * Save Button / functionality is broken. With more time it would have been implemented.
		 * It can currently save the changes correctly. However it runs into a problem with a specific test case.
		 * If a User A makes changes to their account, but chooses to not save, and then logs out without saving.
		 * User B can then come along, login, and make changes to their account. If User B chooses to save it will also
		 * save the changes User A made. Due to how our code was set up we opted to just remove the feature and have it
		 * always save the changes on logout or program close.
		 */
//		//add a button to save everything
//		saveButton = new JButton("Save Changes");
//		saveButton.addActionListener(e->{
//			AccountPage.clone = AccountPage.u;
//			try {
//				UserDatabase.close();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//			try {
//				MasterMovieListCache.close();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		});
//		headerPanel.add(saveButton);

		//Adds a button to log out
		logoutButton = new JButton("Log out");
		//logoutButton.setAlignmentX(RIGHT_ALIGNMENT);
		logoutButton.addActionListener(e -> {
			AccountPage.u = AccountPage.clone;
			//Saves UserDatabase on logout
			try {
				UserDatabase.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			//Saves MovieListCache on logout
			try {
				MasterMovieListCache.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			Application.closeDialogs();
			Application.showPage("mainPage");
		});
		headerPanel.add(logoutButton);
		aboutPanel.add(headerPanel, Component.LEFT_ALIGNMENT);


		//adds the aboutPanel to the contentPanel
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
		movieSearchButton.addActionListener(e->{
			Application.setSearchPage(new SearchPage(ResourceUtils.getMasterMovieList()));
			Application.showPage("searchPage");
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


		//Adds a button that recommends a movie
		recommendButton = new JButton("Recommend a Movie!");
		recommendButton.setMinimumSize(new Dimension(175,50));
		recommendButton.setMaximumSize(new Dimension(175,50));
		recommendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		recommendButton.addActionListener(e -> {
			Objects.requireNonNull(u).recommendedMovie2().openMovie();
		});
		contentPanel.add(recommendButton);

		//movieListPanel is where the customLists and favoriteMovies go.
		movieListPanel = new JPanel();
		favoritesPanel = new JPanel();
		favoritesPanel.setLayout(new BoxLayout(favoritesPanel, BoxLayout.Y_AXIS));
		customListPanel = new JPanel();
		customListPanel.setLayout(new BoxLayout(customListPanel, BoxLayout.Y_AXIS));

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


		//This is for creating the list of Custom Lists Left side of window.
		usersMovieLists = new JPanel();
		usersMovieLists.setLayout(new BoxLayout(usersMovieLists, BoxLayout.Y_AXIS));
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
		favoriteMovieList.setLayout(new BoxLayout(favoriteMovieList, BoxLayout.Y_AXIS));
		favoriteMovieList.setAlignmentX(LEFT_ALIGNMENT);

		if(usersCustomFavoriteMovies != null) {
			populateFavoriteList(usersCustomFavoriteMovies);
		}

		favoriteScroller = new JScrollPane(favoriteMovieList);
		favoriteScroller.setAlignmentX(LEFT_ALIGNMENT);
		favoritesPanel.add(favoriteScroller);
		favoritesPanel.setMaximumSize(new Dimension(415,800));

		movieListPanel.setLayout(new BoxLayout(movieListPanel, BoxLayout.X_AXIS));

		//Adds the customLists and favoriteList to movieListPanel and adds movieListPanel to contenPanel.
		movieListPanel.add(Box.createRigidArea(new Dimension(25,10)));
		movieListPanel.add(customListPanel);
		movieListPanel.add(Box.createHorizontalGlue());
		movieListPanel.add(favoritesPanel);
		movieListPanel.add(Box.createRigidArea(new Dimension(25,10)));
		contentPanel.add(movieListPanel);


		//Checks if the user is a guest of not. If the user is a guest (true) then it removes the user only features and updates the contentPanel.
		if (!Objects.requireNonNull(u).getEntitlementType()){
			contentPanel.remove(createMovieList);
			contentPanel.remove(movieListPanel);
			contentPanel.remove(editPreferencesButton);
			contentPanel.revalidate();
		}
		//adds the contentPanel to accountPage
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
		SearchPage.closeSearchPages();
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

		SearchPage listViewer = new SearchPage(movieList);
		listViewer.removeHeader();

		listViewer.add(confirmation);
		listViewer.add(deleteMovieListButton);
		listViewer.setComponentZOrder(confirmation,0);
		listViewer.setComponentZOrder(deleteMovieListButton,1);

		jd.add(listViewer);

		jd.setVisible(true);
	}

	/**
	 * This populates the panel userMovieLists with the users customLists. Also used to refresh the users CustomLists.
	 * @param usersCustomLists
	 */
	public void populateCustomList(java.util.List<MovieList> usersCustomLists){
		usersMovieLists.removeAll();
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

	/**
	 * This populates favoriteMovieList with buttons of the user's favorite movies. Also refreshes favoriteMovieList.
	 * @param usersCustomFavoriteMovies
	 */
	public void populateFavoriteList(java.util.List<Movie> usersCustomFavoriteMovies){
		favoriteMovieList.removeAll();
		usersCustomFavoriteMovies.forEach(m -> {
			JButton movieButton = new JButton(m.getTitle() + " | " + m.getYear());
			movieButton.setMaximumSize(new Dimension(400, 40));
			movieButton.setMinimumSize(new Dimension(400, 40));
			movieButton.setAlignmentX(LEFT_ALIGNMENT);
			movieButton.setHorizontalAlignment(SwingConstants.LEFT);
			movieButton.addActionListener(a -> {
				m.openMovie();
			});
			favoriteMovieList.add(movieButton);
		});
	}


}


