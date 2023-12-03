# SopiaTech Eats-Team-23-24

Équipe K - kalEATé <br>
![img.png](doc/kaleate.png)

---

## TEAM

Nous sommes une équipe composée de 5 développeurs : <a href="https://github.com/ClervieCauser">Clervie CAUSER</a>, <a href="https://github.com/benneuville">Benjamin NEUVILLE-BURGUIÈRE</a>, <a href="https://github.com/RomainPellegrini">Romain PELLEGRINI</a>, <a href="https://github.com/JulienS0t0">Julien SOTO</a> et <a href="https://github.com/CarlaWagschal1">Carla WAGSCHAL</a>.

Un rôle a été attribué à chacun :
- Product Owner (PO) : <a href="https://github.com/CarlaWagschal1">Carla WAGSCHAL</a>
- Architect Logiciel (SA) : <a href="https://github.com/benneuville">Benjamin NEUVILLE-BURGUIÈRE</a>
- Assureur de Qualité (QA) : <a href="https://github.com/RomainPellegrini">Romain PELLEGRINI</a> et <a href="https://github.com/JulienS0t0">Julien SOTO</a>
- Intégration Continue et Manager de Répertoire (Ops) : <a href="https://github.com/ClervieCauser">Clervie CAUSER</a>

---

## doc
Avant de commencer à coder nous nous sommes familiarisés avec le sujet et nous avons réalisé un <a href="https://github.com/PNS-Conception/ste-23-24-equipe-k-kaleate/blob/main/doc/RapportTD1%3ATD2-EquipeK.pdf">premier rapport</a> qui met en avant nos hypothèses et compréhension du sujet ainsi que nos différents diagrammes.

## .github
   1. Contient sous workflows/maven.yml, une version d'un fichier d'actions qui est déclenché dès que vous poussez du code. 
Sur cette version initiale seule un test Junit5 est déclenché pour vérifier que tout fonctionne.
       - Github Actions (See in .github/workflows) to simply make a maven+test compilation
  2. Contient sous ISSUE_TEMPLATE, les modèles pour les issues user_story et bug. Vous pouvez le compléter à votre guise.

## src
 - pom.xml :  
       - Cucumber 7 et JUnit 5  
       - JDK 17   
       - Etc.  
   Ce pom.xml sera mis à jour avec la démonstration qui vous sera donnée ultérieurement.
 
---

## Ce que fait notre projet

### Principales User stories
Vous mettez en évidence les principales user stories de votre projet.
Chaque user story doit être décrite par 
   - son identifiant en tant que issue github (#), 
   - sa forme classique (As a… I want to… In order to…) (pour faciliter la lecture)
   - Le nom du fichier feature Cucumber et le nom des scénarios qui servent de tests d’acceptation pour la story.
   Les contenus détaillés sont dans l'issue elle-même. 


---

>Choisissez entre Français et Anglais pour décrire l'issue et tenez-vous à une seule langue.
>Adaptez le patron des "US" en fonction de vos choix (il se trouve dans votre dépôt sous _.github/ISSUE_TEMPLATE_

**Titre/Title :** En quelques mots, résumez l'objectif de l'US par exemple _Ajout d'un produit dans le panier_.

**Description :**

**As a** [type of user], **I want** [an action] **so that** [a benefit/a value]<br>
**En tant que** [type of user], **Je veux** [an action] **afin de** [a benefit/a value]


**Priorité/Priority :** C'est la priorité dans les attentes du client, ce qui est important c'est que toute l'équipe soit d'accord sur l'échelle, vous pouvez aussi faire le choix d'étoiles, de chiffres ou suivre l'échelle donnée ci-dessous. Mettez à jour le patron quand l'équipe a fait un choix.

Proposition d'échelle, la [méthode MoSCoW](https://paper-leaf.com/insights/prioritize-user-stories/)
1. _**Must have/Doit avoir :** la première version de ce produit nécessite absolument cette fonctionnalité - elle est essentielle au succès du produit._
2. _**Should Have/Devrait avoir** : l'idéal serait que la première version de ce produit dispose de cette fonctionnalité, mais elle n'est pas absolument nécessaire. Elles peuvent être aussi importantes, mais pas aussi critiques en termes de temps, que les "Must Have"._
3. _**Could have/Aurait pu**: l'histoire de l'utilisateur a de la valeur et est souhaitable, mais en fin de compte, elle n'est pas nécessaire._
4. _**Won't have/N'aura pas** : l'histoire de l'utilisateur est considérée comme étant parmi les moins critiques ou les moins utiles._


**Estimation/Estimate :** Préciser l'effort requis pour mettre en œuvre la US.
Ce point est estimé avec la méthode vue en cours.


**Règle métier /Business rules :**
Précisez ici les règles métiers essentielles pour le développement de cette user-story.

Ces règles sont écrites en français ou en anglais avec comme objectif de très facilement comprendre le travail à effectuer.


_Voici un exemple ci-dessous sur un panier d’un site e-commerce :_
```
lorsque je rajoute un élément supplémentaire d'un produit dans mon 
panier.
    - si quantité > stock alors erreur "pas assez de stock 
      disponible"
    - si quantité < stock alors on ajoute +1 à la quantité_
```

**Critère d'acceptation/Acceptance criteria**
Précisez l'ensemble des conditions que la story doit satisfaire pour être considérée comme complète et terminée.

Plus spécifiquement décrivez un ensemble de scénario qui deviendront des tests d'acceptation.
Précisez bien les données associées comme vous le voyez dans les scénarios d'exemples données ci-dessous.
Vous pouvez faire référence ici aux tests Gherkins correspondant

**Scenario:** objective <br>
**Given** some context<br>
**When** some action is carried out<br>
**Then** a set of observable outcomes should occur <br>

_Voici quelques exemples_<br>

_**Scénario:**_<br>
```
    Etant donné que je suis sur mon panier 
    Et que j'ai un produit d'id "1235" en quantité "1" <br>
    Et que le stock restant sur ce produit est de "10"
    Quand j'ajoute "1" quantité de mon produit
    Alors mon produit aura "2" quantités
```
   
