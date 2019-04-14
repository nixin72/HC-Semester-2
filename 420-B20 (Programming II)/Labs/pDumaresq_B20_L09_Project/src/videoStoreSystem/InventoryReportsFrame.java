package videoStoreSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class InventoryReportsFrame extends JFrame implements ActionListener
{
	private Inventory inventory;
	private JTextArea areaDisplay = new JTextArea();
	private JTextField fldProductNumber = new JTextField();
	private JButton btnListAllProducts = new JButton("List All Products");
	private JButton btnListMovies = new JButton("List Movies");
	private JButton btnListGames = new JButton("List Games");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenu reports = new JMenu("Reports");
	private JMenuItem allProducts = new JMenuItem("All Products");
	private JMenuItem movies = new JMenuItem("Movies");
	private JMenuItem games = new JMenuItem("Games");
	private JMenuItem findProduct = new JMenuItem("Find Product");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					InventoryReportsFrame frame = new InventoryReportsFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	} // main(String[])

	/**
	 * Create the application.
	 */
	public InventoryReportsFrame()
	{
		inventory = new Inventory("inventory.txt");
		initialize();
	} // InventoryReportsFrame()

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		setTitle("Inventory Reports");
		setBounds(100, 100, 820, 585);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		areaDisplay.setEditable(false);
		areaDisplay.setFont(new Font("Courier New", 0, 11));
		areaDisplay.setBounds(10, 55, 648, 525);
			JScrollPane scrollPane = new JScrollPane(areaDisplay);
		scrollPane.setBounds(10, 55, 784, 481);
		getContentPane().add(scrollPane);

		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(this);
		
		this.setJMenuBar(menuBar);
		menuBar.add(reports);
		reports.add(allProducts);
			allProducts.addActionListener(this);
		reports.add(movies);
			movies.addActionListener(this);
		reports.add(games);
			games.addActionListener(this);
		reports.add(findProduct);
			findProduct.addActionListener(this);
	
/*	
	
		btnListAllProducts.addActionListener(this);
		btnListAllProducts.setBounds(39, 21, 138, 23);
		getContentPane().add(btnListAllProducts);

		btnListMovies.addActionListener(this);
		btnListMovies.setBounds(199, 21, 138, 23);
		getContentPane().add(btnListMovies);

		btnListGames.addActionListener(this);
		btnListGames.setBounds(359, 21, 138, 23);
		getContentPane().add(btnListGames);

		fldProductNumber.addActionListener(this);
		fldProductNumber.setBounds(645, 22, 86, 20);
		getContentPane().add(fldProductNumber);
		fldProductNumber.setColumns(10);

		JLabel lblProductNumber = new JLabel("Product Number:");
		lblProductNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblProductNumber.setBounds(495, 25, 138, 14);
		getContentPane().add(lblProductNumber);
*/		
	
	} // initialize()

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == allProducts)
			btnListAllProducts_actionPerformed(e);
		else
			if (e.getSource() == movies)
				btnListMovies_actionPerformed(e);
			else
				if (e.getSource() == games)
					btnListGames_actionPerformed(e);
				else
					if (e.getSource() == findProduct)
						fldProductNumber_actionPerformed(e);
		
		if (e.getSource() == exitMenuItem)
			this.dispose();

	} // actionPerformed(ActionEvent)

	protected void btnListAllProducts_actionPerformed(ActionEvent arg0)
	{
		Product product;
		displayHeadings('A');
		for (int i = 0; i < inventory.getNumProducts(); ++i)
		{
			product = inventory.getProduct(i);
			displayDetailLine('A', product);
		} // for
		areaDisplay.append("\nThere are " + inventory.getNumProducts()
				+ " products.\n");

	} // btnListAllProducts_actionPerformed(ActionEvent)

	protected void btnListMovies_actionPerformed(ActionEvent arg0)
	{
		Product product;
		displayHeadings('M');
		for (int i = 0; i < inventory.getNumProducts(); ++i)
		{
			product = inventory.getProduct(i);
			if (product.getMedia().charAt(0) == 'M')
				displayDetailLine('M', product);
		} // for		
	} // btnListMovies_actionPerformed(ActionEvent)

	protected void btnListGames_actionPerformed(ActionEvent arg0)
	{
		Product product;
		displayHeadings('G');
		for (int i = 0; i < inventory.getNumProducts(); ++i)
		{
			product = inventory.getProduct(i);
			if (product.getMedia().charAt(0) == 'G')
				displayDetailLine('G', product);
		} // for		

	} // btnListGames_actionPerformed(ActionEvent)

	protected void fldProductNumber_actionPerformed(ActionEvent arg0)
	{
		String prodNumber = JOptionPane.showInputDialog(this,
				"Enter product code:", "Find Product",
				JOptionPane.QUESTION_MESSAGE);

	} // fldProductNumber_actionPerformed(ActionEvent)

	private void displayHeadings(char type)
	{
		// lineLength is the sum of the format positions occupied by the heading lines
		int lineLength = 9 + 25 + 10 + 10 + 25 + 10 + 11;
		String lastColumn = null;
		String title = "Inventory Report";
		int endOfTitle = (lineLength / 2) + (title.length() / 2);

		// display title and underline
		areaDisplay.setText(String.format("%" + endOfTitle + "s\n", title));
		StringBuffer underline = new StringBuffer();
		for (int i = 0; i < title.length(); ++i)
			underline.append('-');
		areaDisplay.append(String.format("%" + endOfTitle + "s\n\n",
				underline.toString()));

		// first column heading line
		// For all products include the media type as the first column
		if (type == 'A')
			areaDisplay.append(String.format("%-8s", "Type"));
		areaDisplay.append(String.format("%-9s%-25s%-10s%-10s", "Product", "Title",
				"Category", "Format"));
		if (type == 'G')
			lastColumn = "Platform";
		else
			lastColumn = "Director";
		if (type == 'A')
			lastColumn += "/";
		areaDisplay.append(String.format("%-25s", lastColumn));
		if (type == 'A')
			areaDisplay.append(String.format("%-10s%-11s", "Customer", "Date Due"));

		areaDisplay.append("\n");

		// second column heading line
		if (type == 'A')
		{
			areaDisplay.append(String.format("%-8s", " "));
			areaDisplay.append(String.format("%-54s%-25s%-10s\n", "Number", "Platform","Number"));
			areaDisplay.append("--------");
		}

		// underline column headings
		underline = new StringBuffer();
		for (int i = 0; i < lineLength; ++i)
			underline.append('-');
		areaDisplay.append(String.format("%s\n", underline.toString()));
	} // displayHeadings(char)

	private void displayDetailLine(char type, Product product)
	{
		if (type == 'A')
			areaDisplay.append(String.format("%-8s", product.getMedia()));
		areaDisplay.append(String.format("%-9s%-25s%-10s%-10s",
				product.getProductNumber(), product.getTitle(), product.getCategory(),
				product.getFormat()));
		if (product.getProductNumber().charAt(0) == 'M')
			areaDisplay.append(String.format("%-25s",
					((Movie) product).getDirector(), 20));
		else
			if (product.getProductNumber().charAt(0) == 'G')
				areaDisplay.append(String.format("%-25s",
						((Game) product).getPlatform(), 20));
		if (type == 'A')
		{
			if (product.getCustomerNumber() != null)
				areaDisplay.append(String.format("%-10s%-11s",
						product.getCustomerNumber(), product.getStringDateDue()));
		}
		areaDisplay.append("\n");
	} // displayDetailLine(char, Product)

} // InventoryReportsFrame
