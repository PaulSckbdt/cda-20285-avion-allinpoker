package cda.interfaceGraphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InterfaceAvantJeu {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAvantJeu window = new InterfaceAvantJeu();
					window.frame.setVisible(true);
					window.frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceAvantJeu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 100, 650, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// d�but bouttonNouvellePartie ***********************************************

		JButton bouttonNouvellePartie = new JButton("Nouvelle Partie");
		bouttonNouvellePartie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				InterfaceSaisieNom.main(null);
			}
		});

		bouttonNouvellePartie.setFont(new Font("Times New Roman", Font.BOLD, 18));
		bouttonNouvellePartie.setBackground(Color.LIGHT_GRAY);
		bouttonNouvellePartie.setBounds(221, 200, 168, 83);
		frame.getContentPane().add(bouttonNouvellePartie);

		// fin bouttonNouvellePartie ***********************************************

		// d�but bouttonRetour ***********************************************

		JButton bouttonRetour = new JButton("Retour");
		bouttonRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.setVisible(false);
				InterfaceMenuDemarrer.main(null);

			}
		});

		bouttonRetour.setFont(new Font("Times New Roman", Font.BOLD, 18));
		bouttonRetour.setBackground(Color.LIGHT_GRAY);
		bouttonRetour.setBounds(221, 500, 168, 83);
		frame.getContentPane().add(bouttonRetour);

		// fin bouttonRetour ***********************************************

		// debut fondJouer qui affiche l'image de fond

		JLabel fondJouer = new JLabel("");
		fondJouer.setVerticalAlignment(SwingConstants.TOP);
		fondJouer.setHorizontalAlignment(SwingConstants.RIGHT);
		fondJouer.setIcon(new ImageIcon(InterfaceAvantJeu.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		fondJouer.setBounds(0, 0, 634, 711);

		// on ajoute le label a la JFrame
		frame.getContentPane().add(fondJouer);

		// fin fondJouer qui affiche l'image de fond

	}

	public static void closeFrame() {
		frame.setVisible(false);
		frame.dispose();
	}
}
