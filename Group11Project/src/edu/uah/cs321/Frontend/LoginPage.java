package edu.uah.cs321.Frontend;


import edu.uah.cs321.Backend.AuthSystem;
import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/***
 * Project Name: Group11Project
 * File Name: LoginPage
 * Description: 
 * @author justinbushue
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

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();

				User u = AuthSystem.login(username, password);
				if(u != null) {
					usernameField.setText("");
					passwordField.setText("");
					AccountPage.setUser(u);
					Application.showPage("accountPage");
				}
				else {
					JDialog jd = new JDialog();
					jd.setTitle("Login Failed...");
					JPanel jdP = new JPanel();
					jd.add(jdP);
					jdP.add(new JLabel("Login Failed..."));
					jd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					jd.setPreferredSize(new Dimension(200,100));
					jd.setSize(new Dimension(200,100));

					jd.setVisible(true);

				}
			}
		});

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usernameField.setText("");
				passwordField.setText("");

				Application.showPage("mainPage");
			}
		});
		add(contentPanel);
	}
}
