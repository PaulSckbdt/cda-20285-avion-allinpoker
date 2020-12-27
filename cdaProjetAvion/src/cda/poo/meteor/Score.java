package cda.poo.meteor;

import javax.swing.JLabel;

public class Score extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int scoreMeteor;

	public static int getScoreMeteor() {
		return scoreMeteor;
	}

	public static void setScoreMeteor(int vScoreMeteor) {
		scoreMeteor = vScoreMeteor;
	}

}
