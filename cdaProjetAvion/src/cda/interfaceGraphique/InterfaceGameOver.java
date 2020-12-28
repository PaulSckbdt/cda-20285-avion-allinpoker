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
		frame.setBounds(100, 100, 642, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnRecommencer = new JButton("Rejouer");
		btnRecommencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

				InterfaceMenuDemarrer.main(null);
			}
		});
		btnRecommencer.setForeground(Color.BLACK);
		btnRecommencer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRecommencer.setBackground(Color.LIGHT_GRAY);
		btnRecommencer.setBounds(28, 45, 167, 62);
		frame.getContentPane().add(btnRecommencer);

		JButton btnScore = new JButton("Score");
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// interfacescore
			}
		});
		btnScore.setForeground(Color.BLACK);
		btnScore.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnScore.setBackground(Color.LIGHT_GRAY);
		btnScore.setBounds(28, 149, 167, 62);
		frame.getContentPane().add(btnScore);

		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setForeground(Color.BLACK);
		btnQuitter.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuitter.setBackground(Color.LIGHT_GRAY);
		btnQuitter.setBounds(28, 254, 167, 62);
		frame.getContentPane().add(btnQuitter);

		JLabel lblFondEcran = new JLabel("");
		lblFondEcran
				.setIcon(new ImageIcon(InterfaceGameOver.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		lblFondEcran.setBounds(0, 0, 626, 375);
		frame.getContentPane().add(lblFondEcran);
	}
}
