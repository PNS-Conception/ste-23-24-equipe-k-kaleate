#language: en
Feature: Selectionner un menu pour commander

  Context:
    Given je suis un utilisateur

  Scenario: Choisir le créneau de 12h à 12h15
    Given je suis un utilisateur qui souhaite commander
    Then je precise le creneau de ma commande pour avoir la liste des menus disponibles

  Scenario:
    Given je suis un utilisateur qui souhaite commander dans la liste des menus du restaurant "Burger King"
    Then je selectionne le menu "Burger cheese"

  Scenario: Prendre le menu "Burger cheese"
    Given je suis un utilisateur qui souhaite commander dans la liste des menus disponibles pour le creneau
    Then je selectionne le menu "Burger cheese"