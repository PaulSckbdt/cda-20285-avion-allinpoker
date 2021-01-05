package cda.poo.objects;

import java.util.Timer;
import java.util.TimerTask;

public class GestionDifficulte {
	public static int difficulte = 2500;
	public static int niveau = 1;

	Timer timerDifficulte = new Timer();
	TimerTask taskDifficulte = new TimerTask() {

		@Override
		public void run() {
			if (GestionDifficulte.getDifficulte() > 100) {
				setDifficulte(getDifficulte() - 100);
			} else {

				setDifficulte(100);
			}
		}
	};

	public GestionDifficulte() {
		timerDifficulte.schedule(taskDifficulte, 3000, 3000);
	}

	public static int getDifficulte() {
		return difficulte;
	}

	public static int getNiveau() {
		if (GestionDifficulte.difficulte < 2500 && GestionDifficulte.difficulte > 2200) {
			niveau = 1;
		}
		if (GestionDifficulte.difficulte < 2200 && GestionDifficulte.difficulte > 1900) {
			niveau = 2;
		}
		if (GestionDifficulte.difficulte < 1900 && GestionDifficulte.difficulte > 1200) {
			niveau = 3;
		}
		if (GestionDifficulte.difficulte < 1200 && GestionDifficulte.difficulte > 500) {
			niveau = 4;
		}
		if (GestionDifficulte.difficulte < 500 && GestionDifficulte.difficulte >= 100) {
			niveau = 5;
		}
		return niveau;
	}

	public static void setDifficulte(int difficulte) {
		GestionDifficulte.difficulte = difficulte;
	}

}
