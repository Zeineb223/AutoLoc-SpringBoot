# AutoLoc — Ateliers 1 à 5

Projet Maven Spring Boot 3.4.5 / Java 17, packages `tn.esprit.autoloc`.

## 1. Prérequis
- IntelliJ IDEA avec JDK 17 ou 21
- MySQL 8 démarré (port 3306)
- Maven via IntelliJ ou installation locale
- Postman (facultatif : Swagger permet aussi les tests)

## 2. Ouverture dans IntelliJ
1. Décompresser `autoloc-api.zip`.
2. IntelliJ → File → Open → sélectionner le dossier `autoloc-api` contenant `pom.xml`.
3. Choisir **Trust Project** si demandé.
4. Attendre **Maven Sync** et le téléchargement des dépendances (connexion Internet requise).
5. File → Project Structure → Project SDK : Java 17 ou 21.
6. Settings → Build → Compiler → Annotation Processors : activer si nécessaire pour Lombok.

## 3. MySQL
1. Démarrer MySQL, connaître le compte et le mot de passe.
2. Créer éventuellement la base : `CREATE DATABASE autoloc CHARACTER SET utf8mb4;` (sinon l'URL tente de la créer).
3. Ouvrir `src/main/resources/application.properties`.
4. Modifier `spring.datasource.username` et `spring.datasource.password`, ou définir les variables d'environnement `DB_USER` et `DB_PASSWORD`.
5. Première génération de tables : remplacer temporairement `spring.jpa.hibernate.ddl-auto=update` par `create`, démarrer une fois, puis remettre `update` et redémarrer. **ATTENTION : `create` supprime les anciennes données !**

## 4. Démarrage
1. Ouvrir `src/main/java/tn/esprit/autoloc/AutolocApiApplication.java`.
2. Cliquer sur le triangle vert à côté de `main` → Run.
3. Vérifier `Started AutolocApiApplication` et `Found 9 JPA repository interfaces`.
4. Ouvrir http://localhost:8080/api/swagger-ui.html.
5. Vérifier http://localhost:8080/api/contrats (doit retourner `[]` au départ).

## 5. Postman
1. Importer `postman/AutoLoc.postman_collection.json` et `postman/local.postman_environment.json`.
2. Sélectionner l'environnement `local`.
3. Tester GET `/api/contrats` puis POST `/api/contrats` avec :
```json
{"dateSignature":"2026-11-02","montantTotal":480.00,"valide":true,"paiements":[{"montant":150,"datePaiement":"2026-11-02","modePaiement":"CARTE"},{"montant":330,"datePaiement":"2026-11-06","modePaiement":"VIREMENT"}]}
```
4. Vérifier GET `/api/paiements` (deux paiements) puis PUT `/api/contrats/1` sans champ `paiements` ; ils doivent rester présents.
5. Tester GET `/api/contrats/9999` → 404 ; POST `/api/paiements` → 405 ; DELETE `/api/contrats/1` → 204.
6. Adapter les identifiants selon les valeurs générées en base.

## 6. Structure et ateliers
- Atelier 1 : démarrage Maven, entité `Vehicule`, MySQL.
- Atelier 2 : neuf entités, cinq énumérations, associations JPA.
- Atelier 3 : neuf `I...Repository extends JpaRepository`.
- Atelier 4 : neuf services et injection par constructeur, exception métier, `docs/service-notes.md`.
- Atelier 5 : neuf contrôleurs REST, SpringDoc/Swagger, Postman, `docs/api-notes.md`.

## 7. Vérifications et limites
Ce projet est généré à partir des supports fournis. **La compilation Maven et l'exécution MySQL ne sont pas vérifiées dans cet environnement**. Les notes Sonar présentent des exemples : exécuter l'analyse dans IntelliJ pour les constats réels. La collection Postman propose des requêtes de départ ; compléter les corps JSON selon les champs requis et documenter les résultats réels.
