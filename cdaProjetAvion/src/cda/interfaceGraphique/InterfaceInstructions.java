package cda.interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class InterfaceInstructions {

	private JFrame frame;
	private JLabel page1;
	private JLabel page2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceInstructions window = new InterfaceInstructions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceInstructions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 750);

		frame.getContentPane().setLayout(null);

		JButton bouttonRetour = new JButton("Retour");
		bouttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		JButton BouttonPrecedent = new JButton("Pr\u00E9c\u00E9dent");
		BouttonPrecedent.setBackground(Color.LIGHT_GRAY);
		BouttonPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				page1.setVisible(true);
				page2.setVisible(false);
			}
		});
		BouttonPrecedent.setBounds(328, 20, 148, 55);
		frame.getContentPane().add(BouttonPrecedent);

		JButton BouttonSuivant = new JButton("Suivant");
		BouttonSuivant.setBackground(Color.LIGHT_GRAY);
		BouttonSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				page1.setVisible(false);
				page2.setVisible(true);
			}
		});
		BouttonSuivant.setBounds(486, 20, 148, 55);
		frame.getContentPane().add(BouttonSuivant);
		bouttonRetour.setBackground(Color.LIGHT_GRAY);
		bouttonRetour.setForeground(Color.BLACK);
		bouttonRetour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonRetour.setBounds(10, 10, 148, 70);
		frame.getContentPane().add(bouttonRetour);

		JLabel labelFondMenuDemarrerP1 = new JLabel("");
		labelFondMenuDemarrerP1.setHorizontalAlignment(SwingConstants.TRAILING);
		labelFondMenuDemarrerP1.setVerticalAlignment(SwingConstants.TOP);
		labelFondMenuDemarrerP1.setIcon(
				new ImageIcon(InterfaceInstructions.class.getResource("/cda/poo/images/fondMenuInstructionsP1.png")));
		labelFondMenuDemarrerP1.setBounds(0, 0, 634, 711);
		frame.getContentPane().add(labelFondMenuDemarrerP1);
		page1 = labelFondMenuDemarrerP1;

		JLabel labelFondMenuDemarrerP2 = new JLabel("");
		labelFondMenuDemarrerP2.setIcon(
				new ImageIcon(InterfaceInstructions.class.getResource("/cda/poo/images/fondMenuInstructionsP2.jpg")));
		labelFondMenuDemarrerP2.setBounds(0, 0, 634, 711);
		frame.getContentPane().add(labelFondMenuDemarrerP2);
		page2 = labelFondMenuDemarrerP2;
	}

}
