package cda.poo.objects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cda.poo.meteor.Meteorite;
import cda.poo.meteor.MeteoriteFeu;
import cda.poo.meteor.MeteoriteGlace;
import cda.poo.meteor.MeteoriteIceberg;
import cda.poo.meteor.MeteoriteZigZag;
import cda.poo.meteor.Score;

public class SpawnMeteor extends Thread {
	private static JFrame frame;
	private static JLabel fondEcran;
	private int difficulte;
	private static GestionDifficulte gestionDiff = new GestionDifficulte();

	public SpawnMeteor(JFrame vFrame, JLabel vFondEcran) {

		SpawnMeteor.frame = vFrame;
		SpawnMeteor.fondEcran = vFondEcran;
	}

	@Override
	public void run() {

		while (true) {

			Random r = new Random();
			int typeMeteorite = r.nextInt(4);

			System.out.println(Score.getScoreMeteor());

			switch (typeMeteorite) {
			case 0:
				Meteorite meteorBasic = new Meteorite();
				frame.getContentPane().add(meteorBasic).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);

				break;

			case 1:
				MeteoriteFeu meteorFeu = new MeteoriteFeu();
				frame.getContentPane().add(meteorFeu).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);

				break;

			case 2:
				MeteoriteGlace meteorGlace = new MeteoriteGlace();
				frame.getContentPane().add(meteorGlace).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);

				break;

			case 3:
				MeteoriteZigZag meteorZigZag = new MeteoriteZigZag();
				frame.getContentPane().add(meteorZigZag).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);

				break;

			case 4:
				MeteoriteIceberg meteorIceberg = new MeteoriteIceberg();
				frame.getContentPane().add(meteorIceberg).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);

				break;

			}

			try {

				Thread.sleep(GestionDifficulte.getDifficulte());
				System.out.println(GestionDifficulte.getDifficulte());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	};

}
