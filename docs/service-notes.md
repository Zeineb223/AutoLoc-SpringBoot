# Atelier 4 — Notes de service

## A. Modes d’injection
| Critère | Constructeur | Attribut |
|---|---|---|
| Champ final | Oui | Non |
| Dépendance explicite | Oui | Non |
| Utilisable hors Spring | Oui, avec repository fourni | Risque de null |
| Sonar | Préféré | S6813 possible |

## B. Services
Neuf services injectent chacun leur interface `I...Repository` par constructeur (`@RequiredArgsConstructor`), sans état modifiable. Paiement est en lecture seule.

## C. Erreurs
1. Bean absent : `@Service` oublié ou classe hors `tn.esprit.autoloc`.
2. Deux beans : `@Primary` sur une implémentation ou `@Qualifier` sur le paramètre injecté.
3. Cycle : extraire une responsabilité commune ; ne pas faire dépendre deux services l’un de l’autre.

## D. SonarQube (exemples à vérifier dans IntelliJ)
- S6813 : injection par attribut ; correction : constructeur.
- S112 : exception générique ; correction : exception métier.
- Import inutilisé ; correction : suppression.

## E. Compréhension
1. Spring crée le bean lors du scan, pas de `new` dans le code applicatif.
2. L’interface découple le contrôleur de l’implémentation.
3. Un singleton partagé ne doit pas stocker un contrat courant entre deux requêtes.
4. Charger l’existant avant `save` protège les associations et évite l’écrasement involontaire.
5. `@Component` scanne une classe, `@Bean` déclare une instance produite par méthode. `@Primary` fixe le choix par défaut, `@Qualifier` choisit explicitement. Les paiements passent par le contrat.
