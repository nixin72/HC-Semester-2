package videoStoreSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Inventory
{
	private String inventoryFilename;
	private FileWriter inventoryWriter;
	private Scanner inventoryReader;
	private Product product[];
	private int numProducts;
	private boolean productsAdded;
	private boolean sorted;

	public Inventory(String filename)
	{
		inventoryFilename = filename;
		product = new Product[100];
		numProducts = 0;
		load();
		productsAdded = false;
	} // Inventory(String)

	private void openOutput()
	{
		File inventoryFile = new File(inventoryFilename);
		try
		{
			inventoryWriter = new FileWriter(inventoryFile);
		} // try
		catch (IOException e)
		{
			System.out.println("ERROR: File " + inventoryFilename
					+ "could not opened: " + e.getMessage());
		} // catch
	} // openOutput(String)

	public void rewrite()
	{
		if (productsAdded)
		{
			openOutput();
			try
			{
				for (int i = 0; i < numProducts; ++i)
				{
					inventoryWriter
							.write(product[i].getProductNumber() + "~"
									+ product[i].getTitle() + "~" + product[i].getYearMade()
									+ "~" + product[i].getCategoryCode() + "~"
									+ product[i].getFormatCode());
					inventoryWriter.write("~" + product[i].addToRecord());
					inventoryWriter.write("\n");
				}
				inventoryWriter.close();
			} // try
			catch (IOException e)
			{
				System.err.println("ERROR: All products could not be written to file "
						+ inventoryFilename + ": " + e.getMessage());
			} // catch
		}
	} // rewrite()

	private boolean openInput()
	{
		try
		{
			inventoryReader = new Scanner(new File(inventoryFilename));
			return true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: " + inventoryFilename + " was not found");
			return false;
		}
		catch (IOException e)
		{
			System.out.println("ERROR: Error opening " + inventoryFilename + ": "
					+ e.getMessage());
			return false;
		}
	} // openInput()

	private void load()
	{
		openInput();
		while (inventoryReader.hasNext())
		{
			StringTokenizer inputLine = new StringTokenizer(
					inventoryReader.nextLine(), "~");
			if (inputLine.countTokens() >= 6)
			{
				String number = inputLine.nextToken();
				if (number.charAt(0) == 'M')
				{
					product[numProducts] = new Movie(number, inputLine.nextToken(),
							Integer.parseInt(inputLine.nextToken()),
							Integer.parseInt(inputLine.nextToken()),
							Integer.parseInt(inputLine.nextToken()), inputLine.nextToken());
				} // if (number.charAt(0) == 'M')
				else
				{
					product[numProducts] = new Game(number, inputLine.nextToken(),
							Integer.parseInt(inputLine.nextToken()),
							Integer.parseInt(inputLine.nextToken()),
							Integer.parseInt(inputLine.nextToken()),
							Integer.parseInt(inputLine.nextToken()));
				} // else
				if (inputLine.hasMoreTokens())
				{
					product[numProducts].setCustomerNumber(Integer.parseInt(inputLine.nextToken()));
					product[numProducts].setDateDue(inputLine.nextToken());
				} // if (inputLine.hasMoreTokens())
				++numProducts;
			} // if (inputLine.countTokens() >= 6)

		} // while (inventoryReader.hasNext())
		inventoryReader.close();
	} /// load()

	public Product getProduct(int subscript)
	{
		if (subscript < numProducts && subscript >= 0)
			return product[subscript];
		else
			return null;
	}

	public int getNumProducts()
	{
		return numProducts;
	}

	public int addProduct(Product prod)
	{
		if (numProducts < product.length)
		{
			product[numProducts++] = prod;
			productsAdded = true;
			return numProducts - 1;
		}
		else
		{
			System.err.println("ERROR: The array is full.");
			return -1;
		} // if
	} // addProduct(prod)

	public Product findProduct(String productNum)
	{
		Product foundProduct = null;
		int count = 0;
		while (count < numProducts && foundProduct == null)
		{
			if (productNum.equalsIgnoreCase(product[count].getProductNumber()))
				foundProduct = product[count];
			++count;
		}

		return foundProduct;
	}

  public void sortByMedia()
  {
  	sorted = false;
  	int loopend = numProducts - 1;
  	
  	while (loopend > 0 && sorted == false){
  		sorted = true;
  		for (int j = 0 ; j < loopend ; j++) {
  			if (product[j].getMediaType() > product[j+1].getMediaType()) {
  				switchProducts(j,j+1);
  				sorted = false;
  			}
  			else {
  				if (product[j].getMediaType() == product[j+1].getMediaType()) {
  					if (product[j].getTitle().compareToIgnoreCase(product[j+1].getTitle()) > 0) {
  						switchProducts(j,j+1);
  					}
  				}
  			}
  		}
  		loopend--;
  	}
  } // sortByMedia()

  private void switchProducts(int j, int k)
  {
  	Product temp = product[j];
  	product[j] = product[k];
  	product[k] = temp;
  } // switchProducts(int, int)

} // Inventory class
