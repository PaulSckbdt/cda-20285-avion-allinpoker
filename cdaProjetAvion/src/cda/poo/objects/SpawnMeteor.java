package cda.poo.objects;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cda.poo.meteor.Meteorite;
import cda.poo.meteor.MeteoriteFeu;
import cda.poo.meteor.MeteoriteGlace;
import cda.poo.meteor.MeteoriteIceberg;
import cda.poo.meteor.MeteoriteZigZag;

public class SpawnMeteor extends Thread {
	public static JFrame frame;
	public static JLabel fondEcran;
	public int difficulte;
	public static GestionDifficulte gestionDiff = new GestionDifficulte();
	public Avion avion;
	public static boolean doSpawn = true;

	public SpawnMeteor(JFrame vFrame, JLabel vFondEcran, Avion vAvion) {

		avion = vAvion;
		SpawnMeteor.frame = vFrame;
		SpawnMeteor.fondEcran = vFondEcran;

	}

	@Override
	public void run() {

		while (doSpawn) {

			int typeMeteorite = new Random().nextInt(5);

			if (GestionDifficulte.difficulte < 2500 && GestionDifficulte.difficulte > 2200) {

				for (int i = 0; i < 3; i++) {

					try {
						Thread.sleep(200);
						Meteorite meteorBasic = new Meteorite(avion);
						frame.getContentPane().add(meteorBasic).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}

			else if (GestionDifficulte.difficulte < 2200 && GestionDifficulte.difficulte > 1900) {
				for (int i = 0; i < 3; i++) {

					try {
						Thread.sleep(200);
						Meteorite meteorBasic = new Meteorite(avion);
						frame.getContentPane().add(meteorBasic).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
						frame.getContentPane().add(meteorFeu).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);
						break;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

			else if (GestionDifficulte.difficulte < 1900 && GestionDifficulte.difficulte > 1200) {
				for (int i = 0; i < 3; i++) {

					try {
						Thread.sleep(200);
						Meteorite meteorBasic = new Meteorite(avion);
						frame.getContentPane().add(meteorBasic).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
						frame.getContentPane().add(meteorFeu).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteGlace meteorGlace = new MeteoriteGlace(avion);
						frame.getContentPane().add(meteorGlace).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);
						break;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

			else if (GestionDifficulte.difficulte < 1200 && GestionDifficulte.difficulte > 500) {
				for (int i = 0; i < 3; i++) {

					try {
						Thread.sleep(200);
						Meteorite meteorBasic = new Meteorite(avion);
						frame.getContentPane().add(meteorBasic).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
						frame.getContentPane().add(meteorFeu).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteGlace meteorGlace = new MeteoriteGlace(avion);
						frame.getContentPane().add(meteorGlace).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteIceberg meteorIceberg = new MeteoriteIceberg(avion);
						frame.getContentPane().add(meteorIceberg).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteZigZag meteorZigZag = new MeteoriteZigZag(avion);
						frame.getContentPane().add(meteorZigZag).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);
						break;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

			else if (GestionDifficulte.difficulte < 500 && GestionDifficulte.difficulte > 100
					|| GestionDifficulte.difficulte == 100) {
				for (int i = 0; i < 8; i++) {

					try {
						Thread.sleep(200);
						Meteorite meteorBasic = new Meteorite(avion);
						frame.getContentPane().add(meteorBasic).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
						frame.getContentPane().add(meteorFeu).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteGlace meteorGlace = new MeteoriteGlace(avion);
						frame.getContentPane().add(meteorGlace).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteIceberg meteorIceberg = new MeteoriteIceberg(avion);
						frame.getContentPane().add(meteorIceberg).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

						MeteoriteZigZag meteorZigZag = new MeteoriteZigZag(avion);
						frame.getContentPane().add(meteorZigZag).setVisible(true);
						frame.getContentPane().add(fondEcran).setVisible(true);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

			switch (typeMeteorite) {

			case 0:
				Meteorite meteorBasic = new Meteorite(avion);
				frame.getContentPane().add(meteorBasic).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);
				break;

			case 1:
				MeteoriteFeu meteorFeu = new MeteoriteFeu(avion);
				frame.getContentPane().add(meteorFeu).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);
				break;

			case 2:
				MeteoriteGlace meteorGlace = new MeteoriteGlace(avion);
				frame.getContentPane().add(meteorGlace).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);
				break;

			case 3:
				MeteoriteZigZag meteorZigZag = new MeteoriteZigZag(avion);
				frame.getContentPane().add(meteorZigZag).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);
				break;

			case 4:
				MeteoriteIceberg meteorIceberg = new MeteoriteIceberg(avion);
				frame.getContentPane().add(meteorIceberg).setVisible(true);
				frame.getContentPane().add(fondEcran).setVisible(true);
				break;
			}

			try {

				Thread.sleep(GestionDifficulte.getDifficulte());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void setDoSpawn(boolean doSpawn) {
		SpawnMeteor.doSpawn = doSpawn;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}

	public static GestionDifficulte getGestionDiff() {
		return gestionDiff;
	}

	public static void setGestionDiff(GestionDifficulte gestionDiff) {
		SpawnMeteor.gestionDiff = gestionDiff;
	};

}
