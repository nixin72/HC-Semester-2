package threads;

import java.io.FileWriter;
import java.io.IOException;

public class Letter
{
	private static int countEnded;
	private static int countStarted;
	private int started;
	private char letter;
	private long repetitions;
	private FileWriter writer;

	public Letter(FileWriter writer, char l)
	{
		this.writer = writer;
		letter = l;
		repetitions = 1000000;
		started = ++countStarted;
	} //  Letter(FileWriter, char)

	public void print()
	{
		try
		{
			for (long i = 0; i < repetitions; ++i)
				if (i % 1000 == 0)
					writer.write(letter);
			writer.write("\n");
			++countEnded;
			System.out.println(" " + letter + " is finished. Started position: "
					+ started + ". Ended position: " + countEnded + ".");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // print ()

	public static int getCountStarted()
	{
		return countStarted;
	}

	public static int getCountEnded()
	{
		return countEnded;
	} // getCountEnded()

	public static void setCountEnded(int ended)
	{
		countEnded = ended;
	} // setCountEnded(int ended)
} // Letter 
