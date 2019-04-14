package videoStoreSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InventoryReportsFrame extends JFrame implements ActionListener
{
	private Inventory inventory;
	private JTextArea areaDisplay = new JTextArea();
	private JTextField fldProductNumber = new JTextField();;
	private JButton btnListAllProducts = new JButton("List All Products");
	private JButton btnListMovies = new JButton("List Movies");
	private JButton btnListGames = new JButton("List Games");

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
	} // initialize()

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnListAllProducts)
			btnListAllProducts_actionPerformed(e);
		else
			if (e.getSource() == btnListMovies)
				btnListMovies_actionPerformed(e);
			else
				if (e.getSource() == btnListGames)
					btnListGames_actionPerformed(e);
				else
					if (e.getSource() == fldProductNumber)
						fldProductNumber_actionPerformed(e);
	} // actionPerformed(ActionEvent)
	
	protected void btnListAllProducts_actionPerformed(ActionEvent arg0)
	{
	  displayHeadings('A');
		Product product;
				
		for (int k = 0 ; k < (inventory.getNumProducts()) ; k++) 
		{
			System.out.println(inventory.getNumProducts() + "\n" + k + "\n" + inventory.getProduct(k));
			product = inventory.getProduct(k);
			displayDetailLine('A' , product);
		}//while (k < inventory.getNumProducts())
	
		areaDisplay.append(String.valueOf(inventory.getNumProducts()));

	} // btnListAllProducts_actionPerformed(ActionEvent)

		protected void btnListMovies_actionPerformed(ActionEvent arg0)
	{
			 displayHeadings('M');
				Product movie;
						
				for (int k = 0 ; k < (inventory.getNumProducts()) ; k++) 
				{
					System.out.println(inventory.getNumProducts() + "\n" + k + "\n" + inventory.getProduct(k));
					movie = inventory.getProduct(k);
					if (movie.getProductNumber().charAt(0) == 'M') 
					{
						displayDetailLine('M' , movie);
					}
					
				}//while (k < inventory.getNumProducts())
			
				areaDisplay.append(String.valueOf(inventory.getNumProducts()));

	} // btnListMovies_actionPerformed(ActionEvent)

	protected void btnListGames_actionPerformed(ActionEvent arg0)
	{
		displayHeadings('G');
		Product game;
				
		for (int k = 0 ; k < (inventory.getNumProducts()) ; k++) 
		{
			System.out.println(inventory.getNumProducts() + "\n" + k + "\n" + inventory.getProduct(k));
			game = inventory.getProduct(k);
			if (game.getProductNumber().charAt(0) == 'G') 
			{
				displayDetailLine('G' , game);
			}
		}//while (k < inventory.getNumProducts())
	
		areaDisplay.append(String.valueOf(inventory.getNumProducts()));

	} // btnListGames_actionPerformed(ActionEvent)

	protected void fldProductNumber_actionPerformed(ActionEvent arg0)
	{
		areaDisplay.setText("");
	} // fldProductNumber_actionPerformed(ActionEvent)

	private void displayHeadings(char type)
	{
		int lineLength = 9 + 25 + 10 + 10 + 25;
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
		areaDisplay.append("\n");

		// second column heading line
		if (type == 'A')
		{
			areaDisplay.append(String.format("%-8s", " "));
			areaDisplay.append(String.format("%-54s%-25s\n", "Number", "Platform"));
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
		areaDisplay.append("\n");
	} // displayDetailLine(char, Product)

} // InventoryReportsFrame
