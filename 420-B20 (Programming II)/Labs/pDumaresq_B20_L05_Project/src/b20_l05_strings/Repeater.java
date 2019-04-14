package b20_l05_strings;

/**
 * Title:        420-B20 Labs - Winter, 2016
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author Anne Hamilton
 * @version 1.0
 */
public class Repeater
{

  public Repeater()
  {
  }

  public String repeatStringBuffer(String s, int n)
  {
    StringBuffer newString = new StringBuffer();
    System.out.println("location of newString after instantiation is " + 
                       System.identityHashCode(newString));
    for (int i = 0; i < n; ++i)
    {
      newString.append(s);
      System.out.println(i + "th location of newString is " + 
                         System.identityHashCode(newString));
    }
    
    return newString.toString();
  } // repeat(String, int) method
  
  public String repeat(String s, int n)
  {
    String newString = new String();
    System.out.println("location of newString after instantiation is " + 
                       System.identityHashCode(newString));
    for (int i = 0; i < n; ++i)
    {
      newString += s;
      System.out.println(i + "th location of newString is " + 
                         System.identityHashCode(newString));
    }
    return newString;
  } // repeat(String, int) method

} // Repeater class