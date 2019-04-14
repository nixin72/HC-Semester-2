package videoStoreSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VideoStoreFrame extends JFrame implements ActionListener
{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem newCustomerMenuItem = new JMenuItem("New Customer");
	private JMenuItem newProductMenuItem = new JMenuItem("New Product");
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenu reportsMenu = new JMenu("Reports");
	private JMenuItem inventoryReportsMenuItem = new JMenuItem(
			"Inventory Reports");
	private JMenuItem customerReportsMenuItem = new JMenuItem("Customer Reports");
	private JMenu rentProductMenu = new JMenu("Rentals");
	private JMenuItem rentProductsMenuItem = new JMenuItem("Rent Products");
	private JMenuItem returnProductMenuItem = new JMenuItem("Return Product");

	public VideoStoreFrame()
	{
		setTitle("Heritage Video Store");
		setSize(300, 200);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// menu
		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newCustomerMenuItem);
		fileMenu.add(newProductMenuItem);
		fileMenu.add(exitMenuItem);
		menuBar.add(rentProductMenu);
		rentProductMenu.add(rentProductsMenuItem);
		rentProductMenu.add(returnProductMenuItem);
		menuBar.add(reportsMenu);
		reportsMenu.add(inventoryReportsMenuItem);
		reportsMenu.add(customerReportsMenuItem);

		newCustomerMenuItem.addActionListener(this);
		newProductMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		rentProductsMenuItem.addActionListener(this);
		returnProductMenuItem.addActionListener(this);
		inventoryReportsMenuItem.addActionListener(this);
		customerReportsMenuItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == newCustomerMenuItem)
		{
			AddCustomerFrame frame = new AddCustomerFrame();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		else
			if (e.getSource() == newProductMenuItem)
			{
				AddProductFrame frame = new AddProductFrame();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
			else
				if (e.getSource() == rentProductsMenuItem)
				{
					RentalFrame frame = new RentalFrame();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
				else
					if (e.getSource() == inventoryReportsMenuItem)
					{
						InventoryReportsFrame frame = new InventoryReportsFrame();
						frame.setVisible(true);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
					else if (e.getSource() == exitMenuItem)
						System.exit(0);
					else
						JOptionPane.showMessageDialog(this, "This feature is not implemented",
								"Unimplemented Menu", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		VideoStoreFrame frame = new VideoStoreFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
