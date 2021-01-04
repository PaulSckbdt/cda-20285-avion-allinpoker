package cda.poo.music;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioGameOver {

	public AudioGameOver() {

		try {
			URL defaultSound2 = getClass().getResource("/cda/poo/music/gameOver.wav");
			File soundFileGameOver = new File(defaultSound2.toURI());
			AudioInputStream audioInputStreamGameOver = AudioSystem.getAudioInputStream(soundFileGameOver);
			Clip clipGameOver = AudioSystem.getClip();
			clipGameOver.open(audioInputStreamGameOver);
			clipGameOver.start();
		} catch (Exception ex) {
		}
	}
}
