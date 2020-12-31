package keyListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cda.interfaceGraphique.InterfaceJeu;
import cda.poo.meteor.Bouclier;
import cda.poo.meteor.Missile;
import cda.poo.music.Audio;
import cda.poo.objects.Avion;

public class Keylistener implements KeyListener {

	public Keylistener() {
		
		InterfaceJeu.frame.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && 200 < InterfaceJeu.vMonAvion.getY()
				&& Bouclier.bouclierActived == false) {
			InterfaceJeu.vMonAvion.setLocation(InterfaceJeu.vMonAvion.getX(), InterfaceJeu.vMonAvion.getY() - 15);
			InterfaceJeu.vMonAvion.setIcon(Avion.iAvionUp);
			InterfaceJeu.vMonAvion.setVisible(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && 651 > InterfaceJeu.vMonAvion.getY()
				&& Bouclier.bouclierActived == false) {
			InterfaceJeu.vMonAvion.setLocation(InterfaceJeu.vMonAvion.getX(), InterfaceJeu.vMonAvion.getY() + 15);
			InterfaceJeu.vMonAvion.setIcon(Avion.iAvion);
			InterfaceJeu.vMonAvion.setVisible(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && 0 < InterfaceJeu.vMonAvion.getX()
				&& Bouclier.bouclierActived == false) {
			InterfaceJeu.vMonAvion.setLocation(InterfaceJeu.vMonAvion.getX() - 15, InterfaceJeu.vMonAvion.getY());
			InterfaceJeu.vMonAvion.setIcon(Avion.iAvionGauche);
			InterfaceJeu.vMonAvion.setVisible(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && 574 > InterfaceJeu.vMonAvion.getX()
				&& Bouclier.bouclierActived == false) {
			InterfaceJeu.vMonAvion.setLocation(InterfaceJeu.vMonAvion.getX() + 15, InterfaceJeu.vMonAvion.getY());
			InterfaceJeu.vMonAvion.setIcon(Avion.iAvionDroite);
			InterfaceJeu.vMonAvion.setVisible(true);
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE && 200 < InterfaceJeu.vMonAvion.getY()
				&& Missile.shootingActivated == true) {
			InterfaceJeu.labelTirAvion.setLocation(InterfaceJeu.vMonAvion.getX(), InterfaceJeu.vMonAvion.getY() - 240);
			InterfaceJeu.labelTirAvion.setVisible(true);
			new Audio("/cda/poo/music/tirCut.wav");
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					InterfaceJeu.labelTirAvion.setVisible(false);
				}
			}, 270);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT
				|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
			InterfaceJeu.vMonAvion.setIcon(Avion.iAvion);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
