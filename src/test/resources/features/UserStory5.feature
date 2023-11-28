#language: fr
Fonctionnalité: Le manager du restaurant veux ajouter, supprimer et modifier un menu dee son restaurant.

  Contexte:
    Soit le manager "Bob" "Edward" du restaurant "Burger King"

  Scénario: Ajouter un menu à la liste de menu du restauant "Burger King"
    Quand il ajoute un nouveau menu "Burger" pour 10 euros à la carte
    Alors le restaurant "Burger King" propose un menu supplémentaire
    Et la liste des menus augmente de 1


  Scénario: Supprimer un menu à la liste de menu du restauant "Burger King"
    Quand il supprimer le menu "Burger cheese" de la carte
    Alors le restaurant "Burger King" met à jour son catalogue de menus
    Et la liste des menus diminue de 1

  Scénario: Modifier un menu à la liste de menu du restauant "Burger King"
    Quand il modifie un élément du menu "Burger cheese" de la carte
    Alors le restaurant "Burger King" met à jour son catalogue de menu