package videoStoreSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddProductFrame extends JFrame implements WindowListener {
	private Product product;
	private Inventory inventory;
	private char productType;
	private JPanel contentPane;
	private JTextField fldTitle;
	private JTextField fldYearMade;
	private JTextField fldDirector;
	private JLabel lblTitle = new JLabel("Title:");
	private JLabel lblYearMade = new JLabel("Year Made:");
	private JButton btnNewMovie = new JButton("New Movie");
	private JButton btnNewGame = new JButton("New Game");
	private JComboBox cmboxMovieCategory = new JComboBox();
	private JLabel lblMovieCategory = new JLabel("Category:");
	private JLabel lblMovieFormat = new JLabel("Format:");
	private JLabel lblDirector = new JLabel("Director:");
	private JComboBox cmboxMovieFormat = new JComboBox();
	private JLabel lblGameCategory = new JLabel("Category:");
	private JLabel lblGameFormat = new JLabel("Format:");
	private JComboBox cmboxGameFormat = new JComboBox();
	private JComboBox cmboxGameCategory = new JComboBox();
	private JLabel lblPlatform = new JLabel("Platform:");
	private JComboBox cmboxPlatform = new JComboBox();
	private JButton btnAdd = new JButton("Add");
	private JButton btnClear = new JButton("Clear");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductFrame frame = new AddProductFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddProductFrame() {
		Product.open();
		inventory = new Inventory("inventory.txt");
		product = null;
		setTitle("Add Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(0, 20, 73, 16);
		contentPane.add(lblTitle);

		fldTitle = new JTextField();
		fldTitle.setBounds(85, 16, 388, 22);
		contentPane.add(fldTitle);
		fldTitle.setColumns(10);

		lblYearMade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYearMade.setBounds(0, 56, 73, 16);
		contentPane.add(lblYearMade);

		fldYearMade = new JTextField();
		fldYearMade.setBounds(85, 54, 116, 22);
		contentPane.add(fldYearMade);
		fldYearMade.setColumns(10);

		btnNewMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewMovie_actionPerformed(arg0);
			}
		});
		btnNewMovie.setBounds(110, 92, 95, 25);
		contentPane.add(btnNewMovie);

		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewGame_actionPerformed(arg0);
			}
		});
		btnNewGame.setBounds(272, 92, 95, 25);
		contentPane.add(btnNewGame);

		cmboxMovieCategory.setModel(new DefaultComboBoxModel(new String[] {
				"Unknown", "Family", "Action", "Comedy", "Western", "Drama",
				"Horror", "Sci-Fi" }));
		cmboxMovieCategory.setBounds(85, 134, 145, 22);
		contentPane.add(cmboxMovieCategory);

		lblMovieCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMovieCategory.setBounds(0, 137, 73, 16);
		contentPane.add(lblMovieCategory);

		lblMovieFormat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMovieFormat.setBounds(0, 173, 73, 16);
		contentPane.add(lblMovieFormat);

		lblDirector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDirector.setBounds(0, 209, 73, 16);
		contentPane.add(lblDirector);

		cmboxMovieFormat.setModel(new DefaultComboBoxModel(new String[] {
				"DVD", "DVD-HD", "Blu-Ray" }));
		cmboxMovieFormat.setBounds(85, 170, 145, 22);
		contentPane.add(cmboxMovieFormat);

		fldDirector = new JTextField();
		fldDirector.setBounds(85, 206, 145, 22);
		contentPane.add(fldDirector);
		fldDirector.setColumns(10);

		lblGameCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGameCategory.setBounds(242, 137, 73, 16);
		contentPane.add(lblGameCategory);

		lblGameFormat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGameFormat.setBounds(242, 173, 73, 16);
		contentPane.add(lblGameFormat);

		cmboxGameFormat.setModel(new DefaultComboBoxModel(new String[] { "DVD",
				"CD" }));
		cmboxGameFormat.setBounds(328, 170, 145, 22);
		contentPane.add(cmboxGameFormat);

		cmboxGameCategory.setModel(new DefaultComboBoxModel(new String[] {
				"Unknown", "RPG", "Action", "Education" }));
		cmboxGameCategory.setBounds(328, 134, 145, 22);
		contentPane.add(cmboxGameCategory);

		lblPlatform.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlatform.setBounds(242, 209, 73, 16);
		contentPane.add(lblPlatform);

		cmboxPlatform.setModel(new DefaultComboBoxModel(new String[] {
				"Sony PlayStation", "Microsoft xBox", "Nintendo GameCube",
				"Nintendo Wii" }));
		cmboxPlatform.setBounds(328, 206, 145, 22);
		contentPane.add(cmboxPlatform);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAdd_actionPerformed(arg0);
			}
		});
		btnAdd.setBounds(110, 247, 95, 25);
		contentPane.add(btnAdd);

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearAllFields();
			}
		});
		btnClear.setBounds(272, 247, 95, 25);
		contentPane.add(btnClear);

		enableMovieFields(false);
		enableGameFields(false);
		this.addWindowListener(this);
	} // AddProductFrame()

	private void btnNewMovie_actionPerformed(ActionEvent e) {
		if (fldTitle.getText().length() == 0)
			JOptionPane.showMessageDialog(this, "You must enter a title",
					"Title missing", JOptionPane.ERROR_MESSAGE);
		else {
			productType = 'M';
			enableMovieFields(true);
		} // else
	} // movieBtn_actionPerformed(ActionEvent)

	private void btnNewGame_actionPerformed(ActionEvent e) {
		if (fldTitle.getText().length() == 0)
			JOptionPane.showMessageDialog(this, "You must enter a title",
					"Title missing", JOptionPane.ERROR_MESSAGE);
		else {
			productType = 'G';
			enableGameFields(true);
		} // else
	} // gameBtn_actionPerformed(ActionEvent)

	private void btnAdd_actionPerformed(ActionEvent e) {
		if (fldTitle.getText().length() == 0)
			JOptionPane.showMessageDialog(this, "You must enter a title",
					"Title missing", JOptionPane.ERROR_MESSAGE);
		else {
			if (productType == 'M') {
				product = new Movie(fldTitle.getText());
				if (fldYearMade.getText().length() > 0)
					product.setYearMade(Integer.parseInt(fldYearMade.getText()));
				product.setCategoryCode(cmboxMovieCategory.getSelectedItem()
						.toString());
				product.setFormatCode(cmboxMovieFormat.getSelectedItem()
						.toString());
				if (fldDirector.getText().length() > 0)
					((Movie) product).setDirector(fldDirector.getText());
			} // if (productType == 'M')
			else if (productType == 'G') {
				product = new Game(fldTitle.getText());
				if (fldYearMade.getText().length() > 0)
					product.setYearMade(Integer.parseInt(fldYearMade.getText()));
				product.setCategoryCode(cmboxGameCategory.getSelectedItem()
						.toString());
				product.setFormatCode(cmboxGameFormat.getSelectedItem()
						.toString());
				((Game) product).setPlatformCode(cmboxPlatform
						.getSelectedItem().toString());
			} // else if (productType == 'G')
			if (inventory.addProduct(product) != -1)
				if (productType == 'M') {
					JOptionPane.showMessageDialog(this,
							"The movie was successfully added with product code "
									+ product.getProductNumber(),
							"Successful Add", JOptionPane.INFORMATION_MESSAGE);
				} else if (productType == 'G') {
					JOptionPane.showMessageDialog(this,
							"The game was successfully added with product code "
									+ product.getProductNumber(),
							"Successful Add", JOptionPane.INFORMATION_MESSAGE);
				}
			clearAllFields();
			enableMovieFields(false);
			enableGameFields(false);
		}
	}// addBtn_actionPerformed(ActionEvent)

	private void clearAllFields() {
		fldTitle.setText("");
		fldYearMade.setText("");
		fldDirector.setText("");
		cmboxMovieCategory.setSelectedIndex(0);
		cmboxMovieFormat.setSelectedIndex(0);
		cmboxGameCategory.setSelectedIndex(0);
		cmboxGameFormat.setSelectedIndex(0);
		cmboxPlatform.setSelectedIndex(0);
	} // clearAllFields()

	private void enableMovieFields(boolean enabled) {
		lblMovieCategory.setEnabled(enabled);
		cmboxMovieCategory.setEnabled(enabled);
		lblMovieFormat.setEnabled(enabled);
		cmboxMovieFormat.setEnabled(enabled);
		lblDirector.setEnabled(enabled);
		fldDirector.setEnabled(enabled);
		btnAdd.setEnabled(enabled);
		btnNewMovie.setEnabled(!enabled);
		btnNewGame.setEnabled(!enabled);
	}

	private void enableGameFields(boolean enabled) {
		lblGameCategory.setEnabled(enabled);
		cmboxGameCategory.setEnabled(enabled);
		lblGameFormat.setEnabled(enabled);
		cmboxGameFormat.setEnabled(enabled);
		lblPlatform.setEnabled(enabled);
		cmboxPlatform.setEnabled(enabled);
		btnAdd.setEnabled(enabled);
		btnNewMovie.setEnabled(!enabled);
		btnNewGame.setEnabled(!enabled);
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		JOptionPane.showMessageDialog(this, Movie.getCountMovies()
				+ " movies and " + Game.getCountGames() + " games were added.");
		inventory.rewrite();
		Product.close();
	} // windowClosing(WindowEvent)

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
}// AddProductFrame class
