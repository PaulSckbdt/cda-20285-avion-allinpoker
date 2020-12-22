package cda.interfaceGraphique;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import cda.poo.meteor.Meteorite;
import cda.poo.meteor.MeteoriteFeu;
import cda.poo.meteor.MeteoriteGlace;
import cda.poo.meteor.MeteoriteIceberg;
import cda.poo.meteor.MeteoriteZigZag;
import cda.poo.meteor.Score;
import cda.poo.objects.Avion;
import cda.poo.objects.Joueur;

import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class InterfaceJeu {

	// debut Image des mouvements de l'avion**************
	ImageIcon iAvion = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion.png"));
	ImageIcon iAvionGauche = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-gauche.png"));
	ImageIcon iAvionDroite = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-droite.png"));
	ImageIcon iAvionUp = new ImageIcon(Avion.class.getResource("/cda/poo/images/avionUp.png"));

	// fin Image des mouvements de l'avion****************

	// debut ajout joueur***********************
	// Joueur joueur = new Joueur(InterfaceSaisieNom.getJoueurActuel());

	// fin ajout joueur

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceJeu window = new InterfaceJeu();
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
	public InterfaceJeu() {
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

		// Ajout de l'avion **************************
		Avion vMonAvion = new Avion();
		vMonAvion.setBounds(260, 600, 60, 60);
		vMonAvion.setIcon(iAvion);
		frame.getContentPane().add(vMonAvion);
		vMonAvion.setVisible(true);

		// Ajout du tir de l'avion
		JLabel labelTirAvion = new JLabel("");
		labelTirAvion.setHorizontalAlignment(SwingConstants.CENTER);
		labelTirAvion.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/avion-tir.gif")));
		labelTirAvion.setBounds(260, 234, 60, 398);
		frame.getContentPane().add(labelTirAvion);
		labelTirAvion.setVisible(true);

		// Début deplacementAvion et tirAvion
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP && 200 < vMonAvion.getY()) {
					vMonAvion.setLocation(vMonAvion.getX(), vMonAvion.getY() - 15);
					vMonAvion.setIcon(iAvionUp);
					vMonAvion.setVisible(true);
					labelTirAvion.setLocation(labelTirAvion.getX(), labelTirAvion.getY() - 15);

				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN && 651 > vMonAvion.getY()) {
					vMonAvion.setLocation(vMonAvion.getX(), vMonAvion.getY() + 15);
					vMonAvion.setIcon(iAvion);
					vMonAvion.setVisible(true);
					labelTirAvion.setLocation(labelTirAvion.getX(), labelTirAvion.getY() + 15);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT && 0 < vMonAvion.getX()) {
					vMonAvion.setLocation(vMonAvion.getX() - 15, vMonAvion.getY());
					vMonAvion.setIcon(iAvionGauche);
					vMonAvion.setVisible(true);
					labelTirAvion.setLocation(labelTirAvion.getX() - 15, labelTirAvion.getY());
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && 574 > vMonAvion.getX()) {
					vMonAvion.setLocation(vMonAvion.getX() + 15, vMonAvion.getY());
					vMonAvion.setIcon(iAvionDroite);
					vMonAvion.setVisible(true);
					labelTirAvion.setLocation(labelTirAvion.getX() + 15, labelTirAvion.getY());
				}
			}
		});

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					vMonAvion.setIcon(iAvion);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					vMonAvion.setIcon(iAvion);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					vMonAvion.setIcon(iAvion);
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					vMonAvion.setIcon(iAvion);
				}
			}
		});

		// Fin déplacementAvion et tirAvion (quand on relache la touche l'avion se remet
		// droit)

		// DEBUT METEORITES************

		Meteorite meteorBasic = new Meteorite();
		MeteoriteFeu meteorFeu = new MeteoriteFeu();
		MeteoriteGlace meteorGlace = new MeteoriteGlace();
		MeteoriteZigZag meteorZigZag = new MeteoriteZigZag();
		MeteoriteIceberg meteorIceberg = new MeteoriteIceberg();

		Score.spawnMeteor(frame, meteorBasic, meteorFeu, meteorGlace, meteorZigZag, meteorIceberg);

		// FIN METEORITES*************

//		JLabel LabelNomDuJoueur = new JLabel("Joueur : " + joueur.getNom());
//		LabelNomDuJoueur.setForeground(Color.WHITE);
//		LabelNomDuJoueur.setFont(new Font("Times New Roman", Font.BOLD, 17));
//		LabelNomDuJoueur.setHorizontalAlignment(SwingConstants.CENTER);
//		LabelNomDuJoueur.setBounds(0, 0, 106, 48);
//		frame.getContentPane().add(LabelNomDuJoueur);

		JLabel fondEcranJeu = new JLabel("");
		fondEcranJeu.setHorizontalAlignment(SwingConstants.CENTER);
		fondEcranJeu.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile.gif")));
		fondEcranJeu.setBounds(0, 0, 634, 711);
		frame.getContentPane().add(fondEcranJeu);

	}
}
