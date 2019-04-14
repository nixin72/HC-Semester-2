package b20_l11_project;

import java.util.Scanner;

import videoStoreSystem.Customer;
import videoStoreSystem.CustomerList;

public class TestCustomerFind
{
  public static void main(String[] args)
  {
	CustomerList customerList = new CustomerList("customers.txt");
	int custNum;
	do
	{
		System.out
				.println("Which customer do you wish to find? Enter -1 to stop. ");
		Scanner input = new Scanner(System.in);
		custNum = input.nextInt();
		if (custNum >= 0)
		{
			Customer customer = customerList.findCustomerLinear(custNum);
			customer = customerList.findCustomerBinary(custNum);
			if (customer != null)
				System.out.println("Customer number " + customer.getCustomerNumber()
						+ " is " + customer.getName());
			else
				System.out.println("Customer number " + custNum + " was not found.");
		} // if
	} // while
	while (custNum >= 0);
  } // main()
} // TestCustomerFind
