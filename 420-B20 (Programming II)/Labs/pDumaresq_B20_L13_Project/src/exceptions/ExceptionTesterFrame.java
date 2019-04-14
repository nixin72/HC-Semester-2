package exceptions;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ExceptionTesterFrame extends JFrame
{
	IntField integer = new IntField();
	private JPanel contentPane;
	private JLabel lblPrompt;
	private IntField fldArraySize;
	private JLabel lblStatusBar;
	private int list[];
	private JTextArea areaMessage;

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
					ExceptionTesterFrame frame = new ExceptionTesterFrame();
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
	public ExceptionTesterFrame()
	{
		integer.setBound(100000);
		
		setTitle("Testing Array Expansion Options");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPrompt = new JLabel("How many elements are in the list? ");
		lblPrompt.setBounds(56, 11, 207, 14);
		contentPane.add(lblPrompt);
		
		fldArraySize = new IntField();
		fldArraySize.setBounds(262, 8, 86, 20);
		contentPane.add(fldArraySize);
		fldArraySize.setColumns(10);
		
		lblStatusBar = new JLabel("");
		lblStatusBar.setBounds(0, 233, 434, 29);
		contentPane.add(lblStatusBar);
		
		areaMessage = new JTextArea();
		areaMessage.setEditable(false);
		areaMessage.setBounds(10, 43, 414, 179);
		contentPane.add(areaMessage);
		
		fldArraySize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayNumberOfInts();
				
			}
		});
	}
	
	private void insertAt(int n) {
		try {
			n = list[n];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			int newList[] = new int[list.length+1];
			for (int q = 0 ; q < list.length ; q++) {
				newList[q] = list[q];
			}
			newList[list.length] = list.length;
			list = newList;
		}
	}
	
	public void displayNumberOfInts() {
		try {
			int n = fldArraySize.getInt();
			lblStatusBar.setText(n + " integers were inserted");
			testBigEnoughArray(n);
			testArray(n);
		}
		catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this, "You must enter an integer. Please re-enter",	
					"invalid input", JOptionPane.ERROR_MESSAGE);
		}
		catch(IntOutOfRangeException e) {
			JOptionPane.showMessageDialog(this, "The number you entered is too large. "
					+ "It must be less than 100000. Please re-enter.",	
					"input too large", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void testBigEnoughArray(int n)  {
		long startTime = System.nanoTime();
		
		list = new int[n];
		
		for (int q = 0 ; q < n ; q++) {
			insertAt(q);
		}
		long endTime = System.nanoTime();
		
		areaMessage.setText("it took " + String.valueOf(endTime-startTime)
				+ " nano seconds to create the array.\n");
	}
	
	private void testArray(int n)  {
		long startTime = System.nanoTime();
		
		list = new int[0];
		
		for (int q = 0 ; q < n ; q++) {
			insertAt(q);
		}
		long endTime = System.nanoTime();
		
		areaMessage.append("it took " + String.valueOf(endTime-startTime) 
				+ " nano seconds to create the array starting with size 0");
	}
}
