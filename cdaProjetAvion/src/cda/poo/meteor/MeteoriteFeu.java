package cda.poo.meteor;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;
import cda.poo.music.Audio;
import cda.poo.objects.Avion;
import cda.poo.objects.SpawnMeteor;

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
		Missile.iExplosion.setImage(Missile.iExplosion.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		mepImage("/cda/poo/images/meteorite-feu.png");
		timerMeteoriteFeu("/cda/poo/music/collision.wav");
	}

	public Rectangle bounds() {
		return (new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

	public void mepImage(String lien) {

		setBounds(xDepart, yDepart, width, height);
		setIcon(new ImageIcon(InterfaceJeu.class.getResource(lien)));
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void timerMeteoriteFeu(String lien) {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				if (collision() && isEnabled() && Bouclier.bouclierActived == false
						&& InterfaceJeu.isShooting == false) {
					new Audio(lien);
					if (InterfaceJeu.isShooting == false) {
						Avion.setNombreVie(Avion.getNombreVie() - 2);
					}
					setEnabled(false);
					setVisible(false);
				}
				if (collision() && isEnabled() && Bouclier.bouclierActived == true && InterfaceJeu.isShooting == false ) {
					new Audio("/cda/poo/music/pointUp.wav");
					setEnabled(false);
					setVisible(false);
					Score.setScoreMeteor(Score.getScoreMeteor() + 1);
					Bouclier.bouclierActived = false;
				}

				if (collision() && isEnabled() && InterfaceJeu.isShooting == true) {
					new Audio("/cda/poo/music/destruction.wav");
					Score.setScoreMeteor(Score.getScoreMeteor() + 2);
					setIcon(Missile.iExplosion);
					setVisible(true);
					try {
						Thread.sleep(500);
						setEnabled(false);
						setVisible(false);
					} catch (Exception e) {
					}
				}
				setLocation(getX(), getY() + 1);
				if (getY() == 715 && isEnabled() && SpawnMeteor.doSpawn == true) {
					Score.setScoreMeteor(Score.getScoreMeteor() + 1);
				}
			}
		};
		timer.schedule(timerTask, 12, 12);
	}

	public boolean collision() {

		int avionX = avion.getX();
		int avionY = avion.getY();
		int missileY = 1;
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
		boolean haut;
		if (InterfaceJeu.isShooting == false) {
			haut = meteoriteY + meteoriteH <= avionY;
		} else {
			haut = meteoriteY + meteoriteH <= missileY;
		}

		if ((droite) || (gauche) || (bas) || (haut)) {
			return false;
		} else {
			return true;
		}
	}
}
