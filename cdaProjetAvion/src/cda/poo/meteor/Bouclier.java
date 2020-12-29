package cda.poo.meteor;

import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;
import cda.poo.music.Audio;
import cda.poo.objects.Avion;

public class Bouclier extends Score {
	public Avion avion;

	public static int xDepart;
	public static int yDepart;
	public static int width;
	public static int height;

	ImageIcon iAvionShield = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-shield.png"));
	ImageIcon iAvionGaucheShield = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-gauche-shield.png"));
	ImageIcon iAvionDroiteShield = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-droite-shield.png"));

	public Bouclier(Avion vAvion) {

		this.avion = vAvion;
		Random r = new Random();
		xDepart = r.nextInt((690 - 30) + 1);
		yDepart = 0;
		width = 40;
		height = 40;

		mepImage("/cda/poo/images/powerUpShield.png");
		timerBouclier("/cda/poo/music/bouclier.wav");
	}

	private void timerBouclier(String lien) {

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				if (collision() && isEnabled()) {
					Audio a = new Audio(lien);
//						a.run();

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
//								}
//							}
//						});
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
				setLocation(getX(), getY() + 2);
			}
		};
		timer.schedule(timerTask, 10, 10);
	}

	private void mepImage(String string) {

		setBounds(xDepart, yDepart, width, height);
		setIcon(new ImageIcon(InterfaceJeu.class.getResource(string)));
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	public int getProfondeurY() {
		return yDepart + height;
	}

	public int getProfondeurX() {
		return xDepart + width;
	}

	public Rectangle bounds() {
		return (new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

	public boolean collision() {

		int avionX = avion.getX();
		int avionY = avion.getY();
		int avionW = avion.getWidth();
		int avionH = avion.getHeight();

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
