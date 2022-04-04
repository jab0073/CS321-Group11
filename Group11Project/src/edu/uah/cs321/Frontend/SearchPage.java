package edu.uah.cs321.Frontend;

import edu.uah.cs321.Backend.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * File Name: SearchPage
 * Description: 
 * @author justinbushue & JamesHaywood
 * @version 1.0
 */
public class SearchPage extends JPanel {
	private static JLabel confirmation;
	private static JButton backButton;
	private static JPanel contentPanel;

	public SearchPage() {
		confirmation = new JLabel("You are on the search page");
		backButton = new JButton("Go back to account page");
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Application.showPage("accountPage");
			}
		});


		contentPanel = new JPanel();
		contentPanel.add(confirmation);
		contentPanel.add(backButton);



		this.add(contentPanel);
		contentPanel.setVisible(true);
		this.setVisible(true);


	}
}
