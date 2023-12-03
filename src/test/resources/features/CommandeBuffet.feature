#language: fr
Fonctionnalité: Commande Buffet

  Contexte:
    Soit un campus "Campus"
    Soit un restaurant "Burger King"
    Et un membre du staff "Ronald" "McDonald"
    Et un utilisateur "Bob" "Nom"
    Etant donné que le restaurant "Burger King" propose un buffet

  Scénario:
    Quand "Ronald" commande un buffet
    Et qu'il y aura 50 personnes au buffet
    Et "Bob" sera le receveur de la commande
    Alors le buffet est retiré de la liste des buffets disponibles
    Et le nombre de Menus disponibles est de 50

  Scénario:
    Quand "Bob" essaye commander un menu
    Alors la liste de menus disponibles ne contient pas de buffet

  Scénario:
    Quand "Ronald" commande un buffet
    Et qu'il essaye de modifier le contenu du buffet
    Alors le contenu du buffet ne change pas

  Scénario:
    Soit "Ronald" commande un menu
    Quand "Ronald" commande un buffet
    Alors le menu est remis dans la liste des menus du restaurant
    Et la commande de "Ronald" est un buffet

  Scénario:
    Soit "Ronald" commande un buffet
    Quand "Ronald" annule sa commande
    Alors la commande buffet se retrouve dans la liste de menus disponibles