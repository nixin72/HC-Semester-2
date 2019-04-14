package videoStoreSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CustomerList
{
	private String fileName;
	private Scanner customerReader;

	private Customer customer[];
	private int numCustomers;

	public CustomerList(String file)
	{
		fileName = file;
		customer = new Customer[100];
		numCustomers = 0;
		load();
	} // CustomerFile(String)

	private void openInput()
	{
		try
		{
			customerReader = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("ERROR: " + fileName + " was not found.");
		}
		catch (IOException e)
		{
			System.err.println("ERROR: Error reading " + fileName + e.getMessage());
		}
	} // openInput()

	private void load()
	{
		openInput();
		while (customerReader.hasNext())
		{
			StringTokenizer tokens = new StringTokenizer(customerReader.nextLine(),
					"~\n");
			if (tokens.countTokens() >= 4)
			{
				customer[numCustomers++] = new Customer(Integer.parseInt(tokens
						.nextToken()), tokens.nextToken(), tokens.nextToken(),
						tokens.nextToken());
			}
		}
		customerReader.close();
	} // load()

	public int add(Customer cust)
	{
		if (numCustomers >= 0 && numCustomers < customer.length)
		{
			customer[numCustomers++] = cust;
			return numCustomers - 1;
		}
		else
			return -1;
	}

	public Customer getCustomer(int index)
	{
		if (index >= 0 && index < numCustomers)
			return customer[index];
		else
			return null;
	}

	public void rewrite() throws IOException
	{
		File custFile = new File(fileName);
		FileWriter out = new FileWriter(custFile);
		for (int i = 0; i < numCustomers; ++i)
			out.write(customer[i].getCustomerNumber() + "~"
					+ customer[i].getLastName() + "~" + customer[i].getFirstName() + "~"
					+ customer[i].getPhoneNumber() + "~" + "\n");
		out.close();
	} // write (Customer)

	public Customer findCustomer(int searchNumber)
	{
		int foundIndex, top, bottom, middle, custNum, count;
		count = 0;
		bottom = 0;
		top = numCustomers - 1;
		foundIndex = -1;
		while (bottom <= top && foundIndex == -1)
		{
			middle = (bottom + top) / 2;
			custNum = customer[middle].getCustomerNumber();
			if (searchNumber == custNum)
				foundIndex = middle;
			else
				if (searchNumber < custNum)
					top = middle - 1;
				else
					bottom = middle + 1;
			++count;
		}
		if (foundIndex == -1)
			return null;
		else
			return customer[foundIndex];
	}// findCustomer(int)

	public Customer findCustomerLinear(int searchNumber)
	{
		int count = 0;

		int foundIndex = -1;
		while (count < numCustomers && foundIndex == -1)
		{
			if (searchNumber == customer[count].getCustomerNumber())
				foundIndex = count;
			++count;
		}
		if (foundIndex == -1)
			return null;
		else
			return customer[foundIndex];
	} // findCustomerLinear(int)

} // CustomerFile class
