package com.example.Utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * 🔠 Utilitaire pour la manipulation de chaînes de caractères.
 * Fournit des méthodes pour normaliser, comparer et rechercher du texte sans tenir compte des accents ou de la casse.
 */
public class StringUtils {

    /**
     * 📌 Supprime les accents et normalise le texte en minuscules.
     * @param texte Le texte à normaliser.
     * @return Texte sans accents et en minuscules.
     */
    public static String normaliser(String texte) {
        if (texte == null) return "";
        String texteNormalise = Normalizer.normalize(texte, Normalizer.Form.NFD);
        return Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(texteNormalise).replaceAll("")
                .toLowerCase();
    }

    /**
     * 🔍 Compare deux chaînes de caractères de manière insensible aux accents et à la casse.
     * @param str1 Première chaîne à comparer.
     * @param str2 Deuxième chaîne à comparer.
     * @return `true` si les deux chaînes sont équivalentes après normalisation, sinon `false`.
     */
    public static boolean equalsIgnoreAccents(String str1, String str2) {
        return normaliser(str1).equals(normaliser(str2));
    }

    /**
     * 🔎 Vérifie si une chaîne contient une autre, en ignorant les accents et la casse.
     * @param source La chaîne source où chercher.
     * @param recherche La chaîne recherchée.
     * @return `true` si la source contient la recherche après normalisation, sinon `false`.
     */
    public static boolean containsIgnoreAccents(String source, String recherche) {
        return normaliser(source).contains(normaliser(recherche));
    }

    /**
     * 📖 Vérifie si une chaîne commence par une autre, en ignorant les accents et la casse.
     * @param source La chaîne source.
     * @param prefix Le préfixe recherché.
     * @return `true` si la source commence par le préfixe après normalisation, sinon `false`.
     */
    public static boolean startsWithIgnoreAccents(String source, String prefix) {
        return normaliser(source).startsWith(normaliser(prefix));
    }
}
