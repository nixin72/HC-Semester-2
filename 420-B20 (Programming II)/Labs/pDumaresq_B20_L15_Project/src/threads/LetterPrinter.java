package threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LetterPrinter
{
	public static void main(String[] args) throws IOException
	{
		FileWriter writer = new FileWriter(new File("numbers.txt"));
		LetterThread letter[] = new LetterThread[10];
		Letter.setCountEnded(0);
		char nextLetter = 'a';
		for (int i = 0; i < letter.length; ++i)
		{
		
			letter[i] = new LetterThread(writer, nextLetter);
			letter[i].setPriority(i+1);
			System.out.println("Starting letter " + i + " which is " + nextLetter
					+ " Priority: " + letter[i].getPriority());
							
			letter[i].start();
			++nextLetter;
		} // for

		System.out.println("The end.");
	} // main()
} // LetterPrinter class
