package cda.poo.objects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;

public class MeteoriteGlace extends Meteorite {
	public MeteoriteGlace() {

		Random r = new Random();
		int posXAleatoire = r.nextInt((500 - 100) + 1);

		setBounds(posXAleatoire, 0, 40, 31);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/meteorite-glace.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				setLocation(getX(), getY() + 1);

			}
		};

		timer.schedule(timerTask, 20, 20);

	}
}
