package cda.poo.objects;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cda.poo.meteor.Bouclier;

public class Avion extends JLabel {

	public final static int nombreVieInit = 5;
	public static int nombreVie = nombreVieInit;
	public static boolean isAlive = true;
	public static ImageIcon iAvion = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion.png"));
	public static ImageIcon iAvionGauche = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-gauche.png"));
	public static ImageIcon iAvionDroite = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-droite.png"));
	public static ImageIcon iAvionUp = new ImageIcon(Avion.class.getResource("/cda/poo/images/avionUp.png"));
	public static ImageIcon iAvionShield = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion-shield.png"));
	public static ImageIcon iAvionShieldGauche = new ImageIcon(
			Avion.class.getResource("/cda/poo/images/avion-gauche-shield.png"));
	public static ImageIcon iAvionShieldDroite = new ImageIcon(
			Avion.class.getResource("/cda/poo/images/avion-droite-shield.png"));
	public static JLabel vAvion;

	public Avion() {

		Timer bouclier = new Timer();
		bouclier.schedule(new TimerTask() {

			@Override
			public void run() {
				if (Bouclier.bouclierActived) {
					setIcon(iAvionShield);
				} else {
					setIcon(iAvion);

				}
			}
		}, 100, 100);

		setBounds(260, 600, 60, 60);
		setVisible(true);
	}

	public static int getNombreVie() {
		return nombreVie;
	}

	public static void setNombreVie(int nombreVie) {
		Avion.nombreVie = nombreVie;
	}

	public void activationBouclier() throws InterruptedException {
		Thread.sleep(10000);
	}

	public static void setAlive(boolean isAlive) {
		Avion.isAlive = isAlive;
	}

	public Rectangle bounds() {
		return (new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

}