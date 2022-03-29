package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;

/***
 * File Name: AccountPage
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class AccountPage extends JPanel {
	private static JPanel contentPanel;
	private static JLabel usersNameLabel;
	private static JTextArea aboutMeTextArea;
	private User u;
	private static JPanel aboutPanel;
	private static JPanel customListPanel;
	private static JPanel favoritesPanel;

	private static BoxLayout contentPanelLayout;
	private static BoxLayout aboutPanelLayout;

	public AccountPage(User u) {
		super();
		this.setLayout(new BorderLayout());
		this.u = u;
		System.out.println(u);

		contentPanel = new JPanel();
		aboutPanel = new JPanel();

		contentPanelLayout = new BoxLayout(contentPanel, BoxLayout.Y_AXIS);
		contentPanel.setLayout(contentPanelLayout);

		aboutPanelLayout = new BoxLayout(aboutPanel, BoxLayout.Y_AXIS);
		aboutPanel.setLayout(aboutPanelLayout);

		if(u != null) {
			usersNameLabel = new JLabel(u.getFirstName() + " " + u.getLastName());
			aboutMeTextArea = new JTextArea(u.getAboutMe());
		}
		else {
			usersNameLabel = new JLabel("Error Occurred");
			aboutMeTextArea = new JTextArea("Some kind of error happened.");
		}
		aboutPanel.add(usersNameLabel, Component.CENTER_ALIGNMENT);
		aboutPanel.add(aboutMeTextArea, Component.CENTER_ALIGNMENT);
		contentPanel.add(aboutPanel, Component.CENTER_ALIGNMENT);
		this.add(contentPanel);

		aboutPanel.setVisible(true);
		contentPanel.setVisible(true);
		this.setVisible(true);
	}
}
