#language: fr
  Fonctionnalité: Pouvoir avoir le choix sur les éléments et les composants d'un menu

    Scénario: Creer une commande avec des options
      Etant donné que je suis un Manager de Restaurant
      Quand je cree un menu avec 3 elements
      Et que je donne 2 choix pour le premier element
      Et que je donne 1 choix pour les deux autres
      Et que je l'ajoute au menu de mon restaurant
      Alors il est possible pour l'utilisateur de choisir un des deux elements pour le premier choix
      Et il n'est pas possible pour l'utilisateur de choisir pour les deux autres elements


    Scénario: Creer une commande avec des elements supplements
      Etant donné que je suis un Manager de Restaurant
      Quand je cree un menu avec 2 elements supplements
      Et que je l'ajoute au menu de mon restaurant
      Alors il est possible pour l'utilisateur de rajouter des elements supplements

    Scénario: Creer une commande avec des composants supplements
      Etant donné que je suis un Manager de Restaurant
      Quand je cree un menu avec 2 composants supplements pour un element
      Et que je l'ajoute au menu de mon restaurant
      Alors il est possible pour l'utilisateur de rajouter des composants supplements dans cet element

    Scénario: Choisir parmi des options composants
      Etant donné que je suis utilisateur
      Quand Je veux commander un menu "Cheese"
      Et que je veux boire du "Coca"
      Alors ma commande contient du "Coca"
