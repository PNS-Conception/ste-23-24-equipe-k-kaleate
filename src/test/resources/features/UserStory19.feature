#language: fr
  Fonctionnalité: Supprimer le contenu d'un menu

    Scénario: Supprimer un element d'un menu
      Etant donné que je suis un manager de restaurant
      Quand je supprime l'element "Salade" de mon choix element "Plat" de mon menu "menu1"
      Alors l'element "Salade" n'est plus disponible dans mon choix element "Plat" de mon menu "menu1"
