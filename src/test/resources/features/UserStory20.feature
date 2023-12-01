#language: fr
  Fonctionnalité: Supprimer dans un menu pour un utilisateur

    Scénario: Supprimer un element dans un menu pour un utilisateur
        Etant donné que je suis un utilisateur qui est en train de commande le menu "menu1"
        Quand je supprime l'element "Burger Cheese" dans mon choix element "Plat" de mon menu "menu1"
        Alors quand j'ajoute mon menu "menu1" a ma commande
        Alors je ne vois pas l'element "Burger Cheese" dans mon choix element "Plat" de mon menu "menu1" de ma commande
        Et l'element choisi pour le choix element "Plat" est l'element par defaut soit "Salade"

