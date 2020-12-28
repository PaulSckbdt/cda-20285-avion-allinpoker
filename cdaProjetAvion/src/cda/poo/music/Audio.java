package cda.poo.music;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import cda.poo.objects.Avion;

public class Audio implements Runnable {

	public String lienSon;

	public Audio(String chemin) {
		this.lienSon = chemin;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			java.net.URL defaultSound = getClass().getResource(lienSon);
			File soundFile = new File(defaultSound.toURI());
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
