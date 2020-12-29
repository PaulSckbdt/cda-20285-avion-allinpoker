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

	public static int x;
	public static int y;
	public static int width;
	public static int height;

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