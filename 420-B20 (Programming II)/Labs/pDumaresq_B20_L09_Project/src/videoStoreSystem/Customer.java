package videoStoreSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Customer
{
	private static int nextCustomerNumber;
	private int customerNumber;
	private String lastName;
	private String firstName;
	private String phoneNumber;

	public static void initializeNextCustomerNumber() throws Exception
	{
		File customerNumberFile = new File("customerNumber.txt");
		Scanner in = new Scanner(customerNumberFile);
		nextCustomerNumber = in.nextInt();
		in.close();
	} // initializeNextCustomerNumber ()

	public static void rewriteNextCustomerNumber() throws IOException
	{
		File customerNumberFile = new File("customerNumber.txt");
		FileWriter out = new FileWriter(customerNumberFile);
		out.write(String.valueOf(nextCustomerNumber));
		out.close();
	} // rewriteNextCustomerNumber()

	public Customer()
	{
		setCustomerNumber();
		lastName = "Unknown";
		firstName = "Unknown";
		phoneNumber = "9999999999";
	}

	public Customer(String first, String last, String phone)
	{
		setCustomerNumber();
		firstName = first;
		lastName = last;
		phoneNumber = phone;
	} // Customer(String, String, String )

	public Customer(int num, String first, String last, String phone)
	{
		customerNumber = num;
		firstName = first;
		lastName = last;
		phoneNumber = phone;
	} // Customer(String, String, String )

	public int getCustomerNumber()
	{
		return customerNumber;
	}

	public void setLastName(String last)
	{
		if (last.length() == 1)
			lastName = last.toUpperCase();
		else
			lastName = Character.toUpperCase(last.charAt(0))
					+ last.substring(1).toLowerCase();
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setFirstName(String first)
	{
		if (first.length() == 1)
			firstName = first.toUpperCase();
		else
			firstName = Character.toUpperCase(first.charAt(0))
					+ first.substring(1).toLowerCase();
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setPhoneNumber(String phone)
	{
		phoneNumber = phone;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	private void setCustomerNumber()
	{
		customerNumber = nextCustomerNumber;
		++nextCustomerNumber;
	} // setCustomerNumber()
	
	public String getName()
	{
		return firstName + " "+lastName;
	}
} // Customer
