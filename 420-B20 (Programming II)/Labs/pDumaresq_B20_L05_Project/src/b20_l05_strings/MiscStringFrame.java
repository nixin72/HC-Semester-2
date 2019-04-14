package b20_l05_strings;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MiscStringFrame extends JFrame
{
	private JPanel contentPane;
	private JTextField fldSentence;
	private JTextArea resultsDisplay;

	/**
	 * Create the frame.
	 */
	public MiscStringFrame()
	{
		setTitle("Miscellaneous String Methods");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterASentence = new JLabel("Enter a sentence:");
		lblEnterASentence.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnterASentence.setBounds(25, 14, 100, 14);
		contentPane.add(lblEnterASentence);

		fldSentence = new JTextField();
		fldSentence.setBounds(135, 11, 273, 20);
		contentPane.add(fldSentence);
		fldSentence.setColumns(10);

		resultsDisplay = new JTextArea();
		resultsDisplay.setWrapStyleWord(true);
		resultsDisplay.setLineWrap(true);
		resultsDisplay.setEditable(false);
		resultsDisplay.setBounds(25, 79, 383, 172);
		contentPane.add(resultsDisplay);

		JButton btnReverse = new JButton("Reverse");
		btnReverse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				btnReverse_actionPerformed(arg0);
			}
		});
		btnReverse.setBounds(28, 45, 107, 23);
		contentPane.add(btnReverse);

		JButton btnToAscii = new JButton("To Ascii");
		btnToAscii.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				btnToAscii_actionPerformed(arg0);
			}
		});
		btnToAscii.setBounds(163, 45, 107, 23);
		contentPane.add(btnToAscii);

		JButton btnToSentence = new JButton("To Sentence");
		btnToSentence.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				btnToSentence_actionPerformed(arg0);
			}
		});
		btnToSentence.setBounds(298, 45, 107, 23);
		contentPane.add(btnToSentence);
	} // MiscStringFrame()

	protected void btnReverse_actionPerformed(ActionEvent arg0)
	{
		resultsDisplay.setText(fldSentence.getText() + "\n");
		resultsDisplay.append("The sentence in reverse is: \n");
		resultsDisplay.append(StringMethods.reverse(fldSentence.getText()));		
	}

	protected void btnToAscii_actionPerformed(ActionEvent arg0)
	{
		resultsDisplay.setText(fldSentence.getText() + "\n");
		resultsDisplay.append("The ascii sentence is: ");
		resultsDisplay.append(StringMethods.asciiString(fldSentence.getText()));
	}

	protected void btnToSentence_actionPerformed(ActionEvent arg0)
	{
		resultsDisplay.setText(fldSentence.getText() + "\n");
	}

} // MiscStringFrame class
