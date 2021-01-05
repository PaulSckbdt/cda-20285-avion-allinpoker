package cda.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cda.interfaceGraphique.InterfaceSaisieNom;
import cda.poo.meteor.Score;

public class JsonTools {
	private static File file;
	private static String nomFichier = "C://Score/scores.json";

	public static void main(String[] args) {
//		String name = jsonReadName();
//		String score = jsonReadScore();
//		String date = jsonReadDate();
//		System.out.println(name);
//		System.out.println(score);
//		System.out.println(date);
	}

	public static void jsonWrite() {
		new File("C:\\Score").mkdir();
		file = new File(nomFichier);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("date", DateTools.getDate());
			jsonObject.put("score", "" + Score.getScoreMeteor());
			jsonObject.put("name", InterfaceSaisieNom.getJoueurActuel());
			FileWriter ecriture = new FileWriter(file, false);
			ecriture.write(jsonObject.toString());
			ecriture.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String jsonReadName() {
		String name = null;
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(nomFichier));
			JSONObject jsonObject = (JSONObject) obj;
			name = (String) jsonObject.get("name");
//			System.out.println(name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return name;
	}

	public static String jsonReadScore() {
		String score = null;
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(nomFichier));
			JSONObject jsonObject = (JSONObject) obj;
			score = (String) jsonObject.get("score");
//			System.out.println(score);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return score;
	}

	public static String jsonReadDate() {
		String date = null;
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(nomFichier));
			JSONObject jsonObject = (JSONObject) obj;
			date = (String) jsonObject.get("date");
//			System.out.println(date);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}