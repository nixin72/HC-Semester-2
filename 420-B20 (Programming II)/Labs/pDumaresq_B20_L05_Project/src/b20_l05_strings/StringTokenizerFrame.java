package b20_l05_strings;

import java.util.StringTokenizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringTokenizerFrame extends JFrame
{

	private JPanel contentPane;
	private JTextField fldSentence;
	private JLabel lblSentence;
	private JTextArea resultsDisplay;

	/**
	 * Create the frame.
	 */
	public StringTokenizerFrame()
	{
		setTitle("StringTokenizer methods");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblSentence = new JLabel("Enter a sentence:");
		lblSentence.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSentence.setBounds(21, 11, 108, 14);
		contentPane.add(lblSentence);

		fldSentence = new JTextField();
		fldSentence.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				fldSentence_actionPerformed(arg0);
			}
		});
		fldSentence.setBounds(139, 8, 272, 20);
		contentPane.add(fldSentence);
		fldSentence.setColumns(10);

		resultsDisplay = new JTextArea();
		resultsDisplay.setWrapStyleWord(true);
		resultsDisplay.setLineWrap(true);
		resultsDisplay.setEditable(false);
		JScrollPane display = new JScrollPane(resultsDisplay);
		display.setBounds(21, 36, 390, 204);
		contentPane.add(display);
	} // StringTokenizerFrame ()

	private void fldSentence_actionPerformed(ActionEvent arg0)
	{
		String sentence = fldSentence.getText();
		StringTokenizer myTokenizer = new StringTokenizer(sentence);
		resultsDisplay.setText("There are " 
		        + myTokenizer.countTokens()
		        + " words in the sentence.\n");
		
		resultsDisplay.append("The words are: \n");
		while(myTokenizer.hasMoreTokens())
     		resultsDisplay.append (myTokenizer.nextToken()+"\n");

		StringTokenizer eToken = new StringTokenizer(sentence, "e");
		resultsDisplay.append("There are " 
		        + eToken.countTokens()
		        + " words in the sentence.\n");
		resultsDisplay.append("The words are: \n");
		while(eToken.hasMoreTokens())
     		resultsDisplay.append (eToken.nextToken()+"\n");
		
	} // fldSentence_actionPerformed(ActionEvent)
} // StringTokenizerFrame class
