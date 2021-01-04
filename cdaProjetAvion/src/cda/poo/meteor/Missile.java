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

public class Missile extends Score {
	public Avion avion;

	public static int xDepart;
	public static int yDepart;
	public static int width;
	public static int height;
	public static boolean shootingActivated = false;
	public static int nbShoot;
	public static ImageIcon iExplosion = new ImageIcon(Avion.class.getResource("/cda/poo/images/explosion.gif"));

	public Missile(Avion vAvion) {

		this.avion = vAvion;
		Random r = new Random();
		xDepart = r.nextInt((690 - 30) + 1);
		yDepart = 0;
		width = 40;
		height = 40;
		mepImage("/cda/poo/images/powerUpBomb.png");
		timerMissile("/cda/poo/music/activation.wav");
	}

	private void timerMissile(String lien) {

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				if (collision() && isEnabled()) {
					shootingActivated = true;
					nbShoot += 3;
					new Audio(lien);
					setEnabled(false);
					setVisible(false);
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

	public Rectangle bounds() {
		return (new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

	public boolean collision() {

		int avionX = avion.getX();
		int avionY = avion.getY();
		int avionW = avion.getWidth();
		int avionH = avion.getHeight();

		int missileX = getX();
		int missileY = getY();
		int missileW = getWidth();
		int missileH = getHeight();

		// trop à droite
		boolean droite = missileX >= avionX + avionW;
		// trop à gauche
		boolean gauche = missileX + missileW <= avionX;
		// trop à bas
		boolean bas = missileY >= avionY + avionH;
		// trop à haut
		boolean haut = missileY + missileH <= avionY;

		if ((droite) || (gauche) || (bas) || (haut)) {
			return false;
		} else {
			return true;
		}

	}
}
