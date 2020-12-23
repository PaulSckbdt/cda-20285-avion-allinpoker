package cda.poo.meteor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score extends JLabel {

	private static int scoreMeteor;

	public Score() {

	}

	public static int getScoreMeteor() {
		return scoreMeteor;
	}

	public static void setScoreMeteor(int vScoreMeteor) {
		scoreMeteor = vScoreMeteor;
	}

}
