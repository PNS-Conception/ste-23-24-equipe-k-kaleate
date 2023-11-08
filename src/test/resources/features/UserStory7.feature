#language: fr
Fonctionnalité: Indiquer qu'une commande est prete

  Contexte:
    Soit le restaurant "Pizza_Rock"
    Et la commande 666 validee avec une liste de 3 menus du Restaurant "Pizza_Rock"
    Et je suis manager du restaurant "Pizza_Rock"

  Scénario: Consulter l'etat d'une commande tout juste validee
    Étant donné que 0 menus de la commande 666 sont prets
    Quand je veux dire que la commande est prete
    Alors la commande n'est pas prete

  Scénario: Consulter l'etat d'une commande preparee
    Étant donné que 3 menus de la commande 666 sont prets
    Quand je veux dire que la commande est prete
    Alors la commande est prete