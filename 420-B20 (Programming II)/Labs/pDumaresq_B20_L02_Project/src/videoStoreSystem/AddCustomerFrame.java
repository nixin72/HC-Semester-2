package videoStoreSystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCustomerFrame extends JFrame implements ActionListener
{
	private static final int frameWidth = 375;
	private static final int frameHeight = 150;

	private Customer customer = new Customer();

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
	
	private JOptionPane missingCustomerNumberFile
	 =  new JOptionPane("Missing " + "customer number file");
	private JOptionFrame Error = newJOptionFrame("E");
	

	public AddCustomerFrame()
	{
		try {
		customer.initialiseNextCustomerNumber();
		}
		catch (FileNotFoundException e){
			System.exit(-1);
		}
		catch (Exception e)
		{
			System.exit( -2);
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
								customer = new Customer(firstName, lastName, phoneNumber);
								JOptionPane.showMessageDialog(
										this,
										customer.getFirstName() + " " + customer.getLastName()
												+ " has been added with customer number "
												+ customer.getCustomerNumber(), "Customer Added",
										JOptionPane.INFORMATION_MESSAGE);
								// print for initial testing purposes
								System.out.println("Customer first name: "
										+ customer.getFirstName() + " last name: "
										+ customer.getLastName() + " Phone number: "
										+ customer.getPhoneNumber());
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
		AddCustomerFrame frame = new AddCustomerFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // main()
} // AddCustomerFrame
