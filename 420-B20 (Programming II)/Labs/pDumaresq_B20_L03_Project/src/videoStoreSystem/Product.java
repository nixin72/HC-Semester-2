package videoStoreSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Date;
import java.util.Scanner;

public class Product {
	protected static int nextNumber;
	protected static String numberFilename;
	protected String productNumber;
	protected String title;
	protected int yearMade;
	protected int categoryCode;
	protected int formatCode;
	protected String customerNumber;
	protected Date dateDue;
	private static boolean nextNumberIsInitialized = false;

	public Product() {
		System.out.println("In Product() constructor");
		setProductNumber();
		title = "Unknown";
		yearMade = 0;
		categoryCode = 0;
		formatCode = 1;
	} // Product()

	public Product(String t) {
		System.out.println("In Product(String) constructor");
		setProductNumber();
		title = t;
		yearMade = 0;
		categoryCode = 0;
		formatCode = 1;
	} // Product(String t)

	public Product(String t, int year, String c, String f) {
		System.out.println("In Product(String, int, String, String) constructor");
		setProductNumber();
		title = t;
		yearMade = year;
		setCategoryCode(c);
		setFormatCode(f);
	} // Product(String t, int year, String c, String f)

	private void setProductNumber() {
		if (nextNumberIsInitialized == true) {
			productNumber = String.valueOf(nextNumber);
			++nextNumber;
		} else {
			System.out.println("Error: The next number is not Initialized. Call Product.open() before"
					+ "instantiating an object.");
			System.exit(-3);
		}

	} // setProductNumber()

	public static void open(String filename) {
		numberFilename = filename;
		initializeNextNumber();
	} // open(String)

	public static void open() {
		numberFilename = "productNumber.txt";
		initializeNextNumber();
	} // open()

	private static void initializeNextNumber() {
		File numberFile = new File(numberFilename);
		Scanner in = null;
		try {
			in = new Scanner(numberFile);
		} // try
		catch (FileNotFoundException e) {
			System.out.println(
					"ERROR: " + numberFilename + " was not found. The next product number cannot be initialized.");
			System.exit(-1);
		} // catch (FileNotFoundException e)
		catch (IOException e) {
			System.out.println("ERROR opening " + numberFilename + ": " + e.getMessage());
			System.exit(-2);
		} // catch (IOException e)
		nextNumber = in.nextInt();

		nextNumberIsInitialized = true;
	} // initializeNextNumber()

	public static void close() {
		File numberFile = new File(numberFilename);
		try {
			FileWriter numberOut = new FileWriter(numberFile);
			numberOut.write(String.valueOf(nextNumber));
			numberOut.close();
		} // try
		catch (IOException e) {
			System.out.println("ERROR: Could not rewrite " + numberFile + " " + e.getMessage());
		} // catch (IOException e)
	} // close()

	public void setTitle(String title) {
		this.title = title;
	} // setTitle(String)

	public String getTitle() {
		return title;
	} // getTitle()

	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	} // setYearMade(int)

	public int getYearMade() {
		return yearMade;
	} // getYearMade()

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;

	} // setProductNumber(String)

	public String getProductNumber() {
		return productNumber;
	} // getProductNumber()

	public void setCategoryCode(int categoryCode) {
		System.out.println("In the Product setCategoryCode(String)" + " method");
		this.categoryCode = categoryCode;
	} // setCategoryCode(int)

	public int getCategoryCode() {
		return categoryCode;
	} // getCategoryCode()

	public void setFormatCode(int formatCode) {
		this.formatCode = formatCode;
	} // setFormatCode(int)

	public int getFormatCode() {
		return formatCode;
	} // getFormatCode()

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	} // setCustomerNumber(String)

	public String getCustomerNumber() {
		return customerNumber;
	} // getCustomerNumber()

	public Date getDateDue() {
		return dateDue;
	} // getDateDue()

	public void setFormatCode(String formatName) {
		formatCode = 0;
	} // setFormatCode(String formatName)

	public String getFormat() {
		return "Unknown";
	} // getFormat()

	public void setCategoryCode(String categoryName) {
		System.out.println("In the Product setCategoryCode(String) method");
		categoryCode = 0;
	} // setCategoryCode(String )

	public String getCategory() {
		return "Unknown";
	} // getCategory()

	public String setDirector(String director) {
		return director;
	}
} // Product class
