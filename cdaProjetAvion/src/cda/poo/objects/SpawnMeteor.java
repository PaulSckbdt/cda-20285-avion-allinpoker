package cda.poo.objects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import cda.poo.meteor.Meteorite;
import cda.poo.meteor.MeteoriteFeu;
import cda.poo.meteor.MeteoriteGlace;
import cda.poo.meteor.MeteoriteIceberg;
import cda.poo.meteor.MeteoriteZigZag;

public class SpawnMeteor extends Thread {
	private static JFrame frame;

	public SpawnMeteor(JFrame vFrame) {

		SpawnMeteor.frame = vFrame;

	}

	@Override
	public void run() {
		int i = 0;

		while (true) {

			i++;
//			System.out.println(i);
			Random r = new Random();
			int typeMeteorite = r.nextInt(4);
			System.out.println(typeMeteorite);

			switch (typeMeteorite) {
			case 0:
				frame.getContentPane().add(new Meteorite()).setVisible(true);

				break;

			case 1:
				frame.getContentPane().add(new MeteoriteFeu()).setVisible(true);

				break;

			case 2:
				frame.getContentPane().add(new MeteoriteGlace()).setVisible(true);

				break;

			case 3:
				frame.getContentPane().add(new MeteoriteZigZag()).setVisible(true);

				i++;

				break;

			case 4:
				frame.getContentPane().add(new MeteoriteZigZag()).setVisible(true);
				frame.getContentPane().add(new MeteoriteIceberg()).setVisible(true);

				break;

			}

			try {
				Thread.sleep(2000);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	};

}
