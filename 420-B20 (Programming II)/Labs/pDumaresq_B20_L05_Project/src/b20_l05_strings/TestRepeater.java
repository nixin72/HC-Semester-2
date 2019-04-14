package b20_l05_strings;

import java.io.*;

import java.util.Scanner;

/**
 * Title:        420-B20 Lab 5
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author Anne Hamilton
 * @version 1.0
 */

public class TestRepeater
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    Repeater overAndOver = new Repeater();

    System.out.print("Enter string to repeat? ");
    String s = input.nextLine();
    System.out.println("\nUsing a String:");
    String t = overAndOver.repeat(s,5);
    System.out.println(t);
    
    System.out.println("\nUsing a StringBuffer:");
    t = overAndOver.repeatStringBuffer(s,5);
    System.out.println(t);
   } // main()
} // TestRepeater class