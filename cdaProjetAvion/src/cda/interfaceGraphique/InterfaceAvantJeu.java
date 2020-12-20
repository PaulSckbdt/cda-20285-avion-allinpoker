package cda.interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import cda.poo.objects.Joueur;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceAvantJeu {

	private JFrame frame;

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

		// début bouttonNouvellePartie ***********************************************

		JButton bouttonNouvellePartie = new JButton("Nouvelle Partie");
		bouttonNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bouttonNouvellePartie.setFont(new Font("Times New Roman", Font.BOLD, 18));
		bouttonNouvellePartie.setBackground(Color.LIGHT_GRAY);
		bouttonNouvellePartie.setBounds(221, 200, 168, 83);
		frame.getContentPane().add(bouttonNouvellePartie);

		// fin bouttonNouvellePartie ***********************************************

		// début bouttonRetour ***********************************************

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
		frame.getContentPane().add(fondJouer);

		// fin fondJouer qui affiche l'image de fond

	}
}
