package Lab1A;

import java.util.Scanner;

/**
 * Title:        420-B20 Labs - Winter, 2009
 * Description:   This program is an arithmetic drill exercise. The user enters
 *                a starting number and is then prompted to enter the correct
 *                answer to the multiplication table from 1 to 10 for that number.
 *                For example, if the user enters 5 as the starting number, he/she
 *                will be prompted for the answers to all the multiplcation problems
 *                from 1 x 5 to 10 x 5. If he/she enters an incorrect answer,
 *                the program will continue to prompt for the answer until
 *                the correct answer is given.
 * Copyright:    Copyright (c) 2007
 * Company:
 * @author Anne Hamilton
 * @version 2.0
 */

public class Lab1A
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		MathDrill drillMe = new MathDrill();
		System.out
				.println("Select one of the following: \n\t 1. Addition drill \n\t 2. Multiplication Drill");
		int drillType = input.nextInt();
		if (drillType == 1)
		{
			System.out.println("1.");
			System.out.print("What number do you want to test? ");
			drillMe.setBase(input.nextInt());
			drillMe.additionDrill();
		}
		else
			if (drillType == 2)
			{
				System.out.print("What number do you want to test? ");
				drillMe.setBase(input.nextInt());
				drillMe.multiplicationDrill();
			}
			else
			{
				System.err.println(drillType
						+ " is not one of the drills. Please enter 1 or 2.");
			}

	} // main
} // Lab1A