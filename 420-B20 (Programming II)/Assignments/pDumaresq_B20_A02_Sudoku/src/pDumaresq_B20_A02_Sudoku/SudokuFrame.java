package pDumaresq_B20_A02_Sudoku;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class SudokuFrame extends JFrame implements ActionListener {
	
	static SudokuGame game = new SudokuGame();
	
	private JPanel contentPane;
	private JPanel panelControls;
	private JPanel panelButtons;
	
	private JTextField fldFileName;
	private static JTextField fldEnterMove;
	
	private JLabel lblFileName;
	private static JLabel lblEnterMove;
	
	private static JButton btnMakeMove;
	private JButton btnQuit;
	private JButton btnUndo;
	private JButton btnSetFileName;
	private JButton btnEndGame;	
	private JButton btnWinOrLose;
	
	private GridBagLayout gbl_panelControls;
	private GridBagConstraints gbc_lblFileName;
	private GridBagConstraints gbc_fldFileName;
	private GridBagConstraints gbc_btnSetFileName;
	private GridBagConstraints gbc_btnEnterMove;
	private GridBagConstraints gbc_btnUndo;
	private GridBagConstraints gbc_btnQuit;
	private GridBagConstraints gbc_fldEnterMove;
	private GridBagConstraints gbc_lblEnterMove;
	private GridBagConstraints gbc_btnMakeMove;
	private GridBagConstraints gbc_btnWinOrLose;
	
	private JMenuBar menuBar;
	private JMenu menuOptions;
	private JMenuItem mntmRules;
	private JMenuItem mntmUndo;
	private JMenuItem mntmQuit;
	private JMenuItem mntmAbout;
	
	private static JButton[][] square;
	
	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuFrame frame = new SudokuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/*
	 * This method instantiates each item in the square array and displays them in the frame.
	 * The result is a 9x9 box of buttons.
	 */
	public void buildBoard() {
		square = new JButton[9][9];
		panelButtons.setLayout(new GridLayout(9,9));
		for (int row = 0; row < square.length; ++row){
			for (int col = 0; col < square[row].length; ++col) {
				square[row][col] = new JButton("");
				square[row][col].setFont(new Font("board", Font.BOLD, 24));
				square[row][col].setVisible(true);
				square[row][col].setEnabled(false);
				panelButtons.add(square[row][col]);
				square[row][col].addActionListener(this); 
			}	
		}	
	}
	
	/*
	 * Whenever a button is clicked on, the button is replaced by a textfield.
	 * When another button is clicked on, the button returns to a button with the contents of the 
	 * text field being the text over top of the button.
	 */
	public void actionPerformed(ActionEvent e) { 
		for (int row = 0; row < square.length ; row++) {
			for (int col = 0; col < square[row].length ; col++) {
				if (e.getSource() == square[row][col]) {
					game.setRow(String.valueOf(row));
					game.setCol(String.valueOf(col));
					lblEnterMove.setVisible(true);
					fldEnterMove.setVisible(true);
					btnMakeMove.setVisible(true);
				}
			}
		}
	}
	
	/*
	 * This method is called after the file name is declared. 
	 * It sets the test on each button to be equal to the matching location in 
	 * the numbers array in the SudokuGame class. 
	 * If a number already exists in that location and it is not equal to an asterix,
	 * The button is deactivated, but still displayed. 
	 * Sets all the borders for the buttons depending on where they're located in the array.
	 */
	@SuppressWarnings("static-access")
	public static void displayValues() {
		Color color = new Color(0);
		for (int row = 0; row < square.length; ++row){
			for (int col = 0; col < square[row].length; ++col) {
				square[row][col].setText(game.numbers[row][col]);
				if (!game.numbers[row][col].equals("*")) {
					square[row][col].setEnabled(false);
				}
				square[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color));
				if (col == 2 || col== 5) {
					square[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 3, color));
				}
				if (row == 2 || row == 5) {
					if (col == 2 || col== 5) {
						square[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, color));
					}
					else {
						square[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, color));
					}
				}
			}	
		}	
	}
	
	/*
	 * If the user enters an invalid file name, this method is called from the SudokuGame 
	 * class and it brings up a message telling the user the file they entered isn't valid.
	 */
	public void displayErrorMessage() {
		JOptionPane.showMessageDialog(this, "<html><h1>Please enter a valid file name.</h1></html>",
				"invalid input", JOptionPane.ERROR_MESSAGE);
	}
	
	/*
	 * If the user enters something other than 1-9, then the validateInput method 
	 * in the game class will return false and display an error message. 
	 */
	public void invalidInput() {
		JOptionPane.showMessageDialog(this, "<html><h1>You must enter a valid number.<br />Please only enter the numbers 1-9</h1></html>",
				"invalid input", JOptionPane.ERROR_MESSAGE);
	}
	
	/*
	 * instantiating all the UI components their location.
	 * respective action listeners are implemented below.
	 */
	public SudokuFrame() {				
		setTitle("Sudoku");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelButtons = new JPanel();
		panelButtons.setBounds(15, 66, 553, 553);
		contentPane.add(panelButtons);
		panelButtons.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelControls = new JPanel();
		panelControls.setBounds(596, 66, 381, 553);
		contentPane.add(panelControls);
		gbl_panelControls = new GridBagLayout();
		gbl_panelControls.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelControls.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelControls.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelControls.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelControls.setLayout(gbl_panelControls);
		
		enterFileName();
		
		lblEnterMove = new JLabel("Enter Value: ");
		lblEnterMove.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEnterMove.setVisible(false);
		gbc_lblEnterMove = new GridBagConstraints();
		gbc_lblEnterMove.gridwidth = 2;
		gbc_lblEnterMove.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterMove.anchor = GridBagConstraints.EAST;
		gbc_lblEnterMove.gridx = 0;
		gbc_lblEnterMove.gridy = 1;
		panelControls.add(lblEnterMove, gbc_lblEnterMove);
		
		fldEnterMove = new JTextField();
		fldEnterMove.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fldEnterMove.setColumns(10);
		fldEnterMove.setVisible(false);
		gbc_fldEnterMove = new GridBagConstraints();
		gbc_fldEnterMove.gridwidth = 2;
		gbc_fldEnterMove.insets = new Insets(0, 0, 5, 5);
		gbc_fldEnterMove.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldEnterMove.gridx = 2;
		gbc_fldEnterMove.gridy = 1;
		panelControls.add(fldEnterMove, gbc_fldEnterMove);
		
		btnMakeMove = new JButton("Enter Your Move!");
		btnMakeMove.setVisible(false);
		btnMakeMove.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbc_btnMakeMove = new GridBagConstraints();
		gbc_btnMakeMove.anchor = GridBagConstraints.WEST;
		gbc_btnMakeMove.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakeMove.gridx = 3;
		gbc_btnMakeMove.gridy = 10;
		panelControls.add(btnMakeMove, gbc_btnMakeMove);
		
		btnEndGame = new JButton("End Game!");
		btnEndGame.setEnabled(true);
		btnEndGame.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbc_btnEnterMove = new GridBagConstraints();
		gbc_btnEnterMove.anchor = GridBagConstraints.WEST;
		gbc_btnEnterMove.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterMove.gridx = 3;
		gbc_btnEnterMove.gridy = 10;
		panelControls.add(btnEndGame, gbc_btnEnterMove);
		
		btnWinOrLose = new JButton("");
		btnWinOrLose.setEnabled(true);
		btnWinOrLose.setVisible(false);
		btnWinOrLose.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbc_btnWinOrLose = new GridBagConstraints();
		gbc_btnWinOrLose.anchor = GridBagConstraints.WEST;
		gbc_btnWinOrLose.insets = new Insets(0, 0, 5, 5);
		gbc_btnWinOrLose.gridx = 3;
		gbc_btnWinOrLose.gridy = 10;
		panelControls.add(btnWinOrLose, gbc_btnWinOrLose);
				
		btnUndo = new JButton("Undo");
		btnUndo.setVisible(false);
		btnUndo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.anchor = GridBagConstraints.WEST;
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 3;
		gbc_btnUndo.gridy = 11;
		panelControls.add(btnUndo, gbc_btnUndo);
				
		btnQuit = new JButton("Quit");
		btnQuit.setVisible(false);
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbc_btnQuit = new GridBagConstraints();
		gbc_btnQuit.anchor = GridBagConstraints.WEST;
		gbc_btnQuit.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuit.gridx = 3;
		gbc_btnQuit.gridy = 12;
		panelControls.add(btnQuit, gbc_btnQuit);
		
		/*
		 * These are all my event handlers for all of my primary buttons. The events fired from
		 * the setFileName button, enterMove button, Undo, Quit and endGame button are all
		 * handled bellow. Anything inside the menu bar is handled bellow, under the instantiation
		 * of all of my menu bar items.
		 */
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.undoMove();
				square[Integer.parseInt(game.getLastRow())][Integer.parseInt(game.getLastCol())].setText("*");
				square[Integer.parseInt(game.getLastRow())][Integer.parseInt(game.getLastCol())].setEnabled(true);
			}
		});//undoButton actionlistener 
		
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.exitGame();
			}
		}); //quitButton actionlistener
		
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.isGameOver();
			}
		});//endGame actionlistener
		
		/*
		 * ActionPerformed for the set file name button. This method handles 
		 * wether or not the fileName field is blank when the button is clicked,
		 * it makes sure all the visible fields are correct when the file name is 
		 * set either correctly, incorrectly or left blank. 
		 */
		btnSetFileName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayGameComponents();
				enableBoard();
			}
			
			public void displayGameComponents() {
				//If the field is blank, set the filename to be the default sudoku.txt
				if (fldFileName.getText().equals("")) {
					game.setFileName("sudoku.txt");
					defaultFileName();
				}
				else {
					game.setFileName(fldFileName.getText());
				}
				
				fldFileName.setVisible(false);
				btnSetFileName.setVisible(false);
				btnEndGame.setVisible(true);
				lblFileName.setVisible(false);
				btnQuit.setVisible(true);
			}//displayGameComponents
			
			/*
			 * If the file name is valid, it goes through and initialized the board,
			 * setting all button's who's text is * to enables, and otherwise to disabled.
			 * If the file name is invalid, it sets the text in the field to blank, resets 
			 * all frame components to the components seen when you first open the frame 
			 * and the program is essentially restarted.
			 */
			@SuppressWarnings("static-access")
			public void enableBoard() {
				if (game.validFile == true) {
					for (int row = 0 ; row < square.length ; row++) {
						for (int col = 0 ; col < square.length ; col++) {
							if (!game.numbers[row][col].equals("*")) {
								square[row][col].setEnabled(false);
							}
							else {
								square[row][col].setEnabled(true);
							}//else
						}//inner for
					}//outer for
				}//if 
				else {
					fldFileName.setText("");
					invalidFileName();
				}
			}//enableBoard method
			
			public void invalidFileName() {
				fldFileName.setVisible(true);
				lblFileName.setVisible(true);
				btnSetFileName.setVisible(true);
				btnEndGame.setVisible(false);
				btnQuit.setVisible(false);
			}//invalidFileName
			
		});//btnSetFileName.actionPerformed
		
		/*
		 * This method handles input when the user enters something into the 
		 * enterValue field. The method calls to the validate move method in the SudokuGame
		 * class to do all of the actual validation. If everything validates correctly,
		 * the fields are reset and the array in the SudokuGame class is updated accordingly. 
		 * If the fields aren't entered correctly, a message will pop up (handled above the sudokuFrame method)
		 * and the array isn't updated and the board is kept the same. 
		 */
		btnMakeMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Because the validateInput method in the SudokuGame class passes U and Q as valid 
				 * inputs, they need to be stopped in the SudokuFrame class before the validate input 
				 * method gets called. So there's some validation in here and in the SudokuGame class.
				 */
				if (fldEnterMove.getText().equals("Q") || fldEnterMove.getText().equals("q")
						|| fldEnterMove.getText().equals("U") || fldEnterMove.getText().equals("u")) {
					invalidInput();
				}
				else {
					game.validateInput(fldEnterMove.getText());
					makeTheMove();
					resetAllComponents();
				}
			}
			
			/*
			 * Makes all of the proper components visible when you click the button 
			 * to enter your move. The enter move button is replaced with the 
			 * end game button.
			 */
			public void resetAllComponents() {
				btnEndGame.setVisible(true);
				lblFileName.setVisible(false);
				btnUndo.setVisible(true);
				mntmUndo.setVisible(true);
				btnQuit.setVisible(true);
				btnMakeMove.setVisible(false);
				lblEnterMove.setVisible(false);
				fldEnterMove.setVisible(false);
				fldEnterMove.setText("");
				
			}
			
			/*
			 * sets the text in the button to be equal to the value entered in the 
			 * fldEnterMove box. The array in the Game class is also updated so 
			 * the two classes are up to date with eachother. 
			 */
			@SuppressWarnings("static-access")
			public void makeTheMove() {
				if (game.validInput == true) {
					game.updateArray();
					square[Integer.parseInt(game.getRow())][Integer.parseInt(game.getCol())].setText(fldEnterMove.getText());
					game.numbers[Integer.parseInt(game.getRow())][Integer.parseInt(game.getCol())] = fldEnterMove.getText();
					square[Integer.parseInt(game.getRow())][Integer.parseInt(game.getCol())].setEnabled(false);
				}
				else {
					game.updateArray();
					square[Integer.parseInt(game.getRow())][Integer.parseInt(game.getCol())].setEnabled(true);
					game.numbers[Integer.parseInt(game.getRow())][Integer.parseInt(game.getCol())] = "*";
				}
			}
		});
		
		/*
		 * This whole section just deals with building the menu bar
		 * and binding the action listeners to each item. 
		 * The action listener methods are all implemented below.
		 */
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1138, 50);
		contentPane.add(menuBar);
			
		menuOptions = new JMenu("Options");
		menuOptions.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(menuOptions);
		
		mntmRules = new JMenuItem("Rules");
		mntmRules.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuOptions.add(mntmRules);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuOptions.add(mntmAbout);
		
		mntmUndo = new JMenuItem("Undo");
		mntmUndo.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		mntmUndo.setVisible(false);
		menuOptions.add(mntmUndo);
		
		mntmQuit = new JMenuItem("Quit");
		mntmQuit.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuOptions.add(mntmQuit);
		
		/*
		 * These are the action performed methods for all of my menu items. 
		 * Anything regarding my primary buttons is handled above the instantiation
		 * of all of my menu bar items. 
		 */		
		mntmRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayRules();
			}
		});
		
		mntmUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.undoMove();
				square[Integer.parseInt(game.getLastRow())][Integer.parseInt(game.getLastCol())].setText("*");
				square[Integer.parseInt(game.getLastRow())][Integer.parseInt(game.getLastCol())].setEnabled(true);
			}
		});
		
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.exitGame();
			}
		});
		
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAboutBox();
			}
		});
		
		buildBoard();
	}//public sudokuFrame() 
	
	/*
	 * Alerts the user if the file name has been set to the default of sudoku.txt
	 */
	public void defaultFileName() {
		JOptionPane optionPane = new JOptionPane(new JLabel("<html><h1>The file has been set "
				+ "<br /> to the default \"sudoku.txt\"</h1></html>", JLabel.CENTER));
	    JDialog dialog = optionPane.createDialog("Default");
	    dialog.setModal(true);
	    dialog.setVisible(true);	
	}
	
	public void displayRules() {
		JOptionPane optionPane = new JOptionPane(new JLabel("<html><h1>Sudoku rules: </h1><br />"
				+ "<h2>The objective of sudoku is to fill a 9×9 grid with digits so that each column, <br />"
				+ "each row, and each of the nine 3×3 sub-grids that compose the grid  <br />"
				+ "contains all of the digits from 1 to 9. The puzzle setter provides a  <br />"
				+ "partially completed grid, which for a well-posed puzzle has a unique  <br />"
				+ "solution. You must enter all of the missing numbers to find that solution.</h2></html>"
				+ "",JLabel.CENTER));
	    JDialog dialog = optionPane.createDialog("Rules");
	    dialog.setModal(true);
	    dialog.setVisible(true);
		
	}
	
	public void displayAboutBox() {
		JOptionPane optionPane = new JOptionPane(new JLabel("<html><h1>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sudoku</h1>"
				+ "<h1>Philip Dumaresq, 2016</h1>"
				+ "<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Heritage College</h1></html>", JLabel.CENTER));
	    JDialog dialog = optionPane.createDialog("About");
	    dialog.setModal(true);
	    dialog.setVisible(true);		
	}
	
	public void enterFileName() {
		lblFileName = new JLabel("File name: ");
		lblFileName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbc_lblFileName = new GridBagConstraints();
		gbc_lblFileName.gridwidth = 2;
		gbc_lblFileName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileName.anchor = GridBagConstraints.EAST;
		gbc_lblFileName.gridx = 0;
		gbc_lblFileName.gridy = 1;
		panelControls.add(lblFileName, gbc_lblFileName);
		
		fldFileName = new JTextField();
		fldFileName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fldFileName.setColumns(10);
		gbc_fldFileName = new GridBagConstraints();
		gbc_fldFileName.gridwidth = 2;
		gbc_fldFileName.insets = new Insets(0, 0, 5, 5);
		gbc_fldFileName.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldFileName.gridx = 2;
		gbc_fldFileName.gridy = 1;
		panelControls.add(fldFileName, gbc_fldFileName);
		
		btnSetFileName = new JButton("Set File Name");
		btnSetFileName.setEnabled(true);
		btnSetFileName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbc_btnSetFileName = new GridBagConstraints();
		gbc_btnSetFileName.anchor = GridBagConstraints.WEST;
		gbc_btnSetFileName.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetFileName.gridx = 3;
		gbc_btnSetFileName.gridy = 10;
		panelControls.add(btnSetFileName, gbc_btnSetFileName);
	}
	
	/*
	 * Once the user clicks the end game button, the winning condition methods are run and if all is good, 
	 * the public boolean variable win is set to true or false. Here, if "win" is true, then a message 
	 * comes up telling you you've won. If it's false, a message comes up telling you you've lost. 
	 * After clicking okay, the game is exited.
	 */
	public void gameOver() {
		btnUndo.setVisible(false);
		btnQuit.setVisible(false);
		btnEndGame.setVisible(false);
		btnWinOrLose.setVisible(true);
		
		if (game.win == true) {
			JOptionPane optionPane = new JOptionPane(new JLabel("<html><h1>You Win!</h1></html>",JLabel.CENTER));
		    JDialog dialog = optionPane.createDialog("Winner!");
		    dialog.setModal(true);
		    dialog.setVisible(true);
		    game.exitGame();
			//btnWinOrLose.setText("You Win!");
		}
		else {
			JOptionPane optionPane = new JOptionPane(new JLabel("<html><h1>Sorry, you lost</h1></html>",JLabel.CENTER));
		    JDialog dialog = optionPane.createDialog("Lost");
		    dialog.setModal(true);
		    dialog.setVisible(true);
			game.exitGame();
		}
	}
}
