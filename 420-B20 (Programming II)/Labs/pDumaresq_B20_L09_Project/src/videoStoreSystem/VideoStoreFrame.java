package videoStoreSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
	private JMenu rentalMenu = new JMenu("Rentals");
	private JMenuItem rentProductsMenuItem = new JMenuItem("Rent Products");
	private JMenuItem returnProductMenuItem = new JMenuItem("Return Product");
	private JMenu helpMenu = new JMenu("Help");
	private JMenuItem aboutMenuItem = new JMenuItem("About");
	
	public VideoStoreFrame()
	{
		setBounds(100, 100, 820, 585);
		setTitle("Heritage Video Store");
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newCustomerMenuItem);
		fileMenu.add(newProductMenuItem);
		menuBar.add(reportsMenu);
		reportsMenu.add(inventoryReportsMenuItem);
		reportsMenu.add(customerReportsMenuItem);
		menuBar.add(rentalMenu);
		rentalMenu.add(rentProductsMenuItem);
		rentalMenu.add(returnProductMenuItem);
		menuBar.add(helpMenu);
		helpMenu.add(aboutMenuItem);
		newCustomerMenuItem.addActionListener(this);
		newProductMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		inventoryReportsMenuItem.addActionListener(this);
		customerReportsMenuItem.addActionListener(this);
		rentProductsMenuItem.addActionListener(this);
		rentProductsMenuItem.addActionListener(this);
		aboutMenuItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		// TODO Auto-generated method stub
		if(e.getSource() == rentProductsMenuItem) {
			RentalFrame rental = new RentalFrame();
			rental.setVisible(true);
			rental.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		else
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
					if (e.getSource() == inventoryReportsMenuItem)
					{
						InventoryReportsFrame frame = new InventoryReportsFrame();
						frame.setVisible(true);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
					else
						if (e.getSource() == exitMenuItem)
							System.exit(0);
						else
							JOptionPane.showMessageDialog(this,
									new VideoStore_AboutPanel(), "About",
									JOptionPane.PLAIN_MESSAGE);

	}
	
	public static void main(String args[])
	{
		VideoStoreFrame frame = new VideoStoreFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}

}
