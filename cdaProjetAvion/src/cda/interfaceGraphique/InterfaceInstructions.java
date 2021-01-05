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

public class InterfaceInstructions {

	private JFrame frame;
	private JLabel page1;
	private JLabel page2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceInstructions window = new InterfaceInstructions();
					window.frame.setVisible(true);
					window.frame.setResizable(false);

				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceInstructions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 100, 650, 750);

		frame.getContentPane().setLayout(null);

		// dï¿½but bouttonRetour ***********************************************

		JButton bouttonRetour = new JButton("Retour");
		bouttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InterfaceMenuDemarrer.main(null);
			}
		});
		bouttonRetour.setBackground(Color.LIGHT_GRAY);
		bouttonRetour.setForeground(Color.BLACK);
		bouttonRetour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonRetour.setBounds(10, 10, 148, 70);

		// on ajoute le bouton a la JFrame
		frame.getContentPane().add(bouttonRetour);

		// fin bouttonRetour ***********************************************

		// dÃ©but bouttonRetour ***********************************************

		JButton BouttonPrecedent = new JButton("Précédent");
		BouttonPrecedent.setBackground(Color.LIGHT_GRAY);
		BouttonPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				page1.setVisible(true);
				page2.setVisible(false);
			}
		});
		BouttonPrecedent.setBounds(328, 20, 148, 55);

		// on ajoute le bouton a la JFrame
		frame.getContentPane().add(BouttonPrecedent);

		JButton BouttonSuivant = new JButton("Suivant");
		BouttonSuivant.setBackground(Color.LIGHT_GRAY);
		BouttonSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				page1.setVisible(false);
				page2.setVisible(true);
			}
		});
		BouttonSuivant.setBounds(486, 20, 148, 55);

		// on ajoute le bouton a la JFrame
		frame.getContentPane().add(BouttonSuivant);

		// fin BouttonSuivant ***********************************************

		// debut fondMenuInstructionsP1 qui affiche l'image de la page 1 instruction

		JLabel fondMenuInstructionsP1 = new JLabel("");
		fondMenuInstructionsP1.setIcon(
				new ImageIcon(InterfaceInstructions.class.getResource("/cda/poo/images/fondMenuInstructionsP1.png")));
		fondMenuInstructionsP1.setBounds(0, 0, 634, 711);

		// on ajoute le label a la JFrame
		frame.getContentPane().add(fondMenuInstructionsP1);
		page1 = fondMenuInstructionsP1;

		// fin fondMenuInstructionsP1 ***********************************************

		// debut fondMenuInstructionsP2 qui affiche l'image de la page 2 instruction

		JLabel fondMenuInstructionsP2 = new JLabel("");
		fondMenuInstructionsP2.setIcon(
				new ImageIcon(InterfaceInstructions.class.getResource("/cda/poo/images/fondMenuInstructionsP2.jpg")));
		fondMenuInstructionsP2.setBounds(0, 0, 634, 711);

		// on ajoute le label a la JFrame
		frame.getContentPane().add(fondMenuInstructionsP2);
		page2 = fondMenuInstructionsP2;
	}

}
