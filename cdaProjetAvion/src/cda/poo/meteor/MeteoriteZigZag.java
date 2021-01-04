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

public class MeteoriteZigZag extends Score {
	private boolean bouge;
	public Avion avion;
	public static int xDepart;
	public static int yDepart;
	public static int width;
	public static int height;

	public MeteoriteZigZag(Avion vAvion) {
		this.avion = vAvion;
		xDepart = new Random().nextInt((680 - 40) + 1);
		yDepart = 0;
		width = 40;
		height = 31;
		mepImage("/cda/poo/images/meteorite-zigzag.png");
		timerMeteoriteZigZag("/cda/poo/music/collision.wav");
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

	public void mepImage(String lien) {
		setBounds(xDepart, yDepart, width, height);
		setIcon(new ImageIcon(InterfaceJeu.class.getResource(lien)));
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void timerMeteoriteZigZag(String lien) {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (collision() && isEnabled() && Bouclier.bouclierActived == false
						&& InterfaceJeu.isShooting == false) {
					new Audio(lien);
					if (InterfaceJeu.isShooting == false) {
						Avion.setNombreVie(Avion.getNombreVie() - 1);
					}
					setEnabled(false);
					setVisible(false);
				}
				if (collision() && isEnabled() && Bouclier.bouclierActived == true) {
					new Audio("/cda/poo/music/pointUp.wav");
					setEnabled(false);
					setVisible(false);

					Bouclier.bouclierActived = false;
				}
				if (collision() && isEnabled() && InterfaceJeu.isShooting == true) {
					new Audio("/cda/poo/music/destruction.wav");
					setIcon(Missile.iExplosion);
					setVisible(true);
					Score.setScoreMeteor(Score.getScoreMeteor() + 5);
					try {
						Thread.sleep(250);
						setEnabled(false);
						setVisible(false);
					} catch (Exception e) {
					}
				}
				setLocation(getX(), getY() + 1);
				if (getY() == 715 && isEnabled()) {
					Score.setScoreMeteor(Score.getScoreMeteor() + 5);
				}
			}
		};
		TimerTask timerBouge = new TimerTask() {
			@Override
			public void run() {
				if (bouge) {
					setLocation(getX() + 50, getY());
					bouge = false;
				} else {
					setLocation(getX() - 50, getY());
					bouge = true;
				}
			}
		};
		timer.schedule(timerTask, 12, 12);
		timer.schedule(timerBouge, 1000, 1000);
	}

	public boolean collision() {
		int avionX = avion.getX();
		int avionY = avion.getY();
		int missileY = 250;
		int avionW = avion.getWidth();
		int avionH = avion.getHeight();
		int meteoriteX = getX();
		int meteoriteY = getY();
		int meteoriteW = getWidth();
		int meteoriteH = getHeight();
		// trop Ã droite
		boolean droite = meteoriteX >= avionX + avionW;
		// trop Ã gauche
		boolean gauche = meteoriteX + meteoriteW <= avionX;
		// trop Ã bas
		boolean bas = meteoriteY >= avionY + avionH;
		// trop Ã haut
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