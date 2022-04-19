package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/***
 * File Name: SearchPage
 * Description: 
 * @author justinbushue & JamesHaywood
 * @version 1.0
 */
public class SearchPage extends JPanel {
	private static JLabel confirmation;
	private static JButton backButton;
	private static JPanel contentPanel;
	private static JPanel searchBar;
	private static JTextField searchArea;
	private static JLabel searchBarLabel;
	private static MovieList masterMovieList;

	private static JPanel displayedMovies;
	private static JScrollPane displayedMoviesScroller;
	private static String parameterState;


	public SearchPage(MovieList movieList) {
		masterMovieList = movieList;
		confirmation = new JLabel("You are on the search page");
		confirmation.setAlignmentX(CENTER_ALIGNMENT);
		backButton = new JButton("Go back to account page");
		backButton.setAlignmentX(CENTER_ALIGNMENT);
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Application.showPage("accountPage");
			}
		});

		//adds the header
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		contentPanel.add(confirmation);
		contentPanel.add(backButton);

		//This will add the search bar to the content panel. Doesn't work rn.
		addSearchBar(contentPanel);


		displayedMovies = new JPanel();
		displayedMovies.setLayout(new BoxLayout(displayedMovies, BoxLayout.PAGE_AXIS));
		displayedMoviesScroller = new JScrollPane(displayedMovies);
		displayedMoviesScroller.setAlignmentX(CENTER_ALIGNMENT);
		displayedMoviesScroller.setMaximumSize(new Dimension(400,600));

		//This adds the buttons in the search page that open up the MoviePage for each Movie
		populateSearchList(masterMovieList.getMovieList());


		contentPanel.add(displayedMoviesScroller);

		this.add(contentPanel);
		contentPanel.setVisible(true);
		this.setVisible(true);


	}

	public void addSearchBar(JPanel p){
		searchBar = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		searchBar.setPreferredSize(new Dimension(400,100));
		searchBar.setMinimumSize(new Dimension(400,100));
		searchBar.setMaximumSize(new Dimension(400,100));

		searchBarLabel = new JLabel("Search Bar");
		c.gridx=0; c.gridy=0;
		searchBar.add(searchBarLabel,c);

		searchArea = new JTextField("Enter Text to Search");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0; c.gridy=1; c.gridwidth=10; c.ipadx = 0; c.ipady=5; c.anchor = GridBagConstraints.LINE_START;
		searchBar.add(searchArea,c);

		//n will be the search state
		//n=0 -> default title search.
		parameterState="";

		JButton searchEnter = new JButton("Search");
		c.gridx=11; c.gridy=1; c.gridwidth=1; c.ipadx=0; c.ipady=0;
		searchEnter.addActionListener(a->{
			updateSearchResults(parameterState, masterMovieList, searchArea.getText());
			contentPanel.revalidate();

		});
		searchBar.add(searchEnter,c);


		JLabel searchParameters = new JLabel("Search by:");
		c.gridx=0; c.gridy=2;
		searchBar.add(searchParameters,c);


		String[] parameterList = new String[]{"Title","Actor","Director"};
		for (int i=0; i<parameterList.length; i++){
			JToggleButton parameterButton = new JToggleButton(parameterList[i], false);
			int a=i;
			c.gridx=i; c.gridy=3;
			parameterButton.addActionListener(e->{
				boolean state = parameterButton.isSelected();
				if (state==true){
					parameterState = parameterState + parameterList[a];

				}
				if (state==false){
					parameterState= parameterState.substring(0,parameterState.length()-parameterList[a].length());

				}
			});
			searchBar.add(parameterButton,c);

		}

		p.add(searchBar);
	}


	public void updateSearchResults(String State, MovieList ml, String input){
		displayedMovies.removeAll();
		//Okay so
		switch (State) {
			//Search by Title
			case "Title":
				populateSearchList(ml.searchForMovie(input));
				break;
			case "Actor":
				populateSearchList(ml.filterByActor(input));
				ml.clearFilteredList();
				break;
			case "Director":
				populateSearchList(ml.filterByDirector(input));
				ml.clearFilteredList();
				break;
			//Default case is search by title
			default:
				populateSearchList(ml.searchForAny(input));
				break;
		}
	}

	/**
	 * Changes the header of the search page. Used when viewing a MovieList.
	 *
	 */
	public void removeHeader(){
		contentPanel.remove(confirmation);
		contentPanel.remove(backButton);

	}


	public void populateSearchList(List<Movie> ml){
		ml.forEach(m -> {
			JButton movieButton = new JButton(m.getTitle() + " | " + m.getYear());
			movieButton.setMaximumSize(new Dimension(400,50));
			movieButton.setHorizontalAlignment(SwingConstants.LEFT);
			movieButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					Movie.openMovie(m);
				}
			});
			displayedMovies.add(movieButton);
			displayedMovies.revalidate();
		});
		if (ml.isEmpty()) {
			JLabel noResults = new JLabel("No Results");
			displayedMovies.add(noResults);
		}
	}
}
