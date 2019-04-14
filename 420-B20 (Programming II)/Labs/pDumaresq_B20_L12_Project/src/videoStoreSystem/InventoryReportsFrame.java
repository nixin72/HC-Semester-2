package videoStoreSystem;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryReportsFrame extends JFrame implements ActionListener
{
	private int lineLength = 72;
	private int indent = 2;
	private Inventory inventory;
	private InventoryReport inventoryReport;
	private JTextArea areaDisplay;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenu reportsMenu = new JMenu("Reports");
	private JMenuItem allProductsMenuItem = new JMenuItem("All Products");
	private JMenuItem moviesMenuItem = new JMenuItem("Movies");
	private JMenuItem gamesMenuItem = new JMenuItem("Games");
	private JMenuItem sortedInventoryMenuItem = new JMenuItem("Sorted Inventory");
	private JMenuItem inventoryByMediaMenuItem = new JMenuItem(
			"Inventory by Media Type");
	private JMenuItem categorySummaryMenuItem = new JMenuItem("Category Summary");
	private JMenu searchMenu = new JMenu("Search");
	private JMenuItem oneProductsMenuItem = new JMenuItem("Find Product");

	/**
	 * Create the application.
	 */
	public InventoryReportsFrame()
	{
		initializeFrame();
		inventory = new Inventory("inventory.txt");
		inventoryReport = new InventoryReport(areaDisplay);
	} // InventoryReportsFrame()

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame()
	{
		setTitle("Inventory Reports");
		setSize(700, 600);
		setLocation(100, 100);
		// menu
		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(exitMenuItem);
		menuBar.add(reportsMenu);
		reportsMenu.add(allProductsMenuItem);
		reportsMenu.add(moviesMenuItem);
		reportsMenu.add(gamesMenuItem);
		reportsMenu.add(sortedInventoryMenuItem);
		reportsMenu.add(inventoryByMediaMenuItem);
		reportsMenu.add(categorySummaryMenuItem);
		menuBar.add(searchMenu);
		searchMenu.add(oneProductsMenuItem);

		// menu actionListeners
		allProductsMenuItem.addActionListener(this);
		moviesMenuItem.addActionListener(this);
		gamesMenuItem.addActionListener(this);
		sortedInventoryMenuItem.addActionListener(this);
		inventoryByMediaMenuItem.addActionListener(this);
		categorySummaryMenuItem.addActionListener(this);
		oneProductsMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);

		areaDisplay = new JTextArea(500, 500);
		areaDisplay.setEditable(false);
		areaDisplay.setFont(new Font("Courier New", 0, 11));
		getContentPane().add(new JScrollPane(areaDisplay), BorderLayout.CENTER);
	} // initialize()

	protected void btnListAllProducts_actionPerformed()
	{
		Product product;
		int numProducts = inventory.getNumProducts();

		if (numProducts == 0)
			areaDisplay.setText("No products found");
		else
		{
			displayHeadings('A');
			for (int i = 0; i < numProducts; ++i)
			{
				product = inventory.getProduct(i);
				displayDetailLine('A', product);
			}
		}
	} // btnListAllProducts_actionPerformed(ActionEvent)

	protected void btnListMovies_actionPerformed()
	{
		Product product;
		int numProducts = inventory.getNumProducts();

		if (numProducts == 0)
			areaDisplay.setText("No products found");
		else
		{
			displayHeadings('M');
			for (int i = 0; i < numProducts; ++i)
			{
				product = inventory.getProduct(i);
				if (product.getMedia().equalsIgnoreCase("Movie"))
					displayDetailLine('M', product);
			}
		}
	} // btnListMovies_actionPerformed(ActionEvent)

	protected void btnListGames_actionPerformed()
	{
		Product product;
		int numProducts = inventory.getNumProducts();

		if (numProducts == 0)
			areaDisplay.setText("No products found");
		else
		{
			displayHeadings('G');
			for (int i = 0; i < numProducts; ++i)
			{
				product = inventory.getProduct(i);
				if (product.getMedia().equalsIgnoreCase("Game"))
					displayDetailLine('G', product);
			}
		}
	} // btnListGames_actionPerformed(ActionEvent)

	protected void fldProductNumber_actionPerformed()
	{
		String prodNumber = JOptionPane.showInputDialog(this,
				"Enter product code:", "Find Product", JOptionPane.QUESTION_MESSAGE);
		Product product = inventory.findProduct(prodNumber);
		if (product == null)
			JOptionPane.showMessageDialog(this, prodNumber
					+ " is an invalid product number", "Invalid Product Number",
					JOptionPane.ERROR_MESSAGE);
		else
		{
			areaDisplay.setText("Product Type:\t" + product.getMedia() + "\n");
			areaDisplay.append("Product Number:\t" + product.getProductNumber()
					+ "\n");
			areaDisplay.append("Title:\t\t" + product.getTitle() + "\n");
			areaDisplay.append("Category:\t" + product.getCategory() + "\n");
			areaDisplay.append("Format:\t\t" + product.getFormat() + "\n");
			areaDisplay.append("Year Made:\t" + product.getYearMade() + "\n");
		}
	} // fldProductNumber_actionPerformed(ActionEvent)

	private void displayHeadings(char type)
	{
		String title = "Inventory Report";
		String underline = "----------------";
		if (type == 'A')
		{
			title += " - All Products";
			underline += "---------------";
			lineLength = 82;
		}
		if (type == 'M')

		{
			title += " - Movies";
			underline += "---------";
			lineLength = 74;
		}
		else
			if (type == 'G')
			{
				title += " - Games";
				underline += "--------";
				lineLength = 74;
			}

		int titleEnd = (lineLength / 2) + (title.length() / 2);
		areaDisplay.setText(String.format("%" + indent + "s%" + titleEnd + "s\n",
				" ", title));
		areaDisplay.append(String.format("%" + indent + "s%" + titleEnd + "s\n",
				" ", underline, " "));
		areaDisplay.append(String.format("%" + indent + "s", " "));
		if (type == 'A')
			areaDisplay.append(String.format("%-8s", "Type"));
		areaDisplay.append(String.format("%-9s%-25s%-10s%-10s", "Product", "Title",
				"Category", "Format"));
		if (type == 'A')
			areaDisplay.append(String.format("%-20s\n", "Director/"));
		else
			if (type == 'M')
				areaDisplay.append(String.format("%-20s\n", "Director"));
			else
				if (type == 'G')
					areaDisplay.append(String.format("%-20s\n", "Platform"));
		areaDisplay.append(String.format("%" + indent + "s", " "));
		if (type == 'A')
			areaDisplay.append(String.format("%8s", " "));
		areaDisplay.append(String.format("%-54s", "Number"));
		if (type == 'A')
			areaDisplay.append(String.format("%-20s", "Platform"));
		areaDisplay.append(String.format("\n%" + indent + "s", " "));

		for (int i = 0; i < lineLength; ++i)
			areaDisplay.append("-");
		areaDisplay.append("\n");
	} // displayHeadings(char)

	private void displayDetailLine(char type, Product product)
	{
		areaDisplay.append(String.format("%" + indent + "s", " "));

		if (type == 'A')
			areaDisplay.append(String.format("%-8s", product.getMedia()));
		areaDisplay.append(String.format("%-9s%-25s%-10s%-10s",
				product.getProductNumber(), product.getTitle(), product.getCategory(),
				product.getFormat()));
		if (product.getProductNumber().charAt(0) == 'M')
			areaDisplay
					.append(String.format("%-20s", ((Movie) product).getDirector()));
		else
			if (product.getProductNumber().charAt(0) == 'G')
				areaDisplay.append(String.format("%-20s",
						((Game) product).getPlatform()));
		areaDisplay.append("\n");
	} // displayDetailLine(char, Product)

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == allProductsMenuItem)
			btnListAllProducts_actionPerformed();
		else
			if (e.getSource() == moviesMenuItem)
				btnListMovies_actionPerformed();
			else
				if (e.getSource() == gamesMenuItem)
					btnListGames_actionPerformed();
				else
					if (e.getSource() == sortedInventoryMenuItem)
						inventoryReport.displaySortedReport();
					else
						if (e.getSource() == inventoryByMediaMenuItem)
							inventoryReport.displayByMedia();
						else
							if (e.getSource() == categorySummaryMenuItem)
								inventoryReport.displayCategorySummary();
							else
								if (e.getSource() == oneProductsMenuItem)
									fldProductNumber_actionPerformed();
								else
									if (e.getSource() == exitMenuItem)
										this.dispose();
	} // actionPerformed(ActionEvent)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		InventoryReportsFrame frame = new InventoryReportsFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // main(String[])
} // InventoryReportsFrame

