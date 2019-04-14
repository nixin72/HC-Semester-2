package b20_l05_strings;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringProcessingExamples
{

	private JFrame frmStringProcessingExamples;

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
					StringProcessingExamples window = new StringProcessingExamples();
					window.frmStringProcessingExamples.setVisible(true);
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
	public StringProcessingExamples()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmStringProcessingExamples = new JFrame();
		frmStringProcessingExamples.setTitle("String Processing Examples");
		frmStringProcessingExamples.setBounds(100, 100, 450, 300);
		frmStringProcessingExamples.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmStringProcessingExamples.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				mntmExit_actionPerformed(arg0);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnExercises = new JMenu("Exercises");
		menuBar.add(mnExercises);

		JMenuItem mntmMiscellaneousStringMethods = new JMenuItem(
				"Miscellaneous String Methods");
		mntmMiscellaneousStringMethods.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				mntmMiscellaneousStringMethods_actionPerformed(arg0);
			}
		});
		mnExercises.add(mntmMiscellaneousStringMethods);

		JMenuItem mntmComparetoMethod = new JMenuItem("CompareTo Method");
		mntmComparetoMethod.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				mntmComparetoMethod_actionPerformed(arg0);
			}
		});
		mnExercises.add(mntmComparetoMethod);

		JMenuItem mntmStringtokenizerMethods = new JMenuItem(
				"StringTokenizer Methods");
		mntmStringtokenizerMethods.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				mntmStringtokenizerMethods_actionPerformed(arg0);
			}
		});
		mnExercises.add(mntmStringtokenizerMethods);
	} // initialize ()

	protected void mntmExit_actionPerformed(ActionEvent arg0)
	{
		System.exit(0);
	} // mntmExit_actionPerformed(ActionEvent
	
	protected void mntmMiscellaneousStringMethods_actionPerformed(ActionEvent arg0)
	{
		JFrame frame = new MiscStringFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height)
		{
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width)
		{
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	} // mntmMiscellaneousStringMethods_actionPerformed(ActionEvent)

	protected void mntmComparetoMethod_actionPerformed(ActionEvent arg0)
	{
		JFrame frame = new StringCompareFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height)
		{
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width)
		{
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	} // mntmComparetoMethod_actionPerformed(ActionEvent)

	protected void mntmStringtokenizerMethods_actionPerformed(ActionEvent arg0)
	{
		JFrame frame = new StringTokenizerFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height)
		{
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width)
		{
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	} // mntmStringtokenizerMethods_actionPerformed(ActionEvent)

} // StringProcessingExamples class
