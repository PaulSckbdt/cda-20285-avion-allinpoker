package cda.poo.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import cda.interfaceGraphique.InterfaceJeu;
import cda.poo.objects.Joueur;

public class JsonTools {

	private static Joueur j;

	public static void main(String[] args) {

	}

//	méthode pour créer ou éditer un fichier .json

	public static void jsonWrite() {

		String nomFichier = "scores.json";

		// Creating a JSONObject object
		JSONObject jsonObject = new JSONObject();
		// Inserting key-value pairs into the json object

		
//		La date
		jsonObject.put("date", DateTools.getDate());
		
//		Le score
		jsonObject.put("score", InterfaceJeu.getScore());
		
//		Le nom
		jsonObject.put("name", InterfaceJeu.getNom());




		try {

			FileWriter file = new FileWriter(nomFichier, true);

			file.write(jsonObject.toJSONString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
