package cda.poo.objects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;

public class MeteoriteZigZag extends Meteorite {
	private boolean bouge;

	public MeteoriteZigZag() {

		Random r = new Random();
		int posXAleatoire = r.nextInt((500 - 100) + 1);

		setBounds(posXAleatoire, 0, 40, 31);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/meteorite-zigzag.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				setLocation(getX(), getY() + 1);

			}
		};
		TimerTask timerBouge = new TimerTask() {

			@Override
			public void run() {
				if (bouge) {
					setLocation(getX() + 50, getY());
					bouge = false;
				} else {

					setLocation(getX() - 50, getY());
					bouge = true;
				}
			}
		};

		timer.schedule(timerTask, 30, 30);
		timer.schedule(timerBouge, 1000, 1000);

	}
}
