package cda.poo.music;

import java.awt.Window;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import cda.interfaceGraphique.InterfaceGameOver;
import cda.poo.objects.Avion;

public class AudioMainLoop {

	public AudioMainLoop() {

		try {
			URL defaultSound = getClass().getResource("/cda/poo/music/musicFond.wav");
			AudioInputStream audioIn;
			audioIn = AudioSystem.getAudioInputStream(defaultSound);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			Timer timerVie = new Timer();
			TimerTask taskVie = new TimerTask() {
				@Override
				public void run() {
					if (Avion.getNombreVie() < 5) {
						clip.stop();
						timerVie.cancel();
						InterfaceGameOver.main(null);
//						Arrays.asList(Window.getOwnerlessWindows()).forEach(e -> e.dispose());
					}
				}
			};
			timerVie.schedule(taskVie, 100, 100);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
	}
}

//			timerScore.cancel();
//			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//			frame.setVisible(false); //you can't see me!
//			frame.dispose();
//			Arrays.asList(Window.getWindows()).forEach(e -> e.dispose());
