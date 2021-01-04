package cda.interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceGameOver {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGameOver window = new InterfaceGameOver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGameOver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 652, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnRecommencer = new JButton("Rejouer");
		btnRecommencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

				InterfaceMenuDemarrer.main(null);
			}
		});
		btnRecommencer.setForeground(Color.RED);
		btnRecommencer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRecommencer.setBackground(Color.DARK_GRAY);
		btnRecommencer.setBounds(236, 410, 167, 62);
		frame.getContentPane().add(btnRecommencer);

		JButton btnScore = new JButton("Score");
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				InterfaceScore.main(null);

			}
		});
		btnScore.setForeground(Color.RED);
		btnScore.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnScore.setBackground(Color.DARK_GRAY);
		btnScore.setBounds(27, 410, 167, 62);
		frame.getContentPane().add(btnScore);

		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setForeground(Color.RED);
		btnQuitter.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuitter.setBackground(Color.DARK_GRAY);
		btnQuitter.setBounds(446, 410, 167, 62);
		frame.getContentPane().add(btnQuitter);

		JLabel lblFondEcran = new JLabel("");
		lblFondEcran.setIcon(new ImageIcon(InterfaceGameOver.class.getResource("/cda/poo/images/gameOver.png")));
		lblFondEcran.setBounds(0, -17, 634, 524);
		frame.getContentPane().add(lblFondEcran);
	}
}
