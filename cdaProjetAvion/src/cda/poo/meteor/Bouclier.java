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
	public static boolean bouclierActived = false;
	public static int bouclierTime = 10000;
	public static ImageIcon iAvionShield = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-shield.png"));

	public Bouclier(Avion vAvion) {

		this.avion = vAvion;
		Random r = new Random();
		xDepart = r.nextInt((690 - 30) + 1);
		yDepart = 0;
		width = 40;
		height = 40;

		mepImage("/cda/poo/images/powerUpShield.png");
		timerBouclier("/cda/poo/music/activation.wav");
	}

	public void timerBouclier(String lien) {

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				setLocation(getX(), getY() + 2);
				if (collision() && isEnabled()) {
					new Audio(lien);
					bouclierActived = true;
					setEnabled(false);
					setVisible(false);

				}

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
