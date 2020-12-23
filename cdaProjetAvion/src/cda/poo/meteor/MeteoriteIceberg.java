package cda.poo.meteor;

import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cda.interfaceGraphique.InterfaceJeu;

public class MeteoriteIceberg extends Score {

	public int x;
	public int y;
	public int width;
	public int height;

	private boolean bouge;

	public MeteoriteIceberg() {

		Random r = new Random();

		x = r.nextInt((690 - 30) + 1);
		y = 0;
		width = 80;
		height = 31;

		setBounds(x, y, width, height);

		setIcon(new ImageIcon(InterfaceJeu.class.getResource("/cda/poo/images/meteorite-zigzag.png")));
		setHorizontalAlignment(SwingConstants.CENTER);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				setLocation(getX(), getY() + 1);
				if (getY() == 715) {
					this.cancel();
					Score.setScoreMeteor(Score.getScoreMeteor() + 8);
				}
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

		timer.schedule(timerTask, 8, 8);
		timer.schedule(timerBouge, 1000, 1000);

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
