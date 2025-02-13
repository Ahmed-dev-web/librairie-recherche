package com.example.Controllers;

import com.example.Models.Inventaire;
import com.example.Models.Livre;
import java.util.List;

/**
 * 📌 Contrôleur pour gérer les recherches et affichages des livres.
 * Il sert d'intermédiaire entre `Inventaire` et l'interface utilisateur.
 */
public class LivreController {
    private Inventaire inventaire;

    /**
     * 🔹 Constructeur du contrôleur.
     * @param inventaire L'inventaire contenant les livres.
     */
    public LivreController(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    /**
     * 🔍 Rechercher un livre par titre.
     * @param titre Le titre du livre recherché.
     * @return Liste des livres correspondants.
     */
    public List<Livre> rechercherParTitre(String titre) {
        return inventaire.rechercherParTitre(titre);
    }

    /**
     * 🔍 Rechercher un livre par auteur.
     * @param auteur Le nom de l'auteur recherché.
     * @return Liste des livres de cet auteur.
     */
    public List<Livre> rechercherParAuteur(String auteur) {
        return inventaire.rechercherParAuteur(auteur);
    }

    /**
     * 🔍 Rechercher un livre par catégorie.
     * @param categorie La catégorie recherchée.
     * @return Liste des livres de cette catégorie.
     */
    public List<Livre> rechercherParCategorie(String categorie) {
        return inventaire.rechercherParCategorie(categorie);
    }

    /**
     * 🔍 Rechercher un livre par catégorie et intervalle de prix.
     * @param categorie La catégorie des livres recherchés.
     * @param minPrix Le prix minimum.
     * @param maxPrix Le prix maximum.
     * @return Liste des livres de la catégorie et dans l'intervalle de prix donné.
     */
    public List<Livre> rechercherParCategorieEtPrix(String categorie, double minPrix, double maxPrix) {
        return inventaire.rechercherParCategorieEtPrix(categorie, minPrix, maxPrix);
    }

    /**
     * 📚 Afficher tous les livres disponibles dans l'inventaire.
     */
    public void afficherTousLesLivres() {
        inventaire.afficherTousLesLivres();
    }

    /**
     * ⚠️ Obtenir la liste des livres en rupture de stock.
     * @return Liste des livres ayant une quantité de 0.
     */
    public List<Livre> livresEnRuptureDeStock() {
        return inventaire.livresEnRuptureDeStock();
    }
}
