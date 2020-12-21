package cda.poo.objects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;

public class MeteoriteFeu extends Meteorite {
	public MeteoriteFeu() {

		Random r = new Random();
		int posXAleatoire = r.nextInt((500 - 100) + 1);

		setBounds(posXAleatoire, 0, 50, 39);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/meteorite-feu.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				setLocation(getX(), getY() + 1);

			}
		};

		timer.schedule(timerTask, 25, 25);

	}
}
