package cda.poo.objects;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cda.poo.meteor.Bouclier;
import cda.poo.meteor.Missile;

public class SpawnBonus extends Thread {
	public static JFrame frame;
	public static JLabel fondEcran;
	public int frequence;
	public static GestionFrequence gestionFre = new GestionFrequence();
	public Avion avion;

	public SpawnBonus(JFrame vFrame, JLabel vFondEcran, Avion vAvion) {

		avion = vAvion;
		SpawnBonus.frame = vFrame;
		SpawnBonus.fondEcran = vFondEcran;
	}

	@Override
	public void run() {

		while (true) {

			Random r = new Random();
			int typeBonus = r.nextInt(2);
//			int typeMeteorite = 4;
			

			switch (typeBonus) {
			case 0:
				Bouclier bouclier = new Bouclier(avion);
				frame.getContentPane().add(bouclier).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);

				break;

			case 1:
				Missile missile = new Missile(avion);
				frame.getContentPane().add(missile).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);

				break;

			}

			try {

				Thread.sleep(GestionFrequence.getFrequence());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	public static GestionFrequence getGestionFrequence() {
		return gestionFre;
	}

	public static void setGestionFrequence(GestionDifficulte gestionDiff) {
		SpawnMeteor.gestionDiff = gestionDiff;
	};

}