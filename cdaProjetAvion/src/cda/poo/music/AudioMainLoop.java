package cda.poo.music;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import cda.poo.objects.Avion;

public class AudioMainLoop implements Runnable {


	@Override
	public void run() {
		try {

			java.net.URL defaultSound = getClass().getResource("/cda/poo/music/musicFond.wav");
			File soundFile = new File(defaultSound.toURI());
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}