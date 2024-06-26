#language: fr
Fonctionnalité: Livraison de la commande au client
  Contexte:
    Soit un livreur et un utilisateur et une commande appartenant à l'utilisateur

  Scénario: Le livreur arrive au point de rendez-vous

    Quand Le livreur confirme qu'il est arrivé
    Alors le client valide qu'il a reçu la commande

  Scénario: retrouver sa commande dans son historique

    Quand la commande a été récupérée
    Alors le client peut la retrouver dans son historique

