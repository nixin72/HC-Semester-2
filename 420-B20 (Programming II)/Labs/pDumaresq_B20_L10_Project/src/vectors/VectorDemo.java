package vectors;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.Vector;

public class VectorDemo
{
  private Vector<Integer> collection;
  private int numNumbers;
  private Scanner keyboard;

  public VectorDemo()
  {
    keyboard = new Scanner(System.in);
    collection = new Vector();
    initialize();
  } // VectorDemo()

  public void initialize()
  {
    Scanner input;

    System.out.println("Enter the file name: ");
    String filename = keyboard.next();
    try
    {
      input = new Scanner(new File(filename));
      while (input.hasNext())
      {
      	collection.addElement(input.nextInt());
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("ERROR: " + filename + " could not be found.");
      initialize();
    }
  } // initializeArray()

  public void print()
  {
    System.out.println(collection.size() + " numbers");
    for (int i = 0; i < numNumbers; ++i)
    	System.out.println(collection.elementAt(i));
  } // printArray(int)

  public void changeCollection()
  {
    char ans = 'Y';
    while (ans == 'Y')
    {
      System.out.println("Enter A to add or D to delete: ");
      char action = Character.toUpperCase(keyboard.next().charAt(0));
      keyboard.nextLine();
      switch (action)
      {
        case 'A':
          addToCollection();
          break;
        case 'D':
          deleteFromCollection();
      } // switch()
      System.out.println("Do you wish to make another change (y or n)?");
      ans = Character.toUpperCase(keyboard.next().charAt(0));
      print();
    } // while
  } // changeCollection()

  public void addToCollection()
  {
    System.out.println("Enter number to add: ");
    int num = keyboard.nextInt();
    System.out.println("Before which number? ");
    int before = keyboard.nextInt();
    int index = getLocation(before);
    collection.insertElementAt(before, index);
  } // addToCollection()

  public void deleteFromCollection()
  {
    System.out.println("Enter number to delete: ");
    int num = keyboard.nextInt();
   
    int index = getLocation(num);
  	System.out.println("The index of the number entered is: " + getLocation(num));
  	if (getLocation(num) != -1) {
  		collection.removeElementAt(getLocation(num));
  	}
  	print();
  } // deleteFromCollection()

  public int getLocation(int num)
  {
  	for (int i = 0 ; i < collection.size() ; i++) {
  		if (collection.elementAt(i).equals(num)) {
  			return i;
  		}
  	}
     return -1;
  } // getLocation (int)

  public static void main(String[] args)
  {
    VectorDemo vectorDemo = new VectorDemo();
    vectorDemo.print();
    vectorDemo.changeCollection();
    
  } // main()
} // VectorDemo class
