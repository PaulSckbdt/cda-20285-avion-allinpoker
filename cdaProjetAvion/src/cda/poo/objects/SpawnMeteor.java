package cda.poo.objects;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cda.poo.meteor.Meteorite;
import cda.poo.meteor.MeteoriteFeu;
import cda.poo.meteor.MeteoriteGlace;
import cda.poo.meteor.MeteoriteIceberg;
import cda.poo.meteor.MeteoriteZigZag;
import cda.poo.meteor.Score;

public class SpawnMeteor extends Thread {
	public static JFrame frame;
	public static JLabel fondEcran;
	public static int niveauDifficulte;
	public Avion avion;
	public static boolean doSpawn = true;

	public static void setDoSpawn(boolean doSpawn) {
		SpawnMeteor.doSpawn = doSpawn;
	}

	public SpawnMeteor(JFrame vFrame, JLabel vFondEcran, Avion vAvion) {

		avion = vAvion;
		SpawnMeteor.frame = vFrame;
		SpawnMeteor.fondEcran = vFondEcran;
	}

	@Override
	public void run() {

		while (doSpawn) {
			
			int level1 = 0;
			int level2 = new Random().nextInt(1);
			int level3 = new Random().nextInt(2);
			int level4 = new Random().nextInt(3);
			int level5 = new Random().nextInt(4);

			if (Score.getScoreMeteor() < 10) {
				setDifficulte(1);
				switch (level1) {
				case 0:
					Meteorite meteorBasic = new Meteorite(avion);
					frame.getContentPane().add(meteorBasic).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				}
			}

			if (Score.getScoreMeteor() > 10 && Score.getScoreMeteor() < 20) {
				setDifficulte(2);
				switch (level2) {
				
				case 0:
					Meteorite meteorBasic = new Meteorite(avion);
					frame.getContentPane().add(meteorBasic).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				case 1:
					MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
					frame.getContentPane().add(meteorFeu).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				}
			}

			if (Score.getScoreMeteor() > 20 && Score.getScoreMeteor() < 30) {
				setDifficulte(3);
				switch (level3) {
				case 0:
					Meteorite meteorBasic = new Meteorite(avion);
					frame.getContentPane().add(meteorBasic).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				case 1:
					MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
					frame.getContentPane().add(meteorFeu).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				case 2:
					MeteoriteGlace meteorGlace = new MeteoriteGlace(avion);
					frame.getContentPane().add(meteorGlace).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				}
			}

			if (Score.getScoreMeteor() > 30 && Score.getScoreMeteor() < 40) {
				setDifficulte(4);
				switch (level4) {
				case 0:
					Meteorite meteorBasic = new Meteorite(avion);
					frame.getContentPane().add(meteorBasic).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				case 1:
					MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
					frame.getContentPane().add(meteorFeu).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				case 2:
					MeteoriteGlace meteorGlace = new MeteoriteGlace(avion);
					frame.getContentPane().add(meteorGlace).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				case 3:
					MeteoriteZigZag meteorZigZag = new MeteoriteZigZag(avion);
					frame.getContentPane().add(meteorZigZag).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				}
			}

			if (Score.getScoreMeteor() > 40) {
				setDifficulte(5);
				switch (level5) {
				case 0:
					Meteorite meteorBasic = new Meteorite(avion);
					frame.getContentPane().add(meteorBasic).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);

				case 1:
					MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
					frame.getContentPane().add(meteorFeu).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);

				case 2:
					MeteoriteGlace meteorGlace = new MeteoriteGlace(avion);
					frame.getContentPane().add(meteorGlace).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);

				case 3:
					MeteoriteZigZag meteorZigZag = new MeteoriteZigZag(avion);
					frame.getContentPane().add(meteorZigZag).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);

				case 4:
					MeteoriteIceberg meteorIceberg = new MeteoriteIceberg(avion);
					frame.getContentPane().add(meteorIceberg).setVisible(true);
					frame.getContentPane().add(fondEcran).setVisible(true);
				}
			}

			try {
				if (Score.getScoreMeteor() < 10) {
					Thread.sleep(1000);
				}
				if (Score.getScoreMeteor() > 10 && Score.getScoreMeteor() < 20) {
					Thread.sleep(1500);
				}
				if (Score.getScoreMeteor() > 20 && Score.getScoreMeteor() < 30) {
					Thread.sleep(2000);
				}
				if (Score.getScoreMeteor() > 30 && Score.getScoreMeteor() < 40) {
					Thread.sleep(2500);
				}
				if (Score.getScoreMeteor() > 40 && Score.getScoreMeteor() < 50) {
					Thread.sleep(3000);
				}
				if (Score.getScoreMeteor() > 50 && Score.getScoreMeteor() < 60) {
					Thread.sleep(2500);
				}
				if (Score.getScoreMeteor() > 60) {
					Thread.sleep(2000);
				}

			} catch (Exception e) {
			}
		}
	}

	public void setDifficulte(int niveauDifficulte) {
		SpawnMeteor.niveauDifficulte = niveauDifficulte;
	}

}
