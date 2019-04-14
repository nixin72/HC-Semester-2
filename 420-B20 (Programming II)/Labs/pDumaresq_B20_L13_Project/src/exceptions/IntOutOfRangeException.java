package exceptions;

public class IntOutOfRangeException extends Exception
{

	public IntOutOfRangeException(int n)
	{
		super("The number entered exceeds " + n);
	}

}
