package cda.poo.objects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cda.interfaceGraphique.InterfaceJeu;

public class FondAleatoire {

	public JLabel jlabel;

	public FondAleatoire(JLabel jlabel) {

		this.jlabel = jlabel;

		if (GestionDifficulte.getNiveau() == 1) {

			jlabel.setIcon(
					new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/fond etoile/fondEtoileNiveau1.gif")));

		} else if (GestionDifficulte.getNiveau() == 2) {

			jlabel.setIcon(
					new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/fond etoile/fondEtoileNiveau2.gif")));

		} else if (GestionDifficulte.getNiveau() == 3) {

			jlabel.setIcon(
					new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/fond etoile/fondEtoileNiveau3.gif")));

		} else if (GestionDifficulte.getNiveau() == 4) {

			jlabel.setIcon(
					new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/fond etoile/fondEtoileNiveau4.gif")));

		} else if (GestionDifficulte.getNiveau() == 5) {

			jlabel.setIcon(
					new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/fond etoile/fondEtoileNiveau5.gif")));
		}
	}
}
