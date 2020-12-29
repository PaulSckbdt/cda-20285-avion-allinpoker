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
	public static int xDepart;
	public static int yDepart;
	public static int width;
	public static int height;

	public MeteoriteFeu(Avion vAvion) {

		this.avion = vAvion;

		xDepart = new Random().nextInt((680 - 40) + 1);
		yDepart = 0;
		width = 50;
		height = 39;

		mepImage("/cda/poo/images/meteorite-feu.png");
		timerMeteoriteFeu("/cda/poo/music/collision.wav");

	}

	public int getProfondeurY() {
		return yDepart + height;
	}

	public int getProfondeurX() {
		return xDepart + width;
	}

	public int getXX() {
		return getX();

	}

	public void timerMeteoriteFeu(String lien) {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				if (collision() && isEnabled()) {
						new Audio(lien);
						Avion.setNombreVie(Avion.getNombreVie() - 1);
						setEnabled(false);
				}
				setLocation(getX(), getY() + 1);
				if (getY() == 715 && isEnabled()) {
					Score.setScoreMeteor(Score.getScoreMeteor() + 1);
				}
			}
		};
		timer.schedule(timerTask, 12, 12);
	}

	public Rectangle bounds() {
		return (new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

	public void mepImage(String lien) {

		setBounds(xDepart, yDepart, width, height);
		setIcon(new ImageIcon(InterfaceJeu.class.getResource(lien)));
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	public boolean collision() {

		int avionX = avion.getX();
		int avionY = avion.getY();
		int avionW = avion.getWidth();
		int avionH = avion.getHeight();

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
