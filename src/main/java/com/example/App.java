package com.example;

import com.example.Models.Inventaire;
import com.example.Models.Livre;
import com.example.Utils.CSVReader;

import java.util.List;
import java.util.Scanner;

/**
 * 🏛️ Classe principale de l'application de gestion de librairie.
 * Permet aux employés et aux clients de rechercher et d'organiser les livres.
 */
public class App {
    public static void main(String[] args) {
        // 📌 Initialisation de l'inventaire et chargement des livres
        Inventaire inventaire = new Inventaire();
        List<Livre> livres = CSVReader.chargerLivresDepuisCSV();

        if (livres.isEmpty()) {
            System.out.println("❌ Aucun livre n'a été chargé. Vérifiez le fichier CSV.");
            return;
        }

        // Ajouter les livres dans l'inventaire
        for (Livre livre : livres) {
            inventaire.ajouterLivre(livre);
        }

        // 📌 Interface utilisateur
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            afficherMenuPrincipal();
            choix = getIntInput(scanner, "🟢 Votre choix : ");

            switch (choix) {
                case 1 -> afficherMenuEmploye(scanner, inventaire);
                case 2 -> afficherMenuClient(scanner, inventaire);
                case 0 -> System.out.println("👋 Merci d'avoir utilisé l'application !");
                default -> System.out.println("❌ Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);

        scanner.close();
    }

    /**
     * 📌 Affiche le menu principal.
     */
    private static void afficherMenuPrincipal() {
        System.out.println("\n📚 **MENU PRINCIPAL**");
        System.out.println("1️⃣ - Mode Employé (Organisation de la librairie)");
        System.out.println("2️⃣ - Mode Client (Recherche de livres)");
        System.out.println("0️⃣ - Quitter");
    }

    /**
     * 📌 Gère le menu Employé.
     */
    private static void afficherMenuEmploye(Scanner scanner, Inventaire inventaire) {
        int choix;
        do {
            System.out.println("\n📋 **MENU EMPLOYÉ**");
            System.out.println("1️⃣ - Afficher tous les livres");
            System.out.println("2️⃣ - Trier les livres par catégorie");
            System.out.println("3️⃣ - Trier les livres par auteur");
            System.out.println("4️⃣ - Trier les livres par titre");
            System.out.println("5️⃣ - Afficher les livres en rupture de stock");
            System.out.println("0️⃣ - Retour au menu principal");

            choix = getIntInput(scanner, "🟢 Votre choix : ");

            switch (choix) {
                case 1 -> inventaire.afficherTousLesLivres();
                case 2 -> inventaire.afficherLivresTriesParCategorie();
                case 3 -> inventaire.afficherLivresTriesParAuteur();
                case 4 -> inventaire.afficherLivresTriesParTitre();
                case 5 -> afficherLivresRupture(inventaire);
                case 0 -> System.out.println("🔙 Retour au menu principal...");
                default -> System.out.println("❌ Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }

    /**
     * 📌 Gère le menu Client.
     */
    private static void afficherMenuClient(Scanner scanner, Inventaire inventaire) {
        int choix;
        do {
            System.out.println("\n🛒 **MENU CLIENT**");
            System.out.println("1️⃣ - Rechercher un livre par titre");
            System.out.println("2️⃣ - Rechercher un livre par auteur");
            System.out.println("3️⃣ - Rechercher un livre par catégorie");
            System.out.println("4️⃣ - Trouver les livres d’un auteur dont le titre commence par des lettres données");
            System.out.println("5️⃣ - Trouver les livres d’un auteur par date de publication (du plus récent au plus ancien)");
            System.out.println("6️⃣ - Trouver les livres d’une catégorie dans un intervalle de prix");
            System.out.println("0️⃣ - Retour au menu principal");

            choix = getIntInput(scanner, "🟢 Votre choix : ");

            switch (choix) {
                case 1 -> rechercherParTitre(scanner, inventaire);
                case 2 -> rechercherParAuteur(scanner, inventaire);
                case 3 -> rechercherParCategorie(scanner, inventaire);
                case 4 -> rechercherParTitreDebutAuteur(scanner, inventaire);
                case 5 -> rechercherParAuteurParDate(scanner, inventaire);
                case 6 -> rechercherParPrix(scanner, inventaire);
                case 0 -> System.out.println("🔙 Retour au menu principal...");
                default -> System.out.println("❌ Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }

    /**
     * 📌 Vérifie et récupère une entrée utilisateur de type entier.
     */
    private static int getIntInput(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Entrée invalide. Veuillez entrer un **nombre** : ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    /**
     * 🔍 Recherche un livre par titre.
     */
    private static void rechercherParTitre(Scanner scanner, Inventaire inventaire) {
        System.out.print("🔍 Entrez un titre à rechercher : ");
        String titre = scanner.nextLine();
        afficherResultats(inventaire.rechercherParTitre(titre));
    }

    /**
     * 🔍 Recherche un livre par auteur.
     */
    private static void rechercherParAuteur(Scanner scanner, Inventaire inventaire) {
        System.out.print("📝 Entrez un nom d'auteur : ");
        String auteur = scanner.nextLine();
        afficherResultats(inventaire.rechercherParAuteur(auteur));
    }

    /**
     * 🔍 Recherche un livre par catégorie.
     */
    private static void rechercherParCategorie(Scanner scanner, Inventaire inventaire) {
        System.out.print("📂 Entrez une catégorie : ");
        String categorie = scanner.nextLine();
        afficherResultats(inventaire.rechercherParCategorie(categorie));
    }

    /**
     * 🔍 Recherche les livres d’un auteur dont le titre commence par certaines lettres.
     */
    private static void rechercherParTitreDebutAuteur(Scanner scanner, Inventaire inventaire) {
        System.out.print("📝 Entrez un nom d'auteur : ");
        String auteur = scanner.nextLine();
        System.out.print("🔍 Entrez les premières lettres du titre : ");
        String prefixeTitre = scanner.nextLine();
        afficherResultats(inventaire.rechercherParAuteurEtTitre(auteur, prefixeTitre));
    }

    /**
     * 📅 Recherche les livres d’un auteur triés par date de publication.
     */
    private static void rechercherParAuteurParDate(Scanner scanner, Inventaire inventaire) {
        System.out.print("📝 Entrez un nom d'auteur : ");
        String auteur = scanner.nextLine();
        afficherResultats(inventaire.rechercherParAuteurParDate(auteur));
    }

    /**
     * 💰 Recherche des livres par catégorie dans un intervalle de prix.
     */
    private static void rechercherParPrix(Scanner scanner, Inventaire inventaire) {
        System.out.print("📂 Entrez une catégorie : ");
        String categorie = scanner.nextLine();
        
        System.out.print("💰 Entrez le prix minimum : ");
        double minPrix = scanner.nextDouble();
        
        System.out.print("💰 Entrez le prix maximum : ");
        double maxPrix = scanner.nextDouble();
        
        scanner.nextLine(); // Nettoyer l'entrée
    
        afficherResultats(inventaire.rechercherParCategorieEtPrix(categorie, minPrix, maxPrix));
    }

    /**
     * ⚠️ Affiche les livres en rupture de stock.
     */
    private static void afficherLivresRupture(Inventaire inventaire) {
        afficherResultats(inventaire.livresEnRuptureDeStock());
    }

    /**
     * 📌 Affiche les résultats d'une recherche.
     */
    private static void afficherResultats(List<Livre> livres) {
        if (livres.isEmpty()) {
            System.out.println("❌ Aucun résultat trouvé.");
        } else {
            livres.forEach(System.out::println);
        }
    }
}
