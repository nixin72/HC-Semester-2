package videoStoreSystem;

import CSClasses.Heading;

import javax.swing.JTextArea;

import videoStoreSystem.Product;

public class InventoryReport
{
	private JTextArea reportDisplay;
	private Inventory inventory;
	private int totalProducts;
	private int mediaCount;
	private String mediaName;
	private Product previousProduct;
	private int mediaRentals, totalRentals;

	public InventoryReport(JTextArea display)
	{
		reportDisplay = display;
		inventory = new Inventory("inventory.txt");
	} // InventoryReport(JTextArea)

	public void displaySortedReport()
	{
		inventory.sortByMedia();
		Heading title = new Heading("Movies and Games~Inventory Report", 92);
		reportDisplay.setText(title.getHeading());
		displayColumnHeadings();
		for (int i = 0; i < inventory.getNumProducts(); ++i)
			displayDetailLine(inventory.getProduct(i));
	} // displaySortedReports()

	/********
	 * Methods to display single level media summary report
	 */

	public void displayByMedia()
	{
		Heading heading = new Heading("Movies and Games~Inventory Report by Media Type",92);
		totalRentals = 0;
		reportDisplay.setText(heading.getHeading());
		displayColumnHeadings();
		inventory.sortByMedia();
		Product product = null;
		totalProducts = 0;
		startNewMediaGroup(inventory.getProduct(0));
		for (int j = 0 ; j < inventory.getNumProducts() ; j++) {
			product = inventory.getProduct(j);
			if (product.getMediaType() != previousProduct.getMediaType()) { 
				processMediaTotals(previousProduct);
				startNewMediaGroup(product);
			}
			displayMediaDetailLine(mediaName, product);
			mediaCount++;
			mediaName = "";
			if (product.isProductRented() == true) {
				totalRentals++;
				mediaRentals++;
			}
		}
		processMediaTotals(previousProduct);
		displayTotals();
	} // displayByMedia()

	private void displayColumnHeadings()
	{
		reportDisplay.append(String.format("%-7s%-9s%-30s%-14s%-10s%-10s\n",
				"Media", "Product", " ", " ", "", "Customer"));
		reportDisplay.append(String.format("%-7s%-9s%-30s%-14s%-10s%-10s%-10s\n",
				"Type", "Number", "Title", "Category", "Format", "Number", "Date Due"));
		reportDisplay.append(String.format("%-7s%-9s%-30s%-14s%-10s%-10s%-10s\n",
				"-----", "-------", "-------------------------", "--------", "------",
				"-------", "------------"));
		reportDisplay.append("\n");
	} // displayColumnHeadings()

	private void startNewMediaGroup(Product product)
	{
		mediaCount = 0;
		mediaRentals = 0;
		mediaName = product.getMedia(); 
		previousProduct = product;
	} // startNewMediaGroup(Product)

	private void processMediaTotals(Product previous)
	{
		String media;
		if (previous.getMediaType() == 'G') 
			media = "games";
		else 
			media = "movies";
		reportDisplay.append("Number of " + media + " currently rented: " + mediaRentals + "\n");
		reportDisplay.append("Number of " + media + ": " + mediaCount + "\n\n");

		totalProducts += mediaCount;
	} // processMediaTotals()

	private void displayMediaDetailLine(String mediaHead, Product product)
	{
		reportDisplay.append(String.format("%-7s%-9s%-30s%-14s%-10s", mediaHead,
				product.getProductNumber(), product.getTitle(), product.getCategory(),
				product.getFormat()));
		if (product.getCustomerNumber() > 0)
			reportDisplay.append(String.format("%-10s%-10s",
					product.getCustomerNumber(), product.getDateDue()));
		reportDisplay.append("\n");
	} // displayDetailLine(Product)

	private void displayTotals()
	{
		reportDisplay.append("Total number of rentals: " + totalRentals + "\n");
		reportDisplay.append("Total number of products: " + totalProducts);
	} // displayTotals()

	/********
	 * Methods to display multi-level category summary report
	 */
	public void displayCategorySummary()
	{
	} // displayCategorySummary()

	private void displayCatSummHeadings()
	{
		Heading title = new Heading(
				"Movies and Games~Summary by Media Type and Category", 62);
		reportDisplay.setText(title.getHeading());
		reportDisplay.append(String.format("%-27s%-13s%-13s%-13s\n", "Number of",
				"Number", "Number of"));
		reportDisplay.append(String.format("%-3s%-24s%-13s%-13s%-13s\n", " ",
				"Category", "Rentals", "Available", "Products"));
		reportDisplay.append(String.format("%-3s%-24s%-13s%-13s%-13s\n", " ",
				"-----------------------", "---------", "---------", "---------"));
	} //displayCatSummColHeadings()

	private void displayDetailLine(Product product)
	{
		reportDisplay.append(String.format("%-7s%-9s%-30s%-14s%-10s",
				product.getMedia(), product.getProductNumber(), product.getTitle(),
				product.getCategory(), product.getFormat(), 10));
		if (product.isProductRented())
			reportDisplay.append(String.format("%-10s%-10s",
					product.getCustomerNumber(), product.getDateDue()));
		reportDisplay.append("\n");
	} // displayDetailLine(Product)

	private void displayMediaHeadings(String media)
	{
		reportDisplay.append(media + " Statistics\n");
	} // displayMediaHeadings()

	/*********************************
	 * process control break totals
	 *********************************/

	private void startNewCategory(Product current)
	{

	} // startNewCategory()

	private void startNewMediaType(Product current)
	{

	} // startNewMediaType()

	private void processMediaCatTotals(Product previous)
	{
		// Display media type summary line for Category Summary report
		//        reportDisplay.append(String.format("%-27s%9s%13s%13\n\n","Total " + previous.getMedia(),
		//                             mediaRentals, mediaAvailable, mediaCount));
		//        reportDisplay.append("\n\n");
	} // processMediaCatTotals()

	private void processCategoryTotals(Product previous)
	{
		// Display category code summary line
		//        reportDisplay.append("   " +String.format("%-24s%9s%13s%13\n",previous.getCategory(), categoryRentals, categoryAvailable, (categoryRentals +
		//                                                       categoryAvailable)));
	} // processCategoryTotals()

	private void displayCatSummTotals()
	{
		reportDisplay.append(String.format("%-27s", "Total "));
		//    reportDisplay.append(String.format("%13s%13s",totalAvailable, (totalRentals + totalAvailable)));
		reportDisplay.append("\n");
	} // displayCatSummTotals()
} // InventoryReport class
