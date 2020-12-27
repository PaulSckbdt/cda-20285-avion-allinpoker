package cda.interfaceGraphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfaceQuitter extends JFrame {

	private JPanel contentPane;
	private static InterfaceQuitter vFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceQuitter frame = new InterfaceQuitter();
					frame.setVisible(true);
					frame.setResizable(false);
					vFrame = frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceQuitter() {

		setBounds(600, 350, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// d�but bouttonQuitterOui ***********************************************

		JButton bouttonQuitterOui = new JButton("Oui");
		bouttonQuitterOui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InterfaceMenuDemarrer.closeFrame();
				vFrame.setVisible(false);
			}
		});
		bouttonQuitterOui.setFont(new Font("Times New Roman", Font.BOLD, 26));
		bouttonQuitterOui.setBackground(Color.LIGHT_GRAY);
		bouttonQuitterOui.setBounds(70, 133, 180, 71);
		
		// on ajoute le bouton a la JFrame
		contentPane.add(bouttonQuitterOui);
		
		// Fin bouttonQuitterNon ***********************************************

		JButton bouttonQuitterNon = new JButton("Non");
		bouttonQuitterNon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vFrame.setVisible(false);
				InterfaceMenuDemarrer.main(null);
			}
		});
		bouttonQuitterNon.setFont(new Font("Times New Roman", Font.BOLD, 26));
		bouttonQuitterNon.setBackground(Color.LIGHT_GRAY);
		bouttonQuitterNon.setBounds(386, 133, 180, 71);
		
		// on ajoute le bouton a la JFrame
		contentPane.add(bouttonQuitterNon);
		
		// debut label quitter

		JLabel quitter = new JLabel("        Voulez-vous vraiment quitter ?");
		quitter.setForeground(new Color(255, 255, 240));
		quitter.setFont(new Font("Times New Roman", Font.BOLD, 29));
		quitter.setBounds(70, 11, 496, 71);
		contentPane.add(quitter);
		
		// fin labelFondMenuQuitter ***********************************************
		
		// debut labelFondMenuQuitter qui affiche l'image de fond
		
		JLabel labelFondMenuQuitter = new JLabel("");
		labelFondMenuQuitter.setIcon(new ImageIcon(InterfaceQuitter.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		labelFondMenuQuitter.setBounds(0, 0, 634, 261);
		
		//on ajouter le label contenant l'image de fond au frame
		contentPane.add(labelFondMenuQuitter);
		
		// fin labelFondMenuQuitter ***********************************************
	}
}
