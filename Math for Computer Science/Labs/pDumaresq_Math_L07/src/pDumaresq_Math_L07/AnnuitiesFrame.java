package pDumaresq_Math_L07;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class AnnuitiesFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField P;
	private JTextField R;
	private JTextField N;
	private JTextField K;
	private JTextField R2;
	private JTextField N2;
	private JLabel label;
	private JLabel label_1;
	private JTextField N3;
	private JTextField T;
	private JLabel label_2;
	private JLabel lblX;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextArea answer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnnuitiesFrame frame = new AnnuitiesFrame();
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
	public AnnuitiesFrame() {
		setTitle("Annuities");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		P = new JTextField();
		P.setBounds(15, 148, 26, 26);
		contentPane.add(P);
		P.setColumns(10);
		
		R = new JTextField();
		R.setColumns(10);
		R.setBounds(82, 126, 26, 26);
		contentPane.add(R);
		
		N = new JTextField();
		N.setColumns(10);
		N.setBounds(82, 168, 26, 26);
		contentPane.add(N);
		
		K = new JTextField();
		K.setColumns(10);
		K.setBounds(156, 148, 26, 26);
		contentPane.add(K);
		
		R2 = new JTextField();
		R2.setColumns(10);
		R2.setBounds(324, 126, 26, 26);
		contentPane.add(R2);
		
		N2 = new JTextField();
		N2.setColumns(10);
		N2.setBounds(324, 168, 26, 26);
		contentPane.add(N2);
		
		label = new JLabel("1 - ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(240, 145, 69, 20);
		contentPane.add(label);
		
		label_1 = new JLabel(")");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 70));
		label_1.setBounds(362, 104, 69, 110);
		contentPane.add(label_1);
		
		N3 = new JTextField();
		N3.setColumns(10);
		N3.setBounds(416, 126, 26, 26);
		contentPane.add(N3);
		
		T = new JTextField();
		T.setColumns(10);
		T.setBounds(468, 126, 26, 26);
		contentPane.add(T);
		
		label_2 = new JLabel(")");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 70));
		label_2.setBounds(509, 104, 69, 110);
		contentPane.add(label_2);
		
		lblX = new JLabel("X");
		lblX.setBounds(446, 129, 69, 20);
		contentPane.add(lblX);
		
		label_3 = new JLabel("(");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 70));
		label_3.setBounds(281, 107, 69, 105);
		contentPane.add(label_3);
		
		label_4 = new JLabel("(");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 70));
		label_4.setBounds(197, 107, 69, 105);
		contentPane.add(label_4);
		
		label_5 = new JLabel("= ");
		label_5.setBounds(137, 151, 69, 20);
		contentPane.add(label_5);
		
		label_6 = new JLabel("(");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 70));
		label_6.setBounds(56, 97, 69, 124);
		contentPane.add(label_6);
		
		label_7 = new JLabel(")");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 70));
		label_7.setBounds(106, 104, 69, 110);
		contentPane.add(label_7);
		
		label_8 = new JLabel("-");
		label_8.setBounds(393, 129, 69, 20);
		contentPane.add(label_8);
		
		JButton btnCalculate = new JButton("CALCULATE");
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnCalculate.setBounds(137, 230, 270, 112);
		contentPane.add(btnCalculate);
		btnCalculate.addActionListener(this);
		
		answer = new JTextArea();
		answer.setBounds(106, 16, 358, 72);
		contentPane.add(answer);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		double k, p, n, t, r;
		String _K = K.getText();
		String _P = P.getText();
		String _N = N.getText();
		String _T = T.getText();
		String _R = R.getText();
		if (_K.equals("")) {
			p = Double.parseDouble(_P);
			n = Double.parseDouble(_N);
			t = Double.parseDouble(_T);
			r = Double.parseDouble(_R);
			k = (p * (r / n)) / (1 - Math.pow((1 + (r / n)) , ((n * -1) * t)));
			answer.setText(String.valueOf(k));
		}
		if (_P.equals("")) {
			k = Double.parseDouble(_K);
			n = Double.parseDouble(_N);
			t = Double.parseDouble(_T);
			r = Double.parseDouble(_R);
			p = (1 - Math.pow((1 + (r / n)) , ((n * -1) * t))) / (r / n)  ;
			answer.setText(String.valueOf(k));
		}
	}
}
