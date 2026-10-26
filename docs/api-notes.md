# Atelier 5 — Notes API

## A. Endpoints
Pour chaque ressource sauf `paiements` : GET collection (200), GET id (200/404), POST (201/400), PUT id (200/400/404), DELETE id (204/404). `paiements` : uniquement GET, POST renvoie 405.

## B. Jackson
`Contrat.paiements` : `@JsonManagedReference`, `Paiement.contrat` : `@JsonBackReference`, pour éviter la récursion. `@JsonIgnore` sur les collections inverses évite d’exposer les relations non nécessaires.

## C. Postman / Swagger
Postman rejoue les requêtes et vérifie les statuts. Swagger documente automatiquement les routes et schémas via `/api/swagger-ui.html`.

## D. Sonar
Exemples à vérifier dans l’IDE : imports inutilisés ; injection par attribut (remplacée par injection constructeur).

## E. Questions
1. `DispatcherServlet` reçoit les requêtes ; `HandlerMapping` choisit le contrôleur.
2. Le contrôleur dépend du contrat `IContratService` et ne contourne pas la logique métier.
3. POST crée (201), DELETE ne retourne pas de corps (204), absence de ressource (404) est une erreur métier attendue.
4. Les paiements appartiennent au contrat ; POST paiements retourne 405.
5. Exposer les entités JPA risque les cycles JSON, proxies lazy et fuite de champs ; les DTO sont recommandés en production.
