package cda.interfaceGraphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cda.poo.objects.Joueur;

public class InterfaceSaisieNom {

	private JFrame frame;
	private static Joueur joueurActuel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceSaisieNom window = new InterfaceSaisieNom();

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
	public InterfaceSaisieNom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 350, 650, 300);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// début fieldNomJoueur ***********************************************

		JFormattedTextField fieldNomJoueur = new JFormattedTextField();
		fieldNomJoueur.setForeground(Color.WHITE);
		fieldNomJoueur.setBackground(Color.DARK_GRAY);
		fieldNomJoueur.setFont(new Font("Times New Roman", Font.BOLD, 17));
		fieldNomJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		fieldNomJoueur.setBounds(69, 89, 486, 48);

		// on ajoute le label a la JFrame
		frame.getContentPane().add(fieldNomJoueur);

		// fin fieldNomJoueur ***********************************************

		// début bouttonOk ***********************************************

		JButton bouttonOk = new JButton("OK");
		bouttonOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomSaisi = fieldNomJoueur.getText().toString();

				// début test nomSaisi ***********************************************

				if (nomSaisi.length() < 3 || nomSaisi.length() > 6) {
					fieldNomJoueur.setText("");

				}
				if (nomSaisi.length() >= 3 && nomSaisi.length() <= 6) {

					Joueur joueur = new Joueur(nomSaisi);
					joueurActuel = joueur;
					InterfaceJeu.main(null);
					InterfaceAvantJeu.closeFrame();
					frame.setVisible(false);
				}
				// fin test nomSaisi ***********************************************
			}
		});
		bouttonOk.setBackground(Color.LIGHT_GRAY);
		bouttonOk.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bouttonOk.setBounds(267, 170, 89, 23);

		// on ajoute le boutton a la JFrame
		frame.getContentPane().add(bouttonOk);

		// fin bouttonOk ***********************************************

		// début label fondSaisieNom qui affiche l'image de fond

		JLabel fondSaisieNom = new JLabel("");
		fondSaisieNom
				.setIcon(new ImageIcon(InterfaceSaisieNom.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		fondSaisieNom.setHorizontalAlignment(SwingConstants.CENTER);
		fondSaisieNom.setBounds(0, 0, 634, 261);

		// on ajoute le label a la JFrame
		frame.getContentPane().add(fondSaisieNom);

		// fin lbel fondSaisieNom ***********************************************

		// début label saisieNom ***********************************************

		JLabel saisieNom = new JLabel("Veuillez saisir un nom entre 3 et 6 lettre");
		saisieNom.setForeground(new Color(255, 255, 240));
		saisieNom.setFont(new Font("Times New Roman", Font.BOLD, 29));
		saisieNom.setBounds(70, 11, 496, 71);
		fondSaisieNom.add(saisieNom);

		// fin label saisieNom ***********************************************
	}

	// méthode qui retourne en string le nom du joueur
	// ***********************************************
	public static String getJoueurActuel() {
		return joueurActuel.getNom();
	}

}
