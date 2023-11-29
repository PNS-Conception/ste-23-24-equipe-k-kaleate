#language: fr
Fonctionnalité: Obtenir une réduction sur une commande

  Scénario: Obtenir une réduction sur une commande simple
    Etant donné que un utilisateur avec une commande de dix menus
    Quand je paye ma commande
    Alors une réduction est appliquée sur le prix de ma commande

  Scénario: Obtenir une réduction sur une commande groupée
    Etant donné que plusieurs utilsateurs dans une meme commande groupée ont dix menus
    Quand chacun paye sa commande
    Alors une réduction est appliquée sur le prix de chaque commande