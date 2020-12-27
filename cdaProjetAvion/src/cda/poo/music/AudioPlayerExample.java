package cda.poo.music;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioPlayerExample implements Runnable {
	
	@Override
	public void run() {
		final int BUFFER_SIZE = 4096;
		try {
			java.net.URL defaultSound = getClass().getResource("/cda/poo/music/Gold.wav");
			File soundFile = new File(defaultSound.toURI());
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = audioStream.getFormat();

			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

			SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);

			audioLine.open(format);

			audioLine.start();

			System.out.println("Playback started.");

			byte[] bytesBuffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
				audioLine.write(bytesBuffer, 0, bytesRead);
			}

			audioLine.drain();
			audioLine.close();
			audioStream.close();

			System.out.println("Playback completed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
