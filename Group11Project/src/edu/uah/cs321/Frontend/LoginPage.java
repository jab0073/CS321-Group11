package edu.uah.cs321.Frontend;


import edu.uah.cs321.Backend.AuthSystem;
import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/***
 * File Name: LoginPage
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class LoginPage extends JPanel {
	private static JPanel contentPanel;
	private static JLabel usernameLabel;
	private static JTextField usernameField;
	private static JLabel passwordLabel;
	private static JPasswordField passwordField;
	private static JButton loginButton;
	private static JButton backButton;
	private static JPanel buttonPanel;
	private static JPanel fieldPanel;
	private static BoxLayout contentPanelLayout;
	private static BoxLayout buttonPanelLayout;
	private static BoxLayout fieldPanelLayout;

	/**
	 * LoginPage is a JPanel where the user inputs login information and determines what user information to access/modify.
	 */
	public LoginPage() {
		super();

		contentPanel = new JPanel();
		fieldPanel = new JPanel();
		buttonPanel = new JPanel();

		contentPanelLayout = new BoxLayout(contentPanel, BoxLayout.Y_AXIS);
		fieldPanelLayout = new BoxLayout(fieldPanel, BoxLayout.Y_AXIS);;
		buttonPanelLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);

		contentPanel.setLayout(contentPanelLayout);
		fieldPanel.setLayout(fieldPanelLayout);
		buttonPanel.setLayout(buttonPanelLayout);

		usernameLabel = new JLabel("Username");
		usernameField = new JTextField();

		passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField();

		loginButton = new JButton("Login");
		backButton = new JButton("Back");

		contentPanel.add(fieldPanel);
		contentPanel.add(buttonPanel);

		fieldPanel.add(usernameLabel);
		fieldPanel.add(usernameField);

		fieldPanel.add(passwordLabel);
		fieldPanel.add(passwordField);

		buttonPanel.add(loginButton);
		buttonPanel.add(backButton);

		loginButton.addActionListener(e->{
			String username = usernameField.getText();
			String password = String.valueOf(passwordField.getPassword());

			User u = AuthSystem.login(username, password);
			if(u != null) {
				usernameField.setText("");
				passwordField.setText("");
				AccountPage ac = new AccountPage(u);
				Application.setAccountPage(ac);
				Application.showPage("accountPage");
			}
			else {
				SimpleDialog jd = new SimpleDialog("Login Failed...","Login Failed...");
			}
		});

		backButton.addActionListener(e->{
			usernameField.setText("");
			passwordField.setText("");

			Application.showPage("mainPage");
		});
		add(contentPanel);
	}
}
