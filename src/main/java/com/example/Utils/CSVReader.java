package com.example.Utils;

import com.example.Models.Livre;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 📂 Utilitaire pour lire un fichier CSV et charger les livres dans l'application.
 * Le fichier doit être placé dans le dossier **resources**.
 */
public class CSVReader {
    private static final String CSV_FILE = "/livres.csv"; // 📍 Fichier CSV dans resources

    /**
     * 📌 Charge les livres depuis le fichier CSV et les stocke dans une liste.
     * @return Liste des livres lus depuis le fichier CSV.
     */
    public static List<Livre> chargerLivresDepuisCSV() {
        List<Livre> livres = new ArrayList<>();

        try (InputStream inputStream = CSVReader.class.getResourceAsStream(CSV_FILE);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String ligne;
            boolean premiereLigne = true; // Ignorer la première ligne (en-têtes)

            while ((ligne = br.readLine()) != null) {
                if (premiereLigne) { 
                    premiereLigne = false;
                    continue; // Passer l'en-tête
                }

                String[] valeurs = ligne.split(",");

                // Vérifier que la ligne contient bien 7 colonnes (pour éviter les erreurs)
                if (valeurs.length < 7) continue;

                // Extraction et conversion des valeurs
                String isbn = valeurs[0].trim();
                String titre = valeurs[1].trim();
                String auteur = valeurs[2].trim();
                String categorie = valeurs[3].trim();
                double prix = Double.parseDouble(valeurs[4].trim());
                LocalDate datePublication = LocalDate.parse(valeurs[5].trim());
                int quantite = Integer.parseInt(valeurs[6].trim());

                // Création de l'objet Livre et ajout à la liste
                livres.add(new Livre(isbn, titre, auteur, categorie, prix, datePublication, quantite));
            }
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
        return livres;
    }
}
