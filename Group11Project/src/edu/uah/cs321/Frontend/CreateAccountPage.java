package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.AuthSystem;
import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/***
 * File Name: CreateAccountPage
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class CreateAccountPage extends JPanel {

	private static JPanel contentPanel;
	private static JLabel firstNameLabel;
	private static JTextField firstNameField;
	private static JLabel lastNameLabel;
	private static JTextField lastNameField;
	private static JLabel aboutMeLabel;
	private static JTextArea aboutMeArea;
	private static JLabel usernameLabel;
	private static JTextField usernameField;
	private static JLabel passwordLabel;
	private static JPasswordField passwordField;
	private static JLabel confirmPasswordLabel;
	private static JPasswordField confirmPasswordField;
	private static JButton createAccountButton;
	private static JButton backButton;
	private static JPanel buttonPanel;
	private static JPanel fieldPanel;
	private static BoxLayout contentPanelLayout;
	private static BoxLayout buttonPanelLayout;
	private static BoxLayout fieldPanelLayout;

	public CreateAccountPage() {
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

		firstNameLabel = new JLabel("First Name");
		firstNameField = new JTextField();

		lastNameLabel = new JLabel("Last Name");
		lastNameField = new JTextField();

		aboutMeLabel = new JLabel("About Me");
		aboutMeArea = new JTextArea();

		usernameLabel = new JLabel("Username");
		usernameField = new JTextField();

		passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField();

		confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordField = new JPasswordField();

		createAccountButton = new JButton("Create Account");
		backButton = new JButton("Back");

		contentPanel.add(fieldPanel);
		contentPanel.add(buttonPanel);

		fieldPanel.add(firstNameLabel);
		fieldPanel.add(firstNameField);

		fieldPanel.add(lastNameLabel);
		fieldPanel.add(lastNameField);

		fieldPanel.add(aboutMeLabel);
		fieldPanel.add(aboutMeArea);

		fieldPanel.add(usernameLabel);
		fieldPanel.add(usernameField);

		fieldPanel.add(passwordLabel);
		fieldPanel.add(passwordField);

		fieldPanel.add(confirmPasswordLabel);
		fieldPanel.add(confirmPasswordField);

		buttonPanel.add(createAccountButton);
		buttonPanel.add(backButton);

		createAccountButton.addActionListener(e -> {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String aboutMe = aboutMeArea.getText();
			String uname = usernameField.getText();
			String pw = String.valueOf(passwordField.getPassword());
			String cpw = String.valueOf(confirmPasswordField.getPassword());
			if(cpw == null || (!pw.equals(cpw))) {
				SimpleDialog jd = new SimpleDialog("Error Creating Account...","Please ensure the passwords match.");
			}
			if(!AuthSystem.checkUserName(uname)) {
				User u = AuthSystem.addUser(firstName,lastName,uname,pw);
				u.setAboutMe(aboutMe);
				if(u != null) {
					PreferencePage ac = new PreferencePage(u,0);
					Application.getContentPanel().add(ac,"preferencePage0");
					Application.showPage("preferencePage0");
				}
				else {
					SimpleDialog jd = new SimpleDialog("Error Creating Account...", "The password is not complex enought. Make sure it is greater than 8 characters and only contains letters and numbers.");
				}
			}
			else {
				SimpleDialog jd = new SimpleDialog("Error Creating Account...","The username entered already exists. Please choose a new username.");
			}
		});

		backButton.addActionListener(e -> {
			usernameField.setText("");
			passwordField.setText("");
			confirmPasswordField.setText("");

			Application.showPage("mainPage");
		});
		add(contentPanel);
		this.setVisible(true);
		fieldPanel.setVisible(true);
		buttonPanel.setVisible(true);
		contentPanel.setVisible(true);
	}
}
