package ticTacToe;

public class TicTacToeBoard {
	
	private static final int ROWCOL = 3;
	private static final int ROWS = ROWCOL;
	private static final int COLS = ROWCOL;
	private int plays;
		private char board[][] = new char[ROWS][COLS];

	public TicTacToeBoard() {
		newGame();
	} // TicTacToeBoard()

	public void newGame() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
		plays = 0;
		
	
		
	} // newGame()

	public void play(int row, int col, char turn) {
		board[row][col] = turn;
		++plays;
	} // play(int, int, char)

	public char isGameOver() {
		for (int col = 0; col < board[0].length; col++) {
			if (checkCol(col) == true) {
				return board[0][col];
			}
		}

		for (int row = 0; row < board[0].length; row++) {
			if (checkRow(board[row]) == true) {
				return board[0][row];
			}
		}

		for (int col = 0; col < board[0].length; col++) {
			if (checkLeftToRightDiagonal() == true) {
				return board[0][0];
			}
		}

		for (int col = 2; col >= 0; col--) {
			if (checkRightToLeftDiagonal() == true) {
				return board[2][0];
			}
		}

		if (plays == (Math.pow((board.length), 2)))
			return 'T'; // tie
		else
			return 'C'; // continue playing
	} // isGameOver()

	private boolean checkRow(char[] boardRow) {
		char start = boardRow[0];
		if (boardRow[0] == ' ') {
			return false;
		}
		for (int col = 0; col < board[0].length; col++) {
			if (boardRow[col] != boardRow[0]) {
				return false;
			}
		}
		return true;
	} // checkRow(char, int)

	private boolean checkCol(int col) {
		char start = board[0][col];
		if (start == ' ') {
			return false;
		}
		for (int row = 0; row < board.length; row++) {
			if (board[row][col] != start) {
				return false;
			}
		}
		return true;
	} // checkCol(char, int)

	private boolean checkLeftToRightDiagonal() {
		char start = board[0][0];

		if (start == ' ') {
			return false;
		}
		for (int col = 0; col < board[0].length; col++) {
			if (board[col][col] != start) {
				return false;
			}
		}
		return true;
	} // checkLeftToRightDiagonal(char)

	private boolean checkRightToLeftDiagonal() {
		char start = board[0][2];
		int row = 0;

		if (start == ' ') {
			return false;

		}
		for (int col = 2; col >= 0; col--) {
			if (board[row++][col] != start) {
				return false;
			}
		}
		return true;
	} // checkLeftToRightDiagonal(char)
} // TicTacToeBoard class