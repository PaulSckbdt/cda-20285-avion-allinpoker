package cda.poo.objects;

public class Avion {

	private final String nom = "PEGASUS";
	private final int nombreVieInit = 5;

	private int nombreVie = nombreVieInit;
	private int posX; // seul la position lateral nous interesse

	private boolean isAlive = true;
	private boolean isTouch = false;

	public Avion() {
	}

	public int getPositionX() {
		return this.posX;
	}

	public void turnRight() {
		this.posX += 20;
	}

	public void turnLeft() {
		this.posX -= 20;
	}

	public int getNombreVie() {
		return nombreVie;
	}

	public void setNombreVie(int degat) {
		this.nombreVie -= degat;
		if (nombreVie < 1) {
			setAlive(false); //partie terminée
		}
	}

	public void activationBouclier() throws InterruptedException {
		if (this.isTouch = true)
			setNombreVie(0);
		Thread.sleep(10000);
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}