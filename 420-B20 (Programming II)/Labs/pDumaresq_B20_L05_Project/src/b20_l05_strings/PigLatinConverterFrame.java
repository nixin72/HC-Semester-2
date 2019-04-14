package b20_l05_strings;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PigLatinConverterFrame
{

	private JFrame frmPigLatinConverter;
	private JTextField fldSentence;
	private JTextArea resultDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{	EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					PigLatinConverterFrame window = new PigLatinConverterFrame();
					window.frmPigLatinConverter.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PigLatinConverterFrame()
	{
		initialize();
	} // PigLatinConverterFrame()

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmPigLatinConverter = new JFrame();
		frmPigLatinConverter.setTitle("Pig Latin Converter");
		frmPigLatinConverter.setBounds(100, 100, 450, 300);
		frmPigLatinConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPigLatinConverter.getContentPane().setLayout(null);

		JLabel lblSentence = new JLabel("Type a sentence:");
		lblSentence.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSentence.setBounds(10, 24, 117, 14);
		frmPigLatinConverter.getContentPane().add(lblSentence);

		fldSentence = new JTextField();
		fldSentence.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				fldSentence_actionPerformat(arg0);
			}
		});
		fldSentence.setBounds(134, 21, 276, 20);
		frmPigLatinConverter.getContentPane().add(fldSentence);
		fldSentence.setColumns(10);

		resultDisplay = new JTextArea();
		resultDisplay.setWrapStyleWord(true);
		resultDisplay.setLineWrap(true);
		resultDisplay.setEditable(false);
		resultDisplay.setBounds(20, 52, 390, 161);
		frmPigLatinConverter.getContentPane().add(resultDisplay);
		
		JButton btnClearResults = new JButton("Clear Results");
		btnClearResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnClearResults_actionPerformed(arg0);
			}
		});
		btnClearResults.setBounds(157, 228, 117, 23);
		frmPigLatinConverter.getContentPane().add(btnClearResults);
	} // initialize()

	protected void btnClearResults_actionPerformed(ActionEvent arg0)
	{
		resultDisplay.setText("");
	}

	protected void fldSentence_actionPerformat(ActionEvent arg0)
	{
		resultDisplay.append(fldSentence.getText() + " in Pig Latin:\n");
		resultDisplay.append(PigLatinConverter.toPigLatin(fldSentence.getText())
				+ "\n\n");
	} // fldSentence_actionPerformat(ActionEvent)
} // PigLatinConverterFrame class
