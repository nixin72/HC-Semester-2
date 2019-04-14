package b20_L06_Project;

import java.io.*;

import java.util.*;

/**
 * Title:         420-B20 Lab 6
 * Description:   Represents a school course with 4 marks enrolled.
 *                Contains methods to input the course marks, calculate the
 *                class average and list all narks above the class average.
 * Copyright:     Copyright (c) 2001
 * @author Anne Hamilton
 * @version 1.0
 */

public class Course
{
	private static final int ARRAY_SIZE = 40;
	private static final char GRADE[] = {'A', 'B', 'C', 'D', 'F'};
	private int gradeCount [] = {0,0,0,0,0};
	private int numMarks;
	private String courseName;
	private int mark[]; 
	
	private double average;

	public Course()
	{
		numMarks = mark.length;
		courseName = "Unknown";
		mark = new int[ARRAY_SIZE];
		for (int i = 0 ; i < mark.length ; i++) {
			mark[i] = 0;
		}
		
		for (int l = 0 ; l < GRADE.length ; l++) {
			System.out.println("The grade is: " + GRADE[l]);
		}
		
	} // Course()

	public Course(String n)
	{
		numMarks = mark.length;
		mark = new int[ARRAY_SIZE];
		courseName = n;
		for (int i = 0 ; i < mark.length ; i++) {
			mark[i] = 0;
		}
	} // Course(String)

	public void inputMarks()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter marks for " + courseName + ":");
		for (int i = 0 ; i < mark.length ; i++) {
			mark[i] = input.nextInt();
		}
 
	} // inputMarks()

	public void displayDistribution() {
		System.out.println("Grade distribution: ");
		for (int k = 0 ; k < GRADE.length ; k++) {
			for (int j = 0 ; j < numMarks ; j++) {
				if (getGrade(mark[j]) == GRADE[k]) {
					gradeCount[k]++;
				}
			}
		}
		for (int k = 0 ;  k < GRADE.length ; k++) {
			System.out.println(GRADE[k] + "'s : " + gradeCount[k]);
		}
	}
	
	public void readMarks()
	{
		Scanner input;
		try
		{
			input = new Scanner(new File("marks.txt"));
			for (int k = 0; k < mark.length && input.hasNext();  ++k) {
				mark[k] = input.nextInt();
				numMarks++;
			}
		}
		catch (FileNotFoundException e)
		{
			System.err.println("ERROR: marks.txt not found");
		}
	} // readMarks()

	public double getAverage()
	{
		return average;
	} // getAverage()

	public String getName()
	{
		return courseName;
	} // getName()

	public void calculateAverage()
	{
		int sum = 0;
		for (int i = 0 ; i < numMarks ; i++) {
			sum += mark[i];
		}
		if (sum > 0)
			average = (double) sum / ARRAY_SIZE;
		else
			average = -1;
	} // calculateAverage()

	public void displayTopMarks()
	{
		int k = 0;
		for (int i = 0 ; i < numMarks ; i++) {
			if (mark[i] > average)
				System.out.println("mark " + (i + 1) + " is above average");
		}
	} // displayTopMarks()

	public char getGrade(int m)
	{
		if (m >= 90)
			return 'A';
		else if (m >= 80)
			return 'B';
		else if (m >= 70)
			return 'C';
		else if (m >= 60)
			return 'D';
		else
			return 'F';
	} // getGrade(int)

} // Course class
