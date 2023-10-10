#language: fr
Fonctionnalité: Selectionner un menu pour commander

  Contexte:
    Étant donné que je suis un utilisateur connecté

  Scénario: Afficher la liste des menus
    Étant donné que je suis un utilisateur "Dorian" "Bouchard" connecté du campus "Sophia_tech"
    Quand  j'ecris "menus" dans le terminal
    Alors je devrais voir la liste des menus de l'ensemble des restaurant "Sophia_Tech"

  Scénario: Selectionner un menu
    Étant donné que j'ai la liste des menus de l'ensemble des restaurants "Sophia_tech"
    Quand je saisie le menu "Sushi Salsa"
    Alors Ma commande est crée avec le menu à l'interieur

  Scénario: Passer une commande
    Étant donné que j'ai ajouté le menu "Sushi Salsa"
    Quand je valide ma commande
    Alors je vais être redirigé vers le paiement de ma commande