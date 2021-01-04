package cda.interfaceGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InterfaceScore {

	private static JFrame frame;


	public static void main(String[] args) {
					new InterfaceScore();
					frame.setVisible(true);
					frame.setResizable(false);
	}

	public InterfaceScore() {
		initialize();
	}

	private static void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 100, 650, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton bouttonRetour = new JButton("Retour");
		bouttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bouttonRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceMenuDemarrer.main(null);
				closeFrame();
			}
		});

		bouttonRetour.setBackground(Color.LIGHT_GRAY);
		bouttonRetour.setForeground(Color.BLACK);
		bouttonRetour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bouttonRetour.setBounds(65, 630, 200, 70);
		frame.getContentPane().add(bouttonRetour);

		JLabel labelFondMenuDemarrer = new JLabel("");
		labelFondMenuDemarrer.setHorizontalAlignment(SwingConstants.LEFT);
		labelFondMenuDemarrer.setVerticalAlignment(SwingConstants.TOP);
		labelFondMenuDemarrer.setIcon(
				new ImageIcon(InterfaceScore.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		labelFondMenuDemarrer.setBounds(0, 0, 634, 711);
		frame.getContentPane().add(labelFondMenuDemarrer);
	}
	
	public static void closeFrame() {
		frame.setVisible(false);
		frame.dispose();
	}
}
