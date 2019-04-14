package videoStoreSystem;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RentalFrame extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JLabel lblHeritageCollegeVideo;
	private	JLabel lblTitle;
	private JLabel lblCustomerNumber;
	private JLabel lblProductNumber;
	private JTextField fldCustomerNumber;
	private JTextField fldProductNumber;
	private JPanel panelKeypad;
	private JButton btnTotal;
	private JButton btnPrint;
	private JPanel areaReceipt;
	private JPanel areaPaymentOptions;
	
	//key pad arrays
	private String keyLabel[] = {"7","8","9",
															"4","5","6",
															"1","2","3",
															"movie","0","game",
															"clear"," ","enter"};
	private JButton btnKey[] = new JButton[keyLabel.length];
		
	//Radio button arrays
	private String paymentLabel[] = {"Cash", "Credit Card", "Debit Card"};
	private JRadioButton rdbtnPayment[] = new JRadioButton[paymentLabel.length];
	ButtonGroup btn = new ButtonGroup();
	
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
					RentalFrame frame = new RentalFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void initializeKeyPad() {
		panelKeypad.setLayout(new GridLayout(5,3));
		
		for (int i = 0 ; i < keyLabel.length ; i++) {
			
			btnKey[i] = new JButton(keyLabel[i]);
			panelKeypad.add(btnKey[i]);
			
		}//for
	
		btnKey[btnKey.length-2].setVisible(false);
	
	}//initializaKeyPad() 
	
	private void initializePaymentButtons() {
		areaPaymentOptions.setBorder(
				BorderFactory.createTitledBorder("Payment Options"));

		areaPaymentOptions.setLayout(new BoxLayout(areaPaymentOptions, BoxLayout.Y_AXIS));
		for (int i = 0 ; i < paymentLabel.length ; i++) {
			
				rdbtnPayment[i] = new JRadioButton(paymentLabel[i]);
				areaPaymentOptions.add(rdbtnPayment[i]);
				btn.add(rdbtnPayment[i]);
			}//for
	}
	
	public RentalFrame()
	{
		setTitle("Product Rental");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("Heritage Movie and Game Rentals ");
		lblTitle.setBounds(87, 10, 310, 22);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblTitle);
		
		lblCustomerNumber = new JLabel("Customer Number: ");
		lblCustomerNumber.setBounds(10, 43, 138, 14);
		lblCustomerNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblCustomerNumber);
		
		lblProductNumber = new JLabel("Product Number: ");
		lblProductNumber.setBounds(20, 68, 128, 14);
		lblProductNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblProductNumber);
		
		fldCustomerNumber = new JTextField();
		fldCustomerNumber.setBounds(158, 43, 73, 20);
		contentPane.add(fldCustomerNumber);
		fldCustomerNumber.setColumns(10);
		
		fldProductNumber = new JTextField();
		fldProductNumber.setBounds(158, 65, 73, 20);
		fldProductNumber.setColumns(10);
		contentPane.add(fldProductNumber);
		
		btnTotal = new JButton("Total");
		btnTotal.setBounds(10, 238, 89, 23);
		contentPane.add(btnTotal);
		
		btnPrint = new JButton("Print");
		btnPrint.setBounds(142, 238, 89, 23);
		btnPrint.addActionListener(this);
		contentPane.add(btnPrint);
		


		areaReceipt = new JPanel();
		areaReceipt.setBounds(240, 43, 234, 358);
		contentPane.add(areaReceipt);
				areaReceipt.setBorder(BorderFactory.createTitledBorder("Payment Options"));
				
		areaPaymentOptions = new JPanel();
		areaPaymentOptions.setBounds(49, 287, 124, 106);
		contentPane.add(areaPaymentOptions);
		
		panelKeypad = new JPanel();
		panelKeypad.setBounds(10, 106, 222, 122);
		contentPane.add(panelKeypad);
				
		lblHeritageCollegeVideo = new JLabel("Heritage College Video Store");
		lblHeritageCollegeVideo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeritageCollegeVideo.setFont(new Font("Tahoma", Font.BOLD, 18));

		
		lblCustomerNumber = new JLabel("Customer Number");

		initializeKeyPad();
		initializePaymentButtons();
	}
	public void actionPerformed(ActionEvent arg0) {
	}
}
