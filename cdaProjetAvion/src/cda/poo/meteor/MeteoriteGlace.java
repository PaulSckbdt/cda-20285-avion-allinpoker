package cda.poo.meteor;

import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;

public class MeteoriteGlace extends Score {

	public int x;
	public int y;
	public int width;
	public int height;

	public MeteoriteGlace() {

		Random r = new Random();

		x = r.nextInt((500 - 100) + 1);
		y = 0;
		width = 40;
		height = 31;

		setBounds(x, y, width, height);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/meteorite-glace.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				setLocation(getX(), getY() + 2);

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
		return (new Rectangle(x, y, width, height));
	}
}
