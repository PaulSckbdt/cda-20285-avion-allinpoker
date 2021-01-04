package cda.poo.json;

import java.io.FileWriter;
import java.io.IOException;

import cda.interfaceGraphique.InterfaceSaisieNom;
import cda.json.JSONException;
import cda.json.JSONObject;
import cda.poo.meteor.Score;
import cda.poo.objects.Joueur;

public class JsonTools {

	public static Joueur j;

	public static void main(String[] args) {

	}

	public static void jsonWrite() {

		String nomFichier = "scores.json";
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put("date", DateTools.getDate());
			jsonObject.put("score", Score.getScoreMeteor());
			jsonObject.put("name", InterfaceSaisieNom.getJoueurActuel());

			FileWriter file = new FileWriter(nomFichier, true);

			file.write(jsonObject.toString());
			file.close();

		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
