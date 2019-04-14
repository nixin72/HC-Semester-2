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
	private boolean writerIsOpen;

	public Inventory(String filename)
	{
		inventoryFilename = filename;
		numProducts = 0;
		product = new Product[100];
		load();
		writerIsOpen = false;
	} // Inventory(String)

	private void openOutput(String filename)
	{
		inventoryFilename = filename;
		File inventoryFile = new File(inventoryFilename);
		try
		{
			inventoryWriter = new FileWriter(inventoryFile, true);
			writerIsOpen = true;
		} // try
		catch (IOException e)
		{
			System.out.println("ERROR: File " + inventoryFilename
					+ "could not opened: " + e.getMessage());
		} // catch
	} // openOutput(String)

	public boolean write(Product product)
	{
		if (!writerIsOpen)
		{
			openOutput(inventoryFilename);
		}
		try
		{
			inventoryWriter.write(product.getProductNumber() + "~"
					+ product.getTitle() + "~" + product.getYearMade() + "~"
					+ product.getCategoryCode() + "~" + product.getFormatCode());
			inventoryWriter.write("~" + product.addToRecord());
			inventoryWriter.write("\n");
		} // try
		catch (IOException e)
		{
			System.out.println("ERROR: Product " + product.getProductNumber()
					+ "could not be written to file " + inventoryFilename + ": "
					+ e.getMessage());
			return false;
		} // catch
		return true;
	} // write(Movie)

	public void closeOutput()
	{
		try
		{
			if (writerIsOpen)
			{
				inventoryWriter.close();
				writerIsOpen = false;
			}
		} // try
		catch (IOException e)
		{
			System.out.println("ERROR: File " + inventoryFilename
					+ "could not closed: " + e.getMessage());
		} // catch
	} // close()

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
							Integer.parseInt(inputLine.nextToken()), inputLine.nextToken(),
							Integer.parseInt(inputLine.nextToken()));
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
					product[numProducts].setCustomerNumber(inputLine.nextToken());
					product[numProducts].setDateDue(inputLine.nextToken());
				} // if (inputLine.hasMoreTokens())
				++numProducts;
			} // if (inputLine.countTokens() >= 6)

		} // while (inventoryReader.hasNext())
		inventoryReader.close();
	} /// load()

	public Product getProduct(int subscript)
	{
		if (subscript >= 0 && subscript < numProducts)
			return product[subscript];
		else
			return null;
	} // getProduct(int)

	public int getNumProducts()
	{
		return numProducts;
	} // getNumProducts()

	public Product findProduct(String productNum) {
		InventoryReportsFrame frame = new InventoryReportsFrame();
		Product foundProduct = null;
		int count = 0;
		
		while (count < numProducts && foundProduct == null) {
			if (productNum.equals(product[count].getProductNumber())) {
				foundProduct = product[count];
			}
			count++;
		}
		return foundProduct;
		
	}
	
} // Inventory class
