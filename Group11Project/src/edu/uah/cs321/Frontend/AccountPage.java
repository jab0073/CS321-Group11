package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static JScrollPane scroller;
	private static JScrollPane aboutMeScroller;

	private static JButton movieSearchButton;



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
		customListPanel = new JPanel();
		favoritesPanel = new JPanel();
		movieListPanel = new JPanel();



		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		//this setLayout makes it so the content panels layout is stacked from top to bottom.

		//This sets the layout of the aboutPanel to top to bottom
		aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.PAGE_AXIS));
		//This makes everything in the content panel stick to the left wall.
		aboutPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		aboutPanel.setPreferredSize(new Dimension(100,10));

		//This gets the aboutMeTextArea and usersNameLabel.
		if(u != null) {
			usersNameLabel = new JLabel(u.getFirstName() + " " + u.getLastName());
			aboutMeTextArea = new JTextArea(u.getAboutMe(),3,10);
			aboutMeTextArea.setLineWrap(true);
			aboutMeScroller = new JScrollPane(aboutMeTextArea);
		}
		else {
			usersNameLabel = new JLabel("Error Occurred");
			aboutMeTextArea = new JTextArea("Some kind of error happened.",3,10);
			aboutMeTextArea.setLineWrap(true);
			aboutMeScroller = new JScrollPane(aboutMeTextArea);
		}


		//adds the username to the contentLabel
		contentPanel.add(usersNameLabel);
		//adds the aboutPanel to the contentPanel
		aboutPanel.add(aboutMeScroller, Component.CENTER_ALIGNMENT);
		contentPanel.add(aboutPanel);

		//Adds a button to go to movie search
		movieSearchButton = new JButton("Search for a movie!");
		contentPanel.add(movieSearchButton);
		movieSearchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Application.showPage("searchPage");
			}
		});


		movieListPanel.setLayout(new BoxLayout(movieListPanel, BoxLayout.X_AXIS));
		movieListPanel.add(favoritesPanel);
		movieListPanel.add(customListPanel);

		contentPanel.add(movieListPanel);





		//adds content panel to scroller
		this.add(contentPanel);
		aboutPanel.setVisible(true);
		contentPanel.setVisible(true);
		this.setVisible(true);
	}

}


