#language: en
Feature: Selectionner un menu pour commander

  Context:
    Given je suis un utilisateur

  Scenario: Choisir le créneau de 12h à 12h15
    Given je suis un utilisateur qui souhaite commander
    Then je precise le creneau de ma commande pour avoir la liste des menus disponibles

  Scenario: Prendre le menu "Sushi Salsa"
    Given je suis un utilisateur qui souhaite commander dans la liste des menus disponibles pour le creneau
    Then je selectionne le menu "Sushi Salsa"