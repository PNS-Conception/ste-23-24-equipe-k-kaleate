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







