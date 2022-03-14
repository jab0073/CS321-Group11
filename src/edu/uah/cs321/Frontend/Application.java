package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.AuthSystem;
import edu.uah.cs321.Backend.UserDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/***
 * Project Name: GroupProject-InitialThoughts
 * File Name: Application
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class Application extends JFrame {
	private static JPanel contentPanel;
	private static MainPage mainPage;
	private static LoginPage loginPage;
	private static AccountPage accountPage;
	private static CardLayout cl;

	public Application(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				try {
					AuthSystem.close();
					UserDatabase.close();
					System.out.println("AuthSystem and UserDatabase have been closed...");
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				e.getWindow().dispose();
			}
		});

		setSize( 480, 480 );

		contentPanel = new JPanel(new CardLayout());

		mainPage = new MainPage();
		loginPage = new LoginPage();
		accountPage = new AccountPage();

		contentPanel.add(mainPage,"mainPage");
		contentPanel.add(loginPage, "loginPage");
		contentPanel.add(accountPage,"accountPage");

		cl = (CardLayout) contentPanel.getLayout();

		cl.first(contentPanel);
		cl.show(contentPanel,"mainPage");
		contentPanel.setVisible(true);
		this.add(contentPanel);
	}

	public static void showPage(String cardName) {
		cl.show(contentPanel, cardName);
	}

}
