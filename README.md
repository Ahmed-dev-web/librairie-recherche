# 📚 Librairie Recherche

Une application Java permettant d'effectuer des **recherches avancées** dans l'inventaire d'une librairie à partir d'un fichier CSV.  
Les utilisateurs peuvent rechercher des livres par **titre, auteur, catégorie, date de publication et prix**.

---

## 🛠️ Technologies utilisées

- **Java 21** avec **Maven**
- **Javadoc** pour la documentation
- **Flux d'entrée/sortie** en Java (lecture de fichiers CSV)
- **Arbre binaire** pour une recherche optimisée
- **Pattern MVC** (Modèle - Vue - Contrôleur)
- **Principes SOLID** pour un code maintenable et évolutif

---

## 📂 Structure du projet

```
📦 librairie-recherche
├── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java
│   │   │   ├── 📂 com.example
│   │   │   │   ├── 📜 App.java              # Point d'entrée de l'application
│   │   │   │   ├── 📂 Controllers
│   │   │   │   │   ├── 📜 LivreController.java # Gestion des recherches
│   │   │   │   ├── 📂 Models
│   │   │   │   │   ├── 📜 Livre.java         # Modèle représentant un livre
│   │   │   │   │   ├── 📜 Inventaire.java    # Gestion de l’inventaire
│   │   │   │   │   ├── 📜 ArbreBinaire.java  # Structure de recherche
│   │   │   │   ├── 📂 Utils
│   │   │   │   │   ├── 📜 CSVReader.java     # Lecture du fichier CSV
│   │   │   │   │   ├── 📜 StringUtils.java   # Gestion des chaînes de caractères
│   │   ├── 📂 resources
│   │   │   ├── 📜 livres.csv                 # Base de données des livres
│   ├── 📂 test
│   │   ├── 📂 java/com/example
│   │   │   ├── 📜 AppTest.java               # Tests unitaires
├── 📜 pom.xml                                # Configuration Maven
├── 📜 README.md                              # Documentation du projet
```

---

## 📌 Fonctionnalités

✅ Rechercher un livre par **titre**  
✅ Rechercher un livre par **auteur**  
✅ Rechercher un livre par **catégorie**  
✅ Trier les livres par **catégorie, auteur, titre, date de publication**  
✅ Trouver les livres d'un auteur dont le **titre commence par certaines lettres**  
✅ Trouver les livres d'un auteur par **date de publication (du plus récent au plus ancien)**  
✅ Trouver les livres d'une **catégorie dans un intervalle de prix**  
✅ Afficher les livres **en rupture de stock**  

---

## 🚀 Installation et exécution

1️⃣ **Cloner le projet**
```bash
git clone https://github.com/Ahmed-dev-web/librairie-recherche.git
cd librairie-recherche
```

2️⃣ **Compiler et exécuter le projet**
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.example.App"
```

3️⃣ **Générer la documentation Javadoc**
```bash
mvn javadoc:javadoc
```
La documentation se trouvera dans `target/site/apidocs/index.html`.

---

## 📤 Pousser ce fichier sur GitHub

```bash
git add README.md
git commit -m "Ajout du README"
git push origin main
```

---

## 📄 Licence

Ce projet est sous licence **MIT**. Vous êtes libre de le modifier et de le distribuer.

---

🚀 **Développé par Ahmed-dev-web** | [GitHub](https://github.com/Ahmed-dev-web/librairie-recherche)
