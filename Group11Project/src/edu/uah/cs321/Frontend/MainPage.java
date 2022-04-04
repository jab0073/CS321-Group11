package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.Constants;
import edu.uah.cs321.Backend.ResourceUtils;
import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

/***
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

	public MainPage() throws IOException {
		contentPanel = new JPanel();
		layout = new BoxLayout(contentPanel,BoxLayout.Y_AXIS);
		contentPanel.setLayout(layout);

		titlePanel = new JPanel();
		ImageIcon logoImg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Images/goodwatcheslogo.png")));
		title = new JLabel(logoImg);
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

		loginButton.addActionListener(e -> goToLoginPage());

		guestButton.addActionListener(e ->{
			User guest = new User();
			AccountPage ac = new AccountPage(guest);
			Application.getContentPanel().add(ac,"accountPage");
			Application.showPage("accountPage");
		});

		createAccountButton.addActionListener(e -> goToCreateAccountPage());

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
