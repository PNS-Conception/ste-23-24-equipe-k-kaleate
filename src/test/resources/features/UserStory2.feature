#language: fr
Fonctionnalité: Un restaurateur valide une commande afin de commencer la préparation

  Contexte:
    Soit Je suis un restaurateur qui travaille à "Burger King"

  Scénario: Afficher la liste des commandes
    Alors Je demande à voir la liste des commandes passées dans mon restaurant

  Scénario: Sélectionner une commande
    Etant donné que J'ai la liste des commandes passées dans mon restaurant
    Quand je sélectionne la première commande
    Alors je vois toutes les informations de la commande

  Scénario: Accepter une commande
    Etant donné que Le restaurant peut préparer la commande
    Alors Le restaurant valide la prise en charge de la commande


  Scénario: Mettre en préparation une commande
    Etant donné que La commande doit être commmencée à être préparée pour être livrée à temps
    Quand Je sélectionne la commande pour la mettre en préparation
    Alors La commande ne peut plus être modifié par le client

