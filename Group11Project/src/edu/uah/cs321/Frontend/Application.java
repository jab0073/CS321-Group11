package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

/***
 * File Name: Application
 * Description: 
 * @auth justinbushue
 * @version 1.0
 */
public class Application extends JFrame {
	private static JPanel contentPanel;
	private static MainPage mainPage;
	private static LoginPage loginPage;
	private static CreateAccountPage createAccountPage;
	private static CardLayout cl;
	private static SearchPage searchPage;
	private static AccountPage accountPage;

	public Application(String title) throws IOException {
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
					MasterMovieListCache.close();
					System.out.println("AuthSystem and UserDatabase have been closed...");
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				Application.closeDialogs();
				e.getWindow().dispose();
			}
		});

		setSize( 750, 950 );

		contentPanel = new JPanel(new CardLayout());

		mainPage = new MainPage();
		loginPage = new LoginPage();
		createAccountPage = new CreateAccountPage();
		searchPage = new SearchPage(ResourceUtils.getMasterMovieList());

		contentPanel.add(mainPage,"mainPage");
		contentPanel.add(loginPage, "loginPage");
		contentPanel.add(createAccountPage, "createAccountPage");
		contentPanel.add(searchPage, "searchPage");

		cl = (CardLayout) contentPanel.getLayout();

		cl.first(contentPanel);
		cl.show(contentPanel,"mainPage");
		contentPanel.setVisible(true);
		this.add(contentPanel);

	}

	/**
	 * shows the inputed page.
	 * @param cardName
	 */
	public static void showPage(String cardName) {
		cl.show(contentPanel, cardName);
	}

	/**
	 * returns the contentPanel for the Application.
	 * @return
	 */
	public static JPanel getContentPanel() {
		return contentPanel;
	}

	/**
	 * sets the AccountPage that the program uses.
	 * @param ap
	 */
	public static void setAccountPage(AccountPage ap) {
		Application.accountPage = ap;
		Application.contentPanel.add(ap, "accountPage");
	}

	/**
	 * gets the AccountPage the application is currently using.
	 * @return
	 */
	public static AccountPage getAccountPage() {
		return Application.accountPage;
	}

	public static void setSearchPage(SearchPage sp){
		Application.contentPanel.remove(searchPage);
		Application.searchPage = sp;
		Application.contentPanel.add(searchPage, "searchPage");
	}

	/**
	 * Closes all dialogs besides the main application.
	 */
	public static void closeDialogs(){
		Window[] children = Application.getWindows();
		for (Window win : children){
			if (win instanceof JDialog){
				win.dispose();
			}
		}
	}

}
