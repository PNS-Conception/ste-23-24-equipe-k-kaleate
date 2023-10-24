#language: fr
Fonctionnalité: Ajouter un restaurant partenaire

  Contexte:
    Soit Je suis l'administrateur du campus "Sophia_tech"

  Scénario: Afficher les restaurants partenaires
    Quand Je demande l'ensemble des restaurants partenaires de mon campus
    Alors J'obtiens la liste des restaurants partenaires du Campus "Sophia_tech"

  Scénario: Ajouter un restaurant
    Quand J'ajoute le restaurant "Pizza Rock"
    Alors Le nombre de restaurant change