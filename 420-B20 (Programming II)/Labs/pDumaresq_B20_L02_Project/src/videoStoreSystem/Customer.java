package videoStoreSystem;

import java.io.File;
import java.util.Scanner;

public class Customer
{
  private int customerNumber;
  private String lastName;
  private String firstName;
  private String phoneNumber;
  private double outstandingBalance;
  private static int nextCustomerNumber;
  
  public static void initialiseNextCustomerNumberThrowsException() {
	  File customerNumberFile = new File("customerNumber.txt");
	  Scanner in = new Scanner(System.in);
	  nextCustomerNumber = in.nextInt();
	  in.close();
  }
  
  private int setCustomerNumber() {
	  customerNumber = nextCustomerNumber;
	  return nextCustomerNumber++;
  }
  public Customer()
  {
    customerNumber = setCustomerNumber();
    lastName = "Unknown";
    firstName = "Unknown";
    phoneNumber = "9999999999";
    outstandingBalance = 0.0;
  } // Customer()

  public Customer(String first, String last, String phone)
  {
    customerNumber = setCustomerNumber();
    firstName = first;
    lastName = last;
    phoneNumber = phone;
    outstandingBalance = 0.0;
  } // Customer(String, String, String )

  public int getCustomerNumber()
  {
    return customerNumber;
  } // getCustomerNumber()

	public void setLastName(String last)
	{
		if (last.length() == 1)
			lastName = last.toUpperCase();
		else
			lastName = Character.toUpperCase(last.charAt(0))
					+ last.substring(1).toLowerCase();
	} // setLastName(String)

	public String getLastName()
	{
		return lastName;
	} // getLastName()

	public void setFirstName(String first)
	{
		if (first.length() == 1)
			firstName = first.toUpperCase();
		else
			firstName = Character.toUpperCase(first.charAt(0))
					+ first.substring(1).toLowerCase();
	} // setFirstName(String first)

	public String getFirstName()
	{
		return firstName;
	} // getFirstName()

	public void setPhoneNumber(String phone)
	{
		phoneNumber = phone;
	} // setPhoneNumber(String)

  public String getPhoneNumber()
  {
    return phoneNumber;
  } // getPhoneNumber()
  
  public double getOutstandingBalance()
	{
		return outstandingBalance;
	} // getOutstandingBalance()

  public String getFullName()
	{
		return firstName + " " + lastName;
	}

	public void clearOutstandingBalance()
	{
		outstandingBalance = 0;
	} // clearOutstandingBalance()

} // Customer
