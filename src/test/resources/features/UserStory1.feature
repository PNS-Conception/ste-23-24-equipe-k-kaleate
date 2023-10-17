#language: fr
Fonctionnalité: Selectionner un menu pour commander

  Contexte:
    Soit je suis un utilisateur

  Scénario: Choisir le créneau de 12h à 12h15
    Etant donné que je suis un utilisateur qui souhaite commander
    Alors je precise le creneau de ma commande pour avoir la liste des menus disponibles

  Scénario:
    Etant donné que je suis un utilisateur qui souhaite commander dans la liste des menus du restaurant "Burger King"
    Alors je selectionne le menu "Burger cheese"

  Scénario: Prendre le menu "Burger cheese"
    Etant donné que je suis un utilisateur qui souhaite commander dans la liste des menus disponibles pour le creneau
    Alors je selectionne le menu "Burger cheese"