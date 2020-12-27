package cda.poo.music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

	public static void main(String[] args) {

		playSound();
	}

	public static void playSound() {
		
		try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(
            		"/cda-20285-avion-allinpoker/cdaProjetAvion/src/cda/poo/music/Gold.wav"));
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
	}
//	public static synchronized void playSound() {
//		new Thread(new Runnable() {
//			// The wrapper thread is unnecessary, unless it blocks on the
//			// Clip finishing; see comments.
//			public void run() {
//				try {
//					Clip clip = AudioSystem.getClip();
//					AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream(
//							"/cda-20285-avion-allinpoker/cdaProjetAvion/src/cda/poo/music/Gold.wav"));
//					clip.open(inputStream);
//					clip.start();
//				} catch (Exception e) {
//					System.err.println(e.getMessage());
//				}
//			}
//		}).start();
//	}
}
