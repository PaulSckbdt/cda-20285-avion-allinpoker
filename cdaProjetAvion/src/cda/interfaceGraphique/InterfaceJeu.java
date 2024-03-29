package cda.interfaceGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cda.poo.meteor.Bouclier;
import cda.poo.meteor.Missile;
import cda.poo.meteor.Score;
import cda.poo.music.Audio;
import cda.poo.music.AudioGameOver;
import cda.poo.music.AudioMainLoop;
import cda.poo.objects.Avion;
import cda.poo.objects.FondAleatoire;
import cda.poo.objects.GestionDifficulte;
import cda.poo.objects.Joueur;
import cda.poo.objects.SpawnBonus;
import cda.poo.objects.SpawnMeteor;

public class InterfaceJeu {

	Joueur joueur = new Joueur(InterfaceSaisieNom.getJoueurActuel());

	public static JFrame frame;
	public static JFrame frameGameOver;
	public static InterfaceJeu game;
	public static Avion vMonAvion;
	public static JLabel labelTirAvion;
	public static boolean isShooting;

	public static void main(String[] args) throws InterruptedException {

		game = new InterfaceJeu();
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
		GestionDifficulte.difficulte = 2500;
		Missile.nbShoot = 0;
		Missile.shootingActivated = false;
		Bouclier.bouclierActived = false;
		SpawnBonus.setDoSpawn(true);
		SpawnMeteor.setDoSpawn(true);
		Score.setScoreMeteor(0);

		// Ajout du tir de l'avion

		JLabel labelTirAvion = new JLabel("");
		labelTirAvion.setHorizontalAlignment(SwingConstants.CENTER);
		labelTirAvion.setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/shooter2.gif")));
		labelTirAvion.setBounds(vMonAvion.getX(), vMonAvion.getY(), vMonAvion.getWidth(), 269);
		frame.getContentPane().add(labelTirAvion);
		labelTirAvion.setVisible(false);

		// deplacementAvion et tirAvion

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
						|| e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {

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
					}, 270);
				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					frame.addMouseMotionListener(new MouseMotionListener() {

						@Override
						public void mouseMoved(MouseEvent e) {

							vMonAvion.setLocation(e.getX() - 40, e.getY() - 40);
							vMonAvion.setIcon(Avion.iAvionDroite);
							vMonAvion.setVisible(true);
							vMonAvion.setIcon(Avion.iAvionGauche);
							vMonAvion.setVisible(true);
						}

						@Override
						public void mouseDragged(MouseEvent e) {
							vMonAvion.setLocation(e.getX() - 40, e.getY() - 40);
							vMonAvion.setIcon(Avion.iAvionDroite);
							vMonAvion.setVisible(true);
						}
					});
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

		// FOND

		JLabel fondEcranJeu = new JLabel("");
		fondEcranJeu.setLabelFor(frame);
		fondEcranJeu.setBackground(Color.DARK_GRAY);
		fondEcranJeu.setBounds(0, 0, 634, 711);

		// meteorites

		SpawnMeteor spwn1 = new SpawnMeteor(frame, fondEcranJeu, vMonAvion);
		spwn1.start();

		// BONUS

		SpawnBonus spwn2 = new SpawnBonus(frame, fondEcranJeu, vMonAvion);
		spwn2.start();

		fondEcranJeu.setHorizontalAlignment(SwingConstants.TRAILING);
		frame.getContentPane().add(fondEcranJeu);

		// JOUEUR

		JLabel LabelNomDuJoueur = new JLabel("Joueur : " + joueur.getNom());
		LabelNomDuJoueur.setForeground(Color.WHITE);
		LabelNomDuJoueur.setFont(new Font("Times New Roman", Font.BOLD, 17));
		LabelNomDuJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNomDuJoueur.setBounds(0, 0, 154, 48);
		frame.getContentPane().add(LabelNomDuJoueur);

		// MUNITIONS

		JLabel LabelMunitions = new JLabel("Munitions : 0");
		LabelMunitions.setHorizontalAlignment(SwingConstants.CENTER);
		LabelMunitions.setForeground(Color.LIGHT_GRAY);
		LabelMunitions.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		LabelMunitions.setBounds(480, 663, 154, 48);
		frame.getContentPane().add(LabelMunitions);

		// SCORE

		JLabel LabelScore = new JLabel("Score : " + Score.getScoreMeteor());
		LabelScore.setHorizontalAlignment(SwingConstants.CENTER);
		LabelScore.setForeground(Color.WHITE);
		LabelScore.setFont(new Font("Times New Roman", Font.BOLD, 17));
		LabelScore.setBounds(226, 0, 154, 48);
		frame.getContentPane().add(LabelScore);

		// niveau

		JLabel lblNiveau = new JLabel("           Level  1");
		lblNiveau.setForeground(Color.WHITE);
		lblNiveau.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblNiveau.setBounds(26, 672, 122, 37);
		frame.getContentPane().add(lblNiveau);

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
				LabelScore.setText("Score : " + Score.getScoreMeteor());
				LabelMunitions.setText("Munitions : " + Missile.nbShoot);
				lblNiveau.setText("Level  " + GestionDifficulte.getNiveau());
				new FondAleatoire(fondEcranJeu);
				if (Avion.getNombreVie() < 1) {
					new AudioGameOver();
					timerVie.cancel();
					SpawnMeteor.setDoSpawn(false);
					SpawnBonus.setDoSpawn(false);
					frame.removeAll();
					InterfaceJeu.frame.setVisible(false);
					InterfaceJeu.frame.setEnabled(false);
					InterfaceGameOver.main(null);
				}
			}
		};
		timerVie.schedule(taskVie, 100, 100);
	}
}
