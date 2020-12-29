package cda.poo.meteor;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;
import cda.poo.music.Audio;
import cda.poo.objects.Avion;

public class Bouclier extends Score {
	public Avion avion;

	public static int x;
	public static int y;
	public static int width;
	public static int height;

	ImageIcon iAvionShield = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-shield.png"));
	ImageIcon iAvionGaucheShield = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-gauche-shield.png"));
	ImageIcon iAvionDroiteShield = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-droite-shield.png"));
	
	public Bouclier(Avion vAvion) {

		this.avion = vAvion;
		Random r = new Random();
		x = r.nextInt((690 - 30) + 1);
		y = 0;
		width = 40;
		height = 40;


		setBounds(x, y, width, height);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/powerUpShield.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				if (collision()) {
					Audio a = new Audio("/cda/poo/music/bouclier.wav");

					if (isEnabled()) {
						a.run();
			
						// TEST CHANGEMENT DE PNG AU DEPLACEMENT //
						
//						// Ajout de l'avion **************************
//						Avion vMonAvion = new Avion();
//						vMonAvion.setBounds(260, 600, 60, 60);
//						vMonAvion.setVisible(true);
//						
//						addKeyListener(new KeyAdapter() {
//							@Override
//							public void keyPressed(KeyEvent e) {
//								if (e.getKeyCode() == KeyEvent.VK_DOWN && 0 < vMonAvion.getX()) {
//									vMonAvion.setLocation(vMonAvion.getX() - 15, vMonAvion.getY());
//									vMonAvion.setIcon(iAvionShield);
//									vMonAvion.setVisible(true);
//					
//								}
//								if (e.getKeyCode() == KeyEvent.VK_UP && 0 < vMonAvion.getX()) {
//									vMonAvion.setLocation(vMonAvion.getX() - 15, vMonAvion.getY());
//									vMonAvion.setIcon(iAvionShield);
//									vMonAvion.setVisible(true);
//					
//								}
//								if (e.getKeyCode() == KeyEvent.VK_LEFT && 0 < vMonAvion.getX()) {
//									vMonAvion.setLocation(vMonAvion.getX() - 15, vMonAvion.getY());
//									vMonAvion.setIcon(iAvionGaucheShield);
//									vMonAvion.setVisible(true);
//					
//								}
//								if (e.getKeyCode() == KeyEvent.VK_RIGHT && 574 > vMonAvion.getX()) {
//									vMonAvion.setLocation(vMonAvion.getX() + 15, vMonAvion.getY());
//									vMonAvion.setIcon(iAvionDroiteShield);
//									vMonAvion.setVisible(true);
//						
//								}
//							}
//						});
//						
//						
//						addKeyListener(new KeyAdapter() {
//							@Override
//							public void keyReleased(KeyEvent e) {
//								if (e.getKeyCode() == KeyEvent.VK_UP) {
//									vMonAvion.setIcon(iAvionShield);
//								}
//								if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//									vMonAvion.setIcon(iAvionShield);
//								}
//								if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//									vMonAvion.setIcon(iAvionShield);
//								}
//								if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//									vMonAvion.setIcon(iAvionShield);
//								}
//							}
//						});
						
						
						setEnabled(false);

					}
				}
				setLocation(getX(), getY() + 2);

			}
		};

		timer.schedule(timerTask, 10, 10);

	}

	public int getProfondeurY() {
		return y + height;
	}

	public int getProfondeurX() {
		return x + width;
	}

	public Rectangle bounds() {
		return (new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

	public boolean collision() {

//		box1 : avion;
		int avionX = avion.getX();
		int avionY = avion.getY();
		int avionW = avion.getWidth();
		int avionH = avion.getHeight();

//		box2 : bouclier
		int bouclierX = getX();
		int bouclierY = getY();
		int bouclierW = getWidth();
		int bouclierH = getHeight();

		// trop à droite
		boolean droite = bouclierX >= avionX + avionW;
		// trop à gauche
		boolean gauche = bouclierX + bouclierW <= avionX;
		// trop à bas
		boolean bas = bouclierY >= avionY + avionH;
		// trop à haut
		boolean haut = bouclierY + bouclierH <= avionY;

		if ((droite) || (gauche) || (bas) || (haut)) {
			return false;
		} else {
			return true;
		}

	}
}
