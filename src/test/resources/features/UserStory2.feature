Feature: Un restaurateur valide une commande afin de commencer la préparation

  Scenario: Afficher la liste des commandes
    Given Je suis un restaurateur qui travaille à "Burger King"
    When J'ecris "commandes" dans le terminal
    Then Je vois la liste des commandes passées dans mon restaurant

  Scenario: Sélectionner une commande
    Given J'ai la liste des commandes passées dans mon restaurant
    When je sélectionne la première commande
    Then je vois toutes les informations de la commande

  Scenario: Mettre en préparation une commande
    Given La commande doit être commmencée à être préparée pour être livrée à temps
    When J'ecris "preparation" et "numCom" qui correspond au numéro de la commande
    Then La commande ne peut plus être modifié par le client

