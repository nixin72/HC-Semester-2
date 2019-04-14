package pDumaresq_B20_A02_Sudoku;

import java.util.Scanner;

public class SudokuInterface {

	private static Scanner keyboard = new Scanner(System.in);
	private static SudokuGame game = new SudokuGame();
	
	private static String row, col, val;

	/*
	 * Sets the actual game in motion. Tells the user that they can undo or quit using q or u,
	 * then calls the method to display the board. This is a completely seperate method because
	 * I only want this to happen the very first time the game is run. 
	 */
	public void startGame() {
		System.out.println("\nType Q at any time to exit the game.\n" + "Type U at any time to undo your last move.\n");
		displayBoard();
	}

	/*
	 * This method reads the board in from the SudokuGame class. It then prints
	 * out the sudoku board. At every 3rd column, it will print out a | to
	 * seperate the boxes in columns. At every 3rd row, it will print out lines
	 * to seperate the boxes into rows.
	 */
	@SuppressWarnings("static-access")
	public void displayBoard() {
		for (int r = 0; r < game.numbers.length; r++) {
			for (int c = 0; c < game.numbers[r].length; c++) {
				if (c == 9) {
					System.out.print(game.numbers[r][c] + "\n");
				} // if
				else {
					System.out.print(game.numbers[r][c] + " ");

					if (c == 2 || c == 5) {
						System.out.print("| ");
					} // if
				} // else
			} // inner for loop
			System.out.println("");
			if (r == 2 || r == 5) {
				System.out.print("------+-------+------\n");
			} // if
		} // outer for loop
		game.isGameOver();
		playGame();
	}

	/*
	 * If the user didn't enter the file name correctly, this method is called
	 * and the user must reenter the filename before proceeding.
	 */
	public String reenterFileName() {
		System.out.print("The file does not exist. Please enter a different file name. ");
		String fileName = keyboard.next();
		game.setFileName(fileName);
		return fileName;
	}

	/*
	 * This is the method where the user inputs their moves. If there's already
	 * a number in the square they're trying to use, the method recalls itself.
	 * If the user inputs a valid square, then the mutator methods for the
	 * row/column/value are accessed and the numbers are stored. The isGameOver
	 * method is then called.
	 */
	@SuppressWarnings("static-access")
	public void playGame() {
		System.out.print("\n\nEnter a square number (row, column) -> ");
		row = keyboard.next();
		game.validateInput(row);
		col = keyboard.next();
		game.validateInput(col);
		System.out.print("Enter value: ");
		val = keyboard.next();
		game.validateInput(val);
		System.out.println("");
		
		if (col.equals("1")) {
			game.numbers[Integer.parseInt(row) - 1][Integer.parseInt(col)- 1]
					= game.numbers[Integer.parseInt(row) - 1][Integer.parseInt(col) - 1].substring(1);
		}

		if (game.numbers[Integer.parseInt(row) - 1][Integer.parseInt(col) - 1].equals("*")
				|| game.numbers[Integer.parseInt(row) - 1][Integer.parseInt(col) - 1].equals("\n*")) {
			// set values of row/col/val
			game.setRow(row);
			game.setCol(col);
			game.setVal(val);
			game.updateArray();
		} // if
		else {
			System.out.println("There's already a number in that square." + " \nPlease chose a different one.");
			playGame();
		} // else
	}// public void playGame()

	/*
	 * This method just displays end game messages to the user. 
	 * In the isGameOver method, the variable win is instantiated.
	 * If boolean variable is equal to true, the player wins. Otherwise, they lost.
	 */
	public void gameOver() {
		if (game.win == true) {
			System.out.println("\n\nCongratulations! You win!\nThank you for playing Heritage Sudoku! ");
			game.exitGame();
		} else {
			System.out.println("\n\nSorry, you lost.\nThank you for playing Heritage Sudoku! ");
			game.exitGame();
		}
	}

	/*
	 * This method is called if the user inputs something other than q, u or 1-9 as part of their move. 
	 */
	public void invalidInput() {
		System.out.println("You must enter a number between 1 and 9, Q to quit, or U to undo your last move.");
		playGame();
	}

	/*
	 * Tells the user they can't undo a move more than once if they attempt to and 
	 * immediately redisplays the board.
	 */
	public void invalidUndo() {
		System.out.println("\nYou may only undo a move once.\n");
		displayBoard();
	}

	/*
	 * All the main method does is get the game started up by welcoming the user
	 * and then it calls the setFileName method where the user must begin
	 * playing.
	 */
	public static void main(String[] args) {
		System.out.print("Welcome to Heritage Sudoku.\n" + "please enter the file name for your puzzle: ");
		String fileName = keyboard.next();
		game.setFileName(fileName);

	}
}