package videoStoreSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Date;
import java.util.Scanner;

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
    setTitle(t);
    yearMade = 0;
    categoryCode = 0;
    formatCode = 1;
  } // Product(String)

  public Product(String t, int year, String c, String f)
  {
    setProductNumber();
    setTitle(t);
    yearMade = year;
    setCategoryCode(c);
    setFormatCode(f);
  } // Product(String, int, String, String)

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
      System.out.println("ERROR: " + numberFilename + 
                         " was not found. The next product number cannot be initialized.");
      System.exit(-1);
    } // catch (FileNotFoundException e)
    catch (IOException e)
    {
      System.out.println("ERROR opening " + numberFilename + ": " + 
                         e.getMessage());
      System.exit(-2);
    } // catch (IOException e)
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
      System.out.println("ERROR: Could not rewrite " + numberFile + " " + 
                         e.getMessage());
    } // catch (IOException e)
  } // close()

  public void setTitle(String t)
  {
    title = t;
  } // setTitle(String) 

  public String getTitle()
  {
    return title;
  } // getTitle()

  public void setYearMade(int year)
  {
    yearMade = year;
  } // setYearMade(int)

  public int getYearMade()
  {
    return yearMade;
  } // getYearMade()

  public void setProductNumber(String productNum)
  {
    productNumber = productNum;
  } // setProductNumber(String)

  public String getProductNumber()
  {
    return productNumber;
  } // getProductNumber()

  public void setCategoryCode(int code)
  {
    categoryCode = code;
  } // setCategoryCode(int)

  public int getCategoryCode()
  {
    return categoryCode;
  } // getCategoryCode()

  public void setFormatCode(int code)
  {
    formatCode = code;
  } // setFormatCode(int)

  public int getFormatCode()
  {
    return formatCode;
  } // getFormatCode()

  public void setCustomerNumber(String custNum)
  {
    customerNumber = custNum;
  } // setCustomerNumber(String) 

  public String getCustomerNumber()
  {
    return customerNumber;
  } // getCustomerNumber()

  public Date getDateDue()
  {
    return dateDue;
  } // getDateDue()

  public abstract void setFormatCode(String formatName); // setFormatCode(String)

  public abstract String getFormat(); // getFormat()

  public abstract void setCategoryCode(String categoryName); // setCategoryCode(String)

  public abstract String getCategory(); // getCategory()

} // Product class
