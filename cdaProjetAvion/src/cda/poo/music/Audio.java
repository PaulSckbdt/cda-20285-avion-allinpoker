package cda.poo.music;

import java.io.File;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import cda.poo.objects.Avion;

public class Audio {

	public String lienSon;

	public Audio(String chemin) {
		this.lienSon = chemin;
		
		try {
			URL defaultSound = getClass().getResource(lienSon);
			File soundFile = new File(defaultSound.toURI());
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
			Timer timerVie = new Timer();
			TimerTask taskVie = new TimerTask() {
				@Override
				public void run() {
					if (Avion.getNombreVie() < 1) {
						clip.stop();
						timerVie.cancel();
					}
				}
			};
			timerVie.schedule(taskVie, 100, 100);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

}
