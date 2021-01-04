package cda.interfaceGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cda.poo.meteor.Missile;
import cda.poo.meteor.Score;
import cda.poo.music.Audio;
import cda.poo.music.AudioGameOver;
import cda.poo.music.AudioMainLoop;
import cda.poo.objects.Avion;
import cda.poo.objects.SpawnBonus;
import cda.poo.objects.SpawnMeteor;

public class InterfaceJeu {

//	Joueur joueur = new Joueur(InterfaceSaisieNom.getJoueurActuel());

	public static JFrame frame;
	public static JFrame frameGameOver;
	public static Avion vMonAvion;
	public static JLabel labelTirAvion;
	public static boolean isShooting;

	public static void main(String[] args) throws InterruptedException {

		new InterfaceJeu();
	}

	public InterfaceJeu() {

		new AudioMainLoop();
		initialize();
	}

	private void initialize() {

		// fenetre principale

		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(600, 100, 650, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);

		// Ajout de l'avion

		Avion vMonAvion = new Avion();
		frame.getContentPane().add(vMonAvion);
		Avion.setNombreVie(5);
		SpawnBonus.setDoSpawn(true);
		SpawnMeteor.setDoSpawn(true);

		// Ajout du tir de l'avion

		JLabel labelTirAvion = new JLabel("");
		labelTirAvion.setHorizontalAlignment(SwingConstants.CENTER);
		labelTirAvion.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/shooter.gif")));
		labelTirAvion.setBounds(260, 338, 60, 269);
		frame.getContentPane().add(labelTirAvion);
		labelTirAvion.setVisible(false);
//		frame.addKeyListener(new Keylistener());

		// deplacementAvion et tirAvion

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP && 200 < vMonAvion.getY()) {
					vMonAvion.setLocation(vMonAvion.getX(), vMonAvion.getY() - 15);
					vMonAvion.setIcon(Avion.iAvionUp);
					vMonAvion.setVisible(true);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN && 651 > vMonAvion.getY()) {
					vMonAvion.setLocation(vMonAvion.getX(), vMonAvion.getY() + 15);
					vMonAvion.setIcon(Avion.iAvion);
					vMonAvion.setVisible(true);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT && 0 < vMonAvion.getX()) {
					vMonAvion.setLocation(vMonAvion.getX() - 15, vMonAvion.getY());
					vMonAvion.setIcon(Avion.iAvionGauche);
					vMonAvion.setVisible(true);
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && 574 > vMonAvion.getX()) {
					vMonAvion.setLocation(vMonAvion.getX() + 15, vMonAvion.getY());
					vMonAvion.setIcon(Avion.iAvionDroite);
					vMonAvion.setVisible(true);
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE && 200 < vMonAvion.getY()
						&& Missile.shootingActivated == true) {
					isShooting = true;
					labelTirAvion.setLocation(vMonAvion.getX(), vMonAvion.getY() - 240);
					if (Missile.shootingActivated == true) {
						labelTirAvion.setVisible(true);
					}
					Missile.nbShoot--;
					new Audio("/cda/poo/music/tirCut.wav");
					if (Missile.nbShoot < 1) {
						Missile.shootingActivated = false;
					}
					new java.util.Timer().schedule(new java.util.TimerTask() {
						@Override
						public void run() {
							labelTirAvion.setVisible(false);
							isShooting = false;
						}
					}, 510);

				}
			}
		});

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
						|| e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					vMonAvion.setIcon(Avion.iAvion);
				}
			}
		});

		// fond

		JLabel fondEcranJeu = new JLabel("");
		fondEcranJeu.setLabelFor(frame);
		fondEcranJeu.setBackground(Color.DARK_GRAY);
		fondEcranJeu.setBounds(0, 0, 634, 711);
		fondEcranJeu.setHorizontalAlignment(SwingConstants.TRAILING);
		fondEcranJeu.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile.gif")));
		frame.getContentPane().add(fondEcranJeu);

		// meteorites

		SpawnMeteor spwn1 = new SpawnMeteor(frame, fondEcranJeu, vMonAvion);
		spwn1.start();

		// BONUS

		SpawnBonus spwn2 = new SpawnBonus(frame, fondEcranJeu, vMonAvion);
		spwn2.start();

		// JOUEUR

//		JLabel LabelNomDuJoueur = new JLabel("Joueur : " + joueur.getNom());
//		LabelNomDuJoueur.setForeground(Color.WHITE);
//		LabelNomDuJoueur.setFont(new Font("Times New Roman", Font.BOLD, 17));
//		LabelNomDuJoueur.setHorizontalAlignment(SwingConstants.CENTER);
//		LabelNomDuJoueur.setBounds(0, 0, 154, 48);
//		frame.getContentPane().add(LabelNomDuJoueur);

		// MUNITIONS

		JLabel LabelMunitions = new JLabel("Munitions : 0");
		LabelMunitions.setHorizontalAlignment(SwingConstants.CENTER);
		LabelMunitions.setForeground(Color.WHITE);
		LabelMunitions.setFont(new Font("Times New Roman", Font.BOLD, 17));
		LabelMunitions.setBounds(480, 663, 154, 48);
		frame.getContentPane().add(LabelMunitions);

		// SCORE

		JLabel LabelScore = new JLabel("Score : " + Score.getScoreMeteor());
		LabelScore.setHorizontalAlignment(SwingConstants.CENTER);
		LabelScore.setForeground(Color.WHITE);
		LabelScore.setFont(new Font("Times New Roman", Font.BOLD, 17));
		LabelScore.setBounds(226, 0, 154, 48);
		frame.getContentPane().add(LabelScore);

		Timer timerScore = new Timer();
		TimerTask taskScore = new TimerTask() {
			@Override
			public void run() {
				LabelScore.setText("Score : " + Score.getScoreMeteor());
				LabelMunitions.setText("Munitions : " + Missile.nbShoot);
			}
		};
		timerScore.schedule(taskScore, 50, 50);

		// VIE

		JLabel LabelNbVie = new JLabel("Vie : " + Avion.getNombreVie());
		LabelNbVie.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNbVie.setForeground(Color.WHITE);
		LabelNbVie.setFont(new Font("Times New Roman", Font.BOLD, 17));
		LabelNbVie.setBounds(470, 0, 154, 48);
		frame.getContentPane().add(LabelNbVie);

		Timer timerVie = new Timer();
		TimerTask taskVie = new TimerTask() {
			@Override
			public void run() {
				LabelNbVie.setText("Vie : " + Avion.getNombreVie());
				if (Avion.getNombreVie() < 1) {
					new AudioGameOver();
					timerVie.cancel();
					timerScore.cancel();
					SpawnMeteor.setDoSpawn(false);
					SpawnBonus.setDoSpawn(false);
					InterfaceJeu.frame.setVisible(false);
					InterfaceJeu.frame.setEnabled(false);
					InterfaceGameOver.main(null);
				}
			}
		};
		timerVie.schedule(taskVie, 150, 150);
	}
}