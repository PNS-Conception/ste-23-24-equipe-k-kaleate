##language: fr
#  Fonctionnalité: Pouvoir avoir le choix sur les éléments et les composants d'un menu
#
#    Scénario: Creer une commande avec des options composants et elements
#      Etant donné que je suis un Manager de Restaurant
#      Quand je cree un menu "Cheese1"
#      Et que je donne le choix entre "Coca" et "Ice Tea" pour la "Boisson"
#      Et que je donne des "Frite" en "Accompagnement" et un "Burger Cheese" en "Burger"
#      Et que je laisse le choix de la "Sauce" pour les "Frite" entre "Ketchup"  "Moutarde" et "Mayonnaise"
#      Et que j'ajoute "Cheese1" au menu de mon restaurant
#      Alors il est possible pour l'utilisateur de choisir entre "Coca" et "Ice Tea" pour la "Boisson"
#      Et il n'est pas possible pour l'utilisateur de choisir pour l'"Accompagnement" et le "Burger"
#      Et l'utilisateur peut choisir 2 "Sauce" entre "Ketchup"  "Moutarde" et "Mayonnaise"
#
#
#    Scénario: Creer une commande avec des elements supplements
#      Etant donné que je suis un Manager de Restaurant
#      Quand je cree un menu "Cheese2"
#      Et que j'ajoute 2 elements supplements "Glace" et "Pomme"
#      Et que j'ajoute "Cheese2" au menu de mon restaurant
#      Alors il est possible pour l'utilisateur de rajouter une "Glace" et une "Pomme"
#
#    Scénario: Creer une commande avec des composants supplements
#      Etant donné que je suis un Manager de Restaurant
#      Quand je cree un menu "Cheese3"
#      Et que j'ajoute 2 composants supplements "Cheddar" et "Bacon" pour le "Burger Cheese"
#      Et que j'ajoute "Cheese3" au menu de mon restaurant
#      Alors il est possible pour l'utilisateur de rajouter du "Cheddar" et du "Bacon" dans le "Burger Cheese" du menu "Cheese3"
#
#    Scénario: Choisir parmi des options composants et elements
#      Etant donné que je suis utilisateur
#      Quand Je veux commander un menu "Cheese"
#      Et que je veux boire du "Coca"
#      Et que je veux du "Ketchup" et de la "Mayonnaise" comme "Sauce" dans mon "Burger Cheese"
#      Alors ma commande contient du "Coca"
#      Et mon "Burger Cheese" contient du "Ketchup" et de la "Mayonnaise"
#
#    Scénario: Choisir parmi des supplements composants et elements
#      Etant donné que je suis utilisateur
#      Quand Je veux commander un menu "Cheese"
#      Et que je veux ajouter du "Bacon" dans mon "Burger Cheese" et une "Glace" avec des "Cacahuetes"
#      Alors ma commande contient du "Bacon" dans mon "Burger Cheese"
#      Et ma commande contient une "Glace"
#      Et le prix de ma commande a augmente
