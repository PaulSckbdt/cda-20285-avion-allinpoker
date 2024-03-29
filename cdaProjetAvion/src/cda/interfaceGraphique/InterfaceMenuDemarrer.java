package cda.interfaceGraphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InterfaceMenuDemarrer {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new InterfaceMenuDemarrer();
					InterfaceMenuDemarrer.frame.setVisible(true);
					InterfaceMenuDemarrer.frame.setResizable(false);
				} catch (Exception e) {
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
		frame.setBounds(600, 100, 650, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// d�but bouttonJouer ***********************************************

		JButton bouttonJouer = new JButton("Jouer");
		bouttonJouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				InterfaceAvantJeu.main(null);
				closeFrame();
			}
		});
		bouttonJouer.setBackground(Color.LIGHT_GRAY);
		bouttonJouer.setForeground(Color.BLACK);
		bouttonJouer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonJouer.setBounds(220, 200, 200, 70);

		// on ajoute le bouton a la JFrame
		frame.getContentPane().add(bouttonJouer);

		// fin bouttonJouer ***********************************************

		// d�but bouttonInstructions ***********************************************

		JButton bouttonInstructions = new JButton("Instructions");
		bouttonInstructions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceInstructions.main(null);
				frame.setVisible(false);
			}
		});
		bouttonInstructions.setBackground(new Color(192, 192, 192));
		bouttonInstructions.setBackground(Color.LIGHT_GRAY);
		bouttonInstructions.setForeground(Color.BLACK);
		bouttonInstructions.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonInstructions.setBounds(220, 300, 200, 70);

		// on ajoute le bouton a la JFrame
		frame.getContentPane().add(bouttonInstructions);

		// fin bouttonInstructions ***********************************************

		// d�but bouttonScore ***********************************************

		JButton bouttonScore = new JButton("Dernier Score");
		bouttonScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		bouttonScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceScore.main(null);
				frame.setVisible(false);
			}
		});
		bouttonScore.setBackground(Color.LIGHT_GRAY);
		bouttonScore.setForeground(Color.BLACK);
		bouttonScore.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonScore.setBounds(220, 400, 200, 70);

		// on ajoute le bouton a la JFrame
		frame.getContentPane().add(bouttonScore);

		// fin bouttonScore ***********************************************

		// d�but bouttonQuitter ***********************************************

		JButton bouttonQuitter = new JButton("Quitter");
		bouttonQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bouttonQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceQuitter.main(null);
				closeFrame();
			}
		});

		bouttonQuitter.setBackground(Color.LIGHT_GRAY);
		bouttonQuitter.setForeground(Color.BLACK);
		bouttonQuitter.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonQuitter.setBounds(220, 500, 200, 70);

		// on ajoute le bouton a la JFrame
		frame.getContentPane().add(bouttonQuitter);

		// fin bouttonScore ***********************************************

		// debut labelFondMenuDemarrer qui affiche l'image de fond

		JLabel labelFondMenuDemarrer = new JLabel("");
		labelFondMenuDemarrer.setHorizontalAlignment(SwingConstants.LEFT);
		labelFondMenuDemarrer.setVerticalAlignment(SwingConstants.TOP);
		labelFondMenuDemarrer.setIcon(
				new ImageIcon(InterfaceMenuDemarrer.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		labelFondMenuDemarrer.setBounds(0, 0, 634, 711);

		// on ajouter le label contenant l'image de fond au frame
		frame.getContentPane().add(labelFondMenuDemarrer);

		// fin labelFondMenuDemarrer ***********************************************

	}

	// Methode pour fermer la fenetre du menu demarrer
	public static void closeFrame() {
		frame.setVisible(false);
		frame.dispose();
	}

}
