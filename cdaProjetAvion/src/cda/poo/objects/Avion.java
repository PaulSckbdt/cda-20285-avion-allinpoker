package cda.poo.objects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cda.interfaceGraphique.InterfaceJeu;

public class Avion extends JLabel {

	private final String nom = "PEGASUS";
	private final int nombreVieInit = 5;

	private int nombreVie = nombreVieInit;
	private int posX; // seul la position lateral nous interesse

	private boolean isAlive = true;
	private boolean isTouch = false;

	private static JLabel vAvion;
	private static ImageIcon avionDroite;
	private static ImageIcon avionGauche;
	private static ImageIcon avion;

	public Avion() {

	}

	public static ImageIcon getAvion() {
		return avion;
	}

	public static void setAvion(ImageIcon avion) {
		Avion.avion = avion;
	}

	public static ImageIcon getAvionGauche() {
		return avionGauche;
	}

	public static void setAvionGauche(ImageIcon avionGauche) {
		Avion.avionGauche = avionGauche;
	}

	public static ImageIcon getAvionDroite() {
		return avionDroite;
	}

	public static void setAvionDroite(ImageIcon avionDroite) {
		Avion.avionDroite = avionDroite;
	}

	public static JLabel getvAvion() {
		return vAvion;
	}

	public int getPositionX() {
		return this.posX;
	}

	public int getNombreVie() {
		return nombreVie;
	}

	public void setNombreVie(int degat) {
		this.nombreVie -= degat;
		if (nombreVie < 1) {
			setAlive(false); // partie terminée
		}
	}

	public void activationBouclier() throws InterruptedException {
		if (this.setTouch(true))
			setNombreVie(0);
		Thread.sleep(10000);
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getNom() {
		return nom;
	}

	public boolean isTouch() {
		return isTouch;
	}

	public boolean setTouch(boolean isTouch) {
		this.isTouch = isTouch;
		return isTouch;
	}
}