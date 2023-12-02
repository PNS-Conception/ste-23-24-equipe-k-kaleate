#language: fr
  Fonctionnalité: Modifier un menu pour un utilisateur

    Scénario: Modifier un élément d'un menu
        Etant donné que je suis un utilisateur qui commande un menu "menu1"
        Alors quand j'ajoute ce menu "menu1" a ma commande
        Et que je choisis "Burger Cheese", "Frite", "Vanille" et "Chantilly" pour mon menu "menu1"
        Quand je remplace "Burger Cheese" par "Salade" pour mon choix element "Plat" dans mon menu "menu1"
        Alors mon menu "menu1" contient pour le choix element "Plat" "Salade"

    Scénario: Modifier un supplément d'un élément d'un menu
      Etant donné que je suis un utilisateur qui commande un menu "menu1"
      Alors quand j'ajoute ce menu "menu1" a ma commande
      Et que je choisis "Burger Cheese", "Frite", "Vanille" et "Chantilly" pour mon menu "menu1"
      Quand je remplace "Frite" par "Potatoes" pour mon supplement element dans mon menu "menu1"
      Alors mon menu "menu1" contient pour le supplement element "Potatoes"

    Scénario: Modifier un composant d'un choix d'un élément d'un menu
      Etant donné que je suis un utilisateur qui commande un menu "menu1"
      Alors quand j'ajoute ce menu "menu1" a ma commande
      Et que je choisis "Burger Cheese", "Frite", "Vanille" et "Chantilly" pour mon menu "menu1"
      Quand je remplace "Vanille" par "Chocolat" pour mon choix composant "Parfum" de mon element "Glace" de mon choix element "Dessert" dans mon menu "menu1"
      Alors mon menu "menu1" contient pour le choix composant "Parfum" de mon element "Glace" de mon choix element "Dessert" "Chocolat"
