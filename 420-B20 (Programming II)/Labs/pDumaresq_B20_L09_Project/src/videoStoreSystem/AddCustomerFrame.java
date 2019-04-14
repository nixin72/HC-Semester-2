package videoStoreSystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCustomerFrame extends JFrame implements ActionListener,
		WindowListener
{
	private static final int frameWidth = 375;
	private static final int frameHeight = 150;

	private CustomerList customerFile;

	private JLabel lblFirstName = new JLabel("First Name:", JLabel.TRAILING);
	private JTextField fldFirstName = new JTextField(20);
	private JLabel lblLastName = new JLabel("Last Name:", JLabel.TRAILING);
	private JTextField fldLastName = new JTextField(20);
	private JLabel lblPhone = new JLabel("Phone Number:", JLabel.TRAILING);
	private JTextField fldPhone = new JTextField(10);

	private JButton btnAddCustomer = new JButton("Add Customer");
	private JButton btnClear = new JButton("Clear");

	private JPanel panelEntry = new JPanel();
	private JPanel panelButton = new JPanel();

	public AddCustomerFrame()
	{
		try
		{
			Customer.initializeNextCustomerNumber();
			customerFile = new CustomerList("customers.txt");
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(this,
					"customerNumber.txt could not be found",
					"Missing customer number file", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Error reading customerNumber.txt: "
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(-2);
		}
		// set up frame
		setTitle("Add Customer");
		setSize(frameWidth, frameHeight);
		this.setLocation(100, 100);

		// add components to entry panel
		panelEntry.add(lblFirstName);
		panelEntry.add(fldFirstName);
		panelEntry.add(lblLastName);
		panelEntry.add(fldLastName);
		panelEntry.add(lblPhone);
		panelEntry.add(fldPhone);

		// add buttons to button panel
		panelButton.add(btnAddCustomer);
		panelButton.add(btnClear);

		// add panels to frame
		getContentPane().add(panelEntry, BorderLayout.CENTER);
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		fldPhone.setToolTipText("Enter 10 digit phone number");

		// add actionListeners
		btnAddCustomer.addActionListener(this);
		btnClear.addActionListener(this);
		this.addWindowListener(this);
	} // AddCustomerFrame()

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String phoneNumber, lastName, firstName;
		if (e.getSource() == btnClear)
		{
			clearAllFields();
		}
		else
			if (e.getSource() == btnAddCustomer)
			{
				if (fldFirstName.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(this, "You must enter a first name",
							"First Name missing", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					firstName = fldFirstName.getText();

					if (fldLastName.getText().length() == 0)
						JOptionPane.showMessageDialog(this, "You must enter a last name",
								"Last Name missing", JOptionPane.ERROR_MESSAGE);
					else
					{
						lastName = fldLastName.getText();

						if (fldPhone.getText().length() == 0)
							JOptionPane.showMessageDialog(this,
									"You must enter a phone number", "Phone Number missing",
									JOptionPane.ERROR_MESSAGE);
						else
						{
							phoneNumber = validatePhoneNumber(fldPhone.getText());
							if (phoneNumber != null)
							{
								addCustomer(firstName, lastName, phoneNumber);
								clearAllFields();
							} // validate phone number
						} // check phone length
					} // check last name length
				} // check first name length
			} // add customer button clicked
	} // actionPerformed()

	private void clearAllFields()
	{
		fldFirstName.setText("");
		fldLastName.setText("");
		fldPhone.setText("");
	} // clearAllFields()

	private void addCustomer(String firstName, String lastName, String phoneNumber)
	{
		int customerIndex = customerFile.add(new Customer(firstName, lastName,
				phoneNumber));
		if (customerIndex >= 0)
		{
			Customer customer = customerFile.getCustomer(customerIndex);
			JOptionPane.showMessageDialog(this, customer.getFirstName() + " "
					+ customer.getLastName() + " has been added with customer number "
					+ customer.getCustomerNumber(), "Customer Added",
					JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(this, firstName + " " + lastName
					+ " could not be added. Contact Customer Support ",
					"Customer Add Failure", JOptionPane.ERROR_MESSAGE);
	} // addCustomer()

	private String validatePhoneNumber(String phoneNumber)
	{
		// check for (ddd)ddd-dddd format
		if (phoneNumber.matches("\\(\\d{3}\\)\\d{3}-\\d{4}"))
		{
			phoneNumber = phoneNumber.replaceAll("\\(", "");
			phoneNumber = phoneNumber.replaceAll("\\)", "");
		}
		// Remove hyphens and spaces
		phoneNumber = phoneNumber.replaceAll("-", "");
		phoneNumber = phoneNumber.replaceAll(" ", "");

		if (phoneNumber.length() == 7)
			if (JOptionPane.showConfirmDialog(this,
					"Area code is missing. Area code is set to 819.",
					"Missing area code", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION)
			{
				phoneNumber = "819" + phoneNumber;
				fldPhone.setText(phoneNumber);
			}
		if (phoneNumber.length() != 10)
		{
			fldPhone.setText("");
			JOptionPane.showMessageDialog(this, "Phone number must be 10 digits.",
					"Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		for (int i = 0; i < phoneNumber.length(); ++i)
			if (!Character.isDigit(phoneNumber.charAt(i)))
			{
				JOptionPane.showMessageDialog(this, "Phone number must be all digits.",
						"Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		return phoneNumber;
	} // validatePhoneNumber()

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AddCustomerFrame frame = new AddCustomerFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // main()

	@Override
	public void windowActivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		try
		{
			Customer.rewriteNextCustomerNumber();
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(this, "Error writing customerNumber.txt: "
					+ e.getMessage(), "Error rewriting customerNumber.txt",
					JOptionPane.ERROR_MESSAGE);
		}
		try
		{
			customerFile.rewrite();
		}
		catch (IOException e1)
		{
			JOptionPane.showMessageDialog(this, "ERROR: " + e1.getMessage(),
					"I/O Error writing customers.txt: ", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}
} // AddCustomerFrame
