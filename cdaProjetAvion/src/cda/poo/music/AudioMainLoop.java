package cda.poo.music;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
			Timer timer = new Timer();
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					if (Avion.getNombreVie() < 1 ) {
						clip.stop();
						timer.cancel();
					}
				}
			};
			timer.schedule(timerTask, 100, 100);
		} catch (Exception e) {
		}
	}
}

//			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//			frame.setVisible(false); //you can't see me!
//			frame.dispose();
//			Arrays.asList(Window.getWindows()).forEach(e -> e.dispose());
//|| InterfaceJeu.game == null