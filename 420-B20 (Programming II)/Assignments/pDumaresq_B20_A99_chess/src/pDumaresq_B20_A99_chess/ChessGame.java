package pDumaresq_B20_A99_chess;

public class ChessGame {
	public String pieces[][] = new String[8][8];
	
	public void initialBoard() {
		for (int row = 0; row < pieces.length; ++row){
			for (int col = 0; col < pieces[row].length; ++col) {
				if (row == 0 || row == 7) {
					if (col == 0) 
						pieces[row][col] = "R";
					if (col == 1) 
						pieces[row][col] = "N";
					if (col == 2)
						pieces[row][col] = "B";
					if (col == 3) 
						pieces[row][col] = "K";
					if (col == 4) 
						pieces[row][col] = "Q";
					if (col == 5) 
						pieces[row][col] = "B";
					if (col == 6) 
						pieces[row][col] = "N";
					if (col == 7) 
						pieces[row][col] = "R";
				}
				else if (row == 1 || row == 6) {
					pieces[row][col] = "P";
				}
				else {
					pieces[row][col] = "";
				}
			}	
		}	
	}
}
