package b20_L06_Project;

import java.util.Scanner;

public class TestSentence
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String inSentence = input.nextLine();
		Sentence mySentence = new Sentence(inSentence);
//		System.out.println("Sentence in reverse: ");
//		System.out.println(mySentence.reverse() + "\n");
		mySentence.displayVowelCounts();
		input.close();
	} // main()
} // TestSentence class