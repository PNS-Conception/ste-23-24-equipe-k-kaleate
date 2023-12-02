#language: fr
  Fonctionnalité: Abandon d'une commande par un utilisateur

    Scénario: Abandon d'une commande par un utilisateur
      Etant donné que je suis un utilisateur ayant commence une commande
      Lorsque j'abandonne ma commande
      Alors ma commande actuelle est vide
      Et les restaurants recuperent leurs menus
      Et les menus sont reinitialises
