Feature: Consulter les menus

  Scenario: consulter la liste des menus disponibles
    Given je suis connecte avec mon compte etudiant
    When j'ecris "menu" dans le terminal
    Then je vois la liste des menus disponibles pour mon campus