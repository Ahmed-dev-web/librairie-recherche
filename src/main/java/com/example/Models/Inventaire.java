package com.example.Models;

import com.example.Utils.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 📦 Gère l'inventaire des livres en mémoire.
 * Fournit des méthodes pour ajouter, rechercher, trier et afficher les livres.
 */
public class Inventaire {
    private List<Livre> livres;

    /**
     * 📌 Constructeur de l'inventaire.
     * Initialise une liste vide de livres.
     */
    public Inventaire() {
        this.livres = new ArrayList<>();
    }

    /**
     * 📌 Ajouter un livre dans l'inventaire.
     * @param livre Le livre à ajouter.
     */
    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    /**
     * 📚 Afficher tous les livres triés par titre.
     */
    public void afficherTousLesLivres() {
        if (livres.isEmpty()) {
            System.out.println("❌ Aucun livre dans l'inventaire.");
        } else {
            System.out.println("\n📚 **Livres disponibles :**");
            afficherListe(livres.stream()
                    .sorted(Comparator.comparing(Livre::getTitre))
                    .collect(Collectors.toList()));
        }
    }

    /**
     * 🔍 Rechercher un livre par titre.
     * @param titre Le titre recherché.
     * @return Liste des livres correspondants.
     */
    public List<Livre> rechercherParTitre(String titre) {
        return livres.stream()
                .filter(l -> StringUtils.containsIgnoreAccents(l.getTitre(), titre))
                .collect(Collectors.toList());
    }

    /**
     * 🔍 Rechercher un livre par auteur.
     * @param auteur Le nom de l'auteur recherché.
     * @return Liste des livres écrits par cet auteur.
     */
    public List<Livre> rechercherParAuteur(String auteur) {
        return livres.stream()
                .filter(l -> StringUtils.equalsIgnoreAccents(l.getAuteur(), auteur))
                .collect(Collectors.toList());
    }

    /**
     * 🔍 Rechercher un livre par catégorie.
     * @param categorie La catégorie recherchée.
     * @return Liste des livres appartenant à cette catégorie.
     */
    public List<Livre> rechercherParCategorie(String categorie) {
        return livres.stream()
                .filter(l -> StringUtils.equalsIgnoreAccents(l.getCategorie(), categorie))
                .collect(Collectors.toList());
    }

    /**
     * 📂 Trier les livres par catégorie (ordre alphabétique).
     */
    public void afficherLivresTriesParCategorie() {
        afficherListe(livres.stream()
                .sorted(Comparator.comparing(Livre::getCategorie))
                .collect(Collectors.toList()));
    }

    /**
     * 📝 Trier les livres par auteur (ordre alphabétique).
     */
    public void afficherLivresTriesParAuteur() {
        afficherListe(livres.stream()
                .sorted(Comparator.comparing(Livre::getAuteur))
                .collect(Collectors.toList()));
    }

    /**
     * 📖 Trier les livres par titre (ordre alphabétique).
     */
    public void afficherLivresTriesParTitre() {
        afficherListe(livres.stream()
                .sorted(Comparator.comparing(Livre::getTitre))
                .collect(Collectors.toList()));
    }

    /**
     * 📅 Trouver tous les livres d’un auteur triés par date de publication (du plus récent au plus ancien).
     * @param auteur Nom de l'auteur.
     * @return Liste triée des livres de l'auteur.
     */
    public List<Livre> rechercherParAuteurParDate(String auteur) {
        return livres.stream()
                .filter(l -> StringUtils.equalsIgnoreAccents(l.getAuteur(), auteur))
                .sorted(Comparator.comparing(Livre::getDatePublication).reversed())
                .collect(Collectors.toList());
    }

    /**
     * 🔍 Trouver tous les livres d’un auteur dont le titre commence par certaines lettres.
     * @param auteur Nom de l'auteur.
     * @param prefixeTitre Début du titre recherché.
     * @return Liste des livres correspondants.
     */
    public List<Livre> rechercherParAuteurEtTitre(String auteur, String prefixeTitre) {
        return livres.stream()
                .filter(l -> StringUtils.equalsIgnoreAccents(l.getAuteur(), auteur) &&
                        StringUtils.startsWithIgnoreAccents(l.getTitre(), prefixeTitre))
                .collect(Collectors.toList());
    }

    /**
     * 💰 Rechercher des livres dans une catégorie spécifique et un intervalle de prix.
     * @param categorie La catégorie du livre.
     * @param minPrix Le prix minimum.
     * @param maxPrix Le prix maximum.
     * @return Liste des livres correspondant aux critères.
     */
    public List<Livre> rechercherParCategorieEtPrix(String categorie, double minPrix, double maxPrix) {
        return livres.stream()
                .filter(l -> StringUtils.equalsIgnoreAccents(l.getCategorie(), categorie))
                .filter(l -> l.getPrix() >= minPrix && l.getPrix() <= maxPrix)
                .collect(Collectors.toList());
    }

    /**
     * ⚠️ Obtenir la liste des livres en rupture de stock.
     * @return Liste des livres avec une quantité de 0.
     */
    public List<Livre> livresEnRuptureDeStock() {
        return livres.stream()
                .filter(Livre::estEnRuptureDeStock)
                .collect(Collectors.toList());
    }

    /**
     * 📌 Fonction utilitaire pour afficher une liste de livres.
     * @param liste Liste des livres à afficher.
     */
    private void afficherListe(List<Livre> liste) {
        if (liste.isEmpty()) {
            System.out.println("❌ Aucun livre trouvé.");
        } else {
            liste.forEach(System.out::println);
        }
    }
}
