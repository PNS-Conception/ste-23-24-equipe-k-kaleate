#language: fr

Fonctionnalité: Modification d'un menu par le manager de magasin

  Scénario: Modifier un élément d'un menu
    Etant donné que je suis un manager de magasin
    Quand je veux modifier le nom de mon element "Burger Cheese" en "Cheese Burger" dans le choix element "Plat" de mon menu "menu1"
    Alors le nom de mon element est "Cheese Burger" dans le choix element "Plat" de mon menu "menu1"

  Scénario: Modifier un composant d'un élément d'un menu
    Etant donné que je suis un manager de magasin
    Quand je veux modifier le nom de mon composant "Pain Brioche" en "Pain aux céréales" dans le choix composant "Pain" de mon element "Burger Cheese" dans le choix element "Plat" de mon menu "menu1"
    Alors le nom de mon composant est "Pain aux céréales" dans le choix composant "Pain" de mon element "Burger Cheese" dans le choix element "Plat" de mon menu "menu1"

  Scénario: Modifier un choix élément d'un menu
    Etant donné que je suis un manager de magasin
    Quand je veux modifier le nom de mon choix element "Plat" en "Plat principal" dans mon menu "menu1"
    Alors le nom de mon choix element est "Plat principal" dans mon menu "menu1"

  Scénario: Modifier un choix composant d'un élément d'un menu
    Etant donné que je suis un manager de magasin
    Quand je veux modifier le nom de mon choix composant "Pain" en "Choix Pain" dans mon element "Burger Cheese" de mon choix element "Plat" de mon menu "menu1"
    Alors le nom de mon choix composant est "Choix Pain" dans mon element "Burger Cheese" de mon choix element "Plat" de mon menu "menu1"

  Scénario: Modifier le nombre de choix d'un choix élément d'un menu
    Etant donné que je suis un manager de magasin
    Quand je veux modifier le nombre de choix de mon choix element "Plat" en 2 dans mon menu "menu1"
    Alors le nombre de choix de mon choix element "Plat" est 2 dans mon menu "menu1"

  Scénario: Modifier le nombre de choix d'un choix composant d'un élément d'un menu
    Etant donné que je suis un manager de magasin
    Quand je veux modifier le nombre de choix de mon choix composant "Parfum" en 2 dans mon element "Glace" de mon choix element "Dessert" de mon menu "menu1"
    Alors le nombre de choix de mon choix composant "Parfum" est 2 dans mon element "Glace" de mon choix element "Dessert" de mon menu "menu1"
