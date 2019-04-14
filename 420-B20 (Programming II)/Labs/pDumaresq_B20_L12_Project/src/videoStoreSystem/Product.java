package videoStoreSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.text.DateFormat;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import CSClasses.MyStringMethods;

public abstract class Product
{
	private static int nextNumber;
	private static String numberFilename;
	protected String productNumber;
	protected String title;
	protected int yearMade;
	protected int categoryCode;
	protected int formatCode;
	protected int customerNumber;
	protected String dateDue;

	public Product()
	{
		setProductNumber();
		title = "Unknown";
		yearMade = 0;
		categoryCode = 0;
		formatCode = 1;
	}

	public Product(String t)
	{
		setProductNumber();
		title = t;
		yearMade = 0;
		categoryCode = 0;
		formatCode = 1;
	}

	public Product(String t, int year, String c, String f)
	{
		setProductNumber();
		title = t;
		yearMade = year;
		setCategoryCode(c);
		setFormatCode(f);
	}

	public Product(String number, String t, int year, int c, int f)
	{
		productNumber = number;
		title = t;
		yearMade = year;
		categoryCode = c;
		formatCode = f;
	}

	public Product(String number, String t, int year, int c, int f, int custNum,
			String d)
	{
		productNumber = number;
		title = t;
		yearMade = year;
		categoryCode = c;
		formatCode = f;
		customerNumber = custNum;
		dateDue = d;
	}

	private void setProductNumber()
	{
		productNumber = String.valueOf(nextNumber);
		++nextNumber;
	}

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
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: " + numberFilename
					+ " was not found. The next product number cannot be initialized.");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("ERROR opening " + numberFilename + ": "
					+ e.getMessage());
			System.exit(-2);
		}
		nextNumber = in.nextInt();
	}

	public static void close()
	{
		File numberFile = new File(numberFilename);
		try
		{
			FileWriter numberOut = new FileWriter(numberFile);
			numberOut.write(String.valueOf(nextNumber));
			numberOut.close();
		}
		catch (IOException e)
		{
			System.err.println("ERROR: Could not rewrite " + numberFile + " "
					+ e.getMessage());
		}
	}

	public void setTitle(String title)
	{
		this.title = MyStringMethods.toTitleCase(title);
	}

	public String getTitle()
	{
		return title;
	}

	public void setYearMade(int yearMade)
	{
		this.yearMade = yearMade;
	}

	public int getYearMade()
	{
		return yearMade;
	}

	public void setProductNumber(String productNumber)
	{
		this.productNumber = productNumber;
	}

	public String getProductNumber()
	{
		return productNumber;
	}

	public void setCategoryCode(int categoryCode)
	{
		this.categoryCode = categoryCode;
	}

	public int getCategoryCode()
	{
		return categoryCode;
	}

	public void setFormatCode(int formatCode)
	{
		this.formatCode = formatCode;
	}

	public int getFormatCode()
	{
		return formatCode;
	}

	public void setCustomerNumber(int custNum)
	{
		this.customerNumber = custNum;
	}

	public int getCustomerNumber()
	{
		return customerNumber;
	}

	public void setDateDue(String dueDate)
	{
		dateDue = dueDate;
	}

	public String getDateDue()
	{
		return dateDue;
	} // getDateDue()

	public String getStringDateDue()
	{
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

		return dateFormat.format(dateDue);
	}

	public void calculateDateDue(int daysRented)
	{
		GregorianCalendar dueDate = new GregorianCalendar();
		dueDate.add(Calendar.DATE, daysRented);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dateDue = dateFormat.format(dueDate.getTime());
	}

	public boolean isProductRented()
	{
		if (customerNumber == 0)
			return false;
		else
			return true;
	}

	public char getMediaType()
	{
		return productNumber.charAt(0);
	} // getMediaType()
	
	public abstract void setFormatCode(String formatName);

	public abstract String getFormat();

	public abstract void setCategoryCode(String categoryName);

	public abstract String getCategory();

	public abstract String addToRecord();

	public abstract String getMedia();

} // Product class
