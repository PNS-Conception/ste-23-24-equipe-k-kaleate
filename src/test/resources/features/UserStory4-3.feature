#language: fr
Fonctionnalité: Historique des menus commandés des restaurants
  Contexte:
    Soit Un restaurant ayant un historique de menus commandés

  Scénario: Une nouvelle commande a été livrée

    Quand Le livreur a terminé une livraison avec au moins un des menus du restaurant
    Alors l'historique des menus commandés est mis à jour

  Scénario: Consulter les tendances du restaurants
    Quand je consulte mon historique de menus commandés
    Alors je peux voir mes menus les plus commandés
