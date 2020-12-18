package cda.interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceMenuDemarrer {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMenuDemarrer window = new InterfaceMenuDemarrer();
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
	public InterfaceMenuDemarrer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton bouttonJouer = new JButton("Jouer");
		bouttonJouer.setBackground(Color.LIGHT_GRAY);
		bouttonJouer.setForeground(Color.BLACK);
		bouttonJouer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonJouer.setBounds(220, 200, 200, 70);
		frame.getContentPane().add(bouttonJouer);

		JButton bouttonInstructions = new JButton("Instructions");
		bouttonInstructions.setBackground(Color.LIGHT_GRAY);
		bouttonInstructions.setForeground(Color.BLACK);
		bouttonInstructions.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonInstructions.setBounds(220, 300, 200, 70);
		frame.getContentPane().add(bouttonInstructions);

		JButton bouttonScore = new JButton("Scores");
		bouttonScore.setBackground(Color.LIGHT_GRAY);
		bouttonScore.setForeground(Color.BLACK);
		bouttonScore.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonScore.setBounds(220, 400, 200, 70);
		frame.getContentPane().add(bouttonScore);

		JButton bouttonQuitter = new JButton("Quitter");
		bouttonQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bouttonQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceQuitter.main(null);
			}
		});

		bouttonQuitter.setBackground(Color.LIGHT_GRAY);
		bouttonQuitter.setForeground(Color.BLACK);
		bouttonQuitter.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonQuitter.setBounds(220, 500, 200, 70);
		frame.getContentPane().add(bouttonQuitter);

		JLabel labelFondMenuDemarrer = new JLabel("");
		labelFondMenuDemarrer.setHorizontalAlignment(SwingConstants.LEFT);
		labelFondMenuDemarrer.setVerticalAlignment(SwingConstants.TOP);
		labelFondMenuDemarrer.setIcon(
				new ImageIcon(InterfaceMenuDemarrer.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		labelFondMenuDemarrer.setBounds(0, 0, 634, 711);
		frame.getContentPane().add(labelFondMenuDemarrer);
	}

	public static void closeFrame() {
		frame.setVisible(false);
		frame.dispose();
	}
}
