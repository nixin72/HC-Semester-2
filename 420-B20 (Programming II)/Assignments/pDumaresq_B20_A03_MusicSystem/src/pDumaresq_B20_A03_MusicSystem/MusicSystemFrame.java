package pDumaresq_B20_A03_MusicSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MusicSystemFrame extends JFrame {
	Font font = new Font("Courier New", 20, 16);
	MusicSystem system = new MusicSystem();;
	Song song;
	private JTextArea displayMusic;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicSystemFrame frame = new MusicSystemFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * Create the frame.
	 */
	public MusicSystemFrame() {
		fileNotFound();
		system.bubbleSortYear();		
		
		setTitle("Heritage Music Reporting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
				
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmWrite = new JMenuItem("Write");
		mnFile.add(mntmWrite);
		mntmWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!system.writeToFile()) {
					writeToFileError();
				}
				else {
					writeToFile();
				}
			}
		});
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenu mnSearch = new JMenu("Search");
		menuBar.add(mnSearch);
				
		JMenuItem mntmBySongTitle = new JMenuItem("By song title");
		mnSearch.add(mntmBySongTitle);
		mntmBySongTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBySongTitle();
			}
		});
		
		JMenuItem mntmByYearranking = new JMenuItem("By year/ranking");
		mnSearch.add(mntmByYearranking);
		mntmByYearranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				byYearRank();
			}
		});
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmListAllMusic = new JMenuItem("List all music");
		mnReports.add(mntmListAllMusic);
		mntmListAllMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listAllMusic();
			}
		});
		
		JMenuItem mntmListByYear = new JMenuItem("List by Year");
		mnReports.add(mntmListByYear);
		mntmListByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listByYear();
			}
		});

		displayMusic = new JTextArea();
		displayMusic.setEditable(false);
		displayMusic.setBounds(0, 0, 1098, 623);
		displayMusic.setFont(new Font("Courier New", 12, 16));
		getContentPane().add(new JScrollPane(displayMusic), BorderLayout.CENTER);
	}
	
	public void fileNotFound() {
		if (!system.readFromFile()) {
			JOptionPane.showMessageDialog(this, "The file \"" + system.getFileName() + "\" could not be found.",
					"Error", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		
	}
	
	public void writeToFileError() {
		JOptionPane.showMessageDialog(this, "There was an error writing to the file",
				"Error", JOptionPane.PLAIN_MESSAGE);
	}
	public void writeToFile() {
		JOptionPane.showMessageDialog(this, "The file has been written to.",
				"Write", JOptionPane.PLAIN_MESSAGE);
	}
	
	/*
	 * This method will simply bring up a JOptionPane prompting the user to enter 
	 * the title of the song that they're searching for. Then it'll save title of 
	 * that song as a variable and pass the song title in as the parameter to the 
	 * linearSearchTitle method in the MusicSystem class. the linearSearchTitle()
	 * method will return index that song was found at and the index will be used
	 * to print out all of the information for the song with the given title. 
	 */
	public void searchBySongTitle() {
		String songTitle = ""; 
		
		songTitle = JOptionPane.showInputDialog(this, "Please enter the title of the\n song you'd like to search for.",
				"Song Title", JOptionPane.PLAIN_MESSAGE);
		
		if (songTitle != null) {
			try {
				int index = system.linearSearchTitle(songTitle);
				
				displayMusic.setText(String.format("%22s%22s%-20s%-20s","Song Details\n", "------------\n",
						"Year:", system.songArray.get(index).getYear()) + "\n");
				displayMusic.append(String.format("%-20s%-20s","Rank:", system.songArray.get(index).getRank()) + "\n");
				displayMusic.append(String.format("%-20s%-20s","Artist:", system.songArray.get(index).getArtist()) + "\n");
				displayMusic.append(String.format("%-20s%-20s","Song Title:", system.songArray.get(index).getTitle()) + "\n");
				displayMusic.append(String.format("%-20s%-20s","# Downloads:", system.songArray.get(index).getDownloads()));
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(this, "The song \"" + songTitle + "\" could not be found.",
						"No Such Song", JOptionPane.QUESTION_MESSAGE);
				searchBySongTitle();
			}
		}
	}	
	
	/*
	 * This method will bring up a JOptionPane prompting for the year of the song followed by 
	 * the rank of the song you'd like to search for and stores them in variables. The method 
	 * will then pass the year and rank entered in as parameters for the binarySearchYearRank
	 * method in the MusicSystem class. The binarySearchYearRank method will return the index 
	 * that the song was found at and it will print out all the information for the song that 
	 * has that index in the songArray ArrayList. If the song isn't found, then a JOptionPane
	 * will come up saying that the song couldn't be found. 
	 */
	public void byYearRank() {		
		String rank = new String();
		String year = new String();
		
		year = JOptionPane.showInputDialog(this, "Please enter the year of the\nsong you'd like to search for.",
			"year published", JOptionPane.PLAIN_MESSAGE);
			
		if ( year != null) {
			if (year.length() == 2) {
				year = "20" + year;
			}
			try {
				if ( Integer.parseInt(year) < 2012 || Integer.parseInt(year) > 2015 ) {
					JOptionPane.showMessageDialog(this, "The year must be between 2012 and 2015",
						"error", JOptionPane.ERROR_MESSAGE);
					byYearRank();
				}
				else {
					rank = JOptionPane.showInputDialog(this, "Please enter the rank of the\n "
							+ "song you'd like to search for.",	"song's rank", JOptionPane.PLAIN_MESSAGE);
					
					if ( rank != null) {
						if ( Integer.parseInt(rank) <= 0 || Integer.parseInt(rank) > 60 ) {
							JOptionPane.showMessageDialog(this, "Please enter a valid rank.",
								"error", JOptionPane.ERROR_MESSAGE);
							byYearRank();
						}
						else {
							int songIndex = system.binarySearchYearRank(Integer.parseInt(year), Integer.parseInt(rank));
						
							if ( songIndex != -1 ) {
								displayMusic.setText(String.format("%22s", "Song Details\n"));
								displayMusic.append(String.format("%22s", "------------\n"));
								displayMusic.append(String.format("%-20s%-20s","Year:", system.songArray.get(songIndex).getYear()) + "\n");
								displayMusic.append(String.format("%-20s%-20s","Rank:", system.songArray.get(songIndex).getRank()) + "\n");
								displayMusic.append(String.format("%-20s%-20s","Artist:", system.songArray.get(songIndex).getArtist()) + "\n");
								displayMusic.append(String.format("%-20s%-20s","Song Title:", system.songArray.get(songIndex).getTitle()) + "\n");
								displayMusic.append(String.format("%-20s%-20s","# Downloads:", system.songArray.get(songIndex).getDownloads()));
							}
							else {
								JOptionPane.showMessageDialog(this, "The song could not be found",
										"error", JOptionPane.PLAIN_MESSAGE);
								byYearRank();
							}
						}
					}
				}
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Please enter a valid Year and Rank",
						"error", JOptionPane.PLAIN_MESSAGE);
				byYearRank();
			}
		}		
	}
	
	/*
	 * This method is called when the list all music button is clicked. It will just display 
	 * all the music organized by year and then by rank. 
	 */
	public void listAllMusic() {
		int downloads = 0;
		displayMusic.setText(String.format("%45s","Top Songs of the Year\n"));
		displayMusic.append(String.format("%45s","---------------------\n"));
		displayMusic.append(String.format("%-10s%-10s%-34s%-44s%-11s","Year","Ranking","Artist","Song Title","# downloads\n"));
		for ( int i = 0 ; i < 110 ; i++ ){ displayMusic.append("-"); }
		displayMusic.append("\n");
		
		for ( int q = 0 ; q < system.songArray.size() ; q++ ) {
			song = new Song();
			displayMusic.append(String.format("%-10s", String.valueOf(system.songArray.get(q).getYear())));
			displayMusic.append(String.format("%-10s", String.valueOf(system.songArray.get(q).getRank())));
			displayMusic.append(String.format("%-34s", String.valueOf(system.songArray.get(q).getArtist())));
			displayMusic.append(String.format("%-44s", String.valueOf(system.songArray.get(q).getTitle())));
			displayMusic.append(String.format("%11s", String.valueOf(system.songArray.get(q).getDownloads())) + "\n");
			downloads += system.songArray.get(q).getDownloads();
		}
		displayMusic.setCaretPosition(0);
		
		//I just added this because I felt like it.
		String t = String.valueOf(downloads).substring(2);
		String m = String.valueOf(downloads).substring(0, 2);
		
		displayMusic.append("\nTotal number of songs: " + system.songArray.size() +
							"\nTotal Number of downloads: " + m + "," + t + ",000");
	}
	
	/*
	 * This method will disply all the music organized by year and by rank. 
	 * Each grouping of years is broken up and it will display the total number
	 * of downloads that year for each of the top songs. 
	 * 
	 * The user will first enter the year. If it's null, then the cancel or exit button have been clicked and 
	 * the method will stop. if the year is invalid, it will tell the user to reenter the year and the method
	 * will be recalled prompting the user for a new year. This will repeat again for the rank. 
	 */
	public void listByYear() {
		int totalDownloads = 0;
		String year;
		
		year = JOptionPane.showInputDialog(this, "What year would you like to search for?",
				"Year", JOptionPane.PLAIN_MESSAGE);
		if ( year != null ) {
			if (year.length() == 2) {
				year = "20" + year;
			}
			try {
				if (Integer.parseInt(year) > 2015 || Integer.parseInt(year) < 2012) {
					JOptionPane.showMessageDialog(this, "The year must be between 2012 and 2015",
							"Year", JOptionPane.PLAIN_MESSAGE);
					listByYear();
				}
				else {
					displayMusic.setText(String.format("%45s","Top Songs of the Year\n"));
					displayMusic.append(String.format("%45s","---------------------\n"));
					displayMusic.append(String.format("%-10s%-10s%-34s%-44s%-11s","Year","Ranking","Artist","Song Title","# downloads\n"));
					for ( int i = 0 ; i < 110 ; i++ ){ displayMusic.append("-"); }
					displayMusic.append("\n");
					
					for ( int q = 0 ; q < system.songArray.size() ; q++ ) {
						song = new Song();
						if (system.songArray.get(q).getYear() == Integer.parseInt(year)) {
							displayMusic.append(String.format("%-10s", String.valueOf(system.songArray.get(q).getYear())));
							displayMusic.append(String.format("%-10s", String.valueOf(system.songArray.get(q).getRank())));
							displayMusic.append(String.format("%-34s", String.valueOf(system.songArray.get(q).getArtist())));
							displayMusic.append(String.format("%-44s", String.valueOf(system.songArray.get(q).getTitle())));
							displayMusic.append(String.format("%11s", String.valueOf(system.songArray.get(q).getDownloads())) + "\n");
							totalDownloads += system.songArray.get(q).getDownloads();
							
							if (q+1 >= system.songArray.size()) {
								String m = String.valueOf(totalDownloads).substring(0,2);
								String t = String.valueOf(totalDownloads).substring(2);
								displayMusic.append(String.format("%111s", "-----\n"));
								displayMusic.append(String.format("%69s%16s%25s", "", "Download Totals:", m+","+t+",000\n"));
								displayMusic.append("\n");
								totalDownloads = 0;
							}
							else {
								if (system.songArray.get(q).getYear() < system.songArray.get(q+1).getYear())	 {
									String m = String.valueOf(totalDownloads).substring(0, 2);
									String t = String.valueOf(totalDownloads).substring(2);
									displayMusic.append(String.format("%110s", "-----\n"));
									displayMusic.append(String.format("%69s%16s%25s", "", "Download Totals:", m+","+t+",000\n"));
									displayMusic.append("\n");
									totalDownloads = 0;
								}//if (system.songArray.get(q).getYear() < system.songArray.get(q+1).getYear())
							}//else 	
						}//if (system.songArray.get(q).getYear() == Integer.parseInt(year))
					}//for ( int q = 0 ; q < system.songArray.size() ; q++ )
				}//else (year is between 2012 and 2015
				displayMusic.setCaretPosition(0);
			}//try
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Please enter a valid year.",
						"Year", JOptionPane.PLAIN_MESSAGE);
				listByYear();
			}//catch
		}//year == null
	}//listByYear
}//MusicSystemFrame 
