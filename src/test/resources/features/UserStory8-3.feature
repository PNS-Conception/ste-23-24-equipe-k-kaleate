#language: fr
Fonctionnalité: Lister les menus du campus Sophia_tech

  Contexte:
    Soit le campus "Sophia_tech" avec une liste de restaurants et leurs menus :
      | Restaurant A | Menu du jour    |
      | Restaurant A | Menu végétarien |
      | Restaurant B | Menu du jour    |
      | Restaurant B | Menu végétarien |
      | Restaurant C | Menu du jour    |
      | Restaurant C | Menu végétarien |

  Scénario: Consulter les menus d'un campus
    Étant donné que je selectionne le campus "Sophia_tech"
    Quand je choisis de consulter les menus du campus "Sophia_tech"
    Alors je devrai avoir 3 restaurants chacun 2 menus
