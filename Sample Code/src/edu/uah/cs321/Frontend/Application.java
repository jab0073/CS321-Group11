package edu.uah.cs321.Frontend;

import javax.swing.*;
import java.awt.*;

/***
 * Project Name: GroupProject-InitalThoughts
 * File Name: Application
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class Application extends JFrame {
	private static JPanel contentPanel;
	private static JPanel mainPage;
	private static JPanel loginPage;
	private static CardLayout cl;

	public Application(String title) {
		super(title);

		setSize( 480, 480 );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPanel = new JPanel(new CardLayout());

		mainPage = new MainPage();
		loginPage = new LoginPage();

		contentPanel.add(mainPage,"mainPage");
		contentPanel.add(loginPage, "loginPage");

		CardLayout cl = (CardLayout) contentPanel.getLayout();
		cl.show(contentPanel, "mainPage");
	}

	public static void showPage(String cardName) {
		cl.show(contentPanel, cardName);
	}

}
