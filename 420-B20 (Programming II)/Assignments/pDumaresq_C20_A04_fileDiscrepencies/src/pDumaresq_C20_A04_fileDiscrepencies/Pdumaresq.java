package pDumaresq_C20_A04_fileDiscrepencies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pdumaresq {
	File file1, file2;
	Scanner read1, read2;
	
	public boolean betting() {
		try {
			file1 = new File("file:///D:/2nd%20semester/web%20II/assignments_2/pDumaresq_C20_A03_Casino/JavaScript/betting.js");
			read1 = new Scanner(file1);
			file2 = new File("file:///E:/pDumaresq_C20_A03_Casino/JavaScript/betting.js");
			read2 = new Scanner(file2);
			
			String file1 = new String();
			String file2 = new String();
			int lines1;
			int lines2;
			while (read1.hasNext()) {
				file1 += read1.next();
			}
			while (read2.hasNext()) {
				file2 += read2.next();
			}
			
			if (file1.equals(file2)) {
				System.out.println("The files are different");
			}
			else {
				
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("one of the betting files wasn't found");
		}
		return true;
	}
	public boolean diceRolls() {
		try {
			file1 = new File("file:///D:/2nd%20semester/web%20II/assignments_2/pDumaresq_C20_A03_Casino/JavaScript/diceRolls.js");
			read1 = new Scanner(file1);
			file2 = new File("file:///E:/pDumaresq_C20_A03_Casino/JavaScript/diceRolls.js");
			read2 = new Scanner(file2);
		}
		catch (FileNotFoundException e) {
			System.out.println("one of the diceRolls files wasn't found");
		}
		return true;
	}
	public boolean input() {
		try {
			file1 = new File("file:///D:/2nd%20semester/web%20II/assignments_2/pDumaresq_C20_A03_Casino/JavaScript/input.js");
			read1 = new Scanner(file1);
			file2 = new File("file:///E:/pDumaresq_C20_A03_Casino/JavaScript/input.js");
			read2 = new Scanner(file2);
		}
		catch (FileNotFoundException e) {
			System.out.println("one of the input files wasn't found");
		}
		return true;
	}
	public boolean onload() {
		try {
			file1 = new File("file:///D:/2nd%20semester/web%20II/assignments_2/pDumaresq_C20_A03_Casino/JavaScript/onLoad.js");
			read1 = new Scanner(file1);
			file2 = new File("file:///E:/pDumaresq_C20_A03_Casino/JavaScript/onLoad.js");
			read2 = new Scanner(file2);
		}
		catch (FileNotFoundException e) {
			System.out.println("one of the onload files wasn't found");
		}
		return true;
	}
	public boolean processData() {
		try {
			file1 = new File("file:///D:/2nd%20semester/web%20II/assignments_2/pDumaresq_C20_A03_Casino/JavaScript/processData.js");
			read1 = new Scanner(file1);
			file2 = new File("file:///E:/pDumaresq_C20_A03_Casino/JavaScript/processData.js");
			read2 = new Scanner(file2);
		}
		catch (FileNotFoundException e) {
			System.out.println("one of the processData files wasn't found");
		}
		return true;
	}
	public boolean winning() {
		try {
			file1 = new File("file:///D:/2nd%20semester/web%20II/assignments_2/pDumaresq_C20_A03_Casino/JavaScript/winning.js");
			read1 = new Scanner(file1);
			file2 = new File("file:///E:/pDumaresq_C20_A03_Casino/JavaScript/winning.js");
			read2 = new Scanner(file2);
		}
		catch (FileNotFoundException e) {
			System.out.println("one of the winning files wasn't found");
		}
		return true;
	}
}
