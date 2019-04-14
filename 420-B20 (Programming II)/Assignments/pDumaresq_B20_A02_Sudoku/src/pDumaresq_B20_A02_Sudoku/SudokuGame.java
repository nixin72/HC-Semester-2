package pDumaresq_B20_A02_Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SudokuGame {
	//SudokuInterface cli = new SudokuInterface();
	SudokuFrame frame = new SudokuFrame();
	final static int BOARD_SIZE = 9;
	public static String numbers[][] = new String[BOARD_SIZE][BOARD_SIZE];
	private Scanner buildBoard;
	private File sudoku;
	private String temp, fileName, row, col, val;
	private static String lastRow, lastCol;
	public boolean win = true;
	public boolean validInput = true;
	public boolean validFile = true;

	// Mutator methods
	public void setFileName(String file) {
		fileName = file;
		buildInitialArray();
	}
	
	public void setVal(String v) {
		val = v;
	}

	public void setRow(String r) {
		row = r;
	}

	public void setCol(String c) {
		col = c;
	}
	
	public void setLastRow(String lR) {
		lastRow = lR;
	}
	
	public void setLastCol(String lC) {
		lastCol = lC;
	}

	// Accessor methods
	public String getCol() {
		return col;
	}

	public String getRow() {
		return row;
	}

	public String getVal() {
		return val;
	}

	public String getFileName() {
		return fileName;
	}
	
	public String getLastRow() {
		return lastRow;
	}

	public String getLastCol() {
		return lastCol;
	}
	
	/*
	 * This method reads the file into a 2D array and stores all the values as
	 * the squares in a sudoku board.
	 */
	@SuppressWarnings("static-access")
	public void buildInitialArray() {
		try {
			sudoku = new File(getFileName());
			buildBoard = new Scanner(sudoku);
			buildBoard.useDelimiter("~");
			while (buildBoard.hasNext()) {
				for (int r = 0; r < numbers.length; r++) {
					for (int c = 0; c < numbers[r].length; c++) {
						if (buildBoard.hasNext()) {
							temp = buildBoard.next();
							temp = temp.replace("\r\n", "");
							numbers[r][c] = temp;
						}
					} // inner for loop
				} // outer for loop
			} // while loop
/*
------------------------------------------------------------------------------------------------------------------------------------------
*/
		//	cli.startGame();
			frame.displayValues();
			validFile = true;
		} catch (FileNotFoundException e) {
/*
------------------------------------------------------------------------------------------------------------------------------------------
*/
		//cli.reenterFileName();
		validFile = false;
		frame.displayErrorMessage();
		} // catch block
	}

	/*
	 * After each user input, the row, col and val are accessed in here and 
	 * the array is updated. 
	 * the method then calls the displayBoard method in the interface class.
	 */
	public void updateArray() {
		setLastRow(row);
		setLastCol(col);
//		numbers[Integer.parseInt(getRow())-1][Integer.parseInt(getCol())-1] = getVal();
		numbers[Integer.parseInt(getRow())][Integer.parseInt(getCol())] = getVal();
/*
------------------------------------------------------------------------------------------------------------------------------------------
*/
//		cli.displayBoard();
	}

	/*
	 * This method gets run after every time the user inputs a value. It loops
	 * through each row and column on the board and checks if any of the values
	 * in the array are an asterix instead of a number. If there's an asterix,
	 * the method returns false. If the board has been finished, it returns true
	 * and checks winning conditions.
	 */
	public void isGameOver() {
		boolean checkwinning = false;
		
		for (int r = 0; r < numbers.length; r++) {
			for (int c = 0; c < numbers[r].length; c++) {
				if (numbers[r][c].equals("*") || numbers[r][c].equals("\n*")) {
/*
------------------------------------------------------------------------------------------------------------------------------------------
*/
//					cli.playGame();
					checkwinning = false;
				} // if
				else {
					checkwinning = true;
				} // else number[r][c] != *
			} // inner for
		} // outer for
		
		if (checkwinning == true) {	 
			boolean isValid = true;
					
			isValid = isValid && checkBox();
			isValid = isValid && checkRow();
			isValid = isValid && checkCol();
								
			if (isValid == true) {
				win = true;
			} // if
			else {
				win = false;
			} // else isValid == false
/*
------------------------------------------------------------------------------------------------------------------------------------------
*/
//			cli.gameOver();
			frame.gameOver();	
		}
	}// public void isGameOver()

	/*
	 * The following methods check all of the winning conditions. They will loop
	 * through each row, column and box to see if there are any matches. If
	 * everything returns true, then there will be a display saying that you win
	 * the game. If not, it will tell you that you've lost.
	 */
	/*
	 * This method checks all the rows by comparing the first array in the numbers array 
	 * to a pre built array of 1-9 as Strings.
	 * It will loop through the rows and as there's alreay arrays in there, I just have to sort each array
	 * Then I compare that array to the pre built one and it will go into an if statement that 
	 * returns true or false. If the two arrays are equal, it will set isValid to true and return isValid.
	 * If it is false, then the method immediately returns false and is exited immediately.
	 */
	private boolean checkRow() {
		boolean isValid = true;
		String rowCheckArray[] = {"1","2","3","4","5","6","7","8","9"};
		for (int r = 0 ; r < numbers.length ; r++) {
			Arrays.sort(numbers[r]);
			//System.out.println((Arrays.toString(numbers[r])));
			
			if (Arrays.equals(rowCheckArray, numbers[r])) {
				isValid = true;
			}
			else {
				return false;
			}
		}
		return isValid;
	} 

	/*
	 * To check wether or not the row is valid, I have a pre built array of 1-9 in Strings.
	 * Unlike the check row method, I can't just use the array inside the numbers array
	 * So I have build a new array that's made up of all the numbers in each column.
	 * So I loop through and add the first number of each row into the array.
	 * Once the array is built, I sort the array and compare it to the array of 1-9.
	 * If the two arrays are identical, the method sets isValid to true and returns isValid.
	 * If the array's aren't identical, the method returns false and is exited immediately
	 */
	private boolean checkCol() {
		boolean isValid = true;
		String rowCheckArray[] = {"1","2","3","4","5","6","7","8","9"};
		String[] arrayToCompare = new String[9];
		for (int r = 0 ; r < numbers.length ; r++) {
			for (int c = 0 ; c < numbers[r].length ; c++) {
				arrayToCompare[c] = numbers[c][r];
			}		
			Arrays.sort(numbers[r]);
						
			if (Arrays.equals(rowCheckArray, arrayToCompare)) {
				isValid = true;
			}
		}
		return isValid;
	} 
	
	public boolean checkBox() {
		boolean itWorks = true;
		
		return itWorks;
	}

	/*
	 * This method validates the user input for the row, column and the value
	 * input. If Q is entered, the exit game method will be called. If U is
	 * entered, the undo move method will be called. If 1-9 is entered, the If
	 * there's an invalid input, then the playGame method is called, the user is
	 * told they messed up and they continue playing.
	 */
	public boolean validateInput(String num) {
		
		if (num.equals("Q") || num.equals("q")) {
			exitGame();
			validInput = true;
			return true;
		} else if (num.equals("U") || num.equals("u")) {
			undoMove();
			validInput = true;
			return true;
		} else if (num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4") || num.equals("5")
				|| num.equals("6") || num.equals("7") || num.equals("8") || num.equals("9")) {
			num = String.valueOf(Integer.parseInt(num) - 1);
			validInput = true;
			return true;
		} else {
/*
------------------------------------------------------------------------------------------------------------------------------------------
*/
//			cli.invalidInput();
			validInput = false;
			frame.invalidInput();
			return false;
		}
	}

	/*
	 * This method undoes your last move. Your previous move is stored in static
	 * variables and this method will access them and update the array returning
	 * it to it's previous state. The displayBoard method is then called for the
	 * user to continue playing
	 */
	public void undoMove() {
		if (numbers[Integer.parseInt(getLastRow())][Integer.parseInt(getLastCol())] == "*") {      //Frame
/*
------------------------------------------------------------------------------------------------------------------------------------------
*/
//		if (numbers[Integer.parseInt(getLastRow())-1][Integer.parseInt(getLastCol())-1] == "*") {//CLI
//			cli.invalidUndo();
		}
		else {
			numbers[Integer.parseInt(getLastRow())][Integer.parseInt(getLastCol())] = "*";    //Frame
/*
------------------------------------------------------------------------------------------------------------------------------------------
*/
//			numbers[Integer.parseInt(getLastRow())-1][Integer.parseInt(getLastCol())-1] = "*";//CLI
		}
//		cli.displayBoard();
	}

	/*
	 * This method exits the game when called.
	 */
	public void exitGame() {
		System.exit(0);
	}

}