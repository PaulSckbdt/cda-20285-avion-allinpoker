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

public class InterfaceScore {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new InterfaceScore();
					InterfaceScore.frame.setVisible(true);
					InterfaceScore.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceScore() {
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

		// fin bouttonScore ***********************************************

		// d�but bouttonQuitter ***********************************************

		JButton bouttonRetour = new JButton("Retour");
		bouttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bouttonRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceMenuDemarrer.main(null);
				closeFrame();
			}
		});

		bouttonRetour.setBackground(Color.LIGHT_GRAY);
		bouttonRetour.setForeground(Color.BLACK);
		bouttonRetour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonRetour.setBounds(65, 630, 200, 70);

		// on ajoute le bouton a la JFrame
		frame.getContentPane().add(bouttonRetour);

		// fin bouttonScore ***********************************************

		// debut labelFondMenuDemarrer qui affiche l'image de fond

		JLabel labelFondMenuDemarrer = new JLabel("");
		labelFondMenuDemarrer.setHorizontalAlignment(SwingConstants.LEFT);
		labelFondMenuDemarrer.setVerticalAlignment(SwingConstants.TOP);
		labelFondMenuDemarrer.setIcon(
				new ImageIcon(InterfaceScore.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
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
