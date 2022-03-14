package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.User;

import javax.swing.*;

/***
 * Project Name: GroupProject-InitalThoughts
 * File Name: AccountPage
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class AccountPage extends JPanel {
	private static JPanel contentPanel;
	private static JLabel usersNameLabel;
	private static JTextArea aboutMeTextArea;
	private static User u;
	private static JPanel aboutPanel;
	private static JPanel customListPanel;
	private static JPanel favoritesPanel;

	public AccountPage() {
		super();
		contentPanel = new JPanel();
		aboutPanel = new JPanel();
		contentPanel.add(aboutPanel);
		usersNameLabel = new JLabel();
		aboutMeTextArea = new JTextArea();

		aboutPanel.add(usersNameLabel);
		aboutPanel.add(aboutMeTextArea);
		if(u != null) {
			usersNameLabel.setText(u.getFirstName() + " " + u.getLastName());
			aboutMeTextArea.setText(u.getAboutMe());
		}
		aboutPanel.setVisible(true);
		contentPanel.setVisible(true);
	}

	public static void setUser(User u) {
		AccountPage.u = u;
	}
}
