# language: fr
Fonctionnalité: Notation du restaurant, du livreur et de l'usager

  Scénario: Noter le restaurant
    Etant donné que je suis un utilisateur
    Quand je suis satisfait de mes repas dans le restaurant auquel j'ai commandé
    Alors je peux attribuer une note au restaurant
    Et ma note est visible pour les autres utilisateurs

  Scénario: Noter le livreur en tant qu'utilisateur livré
    Etant donné que je suis un utilisateur livré
    Et que je veux noter le livreur
    Alors je peux attribuer une note au livreur
    Et ma note est visible pour le restaurant et les autres utilisateurs

  Scénario: Noter l'usager en tant que livreur
    Etant donné que je suis un livreur
    Quand j'ai effectué une livraison
    Alors je peux attribuer une note à l'usager
    Et ma note est visible pour les autres utilisateurs et l'administrateur