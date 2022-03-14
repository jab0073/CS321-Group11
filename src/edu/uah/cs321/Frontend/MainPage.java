package edu.uah.cs321.Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * Project Name: GroupProject-InitalThoughts
 * File Name: MainPage
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class MainPage extends JPanel {
	private static JPanel       contentPanel;
	private static JLabel       title;
	private static JPanel       titlePanel;
	private static JButton      loginButton;
	private static JButton      guestButton;
	private static JButton      createAccountButton;
	private static JPanel       buttonPanel;
	private static BoxLayout    layout;

	public MainPage() {
		contentPanel = new JPanel();
		layout = new BoxLayout(contentPanel,BoxLayout.Y_AXIS);
		contentPanel.setLayout(layout);

		titlePanel = new JPanel();
		title = new JLabel("GoodWatches!");
		titlePanel.add(title, Component.CENTER_ALIGNMENT);
		contentPanel.add(titlePanel, Component.CENTER_ALIGNMENT);

		buttonPanel = new JPanel();
		loginButton = new JButton("Login");
		guestButton = new JButton("Guest");
		createAccountButton = new JButton("Create Account");

		buttonPanel.add(loginButton, Component.CENTER_ALIGNMENT);
		buttonPanel.add(guestButton, Component.CENTER_ALIGNMENT);
		buttonPanel.add(createAccountButton, Component.CENTER_ALIGNMENT);

		contentPanel.add(buttonPanel, Component.CENTER_ALIGNMENT);

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goToLoginPage();
			}
		});

		add(contentPanel, Component.CENTER_ALIGNMENT);
		setVisible(true);
	}

	public void goToLoginPage() {
		Application.showPage("loginPage");
	}

	public void goToCreateAccountPage() {
		Application.showPage("createAccountPage");
	}
}
