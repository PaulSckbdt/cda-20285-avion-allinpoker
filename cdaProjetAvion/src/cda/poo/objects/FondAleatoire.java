package cda.poo.objects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cda.interfaceGraphique.InterfaceJeu;

public class FondAleatoire {

	public JLabel jlabel;

	public FondAleatoire(JLabel jlabel) {

		this.jlabel = jlabel;

		if (GestionDifficulte.getNiveau() == 1) {

			if (InterfaceJeu.randomFond == 1) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau1.gif")));
			} else if (InterfaceJeu.randomFond == 2) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau1.2.gif")));
			} else if (InterfaceJeu.randomFond == 3) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau1.3.gif")));
			} else if (InterfaceJeu.randomFond == 4) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau1.4.gif")));
			}

		} else if (GestionDifficulte.getNiveau() == 2) {

			if (InterfaceJeu.randomFond == 1) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau2.1.gif")));
			} else if (InterfaceJeu.randomFond == 2) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau2.2.gif")));
			} else if (InterfaceJeu.randomFond == 3) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau2.3.gif")));
			} else if (InterfaceJeu.randomFond == 4) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau2.4.gif")));
			}

		} else if (GestionDifficulte.getNiveau() == 3) {

			if (InterfaceJeu.randomFond == 1) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau3.gif")));
			} else if (InterfaceJeu.randomFond == 2) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau3.1.gif")));
			} else if (InterfaceJeu.randomFond == 3) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau3.2.gif")));
			} else if (InterfaceJeu.randomFond == 4) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau3.3.gif")));
			}

		} else if (GestionDifficulte.getNiveau() == 4) {

			if (InterfaceJeu.randomFond == 1) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau4.gif")));
			} else if (InterfaceJeu.randomFond == 2) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau4.1.gif")));
			} else if (InterfaceJeu.randomFond == 3) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau4.2.gif")));
			} else if (InterfaceJeu.randomFond == 4) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau4.3.gif")));
			}

		} else if (GestionDifficulte.getNiveau() == 5) {

			if (InterfaceJeu.randomFond == 1) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau5.gif")));
			} else if (InterfaceJeu.randomFond == 2) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau5.1.gif")));
			} else if (InterfaceJeu.randomFond == 3) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau5..4.gif")));
			} else if (InterfaceJeu.randomFond == 4) {
				jlabel.setIcon(new ImageIcon(
						InterfaceJeu.class.getResource("/cda/poo/images/fondEtoile/fondEtoileNiveau5.3.gif")));
			}
		}
	}
}
