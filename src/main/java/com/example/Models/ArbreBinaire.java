package com.example.Models;

/**
 * 🌳 Arbre Binaire de Recherche (ABR) utilisé pour stocker et trier les livres par titre.
 */
public class ArbreBinaire {
    private Noeud racine;

    /**
     * 🌱 Classe interne représentant un nœud de l'arbre.
     * Chaque nœud contient un livre ainsi que des références aux sous-arbres gauche et droit.
     */
    private static class Noeud {
        Livre livre;
        Noeud gauche, droite;

        /**
         * 🔹 Constructeur du nœud.
         * @param livre Le livre stocké dans ce nœud.
         */
        public Noeud(Livre livre) {
            this.livre = livre;
            this.gauche = this.droite = null;
        }
    }

    /**
     * 📌 Constructeur de l'arbre binaire.
     * Initialise un arbre vide.
     */
    public ArbreBinaire() {
        this.racine = null;
    }

    /**
     * 📌 Ajouter un livre dans l'arbre en le triant par titre.
     * @param livre Le livre à ajouter.
     */
    public void ajouter(Livre livre) {
        racine = ajouterRec(racine, livre);
    }

    /**
     * 🔁 Méthode récursive pour insérer un livre dans l'arbre.
     * @param courant Le nœud actuel du parcours.
     * @param livre Le livre à insérer.
     * @return Le nœud mis à jour.
     */
    private Noeud ajouterRec(Noeud courant, Livre livre) {
        if (courant == null) {
            return new Noeud(livre);
        }
        // Comparaison par titre pour insérer à gauche ou à droite
        if (livre.getTitre().compareToIgnoreCase(courant.livre.getTitre()) < 0) {
            courant.gauche = ajouterRec(courant.gauche, livre);
        } else if (livre.getTitre().compareToIgnoreCase(courant.livre.getTitre()) > 0) {
            courant.droite = ajouterRec(courant.droite, livre);
        }
        return courant;
    }

    /**
     * 📌 Affichage des livres triés en ordre alphabétique.
     * Effectue un parcours **In-Order Traversal** (Gauche - Racine - Droite).
     */
    public void afficher() {
        afficherRec(racine);
    }

    /**
     * 🔁 Méthode récursive pour afficher les livres triés.
     * @param courant Le nœud actuel du parcours.
     */
    private void afficherRec(Noeud courant) {
        if (courant != null) {
            afficherRec(courant.gauche);
            System.out.println(courant.livre);
            afficherRec(courant.droite);
        }
    }

    /**
     * 🔍 Rechercher un livre par son titre dans l'arbre binaire.
     * @param titre Le titre du livre recherché.
     * @return Le livre correspondant, ou `null` s'il n'est pas trouvé.
     */
    public Livre rechercherParTitre(String titre) {
        return rechercherParTitreRec(racine, titre);
    }

    /**
     * 🔁 Méthode récursive pour rechercher un livre par son titre.
     * @param courant Le nœud actuel du parcours.
     * @param titre Le titre du livre recherché.
     * @return Le livre trouvé ou `null` si absent.
     */
    private Livre rechercherParTitreRec(Noeud courant, String titre) {
        if (courant == null) {
            return null;
        }
        int comparaison = titre.compareToIgnoreCase(courant.livre.getTitre());
        if (comparaison == 0) {
            return courant.livre;
        } else if (comparaison < 0) {
            return rechercherParTitreRec(courant.gauche, titre);
        } else {
            return rechercherParTitreRec(courant.droite, titre);
        }
    }
}
