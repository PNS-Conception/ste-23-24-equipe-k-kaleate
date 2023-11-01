#language: fr
Fonctionnalité: Créer une commande groupée

  Contexte :
    Soit un utilisateur "User" "A" et son ami "User" "B"

    Scénario: rejoindre une commande groupée
      Etant donné User A et User B qui ont chacun leur commande
      Et User A qui accepte que des utilisateur rejoignent sa commande
      Quand User B rentre l'idendifiant de la commande de User A
      Alors User B a rejoint la commande de User 1

  Scénario: interdire une commande groupée
    Etant donné User A et User B qui ont chacun leur commande
    Et User A qui rejette que des utilisateur rejoignent sa commande
    Quand User B rentre l'idendifiant de la commande de User A
    Alors User B n'a pas rejoint la commande de User A

  Scénario: impossibilité de rejoindre une commande groupée
    Etant donné User A et User B qui ont chacun leur commande mais dans des restaurants differents
    Et User A qui accepte que des utilisateur rejoignent sa commande
    Quand User B rentre l'idendifiant de la commande de User A
    Alors User B n'a pas rejoint la commande de User A