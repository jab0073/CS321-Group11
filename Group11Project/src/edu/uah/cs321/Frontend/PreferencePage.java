package edu.uah.cs321.Frontend;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import edu.uah.cs321.Backend.ResourceUtils;
import edu.uah.cs321.Backend.User;

/***
 * File Name: PreferencePage
 * Description:
 * @author justinbushue
 * @version 1.0
 */
public class PreferencePage extends JPanel {
	private static JPanel contentPanel;
	private static JPanel preferenceInfoPanel;
	private static JPanel preferenceButtonPanel;

	private static JPanel headerPanel;
	private static JPanel buttonPanel;

	private static List<JButton> buttons;
	private static JLabel header;

	private static BoxLayout contentPanelLayout;
	private static BoxLayout headerPanelLayout;
	private static BoxLayout buttonPanelLayout;
	private static BoxLayout preferenceButtonPanelLayout;
	private static BoxLayout preferenceInfoPanelLayout;

	private static JLabel favoriteGenresLabel;
	private static JLabel favoriteActorsLabel;
	private static JLabel favoriteDirectorsLabel;

	private static JButton doneButton;

	private final User u;

	private final int type;

	public PreferencePage(User u, int type) {
		super();
		this.u = u;
		this.type = type;
		this.setLayout(new BorderLayout());

		contentPanel = new JPanel();
		preferenceInfoPanel = new JPanel();
		preferenceButtonPanel = new JPanel();
		headerPanel = new JPanel();
		buttonPanel = new JPanel();

		contentPanelLayout = new BoxLayout(contentPanel, BoxLayout.X_AXIS);
		preferenceInfoPanelLayout = new BoxLayout(preferenceInfoPanel, BoxLayout.Y_AXIS);
		preferenceButtonPanelLayout = new BoxLayout(preferenceButtonPanel, BoxLayout.Y_AXIS);
		headerPanelLayout = new BoxLayout(headerPanel, BoxLayout.Y_AXIS);
		buttonPanelLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);

		contentPanel.setLayout(contentPanelLayout);
		preferenceButtonPanel.setLayout(preferenceButtonPanelLayout);
		preferenceInfoPanel.setLayout(preferenceInfoPanelLayout);
		headerPanel.setLayout(headerPanelLayout);
		buttonPanel.setLayout(buttonPanelLayout);

		doneButton = new JButton("Done");

		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();
		JButton button6 = new JButton();
		JButton button7 = new JButton();
		JButton button8 = new JButton();
		JButton button9 = new JButton();
		JButton button10 = new JButton();

		buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9, button10));


		switch (this.type) {
			case 0 -> {
				header = new JLabel("Select Your Favorite Genres");
				List<String> genres = ResourceUtils.getMasterMovieList().getAllGenres();
				for(int i = 0 ; i < 10 ; i++) {
					String topGenres = genres.stream()
							.collect(Collectors.groupingBy(w -> w, Collectors.counting()))
							.entrySet()
							.stream()
							.max(Comparator.comparing(Map.Entry::getValue))
							.get()
							.getKey();
					buttons.get(i).setText(topGenres);
					buttons.get(i).addActionListener(e -> {
						if(!u.getFavoriteGenres().contains(topGenres))
							u.getFavoriteGenres().add(topGenres);
						this.setBackground(new Color(250,182,0));
						refreshPreference();
					});
					buttonPanel.add(buttons.get(i));
					genres.removeAll(Collections.singleton(topGenres));
					//System.out.println("Button added with text: " + topGenres);
				}
				doneButton.addActionListener(e -> {
					PreferencePage pp1 = new PreferencePage(this.u,1);
					Application.getContentPanel().add(pp1,"preferencePage1");
					Application.showPage("preferencePage1");
				});
				buttonPanel.add(doneButton);
			}

			case 1 -> {
				header = new JLabel("Select Your Favorite Actors");
				List<String> actors = ResourceUtils.getMasterMovieList().getAllActors();
				for(int i = 0 ; i < 10 ; i++) {
					String topActor = actors.stream()
							.collect(Collectors.groupingBy(w -> w, Collectors.counting()))
							.entrySet()
							.stream()
							.max(Comparator.comparing(Map.Entry::getValue))
							.get()
							.getKey();
					buttons.get(i).setText(topActor);
					buttons.get(i).addActionListener(e -> {
						if(!u.getFavoriteActors().contains(topActor))
							u.getFavoriteActors().add(topActor);
						this.setBackground(new Color(250,182,0));
						refreshPreference();
					});
					buttonPanel.add(buttons.get(i));
					actors.removeAll(Collections.singleton(topActor));
					//System.out.println("Button added with text: " + topActor);
				}
				doneButton.addActionListener(e -> {
					PreferencePage pp2 = new PreferencePage(this.u,2);
					Application.getContentPanel().add(pp2,"preferencePage2");
					Application.showPage("preferencePage2");
				});
				buttonPanel.add(doneButton);
			}

			case 2 -> {
				header = new JLabel("Select Your Favorite Directors");
				List<String> directors = ResourceUtils.getMasterMovieList().getAllDirectors();
				for(int i = 0 ; i < 10 ; i++) {
					String topDirector = directors.stream()
							.collect(Collectors.groupingBy(w -> w, Collectors.counting()))
							.entrySet()
							.stream()
							.max(Comparator.comparing(Map.Entry::getValue))
							.get()
							.getKey();
					buttons.get(i).setText(topDirector);
					buttons.get(i).addActionListener(e -> {
						if(!u.getFavoriteDirectors().contains(topDirector))
							u.getFavoriteDirectors().add(topDirector);
						this.setBackground(new Color(250,182,0));
						refreshPreference();
					});
					buttonPanel.add(buttons.get(i));
					directors.removeAll(Collections.singleton(topDirector));
					//System.out.println("Button added with text: " + topDirector);
				}
				doneButton.addActionListener(e -> {
					AccountPage ac = new AccountPage(u);
					Application.setAccountPage(ac);
					Application.showPage("accountPage");
				});
				buttonPanel.add(doneButton);
			}

			default -> throw new IllegalStateException("Unexpected value: " + this.type);
		}


		JButton resetPreferenceButton = new JButton("Reset your preferences");
		resetPreferenceButton.addActionListener(e->{
			u.getFavoriteActors().clear();
			u.getFavoriteDirectors().clear();
			u.getFavoriteGenres().clear();
			refreshPreference();
			Application.showPage("preferencePage0");
		});

		preferenceInfoPanel.add(resetPreferenceButton);
		favoriteGenresLabel = new JLabel("Genres: ");
		favoriteActorsLabel = new JLabel("Actors: ");
		favoriteDirectorsLabel = new JLabel("Directors: ");
		preferenceInfoPanel.add(favoriteGenresLabel, Component.LEFT_ALIGNMENT);
		preferenceInfoPanel.add(favoriteActorsLabel, Component.LEFT_ALIGNMENT);
		preferenceInfoPanel.add(favoriteDirectorsLabel, Component.LEFT_ALIGNMENT);
		refreshPreference();



		headerPanel.add(header, Component.CENTER_ALIGNMENT);
		preferenceButtonPanel.add(headerPanel, Component.CENTER_ALIGNMENT);
		preferenceButtonPanel.add(buttonPanel, Component.CENTER_ALIGNMENT);
		contentPanel.add(preferenceButtonPanel);
		contentPanel.add(Box.createRigidArea(new Dimension(75,10)));
		contentPanel.add(preferenceInfoPanel);

		contentPanel.setAlignmentX(LEFT_ALIGNMENT);
		contentPanel.setAlignmentY(TOP_ALIGNMENT);
		preferenceButtonPanel.setAlignmentY(TOP_ALIGNMENT);
		preferenceInfoPanel.setAlignmentY(TOP_ALIGNMENT);
		this.add(contentPanel);

		headerPanel.setVisible(true);
		buttonPanel.setVisible(true);
		contentPanel.setVisible(true);
		this.setVisible(true);
	}

	public void refreshPreference(){
		String ActorLabel = "Actors: ";
		String GenreLabel = "Genre: ";
		String DirectorLabel = "Directors: ";
		for (String actor : u.getFavoriteActors()){
			ActorLabel += actor + ", ";
		}
		ActorLabel.substring(0,ActorLabel.length()-1);

		for (String Genre : u.getFavoriteGenres()){
			GenreLabel += Genre + ", ";
		}
		GenreLabel.substring(0,GenreLabel.length()-1);

		for (String director : u.getFavoriteDirectors()){
			DirectorLabel += director + ", ";
		}
		DirectorLabel.substring(0,DirectorLabel.length()-1);
		favoriteActorsLabel.setText(ActorLabel);
		favoriteDirectorsLabel.setText(DirectorLabel);
		favoriteGenresLabel.setText(GenreLabel);

		preferenceInfoPanel.revalidate();
	}
}
