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

public class MeteoriteFeu extends Score {
	public Avion avion;
	public static int x;
	public static int y;
	public static int width;
	public static int height;

	public MeteoriteFeu(Avion vAvion) {

		this.avion = vAvion;

		Random r = new Random();

		x = r.nextInt((680 - 40) + 1);
		y = 0;
		width = 50;
		height = 39;

		setBounds(x, y, width, height);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/meteorite-feu.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				if (collision()) {
					Audio a = new Audio("/cda/poo/music/collision.wav");

					if (isEnabled()) {
						Avion.setNombreVie(Avion.getNombreVie() - 2);
						a.run();
						setEnabled(false);

					}
				}

				setLocation(getX(), getY() + 1);
				if (getY() == 715 && isEnabled()) {
					Score.setScoreMeteor(Score.getScoreMeteor() + 1);
				}
			}
		};

		timer.schedule(timerTask, 12, 12);

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

//		box2 : météorite
		int meteoriteX = getX();
		int meteoriteY = getY();
		int meteoriteW = getWidth();
		int meteoriteH = getHeight();

		// trop à droite
		boolean droite = meteoriteX >= avionX + avionW;
		// trop à gauche
		boolean gauche = meteoriteX + meteoriteW <= avionX;
		// trop à bas
		boolean bas = meteoriteY >= avionY + avionH;
		// trop à haut
		boolean haut = meteoriteY + meteoriteH <= avionY;

		if ((droite) || (gauche) || (bas) || (haut)) {
			return false;
		} else {
			return true;
		}

	}
}
