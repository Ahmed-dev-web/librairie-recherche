package com.example.Models;

import java.time.LocalDate;

/**
 * 📚 Représente un livre dans la librairie.
 * Contient toutes les informations nécessaires sur un livre.
 */
public class Livre {
    private String isbn;
    private String titre;
    private String auteur;
    private String categorie;
    private double prix;
    private LocalDate datePublication;
    private int quantite;

    /**
     * 📌 Constructeur du livre.
     * @param isbn Code ISBN unique du livre.
     * @param titre Nom du livre.
     * @param auteur Nom de l'auteur.
     * @param categorie Catégorie du livre.
     * @param prix Prix du livre en euros.
     * @param datePublication Date de publication du livre.
     * @param quantite Nombre d'exemplaires disponibles.
     */
    public Livre(String isbn, String titre, String auteur, String categorie, double prix, LocalDate datePublication, int quantite) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.prix = prix;
        this.datePublication = datePublication;
        this.quantite = quantite;
    }

    // 🔹 Getters

    /**
     * @return L'ISBN du livre.
     */
    public String getIsbn() { return isbn; }

    /**
     * @return Le titre du livre.
     */
    public String getTitre() { return titre; }

    /**
     * @return L'auteur du livre.
     */
    public String getAuteur() { return auteur; }

    /**
     * @return La catégorie du livre.
     */
    public String getCategorie() { return categorie; }

    /**
     * @return Le prix du livre.
     */
    public double getPrix() { return prix; }

    /**
     * @return La date de publication du livre.
     */
    public LocalDate getDatePublication() { return datePublication; }

    /**
     * @return La quantité en stock du livre.
     */
    public int getQuantite() { return quantite; }

    // 🔹 Setters

    /**
     * Définit un nouvel ISBN.
     * @param isbn Nouveau code ISBN.
     */
    public void setIsbn(String isbn) { this.isbn = isbn; }

    /**
     * Définit un nouveau titre.
     * @param titre Nouveau titre du livre.
     */
    public void setTitre(String titre) { this.titre = titre; }

    /**
     * Définit un nouvel auteur.
     * @param auteur Nouveau nom d'auteur.
     */
    public void setAuteur(String auteur) { this.auteur = auteur; }

    /**
     * Définit une nouvelle catégorie.
     * @param categorie Nouvelle catégorie du livre.
     */
    public void setCategorie(String categorie) { this.categorie = categorie; }

    /**
     * Définit un nouveau prix.
     * @param prix Nouveau prix du livre.
     */
    public void setPrix(double prix) { this.prix = prix; }

    /**
     * Définit une nouvelle date de publication.
     * @param datePublication Nouvelle date de publication.
     */
    public void setDatePublication(LocalDate datePublication) { this.datePublication = datePublication; }

    /**
     * Définit une nouvelle quantité en stock.
     * @param quantite Nouvelle quantité.
     */
    public void setQuantite(int quantite) { this.quantite = quantite; }

    /**
     * Vérifie si le livre est en rupture de stock.
     * @return `true` si la quantité est ≤ 0, sinon `false`.
     */
    public boolean estEnRuptureDeStock() {
        return this.quantite <= 0;
    }

    /**
     * 📌 Retourne une représentation textuelle d'un livre.
     * @return Chaîne formatée contenant les informations du livre.
     */
    @Override
    public String toString() {
        return "Livre{" +
                "ISBN='" + isbn + '\'' +
                ", Titre='" + titre + '\'' +
                ", Auteur='" + auteur + '\'' +
                ", Catégorie='" + categorie + '\'' +
                ", Prix=" + prix +
                ", DatePublication=" + datePublication +
                ", Quantité=" + quantite +
                '}';
    }
}
