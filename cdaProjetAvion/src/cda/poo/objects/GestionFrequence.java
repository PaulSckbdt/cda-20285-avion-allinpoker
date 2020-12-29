package cda.poo.objects;

import java.util.Timer;
import java.util.TimerTask;

public class GestionFrequence {
	private static int frequence = 25000;

	Timer timerFrequence = new Timer();
	TimerTask taskFrequence = new TimerTask() {

		@Override
		public void run() {
			if (GestionFrequence.getFrequence() > 100) {
				setFrequence(getFrequence() - 100);
			} else {

				setFrequence(100);
			}
		}
	};

	public GestionFrequence() {

		timerFrequence.schedule(taskFrequence, 14000, 14000);

	}

	public static int getFrequence() {
		return frequence;
	}

	public static void setFrequence(int frequence) {
		GestionFrequence.frequence = frequence;
	}

}
