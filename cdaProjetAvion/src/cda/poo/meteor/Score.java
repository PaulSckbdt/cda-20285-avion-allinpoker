package cda.poo.meteor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score extends JLabel {

	public Score() {

	}

	public static void spawnMeteor(JFrame frame, Meteorite meteorBasic, MeteoriteFeu meteorFeu,
			MeteoriteGlace meteorGlace, MeteoriteZigZag meteorZigZag, MeteoriteIceberg meteorIceberg) {

		Thread spawn1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Random r = new Random();

				switch (r.nextInt(5)) {
				case 0:
					frame.getContentPane().add(meteorBasic).setVisible(true);
					break;

				case 1:
					frame.getContentPane().add(meteorFeu).setVisible(true);
					break;

				case 2:
					frame.getContentPane().add(meteorGlace).setVisible(true);
					break;

				case 3:
					frame.getContentPane().add(meteorZigZag).setVisible(true);

					break;

				case 4:
					frame.getContentPane().add(meteorIceberg).setVisible(true);
					break;

				}
			}
		});
		spawn1.run();

	}
}
