package cda.interfaceGraphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.PopupMenu;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cda.poo.objects.Joueur;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		JFormattedTextField fieldNomJoueur = new JFormattedTextField();
		fieldNomJoueur.setForeground(Color.WHITE);
		fieldNomJoueur.setBackground(Color.DARK_GRAY);
		fieldNomJoueur.setFont(new Font("Times New Roman", Font.BOLD, 17));
		fieldNomJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		fieldNomJoueur.setBounds(69, 89, 486, 48);
		frame.getContentPane().add(fieldNomJoueur);

		JButton bouttonOk = new JButton("OK");
		bouttonOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomSaisi = fieldNomJoueur.getText().toString();

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

			}
		});
		bouttonOk.setBackground(Color.LIGHT_GRAY);
		bouttonOk.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bouttonOk.setBounds(267, 170, 89, 23);
		frame.getContentPane().add(bouttonOk);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(InterfaceSaisieNom.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 634, 261);
		frame.getContentPane().add(lblNewLabel);
		JLabel saisieNom = new JLabel("Veuillez saisir un nom entre 3 et 6 lettre");
		saisieNom.setForeground(new Color(255, 255, 240));
		saisieNom.setFont(new Font("Times New Roman", Font.BOLD, 29));
		saisieNom.setBounds(70, 11, 496, 71);
		lblNewLabel.add(saisieNom);

	}

	public static String getJoueurActuel() {
		return joueurActuel.getNom();
	}

}
