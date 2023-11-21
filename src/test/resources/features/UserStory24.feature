#language: fr
Fonctionnalité: les informations de ma commande sont envoyés à l'utilisateur

  Scénario: l'utilisateur récupère les informations de ma commande
    Etant donné que un utilisateur avec une commande
    Quand il demande les informations de la commande
    Alors il les récupère seulement s'il a payé sa commande
