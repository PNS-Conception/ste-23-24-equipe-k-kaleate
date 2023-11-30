#language: fr
  Fonctionnalité: Supprimer le contenu d'un menu

    Scénario: Supprimer un element d'un menu
      Etant donné que je suis un manager de restaurant
      Quand je supprime l'element "Salade" de mon choix element "Plat" de mon menu "menu1"
      Alors l'element "Salade" n'est plus disponible dans mon choix element "Plat" de mon menu "menu1"


    Scénario: Supprimer un composant d'un menu
      Etant donné que je suis un manager de restaurant
      Quand je supprime le composant "Fraise" de mon choix composant "Parfum" de mon element "Glace" de mon choix element "Dessert" de mon menu "menu1"
        Alors le composant "Fraise" n'est plus disponible dans mon choix composant "Parfum" de mon element "Glace" de mon choix element "Dessert" de mon menu "menu1"

    Scénario: Supprimer un choix element d'un menu
      Etant donné que je suis un manager de restaurant
      Quand je supprime le choix element "Plat" de mon menu "menu1"
      Alors le choix element "Plat" n'est plus disponible dans mon menu "menu1"

    Scénario: Supprimer un choix composant d'un menu
      Etant donné que je suis un manager de restaurant
      Quand je supprime le choix composant "Parfum" de mon element "Glace" de mon choix element "Dessert" de mon menu "menu1"
      Alors le choix composant "Parfum" n'est plus disponible dans mon element "Glace" de mon choix element "Dessert" de mon menu "menu1"

    Scénario: Supprimer un supplement element d'un menu
      Etant donné que je suis un manager de restaurant
      Quand je supprime le supplement element "Frite" de mon menu "menu1"
      Alors le supplement element "Frite" n'est plus disponible dans mon menu "menu1"
