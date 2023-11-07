#language: fr
Fonctionnalité: Ajouter des utilisateurs et des restaurants au campus

  Contexte:
    Soit je suis un administrateur campus "SophiaTech"

  Scénario: Ajouter un utilisateur au campus
    Etant donné que le nombre d'utlisateur du campus est de 0
    Quand j'ajoute l'utilisateur "Bob" "Falbert"
    Alors le nombre d'utilisateurs augmente de 1

  Scénario: Supprimer un utilisateur au campus
    Etant donné que le nombre d'utisateur du campus est de 1
    Quand je supprime l'utilisateur "Bob" "Falbert"
    Alors le nombre d'utilisateurs diminue et est égal à 0