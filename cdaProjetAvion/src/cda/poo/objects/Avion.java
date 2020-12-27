package cda.poo.objects;

<<<<<<< HEAD
import java.awt.Rectangle;

import javax.swing.ImageIcon;
=======
>>>>>>> 938c89e... fix score
import javax.swing.JLabel;

public class Avion extends JLabel {

<<<<<<< HEAD
	public final String nom = "PEGASUS";
	public final int nombreVieInit = 5;
	public int nombreVie = nombreVieInit;
	public int x = 260; 
	public int y = 600;
	public int width = 60;
	public int height = 60;
	public boolean isAlive = true;
	public boolean isTouch = false;
	ImageIcon iAvion = new ImageIcon(Avion.class.getResource("/cda/poo/images/avion.png"));
	
	public static JLabel vAvion;

	public Avion() {
		setBounds(x, y, width, height);
		setIcon(iAvion);
		setVisible(true);
=======
	private final String nom = "PEGASUS";
	private final int nombreVieInit = 5;

	private int nombreVie = nombreVieInit;
	private int posX; // seul la position lateral nous interesse

	private boolean isAlive = true;
	private boolean isTouch = false;

	private static JLabel vAvion;

	public Avion() {

	}

	public int getPositionX() {
		return this.posX;
>>>>>>> 938c89e... fix score
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

	public int getProfondeurY() {
		return y + height;
	}

	public int getProfondeurX() {
		return x + width;
	}

	public Rectangle bounds() {
		return (new Rectangle(x, y, width, height));
	}
}