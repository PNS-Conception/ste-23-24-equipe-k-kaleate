#language: fr
Fonctionnalité: Un utilisateur paye sa commande

  Contexte:
    Soit Un utilisateur ayant une commande avec deux menus à l'intérieur

  Scénario: Payer sa commande
    Quand l'utilisateur a assez d'argent pour payer sa commande et décide de la payer
    Alors La commande est payée et change de statut
