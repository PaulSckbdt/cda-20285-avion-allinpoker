package cda.poo.objects;

public class Joueur {

	public static String nom;

	public Joueur(String vNom) {
		this.nom = vNom;
	}

	public String getNom() {
		return nom;
	}

	public static void setNom(String nom) {
		Joueur.nom = nom;
	}

}
