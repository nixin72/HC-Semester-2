package b20_l05_strings;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringCompareFrame extends JFrame
{

	private JPanel contentPane;
	private JTextField fldString1;
	private JTextField fldString2;
	private JTextArea resultsDisplay;
	private JButton btnCompare;

	/**
	 * Create the frame.
	 */
	public StringCompareFrame()
	{
		setTitle("Demonstration of the compareTo() method");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblString1 = new JLabel("String 1:");
		lblString1.setBounds(24, 37, 52, 14);
		contentPane.add(lblString1);

		JLabel lblString2 = new JLabel("String 2:");
		lblString2.setBounds(176, 37, 52, 14);
		contentPane.add(lblString2);

		fldString1 = new JTextField();
		fldString1.setBounds(80, 34, 86, 20);
		contentPane.add(fldString1);
		fldString1.setColumns(10);

		fldString2 = new JTextField();
		fldString2.setBounds(232, 34, 86, 20);
		contentPane.add(fldString2);
		fldString2.setColumns(10);

		btnCompare = new JButton("Compare");
		btnCompare.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				btnCompare_actionPerformed(arg0);
			}
		});
		btnCompare.setBounds(133, 74, 89, 23);
		contentPane.add(btnCompare);

		resultsDisplay = new JTextArea();
		resultsDisplay.setEditable(false);
		resultsDisplay.setBounds(24, 116, 315, 109);
		contentPane.add(resultsDisplay);
	}

	private void btnCompare_actionPerformed(ActionEvent e)
	{
		String str1 = fldString1.getText();
		String str2 = fldString2.getText();
		if (str1.length() == 0 || str2.length() == 0)
			JOptionPane.showMessageDialog(this, "You must enter two strings",
					"Missing input", JOptionPane.ERROR_MESSAGE);
		else
		{
			if (str1.compareToIgnoreCase(str2) > str2.compareToIgnoreCase(str1)) {
				resultsDisplay.setText("str1 is less than str2");
			}
			else if (str1.compareToIgnoreCase(str2) == str2.compareToIgnoreCase(str1)) {
				resultsDisplay.setText("str1 is equal to str2");
			}
			else if (str1.compareToIgnoreCase(str2) < str2.compareToIgnoreCase(str1)) {
				resultsDisplay.setText("str1 is greater than str2");
			}
			/*resultsDisplay.setText("\"" + str1 + "\".compareTo(\"" + str2 + "\") is "
					+ str1.compareToIgnoreCase(str2) + "\n");
			resultsDisplay.append("\"" + str2 + "\".compareTo(\"" + str1 + "\") is "
					+ str2.compareToIgnoreCase(str1) + "\n");*/
		}
	}
}
