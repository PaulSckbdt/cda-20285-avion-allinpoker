package cda.poo.objects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cda.poo.meteor.Meteorite;
import cda.poo.meteor.MeteoriteFeu;
import cda.poo.meteor.MeteoriteGlace;
import cda.poo.meteor.MeteoriteIceberg;
import cda.poo.meteor.MeteoriteZigZag;

public class Avion extends JLabel {

	public final static int nombreVieInit = 5;
	public static int nombreVie = nombreVieInit;
	public static boolean isAlive = true;
	ImageIcon iAvion = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion.png"));

	public static JLabel vAvion;

	public Avion() {
		setIcon(iAvion);
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