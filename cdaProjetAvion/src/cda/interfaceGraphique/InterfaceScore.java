package cda.interfaceGraphique;

import java.awt.BorderLayout;
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
import javax.swing.JTable;
import javax.swing.SwingConstants;

import cda.poo.json.JsonTools;

public class InterfaceScore {
	private static JFrame frame;
	private static JTable table;
	private static JLabel textField;
	private static JLabel textField_1;
	private static JLabel textField_2;

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
		
		
		String name = JsonTools.jsonReadName();
		String score = JsonTools.jsonReadScore();
		String date = JsonTools.jsonReadDate();
		String[] entete = { "nom", "score", "date" };
		Object[][] donnees = { { name, score, date }, };
		
		
		
		
		table = new JTable(donnees, entete);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setBounds(65, 77, 513, 513);
		table.setRowHeight(30);
		table.setOpaque(false);
		frame.getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
		frame.getContentPane().add(table);
		textField = new JLabel("NOM");
		textField.setBounds(65, 37, 169, 30);
		textField.setOpaque(true);
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setFont(new Font("sansserif", Font.BOLD, 12));
		frame.getContentPane().add(textField);
		textField_1 = new JLabel("DATE");
		textField_1.setOpaque(true);
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(409, 37, 169, 30);
		textField_1.setFont(new Font("sansserif", Font.BOLD, 12));
		frame.getContentPane().add(textField_1);
		textField_2 = new JLabel("SCORE");
		textField_2.setOpaque(true);
		textField_2.setForeground(Color.WHITE);
		textField_2.setBackground(Color.BLACK);
		textField_2.setFont(new Font("sansserif", Font.BOLD, 12));
		textField_2.setBounds(237, 37, 169, 30);
		frame.getContentPane().add(textField_2);
		JLabel labelFondMenuDemarrer = new JLabel("");
		labelFondMenuDemarrer.setHorizontalAlignment(SwingConstants.LEFT);
		labelFondMenuDemarrer.setVerticalAlignment(SwingConstants.TOP);
		labelFondMenuDemarrer
				.setIcon(new ImageIcon(InterfaceScore.class.getResource("/cda/poo/images/fondMenuDemarrer.jpg")));
		labelFondMenuDemarrer.setBounds(0, 0, 634, 711);
		frame.getContentPane().add(labelFondMenuDemarrer);
	}

	public static void closeFrame() {
		frame.setVisible(false);
		frame.dispose();
	}
}