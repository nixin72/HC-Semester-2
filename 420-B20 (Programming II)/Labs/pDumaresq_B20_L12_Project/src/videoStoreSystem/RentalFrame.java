package videoStoreSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class RentalFrame extends JFrame implements SwingConstants
{
	private JLabel lblTitle = new JLabel("Heritage College Video Store");
	private JLabel lblCustomer = new JLabel("Customer number:");
	private JTextField fldCustomer = new JTextField(5);
	private JLabel lblProduct = new JLabel("Product number:");
	private JTextField fldProduct = new JTextField(10);
	private JButton btnTotal = new JButton("Total");
	private JButton btnPrint = new JButton("Print");
	private JTextArea areaReceipt = new JTextArea(50, 5);
	private JPanel panelCustomer = new JPanel();
	private JPanel panelProduct = new JPanel();
	private JPanel panelInputFields = new JPanel();
	private JPanel panelKeypad = new JPanel();
	private JPanel panelButton = new JPanel();
	private JPanel panelPayment = new JPanel();
	private JPanel panelInput = new JPanel();
	private String keyLabel[] = { "7", "8", "9", "4", "5", "6", "1", "2", "3",
			"Movie", "0", "Game", "Clear", " ", "Enter" };
	private JButton btnKey[] = new JButton[keyLabel.length];
	private String paymentLabel[] = { "Cash", "Credit Card", "Debit Card" };
	private JRadioButton rdBtnPayment[] = new JRadioButton[paymentLabel.length];
	private ButtonGroup paymentGroup = new ButtonGroup();

	public RentalFrame()
	{
		setSize(500, 400);
		setLocation(100, 100);
		setTitle("Rent Products");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(CENTER);
		getContentPane().add(lblTitle, BorderLayout.NORTH);
		lblCustomer.setHorizontalAlignment(RIGHT);
		panelCustomer.add(lblCustomer);
		panelCustomer.add(fldCustomer);
		lblProduct.setHorizontalAlignment(RIGHT);
		panelProduct.add(lblProduct);
		panelProduct.add(fldProduct);
		panelInputFields.add(panelCustomer);
		panelInputFields.add(panelProduct);
		panelInputFields
				.setLayout(new BoxLayout(panelInputFields, BoxLayout.Y_AXIS));
		panelButton.add(btnTotal);
		panelButton.add(btnPrint);
		panelInput.add(panelInputFields);
		initializeKeypad();
		panelInput.add(panelKeypad);
		panelInput.add(panelButton);
		initializePayments();
		panelInput.add(panelPayment);
		panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.Y_AXIS));
		getContentPane().add(panelInput, BorderLayout.WEST);
		areaReceipt.setBorder(
				BorderFactory.createTitledBorder("Rental Receipt"));
		getContentPane().add(areaReceipt, BorderLayout.CENTER);
	} // RentalFrame

	private void initializeKeypad()
	{
		panelKeypad.setLayout(new GridLayout(5, 3));
		for (int i = 0; i < keyLabel.length; ++i)
		{
			btnKey[i] = new JButton(keyLabel[i]);
			panelKeypad.add(btnKey[i]);
		}
		btnKey[btnKey.length - 2].setVisible(false);
	}

	private void initializePayments()
	{
		panelPayment.setLayout(new BoxLayout(panelPayment, BoxLayout.Y_AXIS));
		panelPayment.setBorder(BorderFactory.createTitledBorder("Payment Options"));
		for (int i = 0; i < paymentLabel.length; ++i)
		{
			rdBtnPayment[i] = new JRadioButton(paymentLabel[i]);
			panelPayment.add(rdBtnPayment[i]);
			paymentGroup.add(rdBtnPayment[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		RentalFrame frame = new RentalFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


}
