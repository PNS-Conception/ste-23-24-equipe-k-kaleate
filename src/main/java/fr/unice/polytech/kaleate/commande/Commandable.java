package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.StatutMenu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.outils.Monnayable;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

public interface Commandable extends Monnayable {
    boolean modifiable();
    float getTempsPreparation();
    String getName();

    boolean estMenuParNom(String s);

    boolean chevaucheCreneau(Creneau creneau);

    void setCommande(Commande commandeSimple);

    void verifContenuMenu();

    void setRestaurant(Restaurant restaurant);

    Restaurant getRestaurant();

    void setStatutValide();

    void setStatutEnPreparation();

    void setStatutPret();

    StatutMenu getStatut();

    void setStatut(StatutMenu statutMenu);

    void resetMenu();

    Creneau getCreneau();

    void setTempsPreparation(int i);
}
