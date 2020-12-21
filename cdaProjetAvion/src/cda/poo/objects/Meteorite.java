package cda.poo.objects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;

public class Meteorite extends JLabel {

	public Meteorite() {

		Random r = new Random();
		int posXAleatoire = r.nextInt((500 - 100) + 1);

		setBounds(posXAleatoire, 0, 30, 23);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/meteorite.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				setLocation(getX(), getY() + 1);

			}
		};

		timer.schedule(timerTask, 15, 15);

	}

}
