package threads;

import java.io.FileWriter;
import java.io.IOException;

public class LetterThread extends Thread
{
	private static int countEnded;
	private static int countStarted;
	private int started;
	private char letter;
	private long repetitions;
	private FileWriter writer;

	public LetterThread(FileWriter writer, char l)
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
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // print ()

	public int getCountStarted()
	{
		return countStarted;
	}

	public int getCountEnded()
	{
		return countEnded;
	} // getCountEnded()

	public void setCountEnded(int ended)
	{
		countEnded = ended;
	} // setCountEnded(int ended)
	
	public void run() {
		try
		{
			System.out.println("Letter " + letter + " is going to sleep.");
			long start = System.currentTimeMillis();
			Thread.sleep(5);
			long end = System.currentTimeMillis();
			long time = end - start;
			System.out.println(letter + " slept for " + time + " milliseconds.");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		} 
		print();
	}
} // Letter 
