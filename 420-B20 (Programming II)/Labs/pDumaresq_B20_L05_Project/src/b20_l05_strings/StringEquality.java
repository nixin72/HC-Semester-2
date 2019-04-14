package b20_l05_strings;

/**
 * Title:         420-B20 Lab 5
 * Description:   Demonstrates the difference between string equality and
 *                string identity. Compares the equals() and equalsIgnoreCase()
 *                methods.
 * Copyright:     Copyright (c) 2001
 * @author Anne Hamilton
 * @version 1.0
 */

public class StringEquality
{
	static String s1 = new String("Lab 5");
	static String s2 = new String("Lab 5");
	static String s3 = new String("lab 5");
	static String s4 = "Lab 5";
	static String s5 = s3;
	static String s6 = "lab 5";
	static String s7 = "lab 5";

	private static void testEqual(String name1, String str1, String name2,
			String str2)
	{
		if (str1.equalsIgnoreCase(str2))
			System.out.printf("%-12s%-25s%-12s\n", name1 + "(\"" + str1 + "\")",
					"equals", name2 + "(\"" + str2 + "\")");

		else
			System.out.printf("%-12s%-25s%-12s\n", name1 + "(\"" + str1 + "\")",
					 "does not equal", name2 + "(\"" + str2 + "\")");
	} // testEqual()

	private static void testIdentical(String name1, String str1, String name2,
			String str2)
	{
		if (str1 == str2)
			System.out.printf("%-12s%-25s%-12s\n", name1 + "(\"" + str1 + "\")",
					"is identical to", name2 + "(\"" + str2 + "\")");
		else
			System.out.printf("%-12s%-25s%-12s\n", name1 + "(\"" + str1 + "\")",
					"is not identical to", name2 + "(\"" + str2 + "\")");
	} // testIdentical()

	private static void testMethods(String name1, String firstString,
			String name2, String secondString)
	{

		testEqual(name1, firstString, name2, secondString);
		testIdentical(name1, firstString, name2, secondString);
	} // testMethods()

	public static void main(String[] argv)
	{
		testMethods("s1", s1, "s2", s2);
		testMethods("s1", s1, "s3", s3);
		testMethods("s1", s1, "s4", s4);
		testMethods("s4", s4, "s6", s6);
		testMethods("s3", s3, "s5", s5);
		testMethods("s4", s4, "s7", s7);
		testMethods("s6", s6, "s7", s7);
		testMethods("s1", s1, "\"Lab 5\"", "Lab 5");
		testMethods("s6", s6, "\"Lab 5\"", "Lab 5");
	} // main()
} // StringEquality class