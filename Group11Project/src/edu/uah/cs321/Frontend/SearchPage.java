package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static JButton searchButton;

	private static JPanel displayedMovies;
	private static JScrollPane displayedMoviesScroller;


	public SearchPage() {
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
		//addSearchBar(contentPanel);


		displayedMovies = new JPanel();
		displayedMovies.setLayout(new BoxLayout(displayedMovies, BoxLayout.PAGE_AXIS));
		displayedMoviesScroller = new JScrollPane(displayedMovies);
		displayedMoviesScroller.setAlignmentX(CENTER_ALIGNMENT);
		displayedMoviesScroller.setMaximumSize(new Dimension(400,600));



		//This adds the buttons in the search page that open up the MoviePage for each Movie
		ResourceUtils.getMasterMovieList().getMovieList().forEach(m -> {
			JButton movieButton = new JButton(m.getTitle());
			movieButton.setMaximumSize(new Dimension(400,100));
			movieButton.setHorizontalAlignment(SwingConstants.LEFT);
			movieButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					JDialog movieInfo = new JDialog();
					movieInfo.setMaximumSize(new Dimension(750,750));
					movieInfo.setMinimumSize(new Dimension(750,750));
					MoviePage moviePage = new MoviePage(m);
					movieInfo.add(moviePage);
					movieInfo.setVisible(true);
					movieInfo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			});
			displayedMovies.add(movieButton);
		});


		contentPanel.add(displayedMoviesScroller);

		this.add(contentPanel);
		contentPanel.setVisible(true);
		this.setVisible(true);


	}

	public void addSearchBar(JPanel p){
		searchBar = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		searchBarLabel = new JLabel("Search Bar");
		c.gridx=0; c.gridy=0;
		searchBar.add(searchBarLabel,c);

		searchArea = new JTextField("Enter Text to Search");
		c.gridx=0; c.gridy=1; c.gridwidth=3;
		searchBar.add(searchArea,c);


		p.add(searchBar);
	}


	public void updateSearchResults(){

	}
}
