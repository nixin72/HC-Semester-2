package Lab1B;

import java.util.Scanner;
import java.io.*;

public class TextCounter
{
	public static void main(String args[])
	{
		File readIt = new File("my_favourite_sentences.txt");
		Scanner reader = null;
		
		try {
			readIt = new File("my_favourite_sentences.txt");
			reader = new Scanner (readIt);
		}
		catch (FileNotFoundException e) {
			System.err.println("my_favourite_sentences.txt could not be found.");
			System.exit(-1);
		}
		reader.useDelimiter("~|\r\n");
		
		
		while (reader.hasNext()) {
		
		int numberOfWords = 0;
		String sentence1 = reader.next();
		System.out.println(sentence1);
		
		String sentence = reader.nextLine();
		System.out.print("The words begin at positions 0");
		// Find the end of the first word
		int spaceIndex = sentence.indexOf(" ");
		
		while (spaceIndex != -1)
		{
			++numberOfWords;
			// Skip over multiple spaces
			while (spaceIndex < sentence.length() - 1
					&& sentence.charAt(spaceIndex + 1) == ' ')
				++spaceIndex;
			if (spaceIndex < sentence.length() - 1) // if there's another word in the sentence
				System.out.print(", " + (spaceIndex + 1));
			// Find the end of the next word
			spaceIndex = sentence.indexOf(' ', spaceIndex + 1);
		} // while (spaceIndex != -1)
		
		++numberOfWords;
		System.out.println("\nThere are " + numberOfWords
				+ " words in the sentence.");
		}
		
	} // main()
} // TextCounter class
