#language: fr
Fonctionnalité: Créer une commande groupée

  Contexte :
    Soit un utilisateur "User" "A" et son ami "User" "B"
    Et User A et User B qui ont chacun leur commande

    Scénario: rejoindre une commande groupée
      Etant donné User A qui accepte que des utilisateurs rejoignent sa commande et ont le meme creneau
      Quand User B rentre l'idendifiant de la commande de User A
      Alors User B a rejoint la commande de User A


  Scénario: impossibilité de rejoindre une commande groupée
    Etant donné User A qui accepte que des utilisateurs rejoignent sa commande et n'ont pas le meme creneau
    Quand User B rentre l'idendifiant de la commande de User A
    Alors la commande de User A ne contient qu'une seule commande