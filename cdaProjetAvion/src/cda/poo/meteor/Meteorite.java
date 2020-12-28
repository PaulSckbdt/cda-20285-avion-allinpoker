package cda.poo.meteor;

import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;
import cda.poo.objects.Avion;

public class Meteorite extends Score {

	public static int x;
	public static int y;
	public static int width;
	public static int height;

	public Meteorite(Avion avion) {

		Random r = new Random();
		x = r.nextInt((690 - 30) + 1);
		y = 0;
		width = 30;
		height = 23;

		setBounds(x, y, width, height);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/meteorite.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				System.out.println(avion.bounds());
				setLocation(getX(), getY() + 2);

				if (getY() == 710) {
					Score.setScoreMeteor(Score.getScoreMeteor() + 2);
				}
				Avion.collision(avion);

			}
		};

		timer.schedule(timerTask, 10, 10);

	}

	public int getProfondeurY() {
		return y + height;
	}

	public int getProfondeurX() {
		return x + width;
	}

	public Rectangle bounds() {
		return (new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}


}
