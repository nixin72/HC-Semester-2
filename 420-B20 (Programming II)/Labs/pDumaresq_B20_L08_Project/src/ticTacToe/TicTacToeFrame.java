package ticTacToe;

import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.SwingConstants;
	import java.awt.Font;

public class TicTacToeFrame extends JFrame implements ActionListener, SwingConstants {
	Font bigger = new Font("Comic sans", Font.ITALIC | Font.BOLD, 62);
	private static final int ROWCOL = 3;
	private static final int ROWS = ROWCOL;
	private static final int COLS = ROWCOL;
	private JLabel whoseTurn;
	private JPanel ticTacToePanel = new JPanel();
	private char player[] = { 'X', 'O' };
	private char currentPlayer;
	private TicTacToeBoard board;
	private JButton ticTacToeButton[][] = new JButton[ROWS][COLS];
	
	public TicTacToeFrame() {
		this.setSize(new Dimension(400, 300));
		this.setTitle("Tic Tac Toe");
		currentPlayer = player[(int) (Math.random() * 2)];
		whoseTurn = new JLabel(currentPlayer + " starts");
		whoseTurn.setHorizontalAlignment(CENTER);
		whoseTurn.setFont(new Font("label", Font.BOLD, 14));
		this.getContentPane().add(whoseTurn, "North");
		board = new TicTacToeBoard();
		initializeBoard();
		this.getContentPane().add(ticTacToePanel, "Center");
	}

	private void initializeBoard() {
		ticTacToePanel.setLayout(new GridLayout(ROWS, COLS));
		for (int row = 0; row < ticTacToeButton.length; ++row)
			for (int col = 0; col < ticTacToeButton[row].length; ++col) {
				ticTacToeButton[row][col] = new JButton("");
				ticTacToeButton[row][col].setFont(new Font("board", Font.BOLD, 24));
				ticTacToePanel.add(ticTacToeButton[row][col]);
				ticTacToeButton[row][col].addActionListener(this);
			}
		board.newGame();
	}// initializeBoard()

	public void actionPerformed(ActionEvent e) {
		for (int row = 0; row < ticTacToeButton.length; row++) {
			for (int col = 0; col < ticTacToeButton[row].length; col++) {
				if (e.getSource() == ticTacToeButton[row][col]) {
					((JButton) e.getSource()).setText(String.valueOf(currentPlayer));
					ticTacToeButton[row][col].setFont(bigger);
					takeTurn(row, col);
				}
			}
		}
	}

	private void takeTurn(int row, int col) {

		int next;
		markSquare(row, col);
		char winner = board.isGameOver();
		// if the game is not over yet, change currentPlayers
		if (winner == 'C') {
			if (currentPlayer == 'X')
				currentPlayer = 'O';
			else
				currentPlayer = 'X';

			whoseTurn.setText("It's " + currentPlayer + "'s turn");
		} else {
			// if the game is over inform the players of the result and ask if
			// they want to play again
			if (winner == 'T')
				next = JOptionPane.showConfirmDialog(this, "Game Over! It's a tie! Nobody won!!! Play again?",
						"Game over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			else
				next = JOptionPane.showConfirmDialog(this, "Game Over! " + winner + " won!!! Play again?", "Game over",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (next == JOptionPane.YES_OPTION)
				newGame();
			else
				System.exit(0);
		}
	} // takeTurn(int, int)

	private void markSquare(int row, int col) {
		// don't allow two players to select the same square
		ticTacToeButton[row][col].setEnabled(false);
		ticTacToeButton[row][col].setText(String.valueOf(currentPlayer));
		// mark the square on the board
		board.play(row, col, currentPlayer);
	} // markSquare(int, int);

	private void newGame() {
		// reset the board
		for (int row = 0; row < ticTacToeButton.length; row++) {
			for (int col = 0; col < ticTacToeButton[row].length; col++) {
				ticTacToeButton[row][col].setEnabled(true);
				ticTacToeButton[row][col].setText("");
			}
		}

		board.newGame();
		// select the first player
		whoseTurn.setText(currentPlayer + " starts");
	} // newGame()

	public static void main(String[] args) {
		JFrame frame = new TicTacToeFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
} // TicTacToeFrame