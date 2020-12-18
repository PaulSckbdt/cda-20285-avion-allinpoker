package cda.interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		contentPane.add(bouttonQuitterOui);

		JButton bouttonQuitterNon = new JButton("Non");
		bouttonQuitterNon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vFrame.setVisible(false);
			}
		});
		bouttonQuitterNon.setFont(new Font("Times New Roman", Font.BOLD, 26));
		bouttonQuitterNon.setBackground(Color.LIGHT_GRAY);
		bouttonQuitterNon.setBounds(386, 133, 180, 71);
		contentPane.add(bouttonQuitterNon);

		JLabel quitter = new JLabel("        Voulez-vous vraiment quitter ?");
		quitter.setForeground(new Color(255, 255, 240));
		quitter.setFont(new Font("Times New Roman", Font.BOLD, 29));
		quitter.setBounds(70, 11, 496, 71);
		contentPane.add(quitter);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfaceQuitter.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		lblNewLabel.setBounds(0, 0, 634, 261);
		contentPane.add(lblNewLabel);
	}
}
