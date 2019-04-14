package videoStoreSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductFrame extends JFrame
{

	private JPanel contentPane;
	private JLabel lblYearMade;
	private JLabel lblMovieCategory;
	private JLabel lblMovieFormat;
	private JLabel lblDirector;
	private JLabel lblGameCategory;
	private JLabel lblGameFormat;
	private JLabel lblPlatform;
	private JButton btnNewButton;
	private JButton btnAddGame;
	private JButton btnAdd;
	private JButton btnClear;
	private JComboBox cmbxPlatform;
	private JComboBox cmbxMovieCategory;
	private JComboBox cmbxMovieFormat;
	private JTextField fldTitle;
	private JTextField fldYearMade;
	private JTextField fldDirector;

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
					AddProductFrame frame = new AddProductFrame();
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
	public AddProductFrame()
	{
		setTitle("Add Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title: ");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(0, 14, 75, 14);
		contentPane.add(lblTitle);
		
		lblYearMade = new JLabel("Year Made: ");
		lblYearMade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYearMade.setBounds(0, 43, 75, 14);
		contentPane.add(lblYearMade);
		
		lblMovieCategory = new JLabel("Category:");
		lblMovieCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMovieCategory.setBounds(0, 131, 75, 14);
		contentPane.add(lblMovieCategory);
		
		lblMovieFormat = new JLabel("Format:");
		lblMovieFormat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMovieFormat.setBounds(0, 156, 75, 14);
		contentPane.add(lblMovieFormat);
		
		lblDirector = new JLabel("Director:");
		lblDirector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDirector.setBounds(0, 181, 75, 14);
		contentPane.add(lblDirector);
		
		lblGameCategory = new JLabel("Category:");
		lblGameCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGameCategory.setBounds(204, 131, 75, 14);
		contentPane.add(lblGameCategory);
		
		lblGameFormat = new JLabel("Format:");
		lblGameFormat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGameFormat.setBounds(204, 156, 75, 14);
		contentPane.add(lblGameFormat);
		
		lblPlatform = new JLabel("Platform:");
		lblPlatform.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlatform.setBounds(204, 181, 75, 14);
		contentPane.add(lblPlatform);
		
		btnNewButton = new JButton("Add Movie");
		btnNewButton.setBounds(85, 86, 104, 23);
		contentPane.add(btnNewButton);
		
		btnAddGame = new JButton("Add Game");
		btnAddGame.setBounds(241, 86, 104, 23);
		contentPane.add(btnAddGame);
		
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.setBounds(85, 228, 104, 23);
		contentPane.add(btnAdd);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllFields();
			}

			private void clearAllFields()
			{
				fldTitle.setText("");
				fldYearMade.setText("");
				fldDirector.setText("");
			}
		});
		
		
		
		btnClear.setBounds(241, 228, 104, 23);
		contentPane.add(btnClear);
		
		JComboBox cmbxGameCategory = new JComboBox();
		cmbxGameCategory.setEnabled(false);
		cmbxGameCategory.setModel(new DefaultComboBoxModel(new String[] {"Unknown", "RPG", "Action", "Education"}));
		cmbxGameCategory.setBounds(297, 128, 114, 20);
		contentPane.add(cmbxGameCategory);
		
		JComboBox cmbxGameFormat = new JComboBox();
		cmbxGameFormat.setEnabled(false);
		cmbxGameFormat.setModel(new DefaultComboBoxModel(new String[] {"", "DVD", "CD"}));
		cmbxGameFormat.setBounds(297, 153, 114, 20);
		contentPane.add(cmbxGameFormat);
		
		cmbxPlatform = new JComboBox();
		cmbxPlatform.setEnabled(false);
		cmbxPlatform.setModel(new DefaultComboBoxModel(new String[] {"Unknown", "Sony PlayStation", "Microsoft xBox", "Nintendo Wii U", "Nintendo Wii"}));
		cmbxPlatform.setBounds(297, 178, 114, 20);
		contentPane.add(cmbxPlatform);
		
		cmbxMovieCategory = new JComboBox();
		cmbxMovieCategory.setEnabled(false);
		cmbxMovieCategory.setModel(new DefaultComboBoxModel(new String[] {"Unknown", "Family", "Action", "Comedy", "Western", "Drama", "Horror", "Sci-fi"}));
		cmbxMovieCategory.setBounds(85, 128, 122, 20);
		contentPane.add(cmbxMovieCategory);
		
		cmbxMovieFormat = new JComboBox();
		cmbxMovieFormat.setEnabled(false);
		cmbxMovieFormat.setModel(new DefaultComboBoxModel(new String[] {"", "DVD", "DVD-HD", "Blu-Ray"}));
		cmbxMovieFormat.setBounds(85, 153, 122, 20);
		contentPane.add(cmbxMovieFormat);
		
		fldTitle = new JTextField();
		fldTitle.setBounds(85, 10, 299, 23);
		contentPane.add(fldTitle);
		fldTitle.setColumns(10);
		
		fldYearMade = new JTextField();
		fldYearMade.setBounds(85, 39, 175, 23);
		contentPane.add(fldYearMade);
		fldYearMade.setColumns(10);
		
		fldDirector = new JTextField();
		fldDirector.setBounds(85, 177, 122, 23);
		contentPane.add(fldDirector);
		fldDirector.setColumns(10);
	}
}
