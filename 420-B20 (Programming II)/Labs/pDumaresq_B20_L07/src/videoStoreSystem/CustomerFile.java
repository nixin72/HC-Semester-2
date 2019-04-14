package videoStoreSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CustomerFile
{
	private String fileName;
	private Scanner customerReader;

	private Customer customerList[];
	private int numCustomers;

	public CustomerFile(String file)
	{
		fileName = file;
		customerList = new Customer[100];
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
				customerList[numCustomers++] = new Customer(Integer.parseInt(tokens
						.nextToken()), tokens.nextToken(), tokens.nextToken(),
						tokens.nextToken());
			}
		}
		customerReader.close();
	} // load()

	public int add(Customer customer)
	{
		if (numCustomers >= 0 && numCustomers < customerList.length)
		{
			customerList[numCustomers++] = customer;
			return numCustomers - 1;
		}
		else
			return -1;
	}

	public Customer getCustomer(int index)
	{
		if (index >= 0 && index < numCustomers)
			return customerList[index];
		else
			return null;
	}

	public void rewrite() throws IOException
	{
		File custFile = new File(fileName);
		FileWriter out = new FileWriter(custFile);
		for (int i = 0; i < numCustomers; ++i)
			out.write(customerList[i].getCustomerNumber() + "~"
					+ customerList[i].getLastName() + "~"
					+ customerList[i].getFirstName() + "~"
					+ customerList[i].getPhoneNumber() + "~" + "\n");
		out.close();
	} // write (Customer)

} // CustomerFile class
