package pDumaresq_B20_A99_chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ChessFrame extends JFrame implements ActionListener {
	ChessGame game = new ChessGame();

	private JPanel contentPane;
	private JPanel panelButtons;
	
	private JButton[][] square;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessFrame frame = new ChessFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void buildBoard() {
		square = new JButton[8][8];
		int secondBox = 1;
		
		panelButtons.setLayout(new GridLayout(8,8));
		for (int row = 0; row < square.length; ++row){
			for (int col = 0; col < square[row].length; ++col) {
				square[row][col] = new JButton("");
				square[row][col].setFont(new Font("board", Font.BOLD, 24));
				square[row][col].setVisible(true);
				square[row][col].setEnabled(true);
				panelButtons.add(square[row][col]);
				square[row][col].addActionListener(this); 
				if (secondBox%2 == 0) {
					square[row][col].setBackground(Color.BLACK);
					square[row][col].setForeground(Color.GRAY);
					secondBox = 1;
				}
				else {
					square[row][col].setForeground(Color.WHITE);
					square[row][col].setForeground(Color.GRAY);
					secondBox = 2;
				}
			}	
			if (secondBox%2 == 0) {
				secondBox = 1;
			}
			else {
				secondBox = 2;
			}
			
		}	
		setPieces();
	}
	
	public void setPieces() {
		game.initialBoard();
		for (int row = 0; row < square.length; ++row){
			for (int col = 0; col < square[row].length; ++col) {
				square[row][col].setText(game.pieces[row][col]);
			}	
		}	
	}
	
	public void actionPerformed(ActionEvent e) { 
		for (int row = 0; row < square.length ; row++) {
			for (int col = 0; col < square[row].length ; col++) {
				if (e.getSource() == square[row][col]) {
					if (square[row][col].getText().equals("P")) 
						square[row+1][col].setEnabled(true);
						else 
							square[row+1][col].setEnabled(false);	
				}
			}
		}
	}
		
	/**
	 * Create the frame.
	 */
	public ChessFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelButtons = new JPanel();
		panelButtons.setBounds(15, 66, 553, 553);
		contentPane.add(panelButtons);
		panelButtons.setLayout(new GridLayout(1, 0, 0, 0));
		
		buildBoard();
	}

}
