#language: fr
  Fonctionnalité: Supprimer dans un menu pour un utilisateur

    Scénario: Supprimer un element dans un menu pour un utilisateur
        Etant donné que je suis un utilisateur qui est en train de commander le menu "menu1"
        Alors quand j'ajoute mon menu "menu1" a ma commande
        Et que je choisis "Burger Cheese" "Frite" "Emmental" "Coca" et "Bacon" pour mon menu "menu1"
        Quand je supprime l'element "Burger Cheese" dans mon choix element "Plat" de mon menu "menu1"
        Alors je ne vois pas l'element "Burger Cheese" dans mon choix element "Plat" de mon menu "menu1" de ma commande
        Et quand je paye ma commande l'element choisi pour le choix element "Plat" est l'element par defaut soit "Salade"

