package b20_l05_strings;

import java.util.Scanner;

public class StringMethods
{

  public static void indexOfExamples(String inString)
  {

  } // indexOfExamples(String)

  public static void substringExamples(String inString)
  {
    Scanner input = new Scanner(System.in);

  } // substringExamples(String inString)

  public static String reverse(String s)
  {
    StringBuffer result = new StringBuffer();
    for (int k = s.length() - 1; k >= 0; --k)
    {
    	result.append(s.charAt(k));
    } // for

    return result.toString();
  } // reverse(String)

  public static String asciiString(String s)
  {
	StringBuffer convertToAscii = new StringBuffer();
	for (int i = 0; i < s.length() ; ++i)
	{
		convertToAscii.append((int)s.charAt(i) + " ");
	} // for
    return convertToAscii.toString();
  } // numericString(String)

  public static String toSentenceCase(String s)
  {
	// Trim the leading and trailing spaces from the input string,
	// convert it to lowercase and assign it to the result 
	// StringBuffer
    StringBuffer result = new StringBuffer(s.trim().toLowerCase());
    result.substring(0,1).toUpperCase();
    
    if ((result.substring(result.length() - 1) != "."
    		^ result.substring(result.length() - 1) != "!"
    		^ result.substring(result.length() - 1) != "?")) {
    	String i = result.toString();
    	i =	".";
    }
        
    return result.toString();
  } // toSentenceCase(String);
  
} // StringMethods