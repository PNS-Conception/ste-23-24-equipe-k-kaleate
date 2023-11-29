#language: fr
Fonctionnalité: Le restaurant annule une commande

  Contexte:
    Soit Je suis un restaurant qui a eu un problème

  Scénario: annuler une commande avec 1 menu
    Etant donnée une commande avec un menu
    Quand j'annule le menu
    Alors la commande disparait de liste a faire

  Scénario: annuler une commande avec 2 menu
    Etant donnée une commande avec plusieurs menus
    Quand j'annule un seul menu
    Alors la commande est toujours la mais avec un menu en moins