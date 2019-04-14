package b20_l10;

import java.util.Scanner;

public class WrapperClasses
{
	public static void main(String[] args)
	{
		char ch;
		int num;
		double realNum;
		Scanner reader = new Scanner(System.in);
		String input;
		System.out.println("Type something:");
		input = reader.next();
		ch = input.charAt(0);
		
		System.out.println(Character.isLetterOrDigit(ch) + "\n" +	Character.isLetter(ch) + "\n" 
		+	Character.isDigit(ch) + "\n" + Character.isLowerCase(ch) + "\n" + Character.toLowerCase(ch) 
		+ "\n" + Character.isUpperCase(ch) + "\n" +	Character.toUpperCase(ch) + "\n");

		for (int i = 1 ; i < 10 ; i++) {
			if (ch == i) {
				if (input.indexOf(".") == 1) {
					realNum = Double.parseDouble(input);
				}//input has '.'
				else {
					num = Integer.parseInt(input);
				}
			}//ch == a numbers
		}//for loop
	} // main()
} // WrapperClasses
