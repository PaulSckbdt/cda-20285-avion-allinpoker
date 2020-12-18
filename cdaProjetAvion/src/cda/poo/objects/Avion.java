package cda.poo.objects;

public class Avion {

	private final String NAME = "PEGASUS";
	private final int nombreVieInit = 5;
	private int nombreVie = nombreVieInit;
	private int x, y;
	private boolean isAlive = true;

	public Avion() {
	}
	
	public int getPositionX() {
		return this.x;
	}

	public int getPositionY() {
		return this.y;
	}

	public void setPosition(int pX, int pY) {
		this.x += pX;
		this.y += pY;
	}

	public int getNombreVie() {
		return nombreVie;
	}

	public void setNombreVie(int degat) {
		this.nombreVie -= degat;
		if (nombreVie == 0) {
			setAlive(false);
		}
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}