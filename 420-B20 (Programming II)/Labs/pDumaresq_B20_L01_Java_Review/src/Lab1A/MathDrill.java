package Lab1A;

import java.util.Scanner;

/**
 * Title:         420-B20 Lab 1 - Winter, 2009
 * Description:   This class is an arithmetic drill exercise.
 * Copyright:    Copyright (c) 2007
 * Company:
 * @author Anne Hamilton
 * @version 2.0
 */

public class MathDrill
{
	private int base;

	public MathDrill()
	{
		base = 1;
	} // MathDrill()

	public MathDrill(int b)
	{
		base = b;
	} // MathDrill(int)

	public void setBase(int b)
	{
		base = b;
	} // setBase(int)

	public void multiplicationDrill()
	{
		Scanner input = new Scanner(System.in);
		int ans;

		for (int i = 1; i <= 12; ++i)
		{
			System.out.print("What is " + base + " x " + i + "? ");
			ans = input.nextInt();
			if (ans == base * i)
				System.out.print("");
			else
				while (ans != base * i)
				{
					System.out.print("Sorry - wrong answer. Try again. What is " + base
							+ " x " + i + "? ");
					ans = input.nextInt();
				}
			System.out.println("Congratulations - correct answer.");
		} // for
	} // multiplicationDrill()

	public void additionDrill()
	{
		Scanner Sc = new Scanner(System.in);
		int ans1;
		for (int i = 1; i <= 12; ++i)
		{
			System.out.print("What is " + base + " + " + i + "? ");
			ans1 = Sc.nextInt();
			if (ans1 == base + i)
				System.out.print("");
			else
				while (ans1 != base + i)
				{
					System.out.print("Sorry - wrong answer. Try again. What is " + base
							+ " + " + i + "? ");
					ans1 = Sc.nextInt();
				}
			System.out.println("Congratulations - correct answer.");
		}
	}
} // MathDrill