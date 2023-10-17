#language: fr
Fonctionnalité: Un restaurateur valide une commande afin de commencer la préparation

  Scénario: Afficher la liste des commandes
    Etant donné que Je suis un restaurateur qui travaille à "Burger King"
    Quand J'ecris "commandes" dans le terminal
    Alors Je vois la liste des commandes passées dans mon restaurant

  Scénario: Sélectionner une commande
    Etant donné que J'ai la liste des commandes passées dans mon restaurant
    Quand je sélectionne la première commande
    Alors je vois toutes les informations de la commande

  Scénario: Mettre en préparation une commande
    Etant donné que La commande doit être commmencée à être préparée pour être livrée à temps
    Quand J'ecris "preparation" et "numCom" qui correspond au numéro de la commande
    Alors La commande ne peut plus être modifié par le client

