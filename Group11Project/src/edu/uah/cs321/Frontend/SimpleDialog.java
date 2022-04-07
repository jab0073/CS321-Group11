package edu.uah.cs321.Frontend;

import javax.swing.*;
import java.awt.*;

/***
 * File Name: SimpleDialog
 * Description: 
 * @author justinbushue
 * @version 1.0
 */
public class SimpleDialog extends JDialog {

	public SimpleDialog(String title, String message) {
		super();
		setTitle(title);
		JPanel jdP = new JPanel();
		add(jdP);
		jdP.add(new JLabel(message));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(200,100));
		setSize(new Dimension(200,100));

		setVisible(true);
	}


}
