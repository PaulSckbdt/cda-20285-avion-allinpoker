package cda.poo.music;

import java.io.File;
import java.net.URL;

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
			if (Avion.getNombreVie() > 0) 
				clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
