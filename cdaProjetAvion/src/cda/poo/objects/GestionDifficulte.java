package cda.poo.objects;

import java.util.Timer;
import java.util.TimerTask;

public class GestionDifficulte {
	private static int difficulte = 2500;

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

		timerDifficulte.schedule(taskDifficulte, 14000, 14000);

	}

	public static int getDifficulte() {
		return difficulte;
	}

	public static void setDifficulte(int difficulte) {
		GestionDifficulte.difficulte = difficulte;
	}

}
