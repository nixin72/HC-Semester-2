package videoStoreSystem;

//import CSClasses.MyStringMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import CSClasses.StringMethods;

public abstract class Product
{
	private static int nextNumber;
	private static String numberFilename;
	protected String productNumber;
	protected String title;
	protected int yearMade;
	protected int categoryCode;
	protected int formatCode;
	protected String customerNumber;
	protected Date dateDue;

	public Product()
	{
		setProductNumber();
		title = "Unknown";
		yearMade = 0;
		categoryCode = 0;
		formatCode = 1;
	} // Product()

	public Product(String t)
	{
		setProductNumber();
		title = t;
		yearMade = 0;
		categoryCode = 0;
		formatCode = 1;
	} // Product(String)

	public Product(String t, int year, String c, String f)
	{
		setProductNumber();
		title = t;
		yearMade = year;
		setCategoryCode(c);
		setFormatCode(f);
	} // Product(String, int, String, String)

	public Product(String number, String t, int year, int c, int f)
	{
		productNumber = number;
		title = t;
		yearMade = year;
		categoryCode = c;
		formatCode = f;
	} // Product(String, String, int, int, int)

	public Product(String number, String t, int year, int c, int f,
			String custNum, String d)
	{
		productNumber = number;
		title = t;
		yearMade = year;
		categoryCode = c;
		formatCode = f;
		customerNumber = custNum;
		setDateDue(d);
	} // Product(String, String, int, int, int, String, String)

	private void setProductNumber()
	{
		productNumber = String.valueOf(nextNumber);
		++nextNumber;
	} // setProductNumber()

	public static void open(String filename)
	{
		numberFilename = filename;
		initializeNextNumber();
	} // open(String)

	public static void open()
	{
		numberFilename = "productNumber.txt";
		initializeNextNumber();
	} // open()

	private static void initializeNextNumber()
	{
		File numberFile = new File(numberFilename);
		Scanner in = null;
		try
		{
			in = new Scanner(numberFile);
		} // try
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: " + numberFilename
					+ " was not found. The next product number cannot be initialized.");
			System.exit(-1);
		} // catch (FileNotFoundException)

		nextNumber = in.nextInt();
	} // initializeNextNumber()

	public static void close()
	{
		File numberFile = new File(numberFilename);
		try
		{
			FileWriter numberOut = new FileWriter(numberFile);
			numberOut.write(String.valueOf(nextNumber));
			numberOut.close();
		} // try
		catch (IOException e)
		{
			System.out.println("ERROR: Could not rewrite " + numberFile + " "
					+ e.getMessage());
		} // catch (IOException)
	} // close()

	public void setTitle(String title)
	{
		this.title = StringMethods.toTitleCase(title);
	} // setTitle(String)

	public String getTitle()
	{
		return title;
	} // getTitle()

	public void setYearMade(int yearMade)
	{
		this.yearMade = yearMade;
	} // setYearMade(int)

	public int getYearMade()
	{
		return yearMade;
	} // getYearMade()

	public void setProductNumber(String productNumber)
	{
		this.productNumber = productNumber;
	} // setProductNumber(String)

	public String getProductNumber()
	{
		return productNumber;
	} // getProductNumber()

	public void setCategoryCode(int categoryCode)
	{
		this.categoryCode = categoryCode;
	} // setCategoryCode(int)

	public int getCategoryCode()
	{
		return categoryCode;
	} // getCategoryCode()

	public void setFormatCode(int formatCode)
	{
		this.formatCode = formatCode;
	} // setFormatCode(int)

	public int getFormatCode()
	{
		return formatCode;
	} // getFormatCode()

	public void setCustomerNumber(String customerNumber)
	{
		this.customerNumber = customerNumber;
	} // setCustomerNumber(String)

	public String getCustomerNumber()
	{
		return customerNumber;
	} // getCustomerNumber()

	public Date getDateDue()
	{
		return dateDue;
	} // getDateDue()

	public void setDateDue(String dueDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		try
		{
			dateDue = dateFormat.parse(dueDate);
		} // try
		catch (ParseException e)
		{
			System.err.println("Error: Could not parse due date for product "
					+ productNumber);
		} // catch (ParseException e)
	} // setDateDue(String)

	public String getStringDateDue()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		return dateFormat.format(dateDue);
	} // getStringDateDue()

	public abstract void setFormatCode(String formatName);

	public abstract String getFormat();

	public abstract void setCategoryCode(String categoryName);

	public abstract String getCategory();

	public abstract String addToRecord();

	public abstract String getMedia();
} // Product class
